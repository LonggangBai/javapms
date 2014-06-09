/*  1:   */ package com.portal.doccenter.action.fnt;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.entity.Channel;
/*  4:   */ import com.portal.doccenter.service.ChannelService;
/*  5:   */ import com.portal.sysmgr.entity.Site;
/*  6:   */ import com.portal.sysmgr.utils.ContextTools;
/*  7:   */ import com.portal.sysmgr.utils.ViewTools;
/*  8:   */ import javax.servlet.http.HttpServletRequest;
/*  9:   */ import javax.servlet.http.HttpServletResponse;
/* 10:   */ import org.apache.commons.lang.StringUtils;
/* 11:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 12:   */ import org.springframework.stereotype.Controller;
/* 13:   */ import org.springframework.ui.ModelMap;
/* 14:   */ import org.springframework.web.bind.annotation.PathVariable;
/* 15:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 16:   */ 
/* 17:   */ @Controller
/* 18:   */ public class ChannelAct
/* 19:   */ {
/* 20:   */   public static final String TPL_INDEX = "tpl.index";
/* 21:   */   @Autowired
/* 22:   */   private ChannelService channelService;
/* 23:   */   
/* 24:   */   @RequestMapping({"/", "/index.jsp"})
/* 25:   */   public String index(HttpServletRequest request, ModelMap model)
/* 26:   */   {
/* 27:34 */     Site site = ContextTools.getSite(request);
/* 28:35 */     ViewTools.frontData(request, model, site);
/* 29:36 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 30:37 */       "doc/index", "tpl.index");
/* 31:   */   }
/* 32:   */   
/* 33:   */   @RequestMapping({"/{path}/index.jsp", "/{path}/index_{page:[0-9]+}.jsp"})
/* 34:   */   public String channelIndex(@PathVariable String path, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 35:   */   {
/* 36:45 */     Site site = ContextTools.getSite(request);
/* 37:46 */     Channel channel = this.channelService.findByPathForTag(path, site.getId());
/* 38:47 */     if (channel == null) {
/* 39:48 */       return ViewTools.pageNotFound(response);
/* 40:   */     }
/* 41:50 */     if (!StringUtils.isBlank(channel.getLink())) {
/* 42:51 */       return "redirect:" + channel.getLink();
/* 43:   */     }
/* 44:53 */     model.addAttribute("channel", channel);
/* 45:54 */     ViewTools.frontData(request, model, site);
/* 46:55 */     ViewTools.frontPageData(request, model);
/* 47:56 */     return channel.getTplChannelOrDef();
/* 48:   */   }
/* 49:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.action.fnt.ChannelAct
 * JD-Core Version:    0.7.0.1
 */