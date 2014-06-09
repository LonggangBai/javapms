/*  1:   */ package com.portal.extrafunc.action;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.utils.ResponseUtils;
/*  4:   */ import com.portal.datacenter.operatedata.service.LogService;
/*  5:   */ import com.portal.extrafunc.entity.Category;
/*  6:   */ import com.portal.extrafunc.service.CategoryService;
/*  7:   */ import com.portal.sysmgr.entity.Site;
/*  8:   */ import com.portal.sysmgr.utils.ContextTools;
/*  9:   */ import java.util.List;
/* 10:   */ import javax.servlet.http.HttpServletRequest;
/* 11:   */ import javax.servlet.http.HttpServletResponse;
/* 12:   */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/* 13:   */ import org.json.JSONException;
/* 14:   */ import org.json.JSONObject;
/* 15:   */ import org.slf4j.Logger;
/* 16:   */ import org.slf4j.LoggerFactory;
/* 17:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 18:   */ import org.springframework.stereotype.Controller;
/* 19:   */ import org.springframework.ui.ModelMap;
/* 20:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 21:   */ 
/* 22:   */ @Controller
/* 23:   */ public class CategoryAct
/* 24:   */ {
/* 25:28 */   private static final Logger log = LoggerFactory.getLogger(CategoryAct.class);
/* 26:   */   @Autowired
/* 27:   */   private CategoryService service;
/* 28:   */   @Autowired
/* 29:   */   private LogService logService;
/* 30:   */   
/* 31:   */   @RequiresPermissions({"admin:category:list"})
/* 32:   */   @RequestMapping({"/category/v_list.do"})
/* 33:   */   public String list()
/* 34:   */   {
/* 35:33 */     return "extraFunc/category/list";
/* 36:   */   }
/* 37:   */   
/* 38:   */   @RequiresPermissions({"admin:category:add"})
/* 39:   */   @RequestMapping({"/category/v_add.do"})
/* 40:   */   public String add()
/* 41:   */   {
/* 42:39 */     return "extraFunc/category/add";
/* 43:   */   }
/* 44:   */   
/* 45:   */   @RequiresPermissions({"admin:category:edit"})
/* 46:   */   @RequestMapping({"/category/v_edit.do"})
/* 47:   */   public String edit(Integer id, HttpServletRequest request, ModelMap model)
/* 48:   */   {
/* 49:45 */     model.addAttribute("category", this.service.findById(id));
/* 50:46 */     return "extraFunc/category/edit";
/* 51:   */   }
/* 52:   */   
/* 53:   */   @RequiresPermissions({"admin:category:save"})
/* 54:   */   @RequestMapping({"/category/o_save.do"})
/* 55:   */   public String save(Category bean, HttpServletRequest request, ModelMap model)
/* 56:   */   {
/* 57:52 */     Site site = ContextTools.getSite(request);
/* 58:53 */     bean = this.service.save(bean, site);
/* 59:54 */     log.info("save Category id={}", bean.getId());
/* 60:55 */     this.logService.operating(request, "添加分类", "id=" + bean.getId());
/* 61:56 */     model.addAttribute("msg", "分类添加成功!");
/* 62:57 */     return list();
/* 63:   */   }
/* 64:   */   
/* 65:   */   @RequiresPermissions({"admin:category:update"})
/* 66:   */   @RequestMapping({"/category/o_update.do"})
/* 67:   */   public String update(Category bean, HttpServletRequest request, ModelMap model)
/* 68:   */   {
/* 69:64 */     bean = this.service.update(bean);
/* 70:65 */     log.info("update Category id={}.", bean.getId());
/* 71:66 */     this.logService.operating(request, "修改分类", "id=" + bean.getId());
/* 72:67 */     model.addAttribute("msg", "分类修改成功!");
/* 73:68 */     return list();
/* 74:   */   }
/* 75:   */   
/* 76:   */   @RequestMapping({"/category/jsonData.do"})
/* 77:   */   public String dataPageByJosn(String sortname, String sortorder, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 78:   */   {
/* 79:75 */     Site site = ContextTools.getSite(request);
/* 80:76 */     List<Category> list = this.service
/* 81:77 */       .getList(site.getId(), sortname, sortorder);
/* 82:78 */     model.addAttribute("list", list);
/* 83:79 */     response.setHeader("Cache-Control", "no-cache");
/* 84:80 */     response.setContentType("text/json;charset=UTF-8");
/* 85:81 */     return "extraFunc/category/data";
/* 86:   */   }
/* 87:   */   
/* 88:   */   @RequiresPermissions({"admin:category:delete"})
/* 89:   */   @RequestMapping({"/category/o_ajax_delete.do"})
/* 90:   */   public void deleteCategory(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/* 91:   */     throws JSONException
/* 92:   */   {
/* 93:88 */     JSONObject json = new JSONObject();
/* 94:89 */     Category[] beans = this.service.deleteByIds(ids);
/* 95:90 */     for (Category bean : beans)
/* 96:   */     {
/* 97:91 */       log.info("delete Category id={}", bean.getId());
/* 98:92 */       this.logService.operating(request, "删除分类", "id=" + bean.getId());
/* 99:   */     }
/* :0:94 */     json.put("success", true);
/* :1:95 */     json.put("status", 1);
/* :2:96 */     ResponseUtils.renderJson(response, json.toString());
/* :3:   */   }
/* :4:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.CategoryAct
 * JD-Core Version:    0.7.0.1
 */