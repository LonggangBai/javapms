/*  1:   */ package com.portal.datacenter.commdata.action;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.javapms.basic.page.SimplePage;
/*  5:   */ import com.portal.datacenter.commdata.entity.Metier;
/*  6:   */ import com.portal.datacenter.commdata.service.MetierService;
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
/* 18:   */ public class MetierAct
/* 19:   */ {
/* 20:23 */   private static final Logger log = LoggerFactory.getLogger(MetierAct.class);
/* 21:   */   @Autowired
/* 22:   */   private MetierService service;
/* 23:   */   
/* 24:   */   @RequiresPermissions({"admin:metier:list"})
/* 25:   */   @RequestMapping({"/metier/v_list.do"})
/* 26:   */   public String list(String key, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 27:   */   {
/* 28:29 */     Pagination pagination = this.service.getPage(key, SimplePage.cpn(pageNo), 20);
/* 29:30 */     model.addAttribute("pagination", pagination);
/* 30:31 */     model.addAttribute("key", key);
/* 31:32 */     model.addAttribute("pageNo", Integer.valueOf(pagination.getPageNo()));
/* 32:33 */     return "metier/list";
/* 33:   */   }
/* 34:   */   
/* 35:   */   @RequiresPermissions({"admin:metier:add"})
/* 36:   */   @RequestMapping({"/metier/v_add.do"})
/* 37:   */   public String add(ModelMap model)
/* 38:   */   {
/* 39:39 */     List<Metier> metierList = this.service.getMetierList(null);
/* 40:40 */     model.addAttribute("metierList", metierList);
/* 41:41 */     return "metier/add";
/* 42:   */   }
/* 43:   */   
/* 44:   */   @RequiresPermissions({"admin:metier:edit"})
/* 45:   */   @RequestMapping({"/metier/v_edit.do"})
/* 46:   */   public String edit(Integer id, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 47:   */   {
/* 48:48 */     Metier metier = this.service.findById(id);
/* 49:49 */     List<Metier> metierList = this.service.getMetierList(id);
/* 50:50 */     if (metier.getParent() != null) {
/* 51:51 */       model.addAttribute("parentId", metier.getParent().getId());
/* 52:   */     }
/* 53:53 */     model.addAttribute("metierList", metierList);
/* 54:54 */     model.addAttribute("metier", metier);
/* 55:55 */     model.addAttribute("pageNo", pageNo);
/* 56:56 */     return "metier/edit";
/* 57:   */   }
/* 58:   */   
/* 59:   */   @RequiresPermissions({"admin:metier:save"})
/* 60:   */   @RequestMapping({"/metier/o_save.do"})
/* 61:   */   public String save(Metier bean, Integer parentId, HttpServletRequest request, ModelMap model)
/* 62:   */   {
/* 63:63 */     bean = this.service.save(bean, parentId);
/* 64:64 */     log.info("save Metier id={}", bean.getId());
/* 65:65 */     return "redirect:v_list.do";
/* 66:   */   }
/* 67:   */   
/* 68:   */   @RequiresPermissions({"admin:metier:update"})
/* 69:   */   @RequestMapping({"/metier/o_update.do"})
/* 70:   */   public String update(Metier bean, Integer parentId, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 71:   */   {
/* 72:72 */     bean = this.service.update(bean, parentId);
/* 73:73 */     log.info("update Metier id={}.", bean.getId());
/* 74:74 */     return list(null, pageNo, request, model);
/* 75:   */   }
/* 76:   */   
/* 77:   */   @RequiresPermissions({"admin:metier:delete"})
/* 78:   */   @RequestMapping({"/metier/o_delete.do"})
/* 79:   */   public String delete(Integer[] ids, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 80:   */   {
/* 81:81 */     Metier[] beans = this.service.deleteByIds(ids);
/* 82:82 */     for (Metier bean : beans) {
/* 83:83 */       log.info("delete Metier id={}", bean.getId());
/* 84:   */     }
/* 85:85 */     return list(null, pageNo, request, model);
/* 86:   */   }
/* 87:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.action.MetierAct
 * JD-Core Version:    0.7.0.1
 */