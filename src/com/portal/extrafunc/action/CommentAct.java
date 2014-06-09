/*  1:   */ package com.portal.extrafunc.action;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.javapms.basic.page.SimplePage;
/*  5:   */ import com.javapms.basic.utils.ResponseUtils;
/*  6:   */ import com.portal.datacenter.operatedata.service.LogService;
/*  7:   */ import com.portal.extrafunc.entity.Comment;
/*  8:   */ import com.portal.extrafunc.entity.CommentExt;
/*  9:   */ import com.portal.extrafunc.service.CommentService;
/* 10:   */ import com.portal.sysmgr.entity.Site;
/* 11:   */ import com.portal.sysmgr.utils.ContextTools;
/* 12:   */ import javax.servlet.http.HttpServletRequest;
/* 13:   */ import javax.servlet.http.HttpServletResponse;
/* 14:   */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/* 15:   */ import org.json.JSONException;
/* 16:   */ import org.json.JSONObject;
/* 17:   */ import org.slf4j.Logger;
/* 18:   */ import org.slf4j.LoggerFactory;
/* 19:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 20:   */ import org.springframework.stereotype.Controller;
/* 21:   */ import org.springframework.ui.ModelMap;
/* 22:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 23:   */ 
/* 24:   */ @Controller
/* 25:   */ public class CommentAct
/* 26:   */ {
/* 27:29 */   private static final Logger log = LoggerFactory.getLogger(CommentAct.class);
/* 28:   */   @Autowired
/* 29:   */   private LogService logService;
/* 30:   */   @Autowired
/* 31:   */   private CommentService service;
/* 32:   */   
/* 33:   */   @RequiresPermissions({"admin:comment:list"})
/* 34:   */   @RequestMapping({"/comment/v_list.do"})
/* 35:   */   public String list(Integer docId, ModelMap model)
/* 36:   */   {
/* 37:34 */     model.addAttribute("docId", docId);
/* 38:35 */     return "extraFunc/comment/list";
/* 39:   */   }
/* 40:   */   
/* 41:   */   @RequiresPermissions({"admin:comment:edit"})
/* 42:   */   @RequestMapping({"/comment/v_edit.do"})
/* 43:   */   public String edit(Integer id, HttpServletRequest request, ModelMap model)
/* 44:   */   {
/* 45:41 */     model.addAttribute("comment", this.service.findById(id));
/* 46:42 */     return "extraFunc/comment/edit";
/* 47:   */   }
/* 48:   */   
/* 49:   */   @RequiresPermissions({"admin:comment:update"})
/* 50:   */   @RequestMapping({"/comment/o_update.do"})
/* 51:   */   public String update(Comment bean, CommentExt ext, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 52:   */   {
/* 53:49 */     bean = this.service.update(bean, ext);
/* 54:50 */     log.info("update Comment id={}.", bean.getId());
/* 55:51 */     this.logService.operating(request, "修改评论", "id=" + bean.getId());
/* 56:52 */     model.addAttribute("msg", "评论修改成功!");
/* 57:53 */     return edit(bean.getId(), request, model);
/* 58:   */   }
/* 59:   */   
/* 60:   */   @RequestMapping({"/comment/jsonData.do"})
/* 61:   */   public String dataPageByJosn(Integer docId, Integer parentId, Boolean checked, String sortname, String sortorder, Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 62:   */   {
/* 63:61 */     Site site = ContextTools.getSite(request);
/* 64:62 */     Pagination pagination = this.service.getPage(site.getId(), docId, parentId, 
/* 65:63 */       checked, null, 0, sortname, sortorder, SimplePage.cpn(page), pagesize.intValue());
/* 66:64 */     model.addAttribute("pagi", pagination);
/* 67:65 */     response.setHeader("Cache-Control", "no-cache");
/* 68:66 */     response.setContentType("text/json;charset=UTF-8");
/* 69:67 */     return "extraFunc/comment/data";
/* 70:   */   }
/* 71:   */   
/* 72:   */   @RequiresPermissions({"admin:comment:delete"})
/* 73:   */   @RequestMapping({"/comment/o_ajax_delete.do"})
/* 74:   */   public void deleteComment(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/* 75:   */     throws JSONException
/* 76:   */   {
/* 77:74 */     JSONObject json = new JSONObject();
/* 78:75 */     Comment[] beans = this.service.deleteByIds(ids);
/* 79:76 */     for (Comment bean : beans)
/* 80:   */     {
/* 81:77 */       log.info("delete Comment id={}", bean.getId());
/* 82:78 */       this.logService.operating(request, "删除评论", "id=" + bean.getId());
/* 83:   */     }
/* 84:80 */     json.put("success", true);
/* 85:81 */     json.put("status", 1);
/* 86:82 */     ResponseUtils.renderJson(response, json.toString());
/* 87:   */   }
/* 88:   */   
/* 89:   */   @RequiresPermissions({"admin:comment:check"})
/* 90:   */   @RequestMapping({"/comment/o_ajax_check.do"})
/* 91:   */   public void checkComment(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/* 92:   */     throws JSONException
/* 93:   */   {
/* 94:90 */     JSONObject json = new JSONObject();
/* 95:91 */     Comment[] beans = this.service.checkByIds(ids);
/* 96:92 */     for (Comment bean : beans)
/* 97:   */     {
/* 98:93 */       log.info("check Comment id={}", bean.getId());
/* 99:94 */       this.logService.operating(request, "审核评论", "id=" + bean.getId());
/* :0:   */     }
/* :1:96 */     json.put("success", true);
/* :2:97 */     json.put("status", 1);
/* :3:98 */     ResponseUtils.renderJson(response, json.toString());
/* :4:   */   }
/* :5:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.CommentAct
 * JD-Core Version:    0.7.0.1
 */