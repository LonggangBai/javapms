/*   1:    */ package com.portal.doccenter.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.utils.ResponseUtils;
/*   4:    */ import com.portal.doccenter.entity.Model;
/*   5:    */ import com.portal.doccenter.entity.ModelField;
/*   6:    */ import com.portal.doccenter.service.ModelFieldService;
/*   7:    */ import com.portal.doccenter.service.ModelService;
/*   8:    */ import java.util.List;
/*   9:    */ import javax.servlet.http.HttpServletRequest;
/*  10:    */ import javax.servlet.http.HttpServletResponse;
/*  11:    */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/*  12:    */ import org.json.JSONException;
/*  13:    */ import org.json.JSONObject;
/*  14:    */ import org.slf4j.Logger;
/*  15:    */ import org.slf4j.LoggerFactory;
/*  16:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  17:    */ import org.springframework.stereotype.Controller;
/*  18:    */ import org.springframework.ui.ModelMap;
/*  19:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  20:    */ 
/*  21:    */ @Controller
/*  22:    */ public class ModelFieldAct
/*  23:    */ {
/*  24: 27 */   private static final Logger log = LoggerFactory.getLogger(ModelFieldAct.class);
/*  25:    */   @Autowired
/*  26:    */   private ModelService modelService;
/*  27:    */   @Autowired
/*  28:    */   private ModelFieldService service;
/*  29:    */   
/*  30:    */   @RequiresPermissions({"admin:field:list"})
/*  31:    */   @RequestMapping({"/field/v_list.do"})
/*  32:    */   public String list(Integer modelId, HttpServletRequest request, ModelMap model)
/*  33:    */   {
/*  34: 33 */     model.addAttribute("modelId", modelId);
/*  35: 34 */     return "docCenter/config/model/field/list";
/*  36:    */   }
/*  37:    */   
/*  38:    */   @RequiresPermissions({"admin:field:add"})
/*  39:    */   @RequestMapping({"/field/v_add.do"})
/*  40:    */   public String add(Integer modelId, ModelMap model)
/*  41:    */   {
/*  42: 40 */     Model m = this.modelService.findById(modelId);
/*  43: 41 */     model.addAttribute("model", m);
/*  44: 42 */     model.addAttribute("modelId", modelId);
/*  45: 43 */     return "docCenter/config/model/field/add";
/*  46:    */   }
/*  47:    */   
/*  48:    */   @RequiresPermissions({"admin:field:edit"})
/*  49:    */   @RequestMapping({"/field/v_edit.do"})
/*  50:    */   public String edit(Integer id, ModelMap model)
/*  51:    */   {
/*  52: 49 */     ModelField field = this.service.findById(id);
/*  53: 50 */     model.addAttribute("field", field);
/*  54: 51 */     return "docCenter/config/model/field/edit";
/*  55:    */   }
/*  56:    */   
/*  57:    */   @RequiresPermissions({"admin:field:save"})
/*  58:    */   @RequestMapping({"/field/o_save.do"})
/*  59:    */   public String save(ModelField bean, Integer modelId, HttpServletRequest request, ModelMap model)
/*  60:    */   {
/*  61: 58 */     bean = this.service.save(bean, modelId);
/*  62: 59 */     log.info("update ModelItem id={}.", bean.getId());
/*  63: 60 */     model.addAttribute("modelId", bean.getModel().getId());
/*  64: 61 */     model.addAttribute("msg", "字段添加成功!");
/*  65: 62 */     return add(modelId, model);
/*  66:    */   }
/*  67:    */   
/*  68:    */   @RequiresPermissions({"admin:field:update"})
/*  69:    */   @RequestMapping({"/field/o_update.do"})
/*  70:    */   public String update(ModelField bean, HttpServletRequest request, ModelMap model)
/*  71:    */   {
/*  72: 69 */     bean = this.service.update(bean);
/*  73: 70 */     log.info("update ModelItem id={}.", bean.getId());
/*  74: 71 */     model.addAttribute("modelId", bean.getModel().getId());
/*  75: 72 */     model.addAttribute("msg", "字段修改成功!");
/*  76: 73 */     return edit(bean.getId(), model);
/*  77:    */   }
/*  78:    */   
/*  79:    */   @RequestMapping({"/field/jsonData.do"})
/*  80:    */   public String dataPageByJosn(Integer modelId, String sortname, String sortorder, Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  81:    */   {
/*  82: 81 */     List<ModelField> list = this.service.getList(modelId, true, sortname, 
/*  83: 82 */       sortorder);
/*  84: 83 */     model.addAttribute("list", list);
/*  85: 84 */     response.setHeader("Cache-Control", "no-cache");
/*  86: 85 */     response.setContentType("text/json;charset=UTF-8");
/*  87: 86 */     return "docCenter/config/model/field/dataJson";
/*  88:    */   }
/*  89:    */   
/*  90:    */   @RequiresPermissions({"admin:field:delete"})
/*  91:    */   @RequestMapping({"/field/o_ajax_delete.do"})
/*  92:    */   public void deleteItem(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/*  93:    */     throws JSONException
/*  94:    */   {
/*  95: 93 */     JSONObject json = new JSONObject();
/*  96: 94 */     ModelField[] beans = this.service.deleteByIds(ids);
/*  97: 95 */     for (ModelField bean : beans) {
/*  98: 96 */       log.info("delete Model id={}", bean.getId());
/*  99:    */     }
/* 100: 98 */     json.put("success", true);
/* 101: 99 */     json.put("status", 1);
/* 102:100 */     ResponseUtils.renderJson(response, json.toString());
/* 103:    */   }
/* 104:    */   
/* 105:    */   @RequiresPermissions({"admin:field:priority"})
/* 106:    */   @RequestMapping({"/field/o_priority.do"})
/* 107:    */   public void itemPriority(Integer id, Integer priority, HttpServletRequest request, HttpServletResponse response)
/* 108:    */     throws JSONException
/* 109:    */   {
/* 110:109 */     JSONObject json = new JSONObject();
/* 111:110 */     this.service.updatePriority(id, priority);
/* 112:111 */     json.put("success", true);
/* 113:112 */     json.put("status", 1);
/* 114:113 */     ResponseUtils.renderJson(response, json.toString());
/* 115:    */   }
/* 116:    */   
/* 117:    */   @RequiresPermissions({"admin:field:single"})
/* 118:    */   @RequestMapping({"/field/o_single.do"})
/* 119:    */   public void itemSingle(Integer id, HttpServletRequest request, HttpServletResponse response)
/* 120:    */   {
/* 121:121 */     ModelField bean = this.service.findById(id);
/* 122:122 */     if (bean.getSingle().booleanValue())
/* 123:    */     {
/* 124:123 */       bean.setSingle(Boolean.valueOf(false));
/* 125:124 */       ResponseUtils.renderJson(response, "false");
/* 126:    */     }
/* 127:    */     else
/* 128:    */     {
/* 129:126 */       bean.setSingle(Boolean.valueOf(true));
/* 130:127 */       ResponseUtils.renderJson(response, "true");
/* 131:    */     }
/* 132:129 */     this.service.update(bean);
/* 133:    */   }
/* 134:    */   
/* 135:    */   @RequiresPermissions({"admin:field:show"})
/* 136:    */   @RequestMapping({"/field/o_show.do"})
/* 137:    */   public void itemShow(Integer id, HttpServletRequest request, HttpServletResponse response)
/* 138:    */   {
/* 139:137 */     ModelField bean = this.service.findById(id);
/* 140:138 */     if (bean.getShow().booleanValue())
/* 141:    */     {
/* 142:139 */       bean.setShow(Boolean.valueOf(false));
/* 143:140 */       ResponseUtils.renderJson(response, "false");
/* 144:    */     }
/* 145:    */     else
/* 146:    */     {
/* 147:142 */       bean.setShow(Boolean.valueOf(true));
/* 148:143 */       ResponseUtils.renderJson(response, "true");
/* 149:    */     }
/* 150:145 */     this.service.update(bean);
/* 151:    */   }
/* 152:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.action.ModelFieldAct
 * JD-Core Version:    0.7.0.1
 */