/*   1:    */ package com.portal.datacenter.operatedata.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.page.SimplePage;
/*   5:    */ import com.javapms.basic.utils.ResponseUtils;
/*   6:    */ import com.portal.datacenter.operatedata.entity.Log;
/*   7:    */ import com.portal.datacenter.operatedata.service.LogService;
/*   8:    */ import com.portal.sysmgr.entity.Site;
/*   9:    */ import com.portal.sysmgr.utils.ContextTools;
/*  10:    */ import javax.servlet.http.HttpServletRequest;
/*  11:    */ import javax.servlet.http.HttpServletResponse;
/*  12:    */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/*  13:    */ import org.json.JSONException;
/*  14:    */ import org.json.JSONObject;
/*  15:    */ import org.slf4j.Logger;
/*  16:    */ import org.slf4j.LoggerFactory;
/*  17:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  18:    */ import org.springframework.stereotype.Controller;
/*  19:    */ import org.springframework.ui.ModelMap;
/*  20:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  21:    */ 
/*  22:    */ @Controller
/*  23:    */ public class LogAct
/*  24:    */ {
/*  25: 27 */   private static final Logger log = LoggerFactory.getLogger(LogAct.class);
/*  26:    */   @Autowired
/*  27:    */   private LogService manager;
/*  28:    */   
/*  29:    */   @RequiresPermissions({"admin:log:list_operating"})
/*  30:    */   @RequestMapping({"/log/v_list_operating.do"})
/*  31:    */   public String listOperating()
/*  32:    */   {
/*  33: 32 */     return "dataCenter/logData/operaLog";
/*  34:    */   }
/*  35:    */   
/*  36:    */   @RequiresPermissions({"admin:log:list_success"})
/*  37:    */   @RequestMapping({"/log/v_list_success.do"})
/*  38:    */   public String listLoginSuccess()
/*  39:    */   {
/*  40: 38 */     return "dataCenter/logData/sloginLog";
/*  41:    */   }
/*  42:    */   
/*  43:    */   @RequiresPermissions({"admin:log:list_failure"})
/*  44:    */   @RequestMapping({"/log/v_list_failure.do"})
/*  45:    */   public String listLoginFailure()
/*  46:    */   {
/*  47: 44 */     return "dataCenter/logData/floginLog";
/*  48:    */   }
/*  49:    */   
/*  50:    */   @RequestMapping({"/operating/jsonData.do"})
/*  51:    */   public String operatingPageByJosn(String queryUsername, String queryTitle, String queryIp, Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  52:    */   {
/*  53: 52 */     Site site = ContextTools.getSite(request);
/*  54: 53 */     Pagination pagination = this.manager.getPage(Integer.valueOf(3), site.getId(), 
/*  55: 54 */       queryUsername, queryTitle, queryIp, SimplePage.cpn(page), pagesize.intValue());
/*  56: 55 */     model.addAttribute("pagination", pagination);
/*  57: 56 */     response.setHeader("Cache-Control", "no-cache");
/*  58: 57 */     response.setContentType("text/json;charset=UTF-8");
/*  59: 58 */     return "dataCenter/logData/opdatatree";
/*  60:    */   }
/*  61:    */   
/*  62:    */   @RequiresPermissions({"admin:operating:delete"})
/*  63:    */   @RequestMapping({"/operating/o_ajax_delete.do"})
/*  64:    */   public void deleteOperating(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/*  65:    */     throws JSONException
/*  66:    */   {
/*  67: 65 */     JSONObject json = new JSONObject();
/*  68: 66 */     Log[] beans = this.manager.deleteByIds(ids);
/*  69: 67 */     for (Log bean : beans) {
/*  70: 68 */       log.info("delete Log id={}", bean.getId());
/*  71:    */     }
/*  72: 70 */     json.put("success", true);
/*  73: 71 */     json.put("status", 1);
/*  74: 72 */     ResponseUtils.renderJson(response, json.toString());
/*  75:    */   }
/*  76:    */   
/*  77:    */   @RequiresPermissions({"admin:operating:clear"})
/*  78:    */   @RequestMapping({"/operating/o_ajax_clear.do"})
/*  79:    */   public void clearOperating(Integer days, HttpServletRequest request, HttpServletResponse response)
/*  80:    */     throws JSONException
/*  81:    */   {
/*  82: 80 */     JSONObject json = new JSONObject();
/*  83: 81 */     Site site = ContextTools.getSite(request);
/*  84: 82 */     this.manager.deleteBatch(Integer.valueOf(3), site.getId(), days);
/*  85: 83 */     json.put("success", true);
/*  86: 84 */     json.put("status", 1);
/*  87: 85 */     ResponseUtils.renderJson(response, json.toString());
/*  88:    */   }
/*  89:    */   
/*  90:    */   @RequestMapping({"/logsuccess/jsonData.do"})
/*  91:    */   public String logsuccessPageByJosn(String queryUsername, String queryTitle, String queryIp, Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  92:    */   {
/*  93: 94 */     Pagination pagination = this.manager.getPage(Integer.valueOf(1), null, 
/*  94: 95 */       queryUsername, queryTitle, queryIp, SimplePage.cpn(page), pagesize.intValue());
/*  95: 96 */     model.addAttribute("pagination", pagination);
/*  96: 97 */     response.setHeader("Cache-Control", "no-cache");
/*  97: 98 */     response.setContentType("text/json;charset=UTF-8");
/*  98: 99 */     return "dataCenter/logData/sdatatree";
/*  99:    */   }
/* 100:    */   
/* 101:    */   @RequiresPermissions({"admin:logsuccess:delete"})
/* 102:    */   @RequestMapping({"/logsuccess/o_ajax_delete.do"})
/* 103:    */   public void deleteLogsuccess(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/* 104:    */     throws JSONException
/* 105:    */   {
/* 106:106 */     JSONObject json = new JSONObject();
/* 107:107 */     Log[] beans = this.manager.deleteByIds(ids);
/* 108:108 */     for (Log bean : beans) {
/* 109:109 */       log.info("delete Log id={}", bean.getId());
/* 110:    */     }
/* 111:111 */     json.put("success", true);
/* 112:112 */     json.put("status", 1);
/* 113:113 */     ResponseUtils.renderJson(response, json.toString());
/* 114:    */   }
/* 115:    */   
/* 116:    */   @RequiresPermissions({"admin:logsuccess:clear"})
/* 117:    */   @RequestMapping({"/logsuccess/o_ajax_clear.do"})
/* 118:    */   public void clearLogsuccess(Integer days, HttpServletRequest request, HttpServletResponse response)
/* 119:    */     throws JSONException
/* 120:    */   {
/* 121:121 */     JSONObject json = new JSONObject();
/* 122:122 */     if (days == null) {
/* 123:123 */       days = Integer.valueOf(0);
/* 124:    */     }
/* 125:125 */     this.manager.deleteBatch(Integer.valueOf(1), null, days);
/* 126:126 */     json.put("success", true);
/* 127:127 */     json.put("status", 1);
/* 128:128 */     ResponseUtils.renderJson(response, json.toString());
/* 129:    */   }
/* 130:    */   
/* 131:    */   @RequestMapping({"/logfailure/jsonData.do"})
/* 132:    */   public String logfailurePageByJosn(String queryUsername, String queryTitle, String queryIp, Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 133:    */   {
/* 134:137 */     Pagination pagination = this.manager.getPage(Integer.valueOf(2), null, 
/* 135:138 */       null, queryTitle, queryIp, SimplePage.cpn(page), pagesize.intValue());
/* 136:139 */     model.addAttribute("pagination", pagination);
/* 137:140 */     response.setHeader("Cache-Control", "no-cache");
/* 138:141 */     response.setContentType("text/json;charset=UTF-8");
/* 139:142 */     return "dataCenter/logData/fdatatree";
/* 140:    */   }
/* 141:    */   
/* 142:    */   @RequiresPermissions({"admin:logfailure:delete"})
/* 143:    */   @RequestMapping({"/logfailure/o_ajax_delete.do"})
/* 144:    */   public void deleteLogfailure(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/* 145:    */     throws JSONException
/* 146:    */   {
/* 147:149 */     JSONObject json = new JSONObject();
/* 148:150 */     Log[] beans = this.manager.deleteByIds(ids);
/* 149:151 */     for (Log bean : beans) {
/* 150:152 */       log.info("delete Log id={}", bean.getId());
/* 151:    */     }
/* 152:154 */     json.put("success", true);
/* 153:155 */     json.put("status", 1);
/* 154:156 */     ResponseUtils.renderJson(response, json.toString());
/* 155:    */   }
/* 156:    */   
/* 157:    */   @RequiresPermissions({"admin:logfailure:clear"})
/* 158:    */   @RequestMapping({"/logfailure/o_ajax_clear.do"})
/* 159:    */   public void clearLogfailure(Integer days, HttpServletRequest request, HttpServletResponse response)
/* 160:    */     throws JSONException
/* 161:    */   {
/* 162:164 */     JSONObject json = new JSONObject();
/* 163:165 */     if (days == null) {
/* 164:166 */       days = Integer.valueOf(0);
/* 165:    */     }
/* 166:168 */     this.manager.deleteBatch(Integer.valueOf(2), null, days);
/* 167:169 */     json.put("success", true);
/* 168:170 */     json.put("status", 1);
/* 169:171 */     ResponseUtils.renderJson(response, json.toString());
/* 170:    */   }
/* 171:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.operatedata.action.LogAct
 * JD-Core Version:    0.7.0.1
 */