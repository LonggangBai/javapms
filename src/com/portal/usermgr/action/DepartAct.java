/*   1:    */ package com.portal.usermgr.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.page.SimplePage;
/*   5:    */ import com.javapms.basic.utils.ResponseUtils;
/*   6:    */ import com.portal.doccenter.entity.Channel;
/*   7:    */ import com.portal.doccenter.entity.WorkFlow;
/*   8:    */ import com.portal.doccenter.service.ChannelService;
/*   9:    */ import com.portal.doccenter.service.WorkFlowService;
/*  10:    */ import com.portal.sysmgr.entity.Site;
/*  11:    */ import com.portal.sysmgr.utils.ContextTools;
/*  12:    */ import com.portal.usermgr.entity.Admin;
/*  13:    */ import com.portal.usermgr.entity.Depart;
/*  14:    */ import com.portal.usermgr.entity.User;
/*  15:    */ import com.portal.usermgr.service.DepartService;
/*  16:    */ import java.util.List;
/*  17:    */ import javax.servlet.http.HttpServletRequest;
/*  18:    */ import javax.servlet.http.HttpServletResponse;
/*  19:    */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/*  20:    */ import org.json.JSONException;
/*  21:    */ import org.json.JSONObject;
/*  22:    */ import org.slf4j.Logger;
/*  23:    */ import org.slf4j.LoggerFactory;
/*  24:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  25:    */ import org.springframework.stereotype.Controller;
/*  26:    */ import org.springframework.ui.ModelMap;
/*  27:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  28:    */ 
/*  29:    */ @Controller
/*  30:    */ public class DepartAct
/*  31:    */ {
/*  32: 34 */   private static final Logger log = LoggerFactory.getLogger(DepartAct.class);
/*  33:    */   @Autowired
/*  34:    */   private DepartService service;
/*  35:    */   @Autowired
/*  36:    */   private ChannelService channelService;
/*  37:    */   @Autowired
/*  38:    */   private WorkFlowService workFlowService;
/*  39:    */   
/*  40:    */   @RequestMapping({"/depart/v_chnltree.do"})
/*  41:    */   public String chnltree(Integer departId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  42:    */   {
/*  43: 39 */     Integer siteId = ContextTools.getSiteId(request);
/*  44: 40 */     Integer userId = ContextTools.getUserId(request);
/*  45: 41 */     List<Channel> chnlList = this.channelService.getChannelByAdmin(userId, 
/*  46: 42 */       siteId, null, null, null, null, true);
/*  47: 43 */     model.addAttribute("chnlList", chnlList);
/*  48: 44 */     if (departId != null)
/*  49:    */     {
/*  50: 45 */       Integer[] channelIds = Channel.fetchIds(this.service.findById(departId)
/*  51: 46 */         .getChannels());
/*  52: 47 */       model.addAttribute("chnlIds", channelIds);
/*  53:    */     }
/*  54: 49 */     response.setHeader("Cache-Control", "no-cache");
/*  55: 50 */     response.setContentType("text/json;charset=UTF-8");
/*  56: 51 */     return "userMgr/depart/tree";
/*  57:    */   }
/*  58:    */   
/*  59:    */   @RequestMapping({"/depart/v_addtree.do"})
/*  60:    */   public String addtree(Integer departId, Integer parentId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  61:    */   {
/*  62: 58 */     model.addAttribute("parentId", parentId);
/*  63: 59 */     Integer siteId = ContextTools.getSiteId(request);
/*  64: 60 */     List<Depart> list = null;
/*  65: 61 */     if (parentId != null)
/*  66:    */     {
/*  67: 62 */       list = this.service.getListByParent(parentId);
/*  68: 63 */       model.addAttribute("list", list);
/*  69:    */     }
/*  70:    */     else
/*  71:    */     {
/*  72: 65 */       list = this.service.getListNoParent(siteId);
/*  73: 66 */       model.addAttribute("list", list);
/*  74:    */     }
/*  75: 68 */     if (departId != null) {
/*  76: 69 */       list.remove(this.service.findById(departId));
/*  77:    */     }
/*  78: 71 */     response.setHeader("Cache-Control", "no-cache");
/*  79: 72 */     response.setContentType("text/json;charset=UTF-8");
/*  80: 73 */     return "userMgr/depart/addtree";
/*  81:    */   }
/*  82:    */   
/*  83:    */   @RequiresPermissions({"admin:depart:list"})
/*  84:    */   @RequestMapping({"/depart/v_list.do"})
/*  85:    */   public String list(HttpServletRequest request, ModelMap model)
/*  86:    */   {
/*  87: 79 */     Site site = ContextTools.getSite(request);
/*  88: 80 */     User user = ContextTools.getUser(request);
/*  89: 81 */     if (!user.getAdmin().haveAllManage(site.getId()))
/*  90:    */     {
/*  91: 82 */       Integer departId = user.getAdmin().getDepart(site.getId()).getId();
/*  92: 83 */       return edit(departId, request, model);
/*  93:    */     }
/*  94: 85 */     return "userMgr/depart/list";
/*  95:    */   }
/*  96:    */   
/*  97:    */   @RequiresPermissions({"admin:depart:add"})
/*  98:    */   @RequestMapping({"/depart/v_add.do"})
/*  99:    */   public String add(HttpServletRequest request, ModelMap model)
/* 100:    */   {
/* 101: 91 */     Site site = ContextTools.getSite(request);
/* 102: 92 */     User user = ContextTools.getUser(request);
/* 103: 93 */     if (!user.getAdmin().haveAllManage(site.getId()))
/* 104:    */     {
/* 105: 94 */       Integer departId = user.getAdmin().getDepart(site.getId()).getId();
/* 106: 95 */       return edit(departId, request, model);
/* 107:    */     }
/* 108: 97 */     List<Channel> chnlList = this.channelService.getChannelByAdmin(user.getId(), 
/* 109: 98 */       site.getId(), null, null, null, null, true);
/* 110: 99 */     List<WorkFlow> flowList = this.workFlowService.findByList(site.getId());
/* 111:100 */     model.addAttribute("chnlList", chnlList);
/* 112:101 */     model.addAttribute("flowList", flowList);
/* 113:102 */     return "userMgr/depart/add";
/* 114:    */   }
/* 115:    */   
/* 116:    */   @RequiresPermissions({"admin:depart:edit"})
/* 117:    */   @RequestMapping({"/depart/v_edit.do"})
/* 118:    */   public String edit(Integer id, HttpServletRequest request, ModelMap model)
/* 119:    */   {
/* 120:108 */     Site site = ContextTools.getSite(request);
/* 121:109 */     User user = ContextTools.getUser(request);
/* 122:110 */     List<WorkFlow> flowList = this.workFlowService.findByList(site.getId());
/* 123:111 */     List<Channel> chnlList = this.channelService.getChannelByAdmin(user.getId(), 
/* 124:112 */       site.getId(), null, null, null, null, true);
/* 125:113 */     if (this.service.findById(id).getParent() != null) {
/* 126:114 */       model.addAttribute("parentId", this.service.findById(id).getParent()
/* 127:115 */         .getId());
/* 128:    */     }
/* 129:117 */     model.addAttribute("chnlList", chnlList);
/* 130:118 */     model.addAttribute("flowList", flowList);
/* 131:119 */     model.addAttribute("depart", this.service.findById(id));
/* 132:120 */     return "userMgr/depart/edit";
/* 133:    */   }
/* 134:    */   
/* 135:    */   @RequiresPermissions({"admin:depart:save"})
/* 136:    */   @RequestMapping({"/depart/o_save.do"})
/* 137:    */   public String save(Depart bean, Integer parentId, Integer flowId, Integer[] channelIds, HttpServletRequest request, ModelMap model)
/* 138:    */   {
/* 139:127 */     Site site = ContextTools.getSite(request);
/* 140:128 */     bean = this.service.save(bean, site, parentId, flowId, channelIds);
/* 141:129 */     log.info("save PmsDepartment id={}", bean.getId());
/* 142:130 */     model.addAttribute("msg", "部门添加成功!");
/* 143:131 */     return add(request, model);
/* 144:    */   }
/* 145:    */   
/* 146:    */   @RequiresPermissions({"admin:depart:update"})
/* 147:    */   @RequestMapping({"/depart/o_update.do"})
/* 148:    */   public String update(Depart bean, Integer parentId, Integer flowId, Integer[] channelIds, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 149:    */   {
/* 150:139 */     bean = this.service.update(bean, parentId, flowId, channelIds);
/* 151:140 */     log.info("update PmsDepartment id={}.", bean.getId());
/* 152:141 */     model.addAttribute("msg", "部门修改成功!");
/* 153:142 */     return edit(bean.getId(), request, model);
/* 154:    */   }
/* 155:    */   
/* 156:    */   @RequestMapping({"/depart/jsonData.do"})
/* 157:    */   public String dataPageByJosn(String sortname, String sortorder, Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 158:    */   {
/* 159:149 */     Site site = ContextTools.getSite(request);
/* 160:150 */     Pagination pag = this.service.getPage(site.getId(), sortname, sortorder, 
/* 161:151 */       SimplePage.cpn(page), pagesize.intValue());
/* 162:152 */     model.addAttribute("page", pag);
/* 163:153 */     response.setHeader("Cache-Control", "no-cache");
/* 164:154 */     response.setContentType("text/json;charset=UTF-8");
/* 165:155 */     return "userMgr/depart/data";
/* 166:    */   }
/* 167:    */   
/* 168:    */   @RequiresPermissions({"admin:depart:delete"})
/* 169:    */   @RequestMapping({"/depart/o_ajax_delete.do"})
/* 170:    */   public void deleteUser(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/* 171:    */     throws JSONException
/* 172:    */   {
/* 173:162 */     JSONObject json = new JSONObject();
/* 174:163 */     Depart[] beans = this.service.deleteByIds(ids);
/* 175:164 */     for (Depart bean : beans) {
/* 176:165 */       log.info("delete PmsDepartment id={}", bean.getId());
/* 177:    */     }
/* 178:167 */     json.put("success", true);
/* 179:168 */     json.put("status", 1);
/* 180:169 */     ResponseUtils.renderJson(response, json.toString());
/* 181:    */   }
/* 182:    */   
/* 183:    */   @RequestMapping({"/depart/v_depart.do"})
/* 184:    */   public String treeDepart(Integer id, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 185:    */   {
/* 186:176 */     Integer siteId = ContextTools.getSiteId(request);
/* 187:177 */     List<Depart> list = this.service.getListNoParent(siteId);
/* 188:178 */     list.remove(this.service.findById(id));
/* 189:179 */     model.addAttribute("list", list);
/* 190:180 */     response.setHeader("Cache-Control", "no-cache");
/* 191:181 */     response.setContentType("text/json;charset=UTF-8");
/* 192:182 */     return "userMgr/depart/tree_depart";
/* 193:    */   }
/* 194:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.action.DepartAct
 * JD-Core Version:    0.7.0.1
 */