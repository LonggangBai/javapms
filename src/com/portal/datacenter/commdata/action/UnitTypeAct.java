/*  1:   */ package com.portal.datacenter.commdata.action;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.javapms.basic.page.SimplePage;
/*  5:   */ import com.portal.datacenter.commdata.entity.UnitType;
/*  6:   */ import com.portal.datacenter.commdata.service.UnitTypeService;
/*  7:   */ import javax.servlet.http.HttpServletRequest;
/*  8:   */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/*  9:   */ import org.slf4j.Logger;
/* 10:   */ import org.slf4j.LoggerFactory;
/* 11:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 12:   */ import org.springframework.stereotype.Controller;
/* 13:   */ import org.springframework.ui.ModelMap;
/* 14:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 15:   */ 
/* 16:   */ @Controller
/* 17:   */ public class UnitTypeAct
/* 18:   */ {
/* 19:21 */   private static final Logger log = LoggerFactory.getLogger(UnitTypeAct.class);
/* 20:   */   @Autowired
/* 21:   */   private UnitTypeService service;
/* 22:   */   
/* 23:   */   @RequiresPermissions({"admin:unittype:list"})
/* 24:   */   @RequestMapping({"/unittype/v_list.do"})
/* 25:   */   public String list(Integer pageNo, HttpServletRequest request, ModelMap model)
/* 26:   */   {
/* 27:26 */     Pagination pagination = this.service.getPage(SimplePage.cpn(pageNo), 20);
/* 28:27 */     model.addAttribute("pagination", pagination);
/* 29:28 */     model.addAttribute("pageNo", Integer.valueOf(pagination.getPageNo()));
/* 30:29 */     return "unittype/list";
/* 31:   */   }
/* 32:   */   
/* 33:   */   @RequiresPermissions({"admin:unittype:add"})
/* 34:   */   @RequestMapping({"/unittype/v_add.do"})
/* 35:   */   public String add(ModelMap model)
/* 36:   */   {
/* 37:35 */     return "unittype/add";
/* 38:   */   }
/* 39:   */   
/* 40:   */   @RequiresPermissions({"admin:unittype:edit"})
/* 41:   */   @RequestMapping({"/unittype/v_edit.do"})
/* 42:   */   public String edit(Integer id, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 43:   */   {
/* 44:41 */     model.addAttribute("unitType", this.service.findById(id));
/* 45:42 */     model.addAttribute("pageNo", pageNo);
/* 46:43 */     return "unittype/edit";
/* 47:   */   }
/* 48:   */   
/* 49:   */   @RequiresPermissions({"admin:unittype:save"})
/* 50:   */   @RequestMapping({"/unittype/o_save.do"})
/* 51:   */   public String save(UnitType bean, HttpServletRequest request, ModelMap model)
/* 52:   */   {
/* 53:49 */     bean = this.service.save(bean);
/* 54:50 */     log.info("save UnitType id={}", bean.getId());
/* 55:51 */     return "redirect:v_list.do";
/* 56:   */   }
/* 57:   */   
/* 58:   */   @RequiresPermissions({"admin:unittype:update"})
/* 59:   */   @RequestMapping({"/unittype/o_update.do"})
/* 60:   */   public String update(UnitType bean, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 61:   */   {
/* 62:58 */     bean = this.service.update(bean);
/* 63:59 */     log.info("update UnitType id={}.", bean.getId());
/* 64:60 */     return list(pageNo, request, model);
/* 65:   */   }
/* 66:   */   
/* 67:   */   @RequiresPermissions({"admin:unittype:delete"})
/* 68:   */   @RequestMapping({"/unittype/o_delete.do"})
/* 69:   */   public String delete(Integer[] ids, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 70:   */   {
/* 71:67 */     UnitType[] beans = this.service.deleteByIds(ids);
/* 72:68 */     for (UnitType bean : beans) {
/* 73:69 */       log.info("delete UnitType id={}", bean.getId());
/* 74:   */     }
/* 75:71 */     return list(pageNo, request, model);
/* 76:   */   }
/* 77:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.action.UnitTypeAct
 * JD-Core Version:    0.7.0.1
 */