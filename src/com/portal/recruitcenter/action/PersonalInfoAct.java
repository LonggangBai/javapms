/*   1:    */ package com.portal.recruitcenter.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.page.SimplePage;
/*   5:    */ import com.javapms.basic.utils.ResponseUtils;
/*   6:    */ import com.portal.datacenter.commdata.entity.Industry;
/*   7:    */ import com.portal.datacenter.commdata.entity.Specialty;
/*   8:    */ import com.portal.datacenter.commdata.service.IndustryService;
/*   9:    */ import com.portal.datacenter.commdata.service.SpecialtyService;
/*  10:    */ import com.portal.recruitcenter.entity.PersonalInfo;
/*  11:    */ import com.portal.recruitcenter.entity.PersonalInfoExt;
/*  12:    */ import com.portal.recruitcenter.service.PersonalInfoService;
/*  13:    */ import com.portal.usermgr.service.UserService;
/*  14:    */ import java.util.Date;
/*  15:    */ import java.util.List;
/*  16:    */ import javax.servlet.http.HttpServletRequest;
/*  17:    */ import javax.servlet.http.HttpServletResponse;
/*  18:    */ import org.json.JSONException;
/*  19:    */ import org.json.JSONObject;
/*  20:    */ import org.slf4j.Logger;
/*  21:    */ import org.slf4j.LoggerFactory;
/*  22:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  23:    */ import org.springframework.stereotype.Controller;
/*  24:    */ import org.springframework.ui.ModelMap;
/*  25:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  26:    */ 
/*  27:    */ @Controller
/*  28:    */ public class PersonalInfoAct
/*  29:    */ {
/*  30: 35 */   private static final Logger log = LoggerFactory.getLogger(PersonalInfoAct.class);
/*  31:    */   @Autowired
/*  32:    */   private PersonalInfoService service;
/*  33:    */   @Autowired
/*  34:    */   private SpecialtyService specialtyService;
/*  35:    */   @Autowired
/*  36:    */   private IndustryService industryService;
/*  37:    */   @Autowired
/*  38:    */   private UserService userService;
/*  39:    */   
/*  40:    */   @RequestMapping({"/personalInfo/v_list.do"})
/*  41:    */   public String list(String key, Integer specialId, Integer industryId, Date startTime, Date endTime, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  42:    */   {
/*  43: 41 */     Pagination pagination = this.service.getPageBySelect(key, specialId, 
/*  44: 42 */       industryId, startTime, endTime, SimplePage.cpn(pageNo), 
/*  45: 43 */       20);
/*  46: 44 */     List<Specialty> specialtyList = this.specialtyService.getSpecialtyList(null);
/*  47: 45 */     List<Industry> industryList = this.industryService.getIndustryList(null);
/*  48: 46 */     model.addAttribute("pagination", pagination);
/*  49: 47 */     model.addAttribute("key", key);
/*  50: 48 */     model.addAttribute("specialtyList", specialtyList);
/*  51: 49 */     model.addAttribute("industryList", industryList);
/*  52: 50 */     model.addAttribute("specialId", specialId);
/*  53: 51 */     model.addAttribute("industryId", industryId);
/*  54: 52 */     model.addAttribute("startTime", startTime);
/*  55: 53 */     model.addAttribute("endTime", endTime);
/*  56: 54 */     model.addAttribute("pageNo", Integer.valueOf(pagination.getPageNo()));
/*  57: 55 */     return "personalInfo/list";
/*  58:    */   }
/*  59:    */   
/*  60:    */   @RequestMapping({"/personalInfo/v_add.do"})
/*  61:    */   public String add(ModelMap model)
/*  62:    */   {
/*  63: 60 */     return "personalInfo/add";
/*  64:    */   }
/*  65:    */   
/*  66:    */   @RequestMapping({"/personalInfo/v_edit.do"})
/*  67:    */   public String edit(Integer id, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  68:    */   {
/*  69: 66 */     model.addAttribute("personalInfo", this.service.findById(id));
/*  70: 67 */     model.addAttribute("pageNo", pageNo);
/*  71: 68 */     return "personalInfo/edit";
/*  72:    */   }
/*  73:    */   
/*  74:    */   @RequestMapping({"/personalInfo/o_save.do"})
/*  75:    */   public String save(PersonalInfo bean, PersonalInfoExt ext, Integer specialId, HttpServletRequest request, ModelMap model)
/*  76:    */   {
/*  77: 74 */     bean = this.service.save(bean, ext, specialId);
/*  78: 75 */     log.info("save PersonalInfo id={}", bean.getId());
/*  79: 76 */     return "redirect:v_list.do";
/*  80:    */   }
/*  81:    */   
/*  82:    */   @RequestMapping({"/personalInfo/o_update.do"})
/*  83:    */   public String update(PersonalInfo bean, PersonalInfoExt ext, Integer specialId, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  84:    */   {
/*  85: 83 */     bean = this.service.update(bean, ext, specialId, null, null);
/*  86: 84 */     log.info("update PersonalInfo id={}.", bean.getId());
/*  87: 85 */     return list(null, null, null, null, null, pageNo, request, model);
/*  88:    */   }
/*  89:    */   
/*  90:    */   @RequestMapping({"/personalInfo/o_check.do"})
/*  91:    */   public String check(Integer id, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  92:    */   {
/*  93: 91 */     PersonalInfo bean = this.service.findById(id);
/*  94: 92 */     if ((bean.getCheck() != null) && (bean.getCheck().booleanValue())) {
/*  95: 93 */       bean.setCheck(Boolean.valueOf(false));
/*  96:    */     } else {
/*  97: 95 */       bean.setCheck(Boolean.valueOf(true));
/*  98:    */     }
/*  99: 97 */     this.service.update(bean);
/* 100: 98 */     log.info("update PersonalInfo id={}.", bean.getId());
/* 101: 99 */     return list(null, null, null, null, null, pageNo, request, model);
/* 102:    */   }
/* 103:    */   
/* 104:    */   @RequestMapping({"/personalInfo/o_commend.do"})
/* 105:    */   public String commend(Integer id, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 106:    */   {
/* 107:105 */     PersonalInfo bean = this.service.findById(id);
/* 108:106 */     if ((bean.getCommend() != null) && (bean.getCommend().booleanValue())) {
/* 109:107 */       bean.setCommend(Boolean.valueOf(false));
/* 110:    */     } else {
/* 111:109 */       bean.setCommend(Boolean.valueOf(true));
/* 112:    */     }
/* 113:111 */     this.service.update(bean);
/* 114:112 */     log.info("update PersonalInfo id={}.", bean.getId());
/* 115:113 */     return list(null, null, null, null, null, pageNo, request, model);
/* 116:    */   }
/* 117:    */   
/* 118:    */   @RequestMapping({"/personalInfo/o_delete.do"})
/* 119:    */   public String delete(Integer[] ids, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 120:    */   {
/* 121:119 */     PersonalInfo[] beans = this.service.deleteByIds(ids);
/* 122:120 */     for (PersonalInfo bean : beans) {
/* 123:121 */       log.info("delete PersonalInfo id={}", bean.getId());
/* 124:    */     }
/* 125:123 */     return list(null, null, null, null, null, pageNo, request, model);
/* 126:    */   }
/* 127:    */   
/* 128:    */   @RequestMapping(value={"/personalInfo/o_passwordUpdate.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 129:    */   public void passwordAjaxUpdate(Integer userId, String password, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 130:    */     throws JSONException
/* 131:    */   {
/* 132:130 */     JSONObject json = new JSONObject();
/* 133:131 */     if (userId == null)
/* 134:    */     {
/* 135:132 */       json.put("success", false);
/* 136:133 */       json.put("status", 0);
/* 137:134 */       ResponseUtils.renderJson(response, json.toString());
/* 138:135 */       return;
/* 139:    */     }
/* 140:137 */     json.put("success", true);
/* 141:138 */     json.put("status", 1);
/* 142:139 */     ResponseUtils.renderJson(response, json.toString());
/* 143:    */   }
/* 144:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.PersonalInfoAct
 * JD-Core Version:    0.7.0.1
 */