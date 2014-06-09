/*   1:    */ package com.portal.extrafunc.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.utils.ResponseUtils;
/*   5:    */ import com.portal.datacenter.operatedata.service.LogService;
/*   6:    */ import com.portal.extrafunc.entity.MessageBoard;
/*   7:    */ import com.portal.extrafunc.entity.MessageBoardExt;
/*   8:    */ import com.portal.extrafunc.service.MessageBoardService;
/*   9:    */ import com.portal.sysmgr.entity.Site;
/*  10:    */ import com.portal.sysmgr.utils.ContextTools;
/*  11:    */ import javax.servlet.http.HttpServletRequest;
/*  12:    */ import javax.servlet.http.HttpServletResponse;
/*  13:    */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/*  14:    */ import org.json.JSONException;
/*  15:    */ import org.json.JSONObject;
/*  16:    */ import org.slf4j.Logger;
/*  17:    */ import org.slf4j.LoggerFactory;
/*  18:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  19:    */ import org.springframework.stereotype.Controller;
/*  20:    */ import org.springframework.ui.ModelMap;
/*  21:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  22:    */ 
/*  23:    */ @Controller
/*  24:    */ public class MessageBoardAct
/*  25:    */ {
/*  26: 28 */   private static final Logger log = LoggerFactory.getLogger(MessageBoardAct.class);
/*  27:    */   @Autowired
/*  28:    */   private MessageBoardService service;
/*  29:    */   @Autowired
/*  30:    */   private LogService logService;
/*  31:    */   
/*  32:    */   @RequiresPermissions({"admin:board:list"})
/*  33:    */   @RequestMapping({"/board/v_list.do"})
/*  34:    */   public String list(HttpServletRequest request, ModelMap model)
/*  35:    */   {
/*  36: 33 */     return "extraFunc/board/list";
/*  37:    */   }
/*  38:    */   
/*  39:    */   @RequiresPermissions({"admin:board:add"})
/*  40:    */   @RequestMapping({"/board/v_add.do"})
/*  41:    */   public String add(HttpServletRequest request, ModelMap model)
/*  42:    */   {
/*  43: 39 */     return "extraFunc/board/add";
/*  44:    */   }
/*  45:    */   
/*  46:    */   @RequiresPermissions({"admin:board:edit"})
/*  47:    */   @RequestMapping({"/board/v_edit.do"})
/*  48:    */   public String edit(Integer id, HttpServletRequest request, ModelMap model)
/*  49:    */   {
/*  50: 45 */     model.addAttribute("board", this.service.findById(id));
/*  51: 46 */     return "extraFunc/board/edit";
/*  52:    */   }
/*  53:    */   
/*  54:    */   @RequiresPermissions({"admin:board:save"})
/*  55:    */   @RequestMapping({"/board/o_save.do"})
/*  56:    */   public String save(MessageBoard bean, MessageBoardExt ext, Integer typeId, HttpServletRequest request, ModelMap model)
/*  57:    */   {
/*  58: 53 */     Site site = ContextTools.getSite(request);
/*  59: 54 */     bean = this.service.save(bean, ext, site, typeId);
/*  60: 55 */     log.info("save board id={}", bean.getId());
/*  61: 56 */     model.addAttribute("msg", "留言添加成功!");
/*  62: 57 */     return add(request, model);
/*  63:    */   }
/*  64:    */   
/*  65:    */   @RequiresPermissions({"admin:board:update"})
/*  66:    */   @RequestMapping({"/board/o_update.do"})
/*  67:    */   public String update(MessageBoard bean, MessageBoardExt ext, Integer typeId, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  68:    */   {
/*  69: 65 */     bean = this.service.update(bean, ext, typeId);
/*  70: 66 */     log.info("update board id={}.", bean.getId());
/*  71: 67 */     model.addAttribute("msg", "留言回复成功!");
/*  72: 68 */     return edit(bean.getId(), request, model);
/*  73:    */   }
/*  74:    */   
/*  75:    */   @RequestMapping({"/board/jsonData.do"})
/*  76:    */   public String dataPageByJosn(String name, String sortname, String sortorder, Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  77:    */   {
/*  78: 76 */     Site site = ContextTools.getSite(request);
/*  79: 77 */     Pagination p = this.service.getPage(name, site.getId(), null, sortname, 
/*  80: 78 */       sortorder, page.intValue(), pagesize.intValue());
/*  81: 79 */     model.addAttribute("p", p);
/*  82: 80 */     response.setHeader("Cache-Control", "no-cache");
/*  83: 81 */     response.setContentType("text/json;charset=UTF-8");
/*  84: 82 */     return "extraFunc/board/data";
/*  85:    */   }
/*  86:    */   
/*  87:    */   @RequiresPermissions({"admin:board:delete"})
/*  88:    */   @RequestMapping({"/board/o_ajax_delete.do"})
/*  89:    */   public void deleteboard(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/*  90:    */     throws JSONException
/*  91:    */   {
/*  92: 89 */     JSONObject json = new JSONObject();
/*  93: 90 */     MessageBoard[] beans = this.service.deleteByIds(ids);
/*  94: 91 */     for (MessageBoard bean : beans)
/*  95:    */     {
/*  96: 92 */       log.info("delete board id={}", bean.getId());
/*  97: 93 */       this.logService.operating(request, "删除留言信息", "id=" + bean.getId());
/*  98:    */     }
/*  99: 95 */     json.put("success", true);
/* 100: 96 */     json.put("status", 1);
/* 101: 97 */     ResponseUtils.renderJson(response, json.toString());
/* 102:    */   }
/* 103:    */   
/* 104:    */   @RequiresPermissions({"admin:board:show"})
/* 105:    */   @RequestMapping({"/board/o_ajax_show.do"})
/* 106:    */   public void showboard(Integer id, HttpServletRequest request, HttpServletResponse response)
/* 107:    */     throws JSONException
/* 108:    */   {
/* 109:105 */     JSONObject json = new JSONObject();
/* 110:106 */     MessageBoard board = this.service.findById(id);
/* 111:107 */     if (board == null)
/* 112:    */     {
/* 113:108 */       json.put("success", false);
/* 114:109 */       json.put("status", 0);
/* 115:110 */       ResponseUtils.renderJson(response, json.toString());
/* 116:111 */       return;
/* 117:    */     }
/* 118:113 */     this.service.showBoard(id);
/* 119:114 */     json.put("success", true);
/* 120:115 */     json.put("status", 1);
/* 121:116 */     ResponseUtils.renderJson(response, json.toString());
/* 122:    */   }
/* 123:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.MessageBoardAct
 * JD-Core Version:    0.7.0.1
 */