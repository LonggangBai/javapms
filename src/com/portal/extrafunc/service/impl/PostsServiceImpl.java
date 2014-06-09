package com.portal.extrafunc.service.impl;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.javapms.basic.upload.FileRepository;
import com.javapms.basic.utils.StringBeanUtils;
import com.portal.extrafunc.dao.PostsDao;
import com.portal.extrafunc.entity.Posts;
import com.portal.extrafunc.entity.Theme;
import com.portal.extrafunc.service.*;
import com.portal.sysmgr.service.SiteService;
import com.portal.sysmgr.utils.Constants;
import com.portal.usermgr.entity.User;
import com.portal.usermgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional
public class PostsServiceImpl
        implements PostsService {
    private PostsDao dao;
    private PostsExtService extService;
    private PostsTxtService txtService;
    private ThemeService themeService;
    private FileRepository fileRepository;
    private SiteService siteService;
    private UserService userService;
    private UserForumService userForumService;
    private ForumOperateService operateService;

    @Transactional(readOnly = true)
    public Pagination getPage(int pageNo, int pageSize) {
        Pagination page = this.dao.getPage(pageNo, pageSize);
        return page;
    }

    @Transactional(readOnly = true)
    public Pagination getPostsPageForTag(Integer themeId, int pageNo, int pageSize) {
        return this.dao.getPostsPageForTag(themeId, pageNo, pageSize);
    }

    @Transactional(readOnly = true)
    public Posts findById(Integer id) {
        Posts entity = this.dao.findById(id);
        return entity;
    }

    public Posts saveTheme(Integer siteId, Integer userId, Integer forumId, String title, String content, String ip, List<MultipartFile> file, List<String> code) {
        Posts posts = new Posts();
        Theme theme = new Theme();
        posts.setTitle(title);
        boolean affix = false;
        boolean hidden = false;
        if ((file != null) && (file.size() > 0)) {
            affix = true;
        }
        if (findHidden(content)) {
            hidden = true;
        }
        posts.setFloor(Integer.valueOf(1));
        posts.setAffix(Boolean.valueOf(affix));
        posts.setHidden(Boolean.valueOf(hidden));
        posts.setCreater(this.userService.findById(userId));
        posts.setSite(this.siteService.findById(siteId));
        theme = this.themeService.save(siteId, userId, forumId, title, false, affix);
        posts.setTheme(theme);
        posts.init();
        this.dao.save(posts);
        this.extService.save(ip, posts);
        if ((file != null) && (file.size() > 0)) {
            content = addAttach(content, file, code, posts);
        }
        this.txtService.save(content, posts);
        this.userForumService.update(userId, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
        return posts;
    }

    public Posts savePosts(Integer siteId, Integer userId, Integer themeId, Integer quoteId, String title, String content, String ip, List<MultipartFile> file, List<String> code) {
        Posts posts = new Posts();
        User user = this.userService.findById(userId);
        Theme theme = this.themeService.findById(themeId);
        posts.setTitle(title);
        boolean affix = false;
        boolean hidden = false;
        if ((file != null) && (file.size() > 0)) {
            affix = true;
        }
        if (findHidden(content)) {
            hidden = true;
        }
        posts.setAffix(Boolean.valueOf(affix));
        posts.setHidden(Boolean.valueOf(hidden));
        posts.setCreater(user);
        if (quoteId != null) {
            Posts qp = findById(quoteId);
            posts.setQuote(qp);
        }
        posts.setSite(this.siteService.findById(siteId));
        posts.setTheme(theme);
        posts.setFloor(this.dao.getFloorByTheme(themeId));
        posts.init();
        posts = this.dao.save(posts);
        this.extService.save(ip, posts);
        if ((file != null) && (file.size() > 0)) {
            content = addAttach(content, file, code, posts);
        }
        this.txtService.save(content, posts);
        this.themeService.updateReply(theme, user, affix);
        this.userForumService.update(userId, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1));
        return posts;
    }

    public Posts updatePosts(Integer postsId, Integer userId, String title, String content, String ip, List<MultipartFile> file, List<String> code) {
        Posts posts = findById(postsId);
        posts.setTitle(title);
        boolean affix = false;
        boolean hidden = false;
        if ((file != null) && (file.size() > 0)) {
            affix = true;
        }
        if (findHidden(content)) {
            hidden = true;
        }
        posts.setAffix(Boolean.valueOf(affix));
        posts.setHidden(Boolean.valueOf(hidden));
        this.extService.update(postsId, userId, ip);
        posts.getAttachs().clear();
        if ((file != null) && (file.size() > 0)) {
            content = addAttach(content, file, code, posts);
        }
        this.txtService.update(postsId, content);
        this.operateService.save(postsId, "POSTS", "aa", "a",
                posts.getSite(), this.userService.findById(userId));
        return posts;
    }

    public Theme shieldTheme(Integer themeId, Integer userId, String reason) {
        Theme theme = this.themeService.findById(themeId);
        theme.setStatus(Integer.valueOf(-1));
        Posts posts = this.dao.getPostsOneFloor(themeId);
        if (posts != null) {
            posts.setStatus(Integer.valueOf(-1));
        }
        this.operateService.save(theme.getId(), "THEME", "aa", reason,
                theme.getSite(), this.userService.findById(userId));
        return theme;
    }

    public Posts shieldPosts(Integer postsId, Integer userId, String reason) {
        Posts posts = findById(postsId);
        posts.setStatus(Integer.valueOf(-1));
        this.operateService.save(postsId, "POSTS", "aa", reason,
                posts.getSite(), this.userService.findById(userId));
        return posts;
    }

    public Theme deleteTheme(Integer themeId, Integer userId, String reason) {
        Theme theme = this.themeService.findById(themeId);
        theme.setStatus(Integer.valueOf(-2));
        Posts posts = this.dao.getPostsOneFloor(themeId);
        if (posts != null) {
            posts.setStatus(Integer.valueOf(-2));
        }
        this.operateService.save(theme.getId(), "THEME", "aa", reason,
                theme.getSite(), this.userService.findById(userId));
        return theme;
    }

    public String addAttach(String content, List<MultipartFile> file, List<String> code, Posts posts) {
        List<String> list = findImgUrl(content);
        if (code != null) {
            for (int i = 0; i < code.size(); i++) {
                if (list.contains(code.get(i))) {
                    String origName = ((MultipartFile) file.get(i)).getOriginalFilename();
                    String filepath = this.fileRepository.uploadFile((MultipartFile) file.get(i),
                            posts.getSite().getUploadPath());
                    addAttach(origName, filepath, posts, Long.valueOf(((MultipartFile) file.get(i)).getSize()));
                    int j = i + 1;
                    content = StringBeanUtils.replace(content, "[localimg]" + j +
                            "[/localimg]", "[attachment]" + i +
                            "[/attachment]");
                }
            }
        }
        return content;
    }

    private List<String> findImgUrl(String content) {
        String ems = "\\[localimg]([0-9]+)\\[/localimg]";
        Matcher matcher = Pattern.compile(ems).matcher(content);
        List<String> list = new ArrayList();
        while (matcher.find()) {
            String url = matcher.group(1);
            list.add(url);
        }
        return list;
    }

    private boolean findHidden(String content) {
        String ems = "\\[hide]([\\s\\S]*)\\[/hide]";
        Matcher matcher = Pattern.compile(ems).matcher(content);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    private void addAttach(String filename, String filepath, Posts posts, Long size) {
        boolean tag = false;
        String s = filename.substring(filename.lastIndexOf(".") + 1);
        for (String m : Constants.DEF_IMG_ACCEPT) {
            if (s.equals(m)) {
                tag = true;
            }
        }
        posts.setImg(Boolean.valueOf(tag));
        posts.getTheme().setImg(Boolean.valueOf(tag));
        posts.addToAttachs(filename, null, filename, filepath, Integer.valueOf(size.intValue()),
                Boolean.valueOf(tag));
    }

    public Posts update(Posts bean) {
        Updater<Posts> updater = new Updater(bean);
        bean = this.dao.updateByUpdater(updater);
        return bean;
    }

    public Posts deleteById(Integer id) {
        Posts bean = this.dao.deleteById(id);
        return bean;
    }

    public Posts[] deleteByIds(Integer[] ids) {
        Posts[] beans = new Posts[ids.length];
        int i = 0;
        for (int len = ids.length; i < len; i++) {
            beans[i] = deleteById(ids[i]);
        }
        return beans;
    }

    @Autowired
    public void setDao(PostsDao dao) {
        this.dao = dao;
    }

    @Autowired
    public void setExtService(PostsExtService extService) {
        this.extService = extService;
    }

    @Autowired
    public void setTxtService(PostsTxtService txtService) {
        this.txtService = txtService;
    }

    @Autowired
    public void setThemeService(ThemeService themeService) {
        this.themeService = themeService;
    }

    @Autowired
    public void setFileRepository(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Autowired
    public void setSiteService(SiteService siteService) {
        this.siteService = siteService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserForumService(UserForumService userForumService) {
        this.userForumService = userForumService;
    }

    @Autowired
    public void setOperateService(ForumOperateService operateService) {
        this.operateService = operateService;
    }
}



/* Location:           F:\jspaa\aaaaaa\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.extrafunc.service.impl.PostsServiceImpl

 * JD-Core Version:    0.7.0.1

 */