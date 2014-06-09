/*   1:    */ package com.portal.recruitcenter.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.page.SimplePage;
/*   5:    */ import com.portal.datacenter.commdata.entity.Industry;
/*   6:    */ import com.portal.datacenter.commdata.entity.Metier;
/*   7:    */ import com.portal.datacenter.commdata.service.IndustryService;
/*   8:    */ import com.portal.datacenter.commdata.service.MetierService;
/*   9:    */ import com.portal.recruitcenter.entity.JobPost;
/*  10:    */ import com.portal.recruitcenter.entity.JobPostExt;
/*  11:    */ import com.portal.recruitcenter.service.JobPostService;
/*  12:    */ import java.util.List;
/*  13:    */ import javax.servlet.http.HttpServletRequest;
/*  14:    */ import org.apache.commons.lang.StringUtils;
/*  15:    */ import org.slf4j.Logger;
/*  16:    */ import org.slf4j.LoggerFactory;
/*  17:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  18:    */ import org.springframework.stereotype.Controller;
/*  19:    */ import org.springframework.ui.ModelMap;
/*  20:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  21:    */ 
/*  22:    */ @Controller
/*  23:    */ public class JobPostAct
/*  24:    */ {
/*  25: 28 */   private static final Logger log = LoggerFactory.getLogger(JobPostAct.class);
/*  26:    */   @Autowired
/*  27:    */   private JobPostService service;
/*  28:    */   @Autowired
/*  29:    */   private IndustryService industryService;
/*  30:    */   @Autowired
/*  31:    */   private MetierService metierService;
/*  32:    */   
/*  33:    */   @RequestMapping({"/jobpost/v_list.do"})
/*  34:    */   public String list(String queryKey, Integer queryCompanyId, Integer queryMetierId, Integer queryIndustryId, Byte queryWage, Byte queryEdu, Integer queryNatureId, Byte queryScale, Byte queryGender, Byte queryWorkExp, Integer queryMinAge, Integer queryMaxAge, String queryJobType, Boolean queryShow, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  35:    */   {
/*  36: 37 */     Pagination pagination = this.service.getPage(queryKey, queryCompanyId, 
/*  37: 38 */       queryMetierId, queryIndustryId, queryWage, queryEdu, 
/*  38: 39 */       queryNatureId, queryScale, queryGender, queryWorkExp, 
/*  39: 40 */       queryMinAge, queryMaxAge, queryJobType, queryShow, SimplePage.cpn(pageNo), 
/*  40: 41 */       20);
/*  41: 42 */     List<Industry> industryList = this.industryService.getIndustryList(null);
/*  42: 43 */     List<Metier> metierList = this.metierService.getMetierList(null);
/*  43: 44 */     model.addAttribute("pagination", pagination);
/*  44: 45 */     model.addAttribute("industryList", industryList);
/*  45: 46 */     model.addAttribute("metierList", metierList);
/*  46: 47 */     addAttibuteForQuery(model, queryKey, queryCompanyId, queryMetierId, 
/*  47: 48 */       queryIndustryId, queryWage, queryEdu, queryNatureId, 
/*  48: 49 */       queryScale, queryGender, queryWorkExp, queryMinAge, 
/*  49: 50 */       queryMaxAge, queryJobType, queryShow, pageNo);
/*  50: 51 */     return "jobpost/list";
/*  51:    */   }
/*  52:    */   
/*  53:    */   @RequestMapping({"/jobpost/v_add.do"})
/*  54:    */   public String add(ModelMap model)
/*  55:    */   {
/*  56: 56 */     return "jobpost/add";
/*  57:    */   }
/*  58:    */   
/*  59:    */   @RequestMapping({"/jobpost/v_edit.do"})
/*  60:    */   public String edit(Integer id, String queryKey, Integer queryCompanyId, Integer queryMetierId, Integer queryIndustryId, Byte queryWage, Byte queryEdu, Integer queryNatureId, Byte queryScale, Byte queryGender, Byte queryWorkExp, Integer queryMinAge, Integer queryMaxAge, String queryJobType, Boolean queryShow, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  61:    */   {
/*  62: 66 */     List<Metier> metierList = this.metierService.getMetierList(null);
/*  63: 67 */     List<Metier> metierList1 = this.metierService.getMetierChild(this.service
/*  64: 68 */       .findById(id).getMetier().getParent().getId());
/*  65: 69 */     model.addAttribute("jobPost", this.service.findById(id));
/*  66: 70 */     model.addAttribute("metierList", metierList);
/*  67: 71 */     model.addAttribute("metierList1", metierList1);
/*  68: 72 */     addAttibuteForQuery(model, queryKey, queryCompanyId, queryMetierId, 
/*  69: 73 */       queryIndustryId, queryWage, queryEdu, queryNatureId, 
/*  70: 74 */       queryScale, queryGender, queryWorkExp, queryMinAge, 
/*  71: 75 */       queryMaxAge, queryJobType, queryShow, pageNo);
/*  72: 76 */     return "jobpost/edit";
/*  73:    */   }
/*  74:    */   
/*  75:    */   @RequestMapping({"/jobpost/o_save.do"})
/*  76:    */   public String save(JobPost bean, JobPostExt ext, Integer metierId, HttpServletRequest request, ModelMap model)
/*  77:    */   {
/*  78: 82 */     bean = this.service.save(bean, ext, metierId);
/*  79: 83 */     log.info("save JobPost id={}", bean.getId());
/*  80: 84 */     return "redirect:v_list.do";
/*  81:    */   }
/*  82:    */   
/*  83:    */   @RequestMapping({"/jobpost/o_update.do"})
/*  84:    */   public String update(JobPost bean, JobPostExt ext, Integer metierId, String queryKey, Integer queryCompanyId, Integer queryMetierId, Integer queryIndustryId, Byte queryWage, Byte queryEdu, Integer queryNatureId, Byte queryScale, Byte queryGender, Byte queryWorkExp, Integer queryMinAge, Integer queryMaxAge, String queryJobType, Boolean queryShow, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  85:    */   {
/*  86: 95 */     bean = this.service.update(bean, ext, metierId);
/*  87: 96 */     log.info("update JobPost id={}.", bean.getId());
/*  88: 97 */     return list(queryKey, queryCompanyId, queryMetierId, queryIndustryId, 
/*  89: 98 */       queryWage, queryEdu, queryNatureId, queryScale, queryGender, 
/*  90: 99 */       queryWorkExp, queryMinAge, queryMaxAge, queryJobType, 
/*  91:100 */       queryShow, pageNo, request, model);
/*  92:    */   }
/*  93:    */   
/*  94:    */   @RequestMapping({"/jobpost/o_delete.do"})
/*  95:    */   public String delete(Integer[] ids, String queryKey, Integer queryCompanyId, Integer queryMetierId, Integer queryIndustryId, Byte queryWage, Byte queryEdu, Integer queryNatureId, Byte queryScale, Byte queryGender, Byte queryWorkExp, Integer queryMinAge, Integer queryMaxAge, String queryJobType, Boolean queryShow, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  96:    */   {
/*  97:111 */     JobPost[] beans = this.service.deleteByIds(ids);
/*  98:112 */     for (JobPost bean : beans) {
/*  99:113 */       log.info("delete JobPost id={}", bean.getId());
/* 100:    */     }
/* 101:115 */     return list(queryKey, queryCompanyId, queryMetierId, queryIndustryId, 
/* 102:116 */       queryWage, queryEdu, queryNatureId, queryScale, queryGender, 
/* 103:117 */       queryWorkExp, queryMinAge, queryMaxAge, queryJobType, 
/* 104:118 */       queryShow, pageNo, request, model);
/* 105:    */   }
/* 106:    */   
/* 107:    */   @RequestMapping({"/jobpost/o_check.do"})
/* 108:    */   public String check(Integer id, String queryKey, Integer queryCompanyId, Integer queryMetierId, Integer queryIndustryId, Byte queryWage, Byte queryEdu, Integer queryNatureId, Byte queryScale, Byte queryGender, Byte queryWorkExp, Integer queryMinAge, Integer queryMaxAge, String queryJobType, Boolean queryShow, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 109:    */   {
/* 110:128 */     JobPost bean = this.service.findById(id);
/* 111:129 */     if ((bean.getCheck() != null) && (bean.getCheck().booleanValue())) {
/* 112:130 */       bean.setCheck(Boolean.valueOf(false));
/* 113:    */     } else {
/* 114:132 */       bean.setCheck(Boolean.valueOf(true));
/* 115:    */     }
/* 116:134 */     this.service.update(bean);
/* 117:135 */     log.info("update JobPost id={}.", bean.getId());
/* 118:136 */     return list(queryKey, queryCompanyId, queryMetierId, queryIndustryId, 
/* 119:137 */       queryWage, queryEdu, queryNatureId, queryScale, queryGender, 
/* 120:138 */       queryWorkExp, queryMinAge, queryMaxAge, queryJobType, 
/* 121:139 */       queryShow, pageNo, request, model);
/* 122:    */   }
/* 123:    */   
/* 124:    */   private void addAttibuteForQuery(ModelMap model, String queryKey, Integer queryCompanyId, Integer queryMetierId, Integer queryIndustryId, Byte queryWage, Byte queryEdu, Integer queryNatureId, Byte queryScale, Byte queryGender, Byte queryWorkExp, Integer queryMinAge, Integer queryMaxAge, String queryJobType, Boolean queryShow, Integer pageNo)
/* 125:    */   {
/* 126:148 */     if (!StringUtils.isBlank(queryKey)) {
/* 127:149 */       model.addAttribute("queryKey", queryKey);
/* 128:    */     }
/* 129:151 */     if (queryCompanyId != null) {
/* 130:152 */       model.addAttribute("queryCompanyId", queryCompanyId);
/* 131:    */     }
/* 132:154 */     if (queryMetierId != null) {
/* 133:155 */       model.addAttribute("queryMetierId", queryMetierId);
/* 134:    */     }
/* 135:157 */     if (queryIndustryId != null) {
/* 136:158 */       model.addAttribute("queryIndustryId", queryIndustryId);
/* 137:    */     }
/* 138:160 */     if (queryWage != null) {
/* 139:161 */       model.addAttribute("queryWage", queryWage);
/* 140:    */     }
/* 141:163 */     if (queryEdu != null) {
/* 142:164 */       model.addAttribute("queryEdu", queryEdu);
/* 143:    */     }
/* 144:166 */     if (queryNatureId != null) {
/* 145:167 */       model.addAttribute("queryNatureId", queryNatureId);
/* 146:    */     }
/* 147:169 */     if (queryScale != null) {
/* 148:170 */       model.addAttribute("queryScale", queryScale);
/* 149:    */     }
/* 150:172 */     if (queryGender != null) {
/* 151:173 */       model.addAttribute("queryGender", queryGender);
/* 152:    */     }
/* 153:175 */     if (queryWorkExp != null) {
/* 154:176 */       model.addAttribute("queryWorkExp", queryWorkExp);
/* 155:    */     }
/* 156:178 */     if (queryMinAge != null) {
/* 157:179 */       model.addAttribute("queryMinAge", queryMinAge);
/* 158:    */     }
/* 159:181 */     if (queryMaxAge != null) {
/* 160:182 */       model.addAttribute("queryMaxAge", queryMaxAge);
/* 161:    */     }
/* 162:184 */     if (!StringUtils.isBlank(queryJobType)) {
/* 163:185 */       model.addAttribute("queryJobType", queryJobType);
/* 164:    */     }
/* 165:187 */     if (queryShow != null) {
/* 166:188 */       model.addAttribute("queryShow", queryShow);
/* 167:    */     }
/* 168:190 */     if (pageNo != null) {
/* 169:191 */       model.addAttribute("pageNo", pageNo);
/* 170:    */     }
/* 171:    */   }
/* 172:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.JobPostAct
 * JD-Core Version:    0.7.0.1
 */