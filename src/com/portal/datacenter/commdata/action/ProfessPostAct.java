/*  1:   */ package com.portal.datacenter.commdata.action;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.javapms.basic.page.SimplePage;
/*  5:   */ import com.portal.datacenter.commdata.entity.ProfessPost;
/*  6:   */ import com.portal.datacenter.commdata.service.ProfessPostService;
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
/* 17:   */ public class ProfessPostAct
/* 18:   */ {
/* 19:22 */   private static final Logger log = LoggerFactory.getLogger(ProfessPostAct.class);
/* 20:   */   @Autowired
/* 21:   */   private ProfessPostService service;
/* 22:   */   
/* 23:   */   @RequiresPermissions({"admin:professfost:list"})
/* 24:   */   @RequestMapping({"/professfost/v_list.do"})
/* 25:   */   public String list(Integer pageNo, HttpServletRequest request, ModelMap model)
/* 26:   */   {
/* 27:28 */     Pagination pagination = this.service.getPage(SimplePage.cpn(pageNo), 20);
/* 28:29 */     model.addAttribute("pagination", pagination);
/* 29:30 */     model.addAttribute("pageNo", Integer.valueOf(pagination.getPageNo()));
/* 30:31 */     return "professfost/list";
/* 31:   */   }
/* 32:   */   
/* 33:   */   @RequiresPermissions({"admin:professfost:add"})
/* 34:   */   @RequestMapping({"/professfost/v_add.do"})
/* 35:   */   public String add(ModelMap model)
/* 36:   */   {
/* 37:37 */     return "professfost/add";
/* 38:   */   }
/* 39:   */   
/* 40:   */   @RequiresPermissions({"admin:professfost:edit"})
/* 41:   */   @RequestMapping({"/professfost/v_edit.do"})
/* 42:   */   public String edit(Integer id, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 43:   */   {
/* 44:44 */     ProfessPost post = this.service.findById(id);
/* 45:45 */     model.addAttribute("professPost", post);
/* 46:46 */     model.addAttribute("pageNo", pageNo);
/* 47:47 */     return "professfost/edit";
/* 48:   */   }
/* 49:   */   
/* 50:   */   @RequiresPermissions({"admin:professfost:save"})
/* 51:   */   @RequestMapping({"/professfost/o_save.do"})
/* 52:   */   public String save(ProfessPost bean, HttpServletRequest request, ModelMap model)
/* 53:   */   {
/* 54:54 */     bean = this.service.save(bean);
/* 55:55 */     log.info("save ProfessPost id={}", bean.getId());
/* 56:56 */     return "redirect:v_list.do";
/* 57:   */   }
/* 58:   */   
/* 59:   */   @RequiresPermissions({"admin:professfost:update"})
/* 60:   */   @RequestMapping({"/professfost/o_update.do"})
/* 61:   */   public String update(ProfessPost bean, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 62:   */   {
/* 63:63 */     bean = this.service.update(bean);
/* 64:64 */     log.info("update ProfessPost id={}.", bean.getId());
/* 65:65 */     return list(pageNo, request, model);
/* 66:   */   }
/* 67:   */   
/* 68:   */   @RequiresPermissions({"admin:professfost:delete"})
/* 69:   */   @RequestMapping({"/professfost/o_delete.do"})
/* 70:   */   public String delete(Integer[] ids, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 71:   */   {
/* 72:72 */     ProfessPost[] beans = this.service.deleteByIds(ids);
/* 73:73 */     for (ProfessPost bean : beans) {
/* 74:74 */       log.info("delete ProfessPost id={}", bean.getId());
/* 75:   */     }
/* 76:76 */     return list(pageNo, request, model);
/* 77:   */   }
/* 78:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.action.ProfessPostAct
 * JD-Core Version:    0.7.0.1
 */