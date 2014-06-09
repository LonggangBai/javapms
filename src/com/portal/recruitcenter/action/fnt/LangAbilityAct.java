/*   1:    */ package com.portal.recruitcenter.action.fnt;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.portal.datacenter.commdata.entity.ForeignLang;
/*   5:    */ import com.portal.datacenter.commdata.service.ForeignLangService;
/*   6:    */ import com.portal.recruitcenter.entity.LangAbility;
/*   7:    */ import com.portal.recruitcenter.entity.Resume;
/*   8:    */ import com.portal.recruitcenter.service.LangAbilityService;
/*   9:    */ import com.portal.recruitcenter.service.ResumeService;
/*  10:    */ import com.portal.sysmgr.entity.Site;
/*  11:    */ import com.portal.sysmgr.utils.ContextTools;
/*  12:    */ import com.portal.sysmgr.utils.ViewTools;
/*  13:    */ import com.portal.usermgr.entity.User;
/*  14:    */ import java.util.List;
/*  15:    */ import javax.servlet.http.HttpServletRequest;
/*  16:    */ import javax.servlet.http.HttpServletResponse;
/*  17:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  18:    */ import org.springframework.stereotype.Controller;
/*  19:    */ import org.springframework.ui.ModelMap;
/*  20:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  21:    */ 
/*  22:    */ @Controller
/*  23:    */ public class LangAbilityAct
/*  24:    */ {
/*  25:    */   public static final String LANG_LIST = "tpl.langList";
/*  26:    */   public static final String LANG_EDIT = "tpl.langEdit";
/*  27:    */   @Autowired
/*  28:    */   private LangAbilityService langAbilityService;
/*  29:    */   @Autowired
/*  30:    */   private ResumeService resumeService;
/*  31:    */   @Autowired
/*  32:    */   private ForeignLangService foreignLangService;
/*  33:    */   
/*  34:    */   @RequestMapping(value={"/ability/list.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  35:    */   public String langList(Integer resumeId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  36:    */   {
/*  37: 35 */     Site site = ContextTools.getSite(request);
/*  38: 36 */     User user = ContextTools.getUser(request);
/*  39: 37 */     ViewTools.frontData(request, model, site);
/*  40: 41 */     if (resumeId == null) {
/*  41: 42 */       return ViewTools.pageNotFound(response);
/*  42:    */     }
/*  43: 44 */     Resume resume = this.resumeService.findById(resumeId);
/*  44: 45 */     if (resume == null) {
/*  45: 46 */       return ViewTools.pageNotFound(response);
/*  46:    */     }
/*  47: 51 */     List<ForeignLang> langList = this.foreignLangService.getForeignLangList();
/*  48: 52 */     Pagination pagination = this.langAbilityService.getPage(resumeId, 1, 20);
/*  49: 53 */     model.addAttribute("pagination", pagination);
/*  50: 54 */     model.addAttribute("langList", langList);
/*  51: 55 */     model.addAttribute("resumeId", resumeId);
/*  52: 56 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  53: 57 */       "personal", "tpl.langList");
/*  54:    */   }
/*  55:    */   
/*  56:    */   @RequestMapping(value={"/ability/edit.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  57:    */   public String langEdit(Integer abilityId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  58:    */   {
/*  59: 63 */     Site site = ContextTools.getSite(request);
/*  60: 64 */     User user = ContextTools.getUser(request);
/*  61: 65 */     ViewTools.frontData(request, model, site);
/*  62: 69 */     if (abilityId == null) {
/*  63: 70 */       return ViewTools.pageNotFound(response);
/*  64:    */     }
/*  65: 72 */     LangAbility ability = this.langAbilityService.findById(abilityId);
/*  66: 73 */     if (ability == null) {
/*  67: 74 */       return ViewTools.pageNotFound(response);
/*  68:    */     }
/*  69: 79 */     List<ForeignLang> langList = this.foreignLangService.getForeignLangList();
/*  70: 80 */     Pagination pagination = this.langAbilityService.getPage(ability.getResume()
/*  71: 81 */       .getId(), 1, 20);
/*  72: 82 */     model.addAttribute("ability", ability);
/*  73: 83 */     model.addAttribute("resumeId", ability.getResume().getId());
/*  74: 84 */     model.addAttribute("pagination", pagination);
/*  75: 85 */     model.addAttribute("langList", langList);
/*  76: 86 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  77: 87 */       "personal", "tpl.langEdit");
/*  78:    */   }
/*  79:    */   
/*  80:    */   @RequestMapping(value={"/ability/save.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  81:    */   public String langSave(LangAbility ability, Integer resumeId, Integer langId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  82:    */   {
/*  83: 94 */     Site site = ContextTools.getSite(request);
/*  84: 95 */     User user = ContextTools.getUser(request);
/*  85: 96 */     ViewTools.frontData(request, model, site);
/*  86:100 */     if (resumeId == null) {
/*  87:101 */       return ViewTools.pageNotFound(response);
/*  88:    */     }
/*  89:103 */     Resume resume = this.resumeService.findById(resumeId);
/*  90:104 */     if (resume == null) {
/*  91:105 */       return ViewTools.pageNotFound(response);
/*  92:    */     }
/*  93:110 */     this.langAbilityService.save(ability, resumeId, langId);
/*  94:111 */     return "redirect:list.jsp?resumeId=" + resumeId;
/*  95:    */   }
/*  96:    */   
/*  97:    */   @RequestMapping(value={"/ability/update.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  98:    */   public String langUpdate(LangAbility ability, Integer langId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  99:    */   {
/* 100:118 */     Site site = ContextTools.getSite(request);
/* 101:119 */     User user = ContextTools.getUser(request);
/* 102:120 */     ViewTools.frontData(request, model, site);
/* 103:124 */     if (ability.getId() == null) {
/* 104:125 */       return ViewTools.pageNotFound(response);
/* 105:    */     }
/* 106:127 */     LangAbility lang = this.langAbilityService.findById(ability.getId());
/* 107:128 */     if (lang == null) {
/* 108:129 */       return ViewTools.pageNotFound(response);
/* 109:    */     }
/* 110:134 */     ability = this.langAbilityService.update(ability, langId);
/* 111:135 */     return "redirect:list.jsp?resumeId=" + ability.getResume().getId();
/* 112:    */   }
/* 113:    */   
/* 114:    */   @RequestMapping(value={"/ability/delete.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 115:    */   public String langDelete(Integer abilityId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 116:    */   {
/* 117:141 */     Site site = ContextTools.getSite(request);
/* 118:142 */     User user = ContextTools.getUser(request);
/* 119:143 */     ViewTools.frontData(request, model, site);
/* 120:147 */     if (abilityId == null) {
/* 121:148 */       return ViewTools.pageNotFound(response);
/* 122:    */     }
/* 123:150 */     LangAbility lang = this.langAbilityService.findById(abilityId);
/* 124:151 */     if (lang == null) {
/* 125:152 */       return ViewTools.pageNotFound(response);
/* 126:    */     }
/* 127:157 */     LangAbility ability = this.langAbilityService.deleteById(abilityId);
/* 128:158 */     return "redirect:list.jsp?resumeId=" + ability.getResume().getId();
/* 129:    */   }
/* 130:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.fnt.LangAbilityAct
 * JD-Core Version:    0.7.0.1
 */