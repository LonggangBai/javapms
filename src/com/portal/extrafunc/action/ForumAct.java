/*   1:    */ package com.portal.extrafunc.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.page.SimplePage;
/*   5:    */ import com.javapms.basic.utils.ResponseUtils;
/*   6:    */ import com.portal.extrafunc.entity.Category;
/*   7:    */ import com.portal.extrafunc.entity.Forum;
/*   8:    */ import com.portal.extrafunc.entity.ForumExt;
/*   9:    */ import com.portal.extrafunc.service.CategoryService;
/*  10:    */ import com.portal.extrafunc.service.ForumService;
/*  11:    */ import com.portal.sysmgr.entity.Site;
/*  12:    */ import com.portal.sysmgr.utils.ContextTools;
/*  13:    */ import java.util.List;
/*  14:    */ import javax.servlet.http.HttpServletRequest;
/*  15:    */ import javax.servlet.http.HttpServletResponse;
/*  16:    */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/*  17:    */ import org.json.JSONException;
/*  18:    */ import org.json.JSONObject;
/*  19:    */ import org.slf4j.Logger;
/*  20:    */ import org.slf4j.LoggerFactory;
/*  21:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  22:    */ import org.springframework.stereotype.Controller;
/*  23:    */ import org.springframework.ui.ModelMap;
/*  24:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  25:    */ 
/*  26:    */ @Controller
/*  27:    */ public class ForumAct
/*  28:    */ {
/*  29: 32 */   private static final Logger log = LoggerFactory.getLogger(ForumAct.class);
/*  30:    */   @Autowired
/*  31:    */   private ForumService service;
/*  32:    */   @Autowired
/*  33:    */   private CategoryService categoryService;
/*  34:    */   
/*  35:    */   @RequiresPermissions({"admin:forum:list"})
/*  36:    */   @RequestMapping({"/forum/v_list.do"})
/*  37:    */   public String list(Integer categoryId, HttpServletRequest request, ModelMap model)
/*  38:    */   {
/*  39: 38 */     Site site = ContextTools.getSite(request);
/*  40: 39 */     List<Category> categoryList = this.categoryService.getList(site.getId(), 
/*  41: 40 */       null, null);
/*  42: 41 */     model.addAttribute("categoryList", categoryList);
/*  43: 42 */     model.addAttribute("categoryId", categoryId);
/*  44: 43 */     return "extraFunc/forum/list";
/*  45:    */   }
/*  46:    */   
/*  47:    */   @RequiresPermissions({"admin:forum:save"})
/*  48:    */   @RequestMapping({"/forum/o_save.do"})
/*  49:    */   public String save(Forum bean, ForumExt ext, Integer categoryId, HttpServletRequest request, ModelMap model)
/*  50:    */   {
/*  51: 50 */     Site site = ContextTools.getSite(request);
/*  52: 51 */     bean = this.service.save(bean, ext, site, categoryId);
/*  53: 52 */     log.info("save Forum id={}", bean.getId());
/*  54: 53 */     model.addAttribute("msg", "板块添加成功!");
/*  55: 54 */     return list(null, request, model);
/*  56:    */   }
/*  57:    */   
/*  58:    */   @RequiresPermissions({"admin:forum:update"})
/*  59:    */   @RequestMapping({"/forum/o_update.do"})
/*  60:    */   public String update(Forum bean, ForumExt ext, Integer categoryId, HttpServletRequest request, ModelMap model)
/*  61:    */   {
/*  62: 61 */     bean = this.service.update(bean, ext, categoryId);
/*  63: 62 */     log.info("update Forum id={}.", bean.getId());
/*  64: 63 */     model.addAttribute("msg", "板块修改成功!");
/*  65: 64 */     return list(null, request, model);
/*  66:    */   }
/*  67:    */   
/*  68:    */   @RequestMapping({"/forum/jsonData.do"})
/*  69:    */   public String dataPageByJosn(Integer categoryId, String sortname, String sortorder, Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  70:    */   {
/*  71: 72 */     Site site = ContextTools.getSite(request);
/*  72: 73 */     Pagination pagination = this.service.getPage(site.getId(), categoryId, 
/*  73: 74 */       sortname, sortorder, SimplePage.cpn(page), pagesize.intValue());
/*  74: 75 */     model.addAttribute("page", pagination);
/*  75: 76 */     response.setHeader("Cache-Control", "no-cache");
/*  76: 77 */     response.setContentType("text/json;charset=UTF-8");
/*  77: 78 */     return "extraFunc/forum/data";
/*  78:    */   }
/*  79:    */   
/*  80:    */   @RequiresPermissions({"admin:forum:delete"})
/*  81:    */   @RequestMapping({"/forum/o_ajax_delete.do"})
/*  82:    */   public void deleteForum(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/*  83:    */     throws JSONException
/*  84:    */   {
/*  85: 85 */     JSONObject json = new JSONObject();
/*  86: 86 */     Forum[] beans = this.service.deleteByIds(ids);
/*  87: 87 */     for (Forum bean : beans) {
/*  88: 88 */       log.info("delete Forum id={}", bean.getId());
/*  89:    */     }
/*  90: 90 */     json.put("success", true);
/*  91: 91 */     json.put("status", 1);
/*  92: 92 */     ResponseUtils.renderJson(response, json.toString());
/*  93:    */   }
/*  94:    */   
/*  95:    */   @RequiresPermissions({"admin:forum:findbyid"})
/*  96:    */   @RequestMapping({"/forum/o_ajax_find.do"})
/*  97:    */   public void findForum(Integer id, HttpServletRequest request, HttpServletResponse response)
/*  98:    */     throws JSONException
/*  99:    */   {
/* 100:100 */     JSONObject json = new JSONObject();
/* 101:101 */     Forum bean = this.service.findById(id);
/* 102:102 */     json.put("name", bean.getName());
/* 103:103 */     json.put("keywords", bean.getKeywords());
/* 104:104 */     json.put("description", bean.getDescription());
/* 105:105 */     json.put("rule", bean.getRule());
/* 106:106 */     json.put("categoryId", bean.getCategory().getId());
/* 107:107 */     json.put("tplContent", bean.getTplContent());
/* 108:108 */     ResponseUtils.renderJson(response, json.toString());
/* 109:    */   }
/* 110:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.ForumAct
 * JD-Core Version:    0.7.0.1
 */