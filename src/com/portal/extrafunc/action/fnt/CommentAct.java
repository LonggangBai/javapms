/*   1:    */ package com.portal.extrafunc.action.fnt;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.utils.ResponseUtils;
/*   5:    */ import com.javapms.basic.utils.ServicesUtils;
/*   6:    */ import com.portal.doccenter.entity.Article;
/*   7:    */ import com.portal.doccenter.service.ArticleService;
/*   8:    */ import com.portal.extrafunc.action.cache.CommentUpCache;
/*   9:    */ import com.portal.extrafunc.entity.Comment;
/*  10:    */ import com.portal.extrafunc.service.CommentService;
/*  11:    */ import com.portal.sysmgr.entity.Site;
/*  12:    */ import com.portal.sysmgr.utils.ContextTools;
/*  13:    */ import com.portal.sysmgr.utils.ViewTools;
/*  14:    */ import com.portal.usermgr.entity.User;
/*  15:    */ import javax.servlet.http.HttpServletRequest;
/*  16:    */ import javax.servlet.http.HttpServletResponse;
/*  17:    */ import org.json.JSONException;
/*  18:    */ import org.json.JSONObject;
/*  19:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  20:    */ import org.springframework.stereotype.Controller;
/*  21:    */ import org.springframework.ui.ModelMap;
/*  22:    */ import org.springframework.web.bind.annotation.PathVariable;
/*  23:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  24:    */ 
/*  25:    */ @Controller
/*  26:    */ public class CommentAct
/*  27:    */ {
/*  28:    */   public static final String COMMENT_PAGE = "tpl.commentPage";
/*  29:    */   public static final String COMMENT_LIST = "comment_list";
/*  30:    */   public static final String PARENT_LIST = "parent_list";
/*  31:    */   @Autowired
/*  32:    */   private CommentService commentService;
/*  33:    */   @Autowired
/*  34:    */   private ArticleService articleService;
/*  35:    */   @Autowired
/*  36:    */   private CommentUpCache commentUpCache;
/*  37:    */   
/*  38:    */   @RequestMapping(value={"/comment-{docId:[0-9]+}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  39:    */   public String page(@PathVariable Integer docId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  40:    */   {
/*  41: 39 */     return commentpage(docId, request, response, model);
/*  42:    */   }
/*  43:    */   
/*  44:    */   @RequestMapping(value={"/comment-{docId:[0-9]+}_{page:[0-9]+}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  45:    */   public String commentpage(@PathVariable Integer docId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  46:    */   {
/*  47: 46 */     Site site = ContextTools.getSite(request);
/*  48: 47 */     Article doc = this.articleService.findById(docId);
/*  49: 48 */     if (doc == null) {
/*  50: 49 */       return ViewTools.showMessage(null, request, model, "文档不存在!", Integer.valueOf(0));
/*  51:    */     }
/*  52: 51 */     ViewTools.frontData(request, model, site);
/*  53: 52 */     model.addAttribute("doc", doc);
/*  54: 53 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  55: 54 */       "extrafunc/comment", "tpl.commentPage");
/*  56:    */   }
/*  57:    */   
/*  58:    */   @RequestMapping(value={"/comment.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  59:    */   public void submit(Integer docId, Integer parentId, String content, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  60:    */     throws JSONException
/*  61:    */   {
/*  62: 61 */     Site site = ContextTools.getSite(request);
/*  63: 62 */     User user = ContextTools.getUser(request);
/*  64: 63 */     JSONObject json = new JSONObject();
/*  65: 64 */     if (docId == null)
/*  66:    */     {
/*  67: 65 */       json.put("success", false);
/*  68: 66 */       json.put("status", -1);
/*  69: 67 */       ResponseUtils.renderJson(response, json.toString());
/*  70: 68 */       return;
/*  71:    */     }
/*  72: 70 */     Article doc = this.articleService.findById(docId);
/*  73: 71 */     if (doc == null)
/*  74:    */     {
/*  75: 72 */       json.put("success", false);
/*  76: 73 */       json.put("status", -2);
/*  77:    */     }
/*  78: 74 */     else if ((doc.getCommentControl() != null) && (!doc.getCommentControl().booleanValue()))
/*  79:    */     {
/*  80: 75 */       json.put("success", false);
/*  81: 76 */       json.put("status", -3);
/*  82:    */     }
/*  83:    */     else
/*  84:    */     {
/*  85: 78 */       String ip = ServicesUtils.getIpAddr(request);
/*  86: 79 */       this.commentService.comment(content, ip, parentId, doc, user, site);
/*  87: 80 */       json.put("success", true);
/*  88: 81 */       json.put("status", 0);
/*  89:    */     }
/*  90: 83 */     ResponseUtils.renderJson(response, json.toString());
/*  91:    */   }
/*  92:    */   
/*  93:    */   @RequestMapping(value={"/commentList.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  94:    */   public String commentList(Integer docId, Integer pageNo, Integer count, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  95:    */   {
/*  96: 90 */     Site site = ContextTools.getSite(request);
/*  97: 91 */     Pagination page = this.commentService.getPage(site.getId(), docId, null, 
/*  98: 92 */       Boolean.valueOf(true), Boolean.valueOf(true), 2, null, null, pageNo.intValue(), count.intValue());
/*  99: 93 */     model.addAttribute("page", page);
/* 100: 94 */     ViewTools.frontData(request, model, site);
/* 101: 95 */     response.setHeader("Cache-Control", "no-cache");
/* 102: 96 */     response.setContentType("text/json;charset=UTF-8");
/* 103: 97 */     return ViewTools.getTplPath(null, site.getSolutionPath(), 
/* 104: 98 */       "extrafunc/comment", "comment_list");
/* 105:    */   }
/* 106:    */   
/* 107:    */   @RequestMapping(value={"/commentListByPre.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 108:    */   public String commentListByPre(Integer parentId, Integer pageNo, Integer count, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 109:    */   {
/* 110:105 */     Site site = ContextTools.getSite(request);
/* 111:106 */     Pagination page = this.commentService.getPage(site.getId(), null, parentId, 
/* 112:107 */       Boolean.valueOf(true), Boolean.valueOf(false), 2, null, null, pageNo.intValue(), count.intValue());
/* 113:108 */     Comment comment = this.commentService.findById(parentId);
/* 114:109 */     model.addAttribute("page", page);
/* 115:110 */     model.addAttribute("comment", comment);
/* 116:111 */     ViewTools.frontData(request, model, site);
/* 117:112 */     response.setHeader("Cache-Control", "no-cache");
/* 118:113 */     response.setContentType("text/json;charset=UTF-8");
/* 119:114 */     return ViewTools.getTplPath(null, site.getSolutionPath(), 
/* 120:115 */       "extrafunc/comment", "parent_list");
/* 121:    */   }
/* 122:    */   
/* 123:    */   @RequestMapping(value={"/commentUps.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 124:    */   public void commentUps(Integer commentId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 125:    */     throws JSONException
/* 126:    */   {
/* 127:121 */     JSONObject json = new JSONObject();
/* 128:122 */     Integer ups = this.commentUpCache.upAndGet(commentId);
/* 129:123 */     json.put("ups", ups);
/* 130:124 */     ResponseUtils.renderJson(response, json.toString());
/* 131:    */   }
/* 132:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.fnt.CommentAct
 * JD-Core Version:    0.7.0.1
 */