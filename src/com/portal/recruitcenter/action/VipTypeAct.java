/*  1:   */ package com.portal.recruitcenter.action;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.javapms.basic.page.SimplePage;
/*  5:   */ import com.portal.recruitcenter.entity.VipType;
/*  6:   */ import com.portal.recruitcenter.service.VipTypeService;
/*  7:   */ import javax.servlet.http.HttpServletRequest;
/*  8:   */ import org.slf4j.Logger;
/*  9:   */ import org.slf4j.LoggerFactory;
/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ import org.springframework.stereotype.Controller;
/* 12:   */ import org.springframework.ui.ModelMap;
/* 13:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 14:   */ 
/* 15:   */ @Controller
/* 16:   */ public class VipTypeAct
/* 17:   */ {
/* 18:20 */   private static final Logger log = LoggerFactory.getLogger(VipTypeAct.class);
/* 19:   */   @Autowired
/* 20:   */   private VipTypeService service;
/* 21:   */   
/* 22:   */   @RequestMapping({"/vipType/v_list.do"})
/* 23:   */   public String list(Integer pageNo, HttpServletRequest request, ModelMap model)
/* 24:   */   {
/* 25:25 */     Pagination pagination = this.service.getPage(SimplePage.cpn(pageNo), 
/* 26:26 */       20);
/* 27:27 */     model.addAttribute("pagination", pagination);
/* 28:28 */     model.addAttribute("pageNo", Integer.valueOf(pagination.getPageNo()));
/* 29:29 */     return "vipType/list";
/* 30:   */   }
/* 31:   */   
/* 32:   */   @RequestMapping({"/vipType/v_add.do"})
/* 33:   */   public String add(ModelMap model)
/* 34:   */   {
/* 35:34 */     return "vipType/add";
/* 36:   */   }
/* 37:   */   
/* 38:   */   @RequestMapping({"/vipType/v_edit.do"})
/* 39:   */   public String edit(Integer id, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 40:   */   {
/* 41:40 */     model.addAttribute("vipType", this.service.findById(id));
/* 42:41 */     model.addAttribute("pageNo", pageNo);
/* 43:42 */     return "vipType/edit";
/* 44:   */   }
/* 45:   */   
/* 46:   */   @RequestMapping({"/vipType/o_save.do"})
/* 47:   */   public String save(VipType bean, HttpServletRequest request, ModelMap model)
/* 48:   */   {
/* 49:47 */     bean = this.service.save(bean);
/* 50:48 */     log.info("save VipType id={}", bean.getId());
/* 51:49 */     return "redirect:v_list.do";
/* 52:   */   }
/* 53:   */   
/* 54:   */   @RequestMapping({"/vipType/o_update.do"})
/* 55:   */   public String update(VipType bean, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 56:   */   {
/* 57:55 */     bean = this.service.update(bean);
/* 58:56 */     log.info("update VipType id={}.", bean.getId());
/* 59:57 */     return list(pageNo, request, model);
/* 60:   */   }
/* 61:   */   
/* 62:   */   @RequestMapping({"/vipType/o_delete.do"})
/* 63:   */   public String delete(Integer[] ids, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 64:   */   {
/* 65:63 */     VipType[] beans = this.service.deleteByIds(ids);
/* 66:64 */     for (VipType bean : beans) {
/* 67:65 */       log.info("delete VipType id={}", bean.getId());
/* 68:   */     }
/* 69:67 */     return list(pageNo, request, model);
/* 70:   */   }
/* 71:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.VipTypeAct
 * JD-Core Version:    0.7.0.1
 */