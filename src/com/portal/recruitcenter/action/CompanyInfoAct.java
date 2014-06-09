/*   1:    */ package com.portal.recruitcenter.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.page.SimplePage;
/*   5:    */ import com.javapms.basic.utils.ResponseUtils;
/*   6:    */ import com.portal.datacenter.commdata.entity.EconomyType;
/*   7:    */ import com.portal.datacenter.commdata.entity.Industry;
/*   8:    */ import com.portal.datacenter.commdata.service.EconomyTypeService;
/*   9:    */ import com.portal.datacenter.commdata.service.IndustryService;
/*  10:    */ import com.portal.recruitcenter.entity.CompanyInfo;
/*  11:    */ import com.portal.recruitcenter.entity.CompanyInfoExt;
/*  12:    */ import com.portal.recruitcenter.entity.JobFairs;
/*  13:    */ import com.portal.recruitcenter.entity.VipType;
/*  14:    */ import com.portal.recruitcenter.service.CompanyInfoService;
/*  15:    */ import com.portal.recruitcenter.service.JobFairsService;
/*  16:    */ import com.portal.recruitcenter.service.VipTypeService;
/*  17:    */ import java.util.Date;
/*  18:    */ import java.util.List;
/*  19:    */ import javax.servlet.http.HttpServletRequest;
/*  20:    */ import javax.servlet.http.HttpServletResponse;
/*  21:    */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/*  22:    */ import org.json.JSONException;
/*  23:    */ import org.json.JSONObject;
/*  24:    */ import org.slf4j.Logger;
/*  25:    */ import org.slf4j.LoggerFactory;
/*  26:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  27:    */ import org.springframework.stereotype.Controller;
/*  28:    */ import org.springframework.ui.ModelMap;
/*  29:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  30:    */ 
/*  31:    */ @Controller
/*  32:    */ public class CompanyInfoAct
/*  33:    */ {
/*  34: 39 */   private static final Logger log = LoggerFactory.getLogger(CompanyInfoAct.class);
/*  35:    */   @Autowired
/*  36:    */   private CompanyInfoService service;
/*  37:    */   @Autowired
/*  38:    */   private JobFairsService jobFairsService;
/*  39:    */   @Autowired
/*  40:    */   private VipTypeService vipTypeService;
/*  41:    */   @Autowired
/*  42:    */   private IndustryService industryService;
/*  43:    */   @Autowired
/*  44:    */   private EconomyTypeService economyTypeService;
/*  45:    */   
/*  46:    */   @RequiresPermissions({"admin:companyinfo:list"})
/*  47:    */   @RequestMapping({"/companyinfo/v_list.do"})
/*  48:    */   public String list(String key, Integer natureId, Integer industryId, Date startTime, Date endTime, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  49:    */   {
/*  50: 46 */     Pagination pagination = this.service.getPageBySelect(key, natureId, 
/*  51: 47 */       industryId, startTime, endTime, SimplePage.cpn(pageNo), 
/*  52: 48 */       20);
/*  53: 49 */     List<Industry> industryList = this.industryService.getIndustryList(null);
/*  54: 50 */     List<EconomyType> natureList = this.economyTypeService.getEconomyTypeList();
/*  55: 51 */     List<JobFairs> fairsList = this.jobFairsService.getFairsByTime();
/*  56: 52 */     List<VipType> typeList = this.vipTypeService.getAllVipType();
/*  57: 53 */     model.addAttribute("pagination", pagination);
/*  58: 54 */     model.addAttribute("fairsList", fairsList);
/*  59: 55 */     model.addAttribute("typeList", typeList);
/*  60: 56 */     model.addAttribute("key", key);
/*  61: 57 */     model.addAttribute("natureList", natureList);
/*  62: 58 */     model.addAttribute("industryList", industryList);
/*  63: 59 */     model.addAttribute("natureId", natureId);
/*  64: 60 */     model.addAttribute("industryId", industryId);
/*  65: 61 */     model.addAttribute("startTime", startTime);
/*  66: 62 */     model.addAttribute("endTime", endTime);
/*  67: 63 */     model.addAttribute("pageNo", Integer.valueOf(pagination.getPageNo()));
/*  68: 64 */     return "companyinfo/list";
/*  69:    */   }
/*  70:    */   
/*  71:    */   @RequiresPermissions({"admin:companyinfo:apply_list"})
/*  72:    */   @RequestMapping({"/companyinfo/apply_list.do"})
/*  73:    */   public String applylist(String key, Integer natureId, Integer industryId, Date startTime, Date endTime, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  74:    */   {
/*  75: 72 */     Pagination pagination = this.service.getPageByApply(key, natureId, 
/*  76: 73 */       industryId, startTime, endTime, SimplePage.cpn(pageNo), 
/*  77: 74 */       20);
/*  78: 75 */     List<Industry> industryList = this.industryService.getIndustryList(null);
/*  79: 76 */     List<EconomyType> natureList = this.economyTypeService.getEconomyTypeList();
/*  80: 77 */     List<JobFairs> fairsList = this.jobFairsService.getFairsByTime();
/*  81: 78 */     List<VipType> typeList = this.vipTypeService.getAllVipType();
/*  82: 79 */     model.addAttribute("pagination", pagination);
/*  83: 80 */     model.addAttribute("fairsList", fairsList);
/*  84: 81 */     model.addAttribute("typeList", typeList);
/*  85: 82 */     model.addAttribute("key", key);
/*  86: 83 */     model.addAttribute("natureList", natureList);
/*  87: 84 */     model.addAttribute("industryList", industryList);
/*  88: 85 */     model.addAttribute("natureId", natureId);
/*  89: 86 */     model.addAttribute("industryId", industryId);
/*  90: 87 */     model.addAttribute("startTime", startTime);
/*  91: 88 */     model.addAttribute("endTime", endTime);
/*  92: 89 */     model.addAttribute("pageNo", Integer.valueOf(pagination.getPageNo()));
/*  93: 90 */     return "companyinfo/applylist";
/*  94:    */   }
/*  95:    */   
/*  96:    */   @RequiresPermissions({"admin:companyinfo:add"})
/*  97:    */   @RequestMapping({"/companyinfo/v_add.do"})
/*  98:    */   public String add(ModelMap model)
/*  99:    */   {
/* 100: 96 */     return "companyinfo/add";
/* 101:    */   }
/* 102:    */   
/* 103:    */   @RequiresPermissions({"admin:companyinfo:edit"})
/* 104:    */   @RequestMapping({"/companyinfo/v_edit.do"})
/* 105:    */   public String edit(Integer id, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 106:    */   {
/* 107:103 */     model.addAttribute("companyInfo", this.service.findById(id));
/* 108:104 */     model.addAttribute("pageNo", pageNo);
/* 109:105 */     return "companyinfo/edit";
/* 110:    */   }
/* 111:    */   
/* 112:    */   @RequiresPermissions({"admin:companyinfo:save"})
/* 113:    */   @RequestMapping({"/companyinfo/o_save.do"})
/* 114:    */   public String save(CompanyInfo bean, CompanyInfoExt ext, Integer natureId, Integer industryId1, Integer industryId2, HttpServletRequest request, ModelMap model)
/* 115:    */   {
/* 116:113 */     bean = this.service.save(bean, ext, natureId, industryId1, industryId2);
/* 117:114 */     log.info("save CompanyInfo id={}", bean.getId());
/* 118:115 */     return "redirect:v_list.do";
/* 119:    */   }
/* 120:    */   
/* 121:    */   @RequiresPermissions({"admin:companyinfo:update"})
/* 122:    */   @RequestMapping({"/companyinfo/o_update.do"})
/* 123:    */   public String update(CompanyInfo bean, CompanyInfoExt ext, Integer natureId, Integer industryId1, Integer industryId2, Integer typeId, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 124:    */   {
/* 125:124 */     bean = this.service.update(bean, ext, natureId, industryId1, industryId2, 
/* 126:125 */       typeId);
/* 127:126 */     log.info("update CompanyInfo id={}.", bean.getId());
/* 128:127 */     return list(null, null, null, null, null, pageNo, request, model);
/* 129:    */   }
/* 130:    */   
/* 131:    */   @RequiresPermissions({"admin:companyinfo:check"})
/* 132:    */   @RequestMapping({"/companyinfo/o_check.do"})
/* 133:    */   public String check(Integer id, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 134:    */   {
/* 135:134 */     CompanyInfo bean = this.service.findById(id);
/* 136:135 */     if ((bean.getCheck() != null) && (bean.getCheck().booleanValue())) {
/* 137:136 */       bean.setCheck(Boolean.valueOf(false));
/* 138:    */     } else {
/* 139:138 */       bean.setCheck(Boolean.valueOf(true));
/* 140:    */     }
/* 141:140 */     this.service.update(bean, null);
/* 142:141 */     log.info("update CompanyInfo id={}.", bean.getId());
/* 143:142 */     return list(null, null, null, null, null, pageNo, request, model);
/* 144:    */   }
/* 145:    */   
/* 146:    */   @RequiresPermissions({"admin:companyinfo:commend"})
/* 147:    */   @RequestMapping({"/companyinfo/o_commend.do"})
/* 148:    */   public String commend(Integer id, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 149:    */   {
/* 150:149 */     CompanyInfo bean = this.service.findById(id);
/* 151:150 */     if ((bean.getCommend() != null) && (bean.getCommend().booleanValue())) {
/* 152:151 */       bean.setCommend(Boolean.valueOf(false));
/* 153:    */     } else {
/* 154:153 */       bean.setCommend(Boolean.valueOf(true));
/* 155:    */     }
/* 156:155 */     this.service.update(bean, null);
/* 157:156 */     log.info("update CompanyInfo id={}.", bean.getId());
/* 158:157 */     return list(null, null, null, null, null, pageNo, request, model);
/* 159:    */   }
/* 160:    */   
/* 161:    */   @RequiresPermissions({"admin:companyinfo:apply"})
/* 162:    */   @RequestMapping({"/companyinfo/o_apply.do"})
/* 163:    */   public String apply(Integer id, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 164:    */   {
/* 165:164 */     this.service.applyAgree(id);
/* 166:165 */     return applylist(null, null, null, null, null, pageNo, request, model);
/* 167:    */   }
/* 168:    */   
/* 169:    */   @RequiresPermissions({"admin:companyinfo:delete"})
/* 170:    */   @RequestMapping({"/companyinfo/o_delete.do"})
/* 171:    */   public String delete(Integer[] ids, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 172:    */   {
/* 173:172 */     CompanyInfo[] beans = this.service.deleteByIds(ids);
/* 174:173 */     for (CompanyInfo bean : beans) {
/* 175:174 */       log.info("delete CompanyInfo id={}", bean.getId());
/* 176:    */     }
/* 177:176 */     return list(null, null, null, null, null, pageNo, request, model);
/* 178:    */   }
/* 179:    */   
/* 180:    */   @RequiresPermissions({"admin:companyinfo:ajaxadd"})
/* 181:    */   @RequestMapping(value={"/companyinfo/o_ajaxAdd.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 182:    */   public void vipAjaxAdd(Integer companyId, Integer typeId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 183:    */     throws JSONException
/* 184:    */   {
/* 185:184 */     JSONObject json = new JSONObject();
/* 186:185 */     if (companyId == null)
/* 187:    */     {
/* 188:186 */       json.put("success", false);
/* 189:187 */       json.put("status", 0);
/* 190:188 */       ResponseUtils.renderJson(response, json.toString());
/* 191:189 */       return;
/* 192:    */     }
/* 193:191 */     CompanyInfo info = this.service.findById(companyId);
/* 194:192 */     this.service.update(info, typeId);
/* 195:193 */     json.put("success", true);
/* 196:194 */     json.put("status", 1);
/* 197:195 */     ResponseUtils.renderJson(response, json.toString());
/* 198:    */   }
/* 199:    */   
/* 200:    */   @RequiresPermissions({"admin:companyinfo:passwordupdate"})
/* 201:    */   @RequestMapping(value={"/companyinfo/o_passwordUpdate.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 202:    */   public void passwordAjaxUpdate(Integer userId, String password, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 203:    */     throws JSONException
/* 204:    */   {
/* 205:204 */     JSONObject json = new JSONObject();
/* 206:205 */     if (userId == null)
/* 207:    */     {
/* 208:206 */       json.put("success", false);
/* 209:207 */       json.put("status", 0);
/* 210:208 */       ResponseUtils.renderJson(response, json.toString());
/* 211:209 */       return;
/* 212:    */     }
/* 213:211 */     json.put("success", true);
/* 214:212 */     json.put("status", 1);
/* 215:213 */     ResponseUtils.renderJson(response, json.toString());
/* 216:    */   }
/* 217:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.CompanyInfoAct
 * JD-Core Version:    0.7.0.1
 */