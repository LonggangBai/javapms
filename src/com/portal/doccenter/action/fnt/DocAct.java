/*   1:    */ package com.portal.doccenter.action.fnt;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Paginable;
/*   4:    */ import com.javapms.basic.page.SimplePage;
/*   5:    */ import com.portal.datacenter.docdata.service.KeywordService;
/*   6:    */ import com.portal.doccenter.action.fnt.cache.DocViewsCountCache;
/*   7:    */ import com.portal.doccenter.entity.Article;
/*   8:    */ import com.portal.doccenter.entity.Channel;
/*   9:    */ import com.portal.doccenter.service.ArticleService;
/*  10:    */ import com.portal.sysmgr.entity.Site;
/*  11:    */ import com.portal.sysmgr.utils.ContextTools;
/*  12:    */ import com.portal.sysmgr.utils.ViewTools;
/*  13:    */ import com.portal.usermgr.entity.Group;
/*  14:    */ import com.portal.usermgr.entity.Member;
/*  15:    */ import com.portal.usermgr.entity.User;
/*  16:    */ import java.util.Set;
/*  17:    */ import javax.servlet.http.HttpServletRequest;
/*  18:    */ import javax.servlet.http.HttpServletResponse;
/*  19:    */ import org.apache.commons.lang.StringUtils;
/*  20:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  21:    */ import org.springframework.stereotype.Controller;
/*  22:    */ import org.springframework.ui.ModelMap;
/*  23:    */ import org.springframework.web.bind.annotation.PathVariable;
/*  24:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  25:    */ 
/*  26:    */ @Controller
/*  27:    */ public class DocAct
/*  28:    */ {
/*  29:    */   @Autowired
/*  30:    */   private ArticleService articleService;
/*  31:    */   @Autowired
/*  32:    */   private KeywordService keywordService;
/*  33:    */   @Autowired
/*  34:    */   private DocViewsCountCache viewsCountCache;
/*  35:    */   
/*  36:    */   @RequestMapping({"/doc/{docId:[0-9]+}.jsp"})
/*  37:    */   public String docdetail(@PathVariable Integer docId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  38:    */   {
/*  39: 41 */     return docdetailpageNo(docId, Integer.valueOf(1), request, response, model);
/*  40:    */   }
/*  41:    */   
/*  42:    */   @RequestMapping({"/doc/{docId:[0-9]+}_{page:[0-9]+}.jsp"})
/*  43:    */   public String docdetailpageNo(@PathVariable Integer docId, @PathVariable Integer page, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  44:    */   {
/*  45: 48 */     Site site = ContextTools.getSite(request);
/*  46: 49 */     Article doc = this.articleService.findById(docId);
/*  47: 50 */     if (doc == null) {
/*  48: 51 */       return ViewTools.pageNotFound(response);
/*  49:    */     }
/*  50: 53 */     if (!site.equals(doc.getSite())) {
/*  51: 54 */       return ViewTools.pageNotFound(response);
/*  52:    */     }
/*  53: 56 */     if (!StringUtils.isBlank(doc.getLink())) {
/*  54: 57 */       return "redirect:" + doc.getLink();
/*  55:    */     }
/*  56: 59 */     String result = checkView(doc, request, response, model);
/*  57: 60 */     if (result != null) {
/*  58: 61 */       return result;
/*  59:    */     }
/*  60: 63 */     String ctx = site.getContextPath();
/*  61: 64 */     ctx = ctx == null ? "" : ctx;
/*  62: 65 */     String txt = doc.getTxtByNo(page.intValue());
/*  63:    */     
/*  64: 67 */     txt = StringUtils.replace(txt, "../..", ctx);
/*  65: 68 */     txt = this.keywordService.attachKeyword(site.getId(), txt);
/*  66: 69 */     Paginable pagination = new SimplePage(page.intValue(), 1, doc.getPageCount());
/*  67: 70 */     Integer views = this.viewsCountCache.viewsCount(docId);
/*  68: 71 */     model.addAttribute("page", pagination);
/*  69: 72 */     model.addAttribute("doc", doc);
/*  70: 73 */     model.addAttribute("views", views);
/*  71: 74 */     model.addAttribute("channel", doc.getChannel());
/*  72: 75 */     model.addAttribute("title", doc.getTitle());
/*  73: 76 */     model.addAttribute("txt", txt);
/*  74: 77 */     ViewTools.frontData(request, model, site);
/*  75: 78 */     ViewTools.frontPageData(request, model);
/*  76: 79 */     return doc.getTplContentOrDef();
/*  77:    */   }
/*  78:    */   
/*  79:    */   public String checkView(Article doc, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  80:    */   {
/*  81: 84 */     User user = ContextTools.getUser(request);
/*  82: 85 */     Site site = doc.getSite();
/*  83: 86 */     Set<Group> groups = doc.getViewGroupsExt();
/*  84: 87 */     if ((!doc.getStatus().equals(Byte.valueOf((byte)2))) && (
/*  85: 88 */       (user == null) || (user.getAdmin() == null))) {
/*  86: 89 */       return ViewTools.pageNotFound(response);
/*  87:    */     }
/*  88: 92 */     if ((groups != null) && (groups.size() > 0))
/*  89:    */     {
/*  90: 93 */       if (user == null) {
/*  91: 94 */         return ViewTools.showLogin(request, model, "您需要登录才能浏览该信息!");
/*  92:    */       }
/*  93: 96 */       if ((user.getAdmin() == null) && 
/*  94: 97 */         (user.getMember() != null))
/*  95:    */       {
/*  96: 98 */         Integer groupId = user.getMember().getGroup(site.getId())
/*  97: 99 */           .getId();
/*  98:100 */         for (Group group : groups) {
/*  99:101 */           if (group.getId().equals(groupId)) {
/* 100:102 */             return null;
/* 101:    */           }
/* 102:    */         }
/* 103:105 */         String groupName = user.getMember().getGroup(site.getId())
/* 104:106 */           .getName();
/* 105:107 */         String msg = "您所在的会员组：" + groupName + "没有访问该页面的权限";
/* 106:108 */         return ViewTools.showMessage(doc.getChannel().getUrl(), 
/* 107:109 */           request, model, msg, Integer.valueOf(0));
/* 108:    */       }
/* 109:    */     }
/* 110:113 */     return null;
/* 111:    */   }
/* 112:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.action.fnt.DocAct
 * JD-Core Version:    0.7.0.1
 */