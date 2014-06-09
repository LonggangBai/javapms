/*  1:   */ package com.portal.govcenter.action.fnt;
/*  2:   */ 
/*  3:   */ import com.portal.govcenter.entity.Mailbox;
/*  4:   */ import com.portal.govcenter.entity.MailboxExt;
/*  5:   */ import com.portal.govcenter.entity.MailboxType;
/*  6:   */ import com.portal.govcenter.service.MailboxService;
/*  7:   */ import com.portal.govcenter.service.MailboxTypeService;
/*  8:   */ import com.portal.sysmgr.entity.Site;
/*  9:   */ import com.portal.sysmgr.utils.ContextTools;
/* 10:   */ import com.portal.sysmgr.utils.ViewTools;
/* 11:   */ import java.util.List;
/* 12:   */ import javax.servlet.http.HttpServletRequest;
/* 13:   */ import javax.servlet.http.HttpServletResponse;
/* 14:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 15:   */ import org.springframework.stereotype.Controller;
/* 16:   */ import org.springframework.ui.ModelMap;
/* 17:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 18:   */ import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/* 19:   */ 
/* 20:   */ @Controller
/* 21:   */ public class MailboxAct
/* 22:   */ {
/* 23:   */   public static final String MAILBOX_INPUT = "tpl.mailboxInput";
/* 24:   */   @Autowired
/* 25:   */   private MailboxTypeService typeService;
/* 26:   */   @Autowired
/* 27:   */   private MailboxService mailboxService;
/* 28:   */   
/* 29:   */   @RequestMapping(value={"/mailbox/input.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 30:   */   public String input(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 31:   */   {
/* 32:40 */     Site site = ContextTools.getSite(request);
/* 33:41 */     List<MailboxType> list = this.typeService.getList(site.getId());
/* 34:42 */     model.addAttribute("typeList", list);
/* 35:43 */     ViewTools.frontData(request, model, site);
/* 36:44 */     ViewTools.frontPageData(request, model);
/* 37:45 */     return ViewTools.getTplPath(null, site.getSolutionPath(), 
/* 38:46 */       "govcenter/interactive", "input");
/* 39:   */   }
/* 40:   */   
/* 41:   */   @RequestMapping(value={"/mailbox/submit.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 42:   */   public String submit(Mailbox bean, MailboxExt ext, Integer departId, Integer typeId, HttpServletRequest request, HttpServletResponse response, RedirectAttributes ra)
/* 43:   */   {
/* 44:53 */     Site site = ContextTools.getSite(request);
/* 45:54 */     this.mailboxService.save(bean, ext, site, departId, typeId);
/* 46:55 */     ra.addFlashAttribute("msg", "添加成功");
/* 47:56 */     return "redirect:input.jsp";
/* 48:   */   }
/* 49:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.govcenter.action.fnt.MailboxAct
 * JD-Core Version:    0.7.0.1
 */