/*  1:   */ package com.portal.datacenter.commdata.action;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.javapms.basic.page.SimplePage;
/*  5:   */ import com.portal.datacenter.commdata.entity.Specialty;
/*  6:   */ import com.portal.datacenter.commdata.service.SpecialtyService;
/*  7:   */ import java.util.List;
/*  8:   */ import javax.servlet.http.HttpServletRequest;
/*  9:   */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/* 10:   */ import org.slf4j.Logger;
/* 11:   */ import org.slf4j.LoggerFactory;
/* 12:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 13:   */ import org.springframework.stereotype.Controller;
/* 14:   */ import org.springframework.ui.ModelMap;
/* 15:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 16:   */ 
/* 17:   */ @Controller
/* 18:   */ public class SpecialtyAct
/* 19:   */ {
/* 20:24 */   private static final Logger log = LoggerFactory.getLogger(SpecialtyAct.class);
/* 21:   */   @Autowired
/* 22:   */   private SpecialtyService service;
/* 23:   */   
/* 24:   */   @RequiresPermissions({"admin:specialty:list"})
/* 25:   */   @RequestMapping({"/specialty/v_list.do"})
/* 26:   */   public String list(String key, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 27:   */   {
/* 28:30 */     Pagination pagination = this.service.getPage(key, SimplePage.cpn(pageNo), 20);
/* 29:31 */     model.addAttribute("pagination", pagination);
/* 30:32 */     model.addAttribute("key", key);
/* 31:33 */     model.addAttribute("pageNo", Integer.valueOf(pagination.getPageNo()));
/* 32:34 */     return "specialty/list";
/* 33:   */   }
/* 34:   */   
/* 35:   */   @RequiresPermissions({"admin:specialty:add"})
/* 36:   */   @RequestMapping({"/specialty/v_add.do"})
/* 37:   */   public String add(ModelMap model)
/* 38:   */   {
/* 39:40 */     List<Specialty> specialtyList = this.service.getSpecialtyList(null);
/* 40:41 */     model.addAttribute("specialtyList", specialtyList);
/* 41:42 */     return "specialty/add";
/* 42:   */   }
/* 43:   */   
/* 44:   */   @RequiresPermissions({"admin:specialty:edit"})
/* 45:   */   @RequestMapping({"/specialty/v_edit.do"})
/* 46:   */   public String edit(Integer id, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 47:   */   {
/* 48:49 */     List<Specialty> specialtyList = this.service.getSpecialtyList(id);
/* 49:50 */     Specialty specialty = this.service.findById(id);
/* 50:51 */     if (specialty.getParent() != null) {
/* 51:52 */       model.addAttribute("parentId", specialty.getParent().getId());
/* 52:   */     }
/* 53:54 */     model.addAttribute("specialtyList", Boolean.valueOf(specialtyList.remove(specialty)));
/* 54:55 */     model.addAttribute("specialty", specialty);
/* 55:56 */     model.addAttribute("pageNo", pageNo);
/* 56:57 */     return "specialty/edit";
/* 57:   */   }
/* 58:   */   
/* 59:   */   @RequiresPermissions({"admin:specialty:save"})
/* 60:   */   @RequestMapping({"/specialty/o_save.do"})
/* 61:   */   public String save(Specialty bean, Integer parentId, HttpServletRequest request, ModelMap model)
/* 62:   */   {
/* 63:64 */     bean = this.service.save(bean, parentId);
/* 64:65 */     log.info("save Specialty id={}", bean.getId());
/* 65:66 */     return "redirect:v_list.do";
/* 66:   */   }
/* 67:   */   
/* 68:   */   @RequiresPermissions({"admin:specialty:update"})
/* 69:   */   @RequestMapping({"/specialty/o_update.do"})
/* 70:   */   public String update(Specialty bean, Integer parentId, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 71:   */   {
/* 72:73 */     bean = this.service.update(bean, parentId);
/* 73:74 */     log.info("update Specialty id={}.", bean.getId());
/* 74:75 */     return list(null, pageNo, request, model);
/* 75:   */   }
/* 76:   */   
/* 77:   */   @RequiresPermissions({"admin:specialty:delete"})
/* 78:   */   @RequestMapping({"/specialty/o_delete.do"})
/* 79:   */   public String delete(Integer[] ids, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 80:   */   {
/* 81:82 */     Specialty[] beans = this.service.deleteByIds(ids);
/* 82:83 */     for (Specialty bean : beans) {
/* 83:84 */       log.info("delete Specialty id={}", bean.getId());
/* 84:   */     }
/* 85:86 */     return list(null, pageNo, request, model);
/* 86:   */   }
/* 87:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.action.SpecialtyAct
 * JD-Core Version:    0.7.0.1
 */