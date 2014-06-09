/*  1:   */ package com.portal.extrafunc.action.fnt;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.javapms.basic.utils.ResponseUtils;
/*  5:   */ import com.portal.extrafunc.entity.MessageType;
/*  6:   */ import com.portal.extrafunc.service.MessageBoardService;
/*  7:   */ import com.portal.extrafunc.service.MessageTypeService;
/*  8:   */ import com.portal.sysmgr.entity.Site;
/*  9:   */ import com.portal.sysmgr.utils.ContextTools;
/* 10:   */ import com.portal.sysmgr.utils.ViewTools;
/* 11:   */ import java.util.List;
/* 12:   */ import javax.servlet.http.HttpServletRequest;
/* 13:   */ import javax.servlet.http.HttpServletResponse;
/* 14:   */ import org.json.JSONException;
/* 15:   */ import org.json.JSONObject;
/* 16:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 17:   */ import org.springframework.stereotype.Controller;
/* 18:   */ import org.springframework.ui.ModelMap;
/* 19:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 20:   */ 
/* 21:   */ @Controller
/* 22:   */ public class MessageBoardAct
/* 23:   */ {
/* 24:   */   public static final String BOARD_INPUT = "tpl.boardInput";
/* 25:   */   public static final String BOARD_LIST = "board_list";
/* 26:   */   @Autowired
/* 27:   */   private MessageBoardService service;
/* 28:   */   @Autowired
/* 29:   */   private MessageTypeService typeService;
/* 30:   */   
/* 31:   */   @RequestMapping(value={"/messageboard.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 32:   */   public String input(HttpServletRequest request, ModelMap model)
/* 33:   */   {
/* 34:41 */     Site site = ContextTools.getSite(request);
/* 35:42 */     List<MessageType> typeList = this.typeService.getList(site.getId(), null, 
/* 36:43 */       null);
/* 37:44 */     model.addAttribute("typeList", typeList);
/* 38:45 */     ViewTools.frontData(request, model, site);
/* 39:46 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 40:47 */       "extrafunc/board", "tpl.boardInput");
/* 41:   */   }
/* 42:   */   
/* 43:   */   @RequestMapping(value={"/messageboard.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 44:   */   public void submit(String title, String name, String mobile, String email, String address, String zipcode, Integer typeId, String content, HttpServletRequest request, HttpServletResponse response)
/* 45:   */     throws JSONException
/* 46:   */   {
/* 47:55 */     Site site = ContextTools.getSite(request);
/* 48:56 */     JSONObject json = new JSONObject();
/* 49:57 */     this.service.save(title, name, mobile, email, address, zipcode, typeId, 
/* 50:58 */       content, site);
/* 51:59 */     json.put("success", true);
/* 52:60 */     json.put("status", 1);
/* 53:61 */     ResponseUtils.renderJson(response, json.toString());
/* 54:   */   }
/* 55:   */   
/* 56:   */   @RequestMapping({"/board/list.jsp"})
/* 57:   */   public String list(Integer pageNo, Integer count, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 58:   */   {
/* 59:68 */     Site site = ContextTools.getSite(request);
/* 60:69 */     Pagination page = this.service.getPage(null, site.getId(), Boolean.valueOf(true), null, null, 
/* 61:70 */       pageNo.intValue(), count.intValue());
/* 62:71 */     model.addAttribute("page", page);
/* 63:72 */     ViewTools.frontData(request, model, site);
/* 64:73 */     response.setHeader("Cache-Control", "no-cache");
/* 65:74 */     response.setContentType("text/json;charset=UTF-8");
/* 66:75 */     return ViewTools.getTplPath(null, site.getSolutionPath(), 
/* 67:76 */       "common/tags", "board_list");
/* 68:   */   }
/* 69:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.fnt.MessageBoardAct
 * JD-Core Version:    0.7.0.1
 */