/*   1:    */ package com.portal.extrafunc.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.utils.ResponseUtils;
/*   5:    */ import com.portal.datacenter.operatedata.service.LogService;
/*   6:    */ import com.portal.extrafunc.entity.Advert;
/*   7:    */ import com.portal.extrafunc.entity.AdvertSlot;
/*   8:    */ import com.portal.extrafunc.service.AdvertService;
/*   9:    */ import com.portal.extrafunc.service.AdvertSlotService;
/*  10:    */ import com.portal.sysmgr.entity.Site;
/*  11:    */ import com.portal.sysmgr.utils.ContextTools;
/*  12:    */ import java.util.List;
/*  13:    */ import javax.servlet.http.HttpServletRequest;
/*  14:    */ import javax.servlet.http.HttpServletResponse;
/*  15:    */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/*  16:    */ import org.json.JSONException;
/*  17:    */ import org.json.JSONObject;
/*  18:    */ import org.slf4j.Logger;
/*  19:    */ import org.slf4j.LoggerFactory;
/*  20:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  21:    */ import org.springframework.stereotype.Controller;
/*  22:    */ import org.springframework.ui.ModelMap;
/*  23:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  24:    */ 
/*  25:    */ @Controller
/*  26:    */ public class AdvertAct
/*  27:    */ {
/*  28: 30 */   private static final Logger log = LoggerFactory.getLogger(AdvertAct.class);
/*  29:    */   @Autowired
/*  30:    */   private AdvertService service;
/*  31:    */   @Autowired
/*  32:    */   private AdvertSlotService slotService;
/*  33:    */   @Autowired
/*  34:    */   private LogService logService;
/*  35:    */   
/*  36:    */   @RequiresPermissions({"admin:advert:list"})
/*  37:    */   @RequestMapping({"/advert/v_list.do"})
/*  38:    */   public String list(Integer slotId, ModelMap model)
/*  39:    */   {
/*  40: 35 */     model.addAttribute("slotId", slotId);
/*  41: 36 */     return "extraFunc/advert/list";
/*  42:    */   }
/*  43:    */   
/*  44:    */   @RequiresPermissions({"admin:advert:add"})
/*  45:    */   @RequestMapping({"/advert/v_add.do"})
/*  46:    */   public String add(HttpServletRequest request, ModelMap model)
/*  47:    */   {
/*  48: 42 */     Site site = ContextTools.getSite(request);
/*  49: 43 */     List<AdvertSlot> slotList = this.slotService.getList(site.getId());
/*  50: 44 */     model.addAttribute("slotList", slotList);
/*  51: 45 */     return "extraFunc/advert/add";
/*  52:    */   }
/*  53:    */   
/*  54:    */   @RequiresPermissions({"admin:advert:edit"})
/*  55:    */   @RequestMapping({"/advert/v_edit.do"})
/*  56:    */   public String edit(Integer id, HttpServletRequest request, ModelMap model)
/*  57:    */   {
/*  58: 51 */     Site site = ContextTools.getSite(request);
/*  59: 52 */     List<AdvertSlot> slotList = this.slotService.getList(site.getId());
/*  60: 53 */     model.addAttribute("slotList", slotList);
/*  61: 54 */     model.addAttribute("advert", this.service.findById(id));
/*  62: 55 */     return "extraFunc/advert/edit";
/*  63:    */   }
/*  64:    */   
/*  65:    */   @RequiresPermissions({"admin:advert:save"})
/*  66:    */   @RequestMapping({"/advert/o_save.do"})
/*  67:    */   public String save(Advert bean, Integer slotId, boolean advtype, HttpServletRequest request, ModelMap model)
/*  68:    */   {
/*  69: 62 */     Site site = ContextTools.getSite(request);
/*  70: 63 */     bean = this.service.save(bean, slotId, advtype, site);
/*  71: 64 */     log.info("save Advert id={}", bean.getId());
/*  72: 65 */     model.addAttribute("msg", "广告添加成功!");
/*  73: 66 */     return add(request, model);
/*  74:    */   }
/*  75:    */   
/*  76:    */   @RequiresPermissions({"admin:advert:update"})
/*  77:    */   @RequestMapping({"/advert/o_update.do"})
/*  78:    */   public String update(Advert bean, Integer slotId, boolean advtype, HttpServletRequest request, ModelMap model)
/*  79:    */   {
/*  80: 73 */     bean = this.service.update(bean, slotId, advtype);
/*  81: 74 */     log.info("update Advert id={}.", bean.getId());
/*  82: 75 */     model.addAttribute("msg", "广告修改成功!");
/*  83: 76 */     return edit(bean.getId(), request, model);
/*  84:    */   }
/*  85:    */   
/*  86:    */   @RequestMapping({"/advert/jsonData.do"})
/*  87:    */   public String dataPageByJosn(Integer slotId, String sortname, String sortorder, Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  88:    */   {
/*  89: 84 */     Site site = ContextTools.getSite(request);
/*  90: 85 */     Pagination pagi = this.service.getPage(site.getId(), slotId, sortname, 
/*  91: 86 */       sortorder, page.intValue(), pagesize.intValue());
/*  92: 87 */     model.addAttribute("pagi", pagi);
/*  93: 88 */     response.setHeader("Cache-Control", "no-cache");
/*  94: 89 */     response.setContentType("text/json;charset=UTF-8");
/*  95: 90 */     return "extraFunc/advert/data";
/*  96:    */   }
/*  97:    */   
/*  98:    */   @RequiresPermissions({"admin:advert:delete"})
/*  99:    */   @RequestMapping({"/advert/o_ajax_delete.do"})
/* 100:    */   public void deleteAdvert(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/* 101:    */     throws JSONException
/* 102:    */   {
/* 103: 97 */     JSONObject json = new JSONObject();
/* 104: 98 */     Advert[] beans = this.service.deleteByIds(ids);
/* 105: 99 */     for (Advert bean : beans)
/* 106:    */     {
/* 107:100 */       log.info("delete Advert id={}", bean.getId());
/* 108:101 */       this.logService.operating(request, "删除广告", "id=" + bean.getId());
/* 109:    */     }
/* 110:103 */     json.put("success", true);
/* 111:104 */     json.put("status", 1);
/* 112:105 */     ResponseUtils.renderJson(response, json.toString());
/* 113:    */   }
/* 114:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.AdvertAct
 * JD-Core Version:    0.7.0.1
 */