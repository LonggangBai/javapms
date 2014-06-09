/*   1:    */ package com.portal.doccenter.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.utils.ResponseUtils;
/*   4:    */ import com.portal.datacenter.operatedata.service.LogService;
/*   5:    */ import com.portal.doccenter.entity.Model;
/*   6:    */ import com.portal.doccenter.entity.ModelField;
/*   7:    */ import com.portal.doccenter.service.ModelFieldService;
/*   8:    */ import com.portal.doccenter.service.ModelService;
/*   9:    */ import com.portal.sysmgr.service.TplService;
/*  10:    */ import com.portal.sysmgr.utils.Tpl;
/*  11:    */ import java.util.ArrayList;
/*  12:    */ import java.util.List;
/*  13:    */ import javax.servlet.http.HttpServletRequest;
/*  14:    */ import javax.servlet.http.HttpServletResponse;
/*  15:    */ import org.apache.commons.lang.StringUtils;
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
/*  27:    */ public class ModelAct
/*  28:    */ {
/*  29: 32 */   private static final Logger log = LoggerFactory.getLogger(ModelAct.class);
/*  30:    */   @Autowired
/*  31:    */   private LogService logService;
/*  32:    */   @Autowired
/*  33:    */   private ModelService service;
/*  34:    */   @Autowired
/*  35:    */   private TplService tplService;
/*  36:    */   @Autowired
/*  37:    */   private ModelFieldService fieldService;
/*  38:    */   
/*  39:    */   @RequiresPermissions({"admin:model:list"})
/*  40:    */   @RequestMapping({"/model/v_list.do"})
/*  41:    */   public String list(HttpServletRequest request, ModelMap model)
/*  42:    */   {
/*  43: 37 */     return "docCenter/config/model/list";
/*  44:    */   }
/*  45:    */   
/*  46:    */   @RequiresPermissions({"admin:model:add"})
/*  47:    */   @RequestMapping({"/model/v_add.do"})
/*  48:    */   public String add(ModelMap model)
/*  49:    */   {
/*  50: 43 */     List<? extends Tpl> iconList = this.tplService.getFileChild(
/*  51: 44 */       "/skin/sys", "/img/icon");
/*  52: 45 */     model.addAttribute("iconList", iconList);
/*  53: 46 */     return "docCenter/config/model/add";
/*  54:    */   }
/*  55:    */   
/*  56:    */   @RequiresPermissions({"admin:model:edit"})
/*  57:    */   @RequestMapping({"/model/v_edit.do"})
/*  58:    */   public String edit(Integer id, HttpServletRequest request, ModelMap model)
/*  59:    */   {
/*  60: 52 */     List<? extends Tpl> iconList = this.tplService.getFileChild(
/*  61: 53 */       "/skin/sys", "/img/icon");
/*  62: 54 */     model.addAttribute("iconList", iconList);
/*  63: 55 */     model.addAttribute("model", this.service.findById(id));
/*  64: 56 */     return "docCenter/config/model/edit";
/*  65:    */   }
/*  66:    */   
/*  67:    */   @RequiresPermissions({"admin:model:save"})
/*  68:    */   @RequestMapping({"/model/o_save.do"})
/*  69:    */   public String save(Model bean, HttpServletRequest request, ModelMap model)
/*  70:    */   {
/*  71: 62 */     bean = this.service.save(bean);
/*  72: 63 */     List<ModelField> fieldList = getFields(bean);
/*  73: 64 */     this.fieldService.saveList(fieldList);
/*  74: 65 */     log.info("save Model id={}", bean.getId());
/*  75: 66 */     this.logService.operating(request, "添加模型", "id=" + bean.getId() + ";name=" + 
/*  76: 67 */       bean.getName());
/*  77: 68 */     model.addAttribute("msg", "模型添加成功!");
/*  78: 69 */     return add(model);
/*  79:    */   }
/*  80:    */   
/*  81:    */   @RequiresPermissions({"admin:model:update"})
/*  82:    */   @RequestMapping({"/model/o_update.do"})
/*  83:    */   public String update(Model bean, HttpServletRequest request, ModelMap model)
/*  84:    */   {
/*  85: 75 */     bean = this.service.update(bean);
/*  86: 76 */     log.info("update Model id={}.", bean.getId());
/*  87: 77 */     this.logService.operating(request, "修改模型", "id=" + bean.getId() + ";name=" + 
/*  88: 78 */       bean.getName());
/*  89: 79 */     model.addAttribute("msg", "模型修改成功!");
/*  90: 80 */     return edit(bean.getId(), request, model);
/*  91:    */   }
/*  92:    */   
/*  93:    */   @RequestMapping({"/model/jsonData.do"})
/*  94:    */   public String dataPageByJosn(String sortname, String sortorder, Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  95:    */   {
/*  96: 87 */     List<Model> list = this.service.getList(true, sortname, sortorder);
/*  97: 88 */     model.addAttribute("list", list);
/*  98: 89 */     response.setHeader("Cache-Control", "no-cache");
/*  99: 90 */     response.setContentType("text/json;charset=UTF-8");
/* 100: 91 */     return "docCenter/config/model/dataJson";
/* 101:    */   }
/* 102:    */   
/* 103:    */   @RequiresPermissions({"admin:model:delete"})
/* 104:    */   @RequestMapping({"/model/o_ajax_delete.do"})
/* 105:    */   public void deleteModel(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/* 106:    */     throws JSONException
/* 107:    */   {
/* 108: 98 */     JSONObject json = new JSONObject();
/* 109: 99 */     Model[] beans = this.service.deleteByIds(ids);
/* 110:100 */     for (Model bean : beans)
/* 111:    */     {
/* 112:101 */       log.info("delete Model id={}", bean.getId());
/* 113:102 */       this.logService.operating(request, "删除模型", "id=" + bean.getId() + 
/* 114:103 */         ";name=" + bean.getName());
/* 115:    */     }
/* 116:105 */     json.put("success", true);
/* 117:106 */     json.put("status", 1);
/* 118:107 */     ResponseUtils.renderJson(response, json.toString());
/* 119:    */   }
/* 120:    */   
/* 121:    */   @RequiresPermissions({"admin:model:priority"})
/* 122:    */   @RequestMapping({"/model/o_priority.do"})
/* 123:    */   public String priority(Integer[] wids, Integer[] priority, Boolean[] disabled, Integer defId, HttpServletRequest request, ModelMap model)
/* 124:    */   {
/* 125:116 */     this.service.updatePriority(wids, priority, disabled, defId);
/* 126:117 */     model.addAttribute("msg", "序列修改成功!");
/* 127:118 */     return list(request, model);
/* 128:    */   }
/* 129:    */   
/* 130:    */   private List<ModelField> getFields(Model model)
/* 131:    */   {
/* 132:122 */     List<ModelField> list = new ArrayList();
/* 133:    */     
/* 134:124 */     int i = 0;
/* 135:124 */     for (int len = Model.DEF_NAMES.length; i < len; i++) {
/* 136:125 */       if (!StringUtils.isBlank(Model.DEF_NAMES[i]))
/* 137:    */       {
/* 138:126 */         ModelField field = new ModelField();
/* 139:127 */         field.setEconomy(Boolean.valueOf(true));
/* 140:128 */         field.setModel(model);
/* 141:129 */         field.setName(Model.DEF_NAMES[i]);
/* 142:130 */         field.setLabel(Model.DEF_LABELS[i]);
/* 143:131 */         field.setDataType(Model.DEF_DATA_TYPES[i]);
/* 144:132 */         field.setSingle(Boolean.valueOf(true));
/* 145:133 */         field.setShow(Boolean.valueOf(true));
/* 146:134 */         field.setRequired(Model.DEF_REQUIREDS[i]);
/* 147:135 */         field.setPriority(Integer.valueOf(i + 1));
/* 148:136 */         list.add(field);
/* 149:    */       }
/* 150:    */     }
/* 151:139 */     return list;
/* 152:    */   }
/* 153:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.action.ModelAct
 * JD-Core Version:    0.7.0.1
 */