/*  1:   */ package com.portal.datacenter.lucene;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.utils.ResponseUtils;
/*  4:   */ import com.portal.sysmgr.entity.Site;
/*  5:   */ import com.portal.sysmgr.utils.ContextTools;
/*  6:   */ import java.io.IOException;
/*  7:   */ import java.util.Date;
/*  8:   */ import javax.servlet.http.HttpServletRequest;
/*  9:   */ import javax.servlet.http.HttpServletResponse;
/* 10:   */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/* 11:   */ import org.json.JSONException;
/* 12:   */ import org.json.JSONObject;
/* 13:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 14:   */ import org.springframework.stereotype.Controller;
/* 15:   */ import org.springframework.ui.ModelMap;
/* 16:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 17:   */ 
/* 18:   */ @Controller
/* 19:   */ public class LuceneDocAct
/* 20:   */ {
/* 21:   */   @Autowired
/* 22:   */   private LuceneDocService luceneDocService;
/* 23:   */   
/* 24:   */   @RequiresPermissions({"admin:lucene:index"})
/* 25:   */   @RequestMapping({"/lucene/v_index.do"})
/* 26:   */   public String index(HttpServletRequest request, ModelMap model)
/* 27:   */   {
/* 28:27 */     Site site = ContextTools.getSite(request);
/* 29:28 */     model.addAttribute("site", site);
/* 30:29 */     return "dataCenter/docData/lucene/index";
/* 31:   */   }
/* 32:   */   
/* 33:   */   @RequiresPermissions({"admin:lucene:create"})
/* 34:   */   @RequestMapping({"/lucene/o_create.do"})
/* 35:   */   public void create(Integer channelId, Date startDate, Date endDate, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 36:   */     throws JSONException
/* 37:   */   {
/* 38:37 */     Site site = ContextTools.getSite(request);
/* 39:   */     try
/* 40:   */     {
/* 41:40 */       Integer docId = this.luceneDocService.createSearchIndex(site.getId(), channelId, 
/* 42:41 */         startDate, endDate, null, Integer.valueOf(1000), true);
/* 43:42 */       JSONObject json = new JSONObject();
/* 44:43 */       while (docId != null) {
/* 45:44 */         docId = this.luceneDocService.createSearchIndex(site.getId(), 
/* 46:45 */           channelId, startDate, endDate, docId, Integer.valueOf(1000), false);
/* 47:   */       }
/* 48:47 */       json.put("success", true);
/* 49:48 */       ResponseUtils.renderJson(response, json.toString());
/* 50:   */     }
/* 51:   */     catch (IOException e)
/* 52:   */     {
/* 53:50 */       e.printStackTrace();
/* 54:   */     }
/* 55:   */   }
/* 56:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.lucene.LuceneDocAct
 * JD-Core Version:    0.7.0.1
 */