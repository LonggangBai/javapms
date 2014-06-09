/*  1:   */ package com.portal.doccenter.action;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.utils.ResponseUtils;
/*  4:   */ import com.portal.datacenter.operatedata.service.LogService;
/*  5:   */ import com.portal.doccenter.entity.ArticleType;
/*  6:   */ import com.portal.doccenter.service.ArticleTypeService;
/*  7:   */ import java.util.List;
/*  8:   */ import javax.servlet.http.HttpServletRequest;
/*  9:   */ import javax.servlet.http.HttpServletResponse;
/* 10:   */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/* 11:   */ import org.json.JSONException;
/* 12:   */ import org.json.JSONObject;
/* 13:   */ import org.slf4j.Logger;
/* 14:   */ import org.slf4j.LoggerFactory;
/* 15:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 16:   */ import org.springframework.stereotype.Controller;
/* 17:   */ import org.springframework.ui.ModelMap;
/* 18:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 19:   */ 
/* 20:   */ @Controller
/* 21:   */ public class ArticleTypeAct
/* 22:   */ {
/* 23:26 */   private static final Logger log = LoggerFactory.getLogger(ArticleTypeAct.class);
/* 24:   */   @Autowired
/* 25:   */   private LogService logService;
/* 26:   */   @Autowired
/* 27:   */   private ArticleTypeService service;
/* 28:   */   
/* 29:   */   @RequiresPermissions({"admin:doctype:list"})
/* 30:   */   @RequestMapping({"/type/v_list.do"})
/* 31:   */   public String list(Integer pageNo, HttpServletRequest request, ModelMap model)
/* 32:   */   {
/* 33:32 */     return "docCenter/config/type/list";
/* 34:   */   }
/* 35:   */   
/* 36:   */   @RequiresPermissions({"admin:doctype:add"})
/* 37:   */   @RequestMapping({"/type/v_add.do"})
/* 38:   */   public String add(ModelMap model)
/* 39:   */   {
/* 40:38 */     return "docCenter/config/type/add";
/* 41:   */   }
/* 42:   */   
/* 43:   */   @RequiresPermissions({"admin:doctype:edit"})
/* 44:   */   @RequestMapping({"/type/v_edit.do"})
/* 45:   */   public String edit(Integer id, HttpServletRequest request, ModelMap model)
/* 46:   */   {
/* 47:44 */     model.addAttribute("type", this.service.findById(id));
/* 48:45 */     return "docCenter/config/type/edit";
/* 49:   */   }
/* 50:   */   
/* 51:   */   @RequiresPermissions({"admin:doctype:save"})
/* 52:   */   @RequestMapping({"/type/o_save.do"})
/* 53:   */   public String save(ArticleType bean, HttpServletRequest request, ModelMap model)
/* 54:   */   {
/* 55:52 */     bean = this.service.save(bean);
/* 56:53 */     log.info("save Type id={}", bean.getId());
/* 57:54 */     this.logService.operating(request, "类型添加", "id=" + bean.getId() + ";name=" + 
/* 58:55 */       bean.getName());
/* 59:56 */     model.addAttribute("msg", "类型添加成功");
/* 60:57 */     return add(model);
/* 61:   */   }
/* 62:   */   
/* 63:   */   @RequiresPermissions({"admin:doctype:update"})
/* 64:   */   @RequestMapping({"/type/o_update.do"})
/* 65:   */   public String update(ArticleType bean, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 66:   */   {
/* 67:64 */     bean = this.service.update(bean);
/* 68:65 */     log.info("update Type id={}.", bean.getId());
/* 69:66 */     this.logService.operating(request, "类型修改", "id=" + bean.getId() + ";name=" + 
/* 70:67 */       bean.getName());
/* 71:68 */     model.addAttribute("msg", "类型修改成功");
/* 72:69 */     return edit(bean.getId(), request, model);
/* 73:   */   }
/* 74:   */   
/* 75:   */   @RequestMapping({"/type/jsonData.do"})
/* 76:   */   public String dataPageByJosn(String sortname, String sortorder, Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 77:   */   {
/* 78:76 */     List<ArticleType> list = this.service.getList(true, sortname, sortorder);
/* 79:77 */     model.addAttribute("list", list);
/* 80:78 */     response.setHeader("Cache-Control", "no-cache");
/* 81:79 */     response.setContentType("text/json;charset=UTF-8");
/* 82:80 */     return "docCenter/config/type/dataJson";
/* 83:   */   }
/* 84:   */   
/* 85:   */   @RequiresPermissions({"admin:doctype:delete"})
/* 86:   */   @RequestMapping({"/type/o_ajax_delete.do"})
/* 87:   */   public void deleteType(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/* 88:   */     throws JSONException
/* 89:   */   {
/* 90:87 */     JSONObject json = new JSONObject();
/* 91:88 */     ArticleType[] beans = this.service.deleteByIds(ids);
/* 92:89 */     for (ArticleType bean : beans)
/* 93:   */     {
/* 94:90 */       log.info("delete Type id={}", bean.getId());
/* 95:91 */       this.logService.operating(request, "删除类型", "id=" + bean.getId() + 
/* 96:92 */         ";name=" + bean.getName());
/* 97:   */     }
/* 98:94 */     json.put("success", true);
/* 99:95 */     json.put("status", 1);
/* :0:96 */     ResponseUtils.renderJson(response, json.toString());
/* :1:   */   }
/* :2:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.action.ArticleTypeAct
 * JD-Core Version:    0.7.0.1
 */