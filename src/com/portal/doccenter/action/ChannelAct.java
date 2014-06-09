/*   1:    */ package com.portal.doccenter.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.utils.ResponseUtils;
/*   4:    */ import com.javapms.basic.utils.ServicesUtils;
/*   5:    */ import com.portal.datacenter.operatedata.service.LogService;
/*   6:    */ import com.portal.doccenter.entity.Channel;
/*   7:    */ import com.portal.doccenter.entity.ChannelExt;
/*   8:    */ import com.portal.doccenter.entity.ChannelTxt;
/*   9:    */ import com.portal.doccenter.entity.ChnlTplSelection;
/*  10:    */ import com.portal.doccenter.service.ArticleService;
/*  11:    */ import com.portal.doccenter.service.ChannelService;
/*  12:    */ import com.portal.doccenter.service.ModelService;
/*  13:    */ import com.portal.sysmgr.entity.Site;
/*  14:    */ import com.portal.sysmgr.service.TplService;
/*  15:    */ import com.portal.sysmgr.utils.ContextTools;
/*  16:    */ import com.portal.sysmgr.utils.Tpl;
/*  17:    */ import com.portal.usermgr.entity.Group;
/*  18:    */ import com.portal.usermgr.service.GroupService;
/*  19:    */ import java.util.Collection;
/*  20:    */ import java.util.List;
/*  21:    */ import java.util.Map;
/*  22:    */ import javax.servlet.http.HttpServletRequest;
/*  23:    */ import javax.servlet.http.HttpServletResponse;
/*  24:    */ import org.apache.commons.lang.StringUtils;
/*  25:    */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/*  26:    */ import org.json.JSONException;
/*  27:    */ import org.json.JSONObject;
/*  28:    */ import org.slf4j.Logger;
/*  29:    */ import org.slf4j.LoggerFactory;
/*  30:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  31:    */ import org.springframework.stereotype.Controller;
/*  32:    */ import org.springframework.ui.ModelMap;
/*  33:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  34:    */ 
/*  35:    */ @Controller
/*  36:    */ public class ChannelAct
/*  37:    */ {
/*  38: 41 */   private static final Logger log = LoggerFactory.getLogger(ChannelAct.class);
/*  39:    */   @Autowired
/*  40:    */   private ModelService modelService;
/*  41:    */   @Autowired
/*  42:    */   private GroupService groupService;
/*  43:    */   @Autowired
/*  44:    */   private LogService logService;
/*  45:    */   @Autowired
/*  46:    */   private TplService tplService;
/*  47:    */   @Autowired
/*  48:    */   private ChannelService service;
/*  49:    */   @Autowired
/*  50:    */   private ArticleService articleService;
/*  51:    */   
/*  52:    */   @RequestMapping(value={"/channel/v_tpl_dirtree.do"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  53:    */   public String dirtree(String path, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  54:    */   {
/*  55: 46 */     Site site = ContextTools.getSite(request);
/*  56: 47 */     String root = site.getSolutionPath();
/*  57: 48 */     log.debug("tree path={}", root);
/*  58: 49 */     if (StringUtils.isBlank(path))
/*  59:    */     {
/*  60: 50 */       model.addAttribute("isRoot", Boolean.valueOf(true));
/*  61: 51 */       path = "";
/*  62:    */     }
/*  63:    */     else
/*  64:    */     {
/*  65: 53 */       model.addAttribute("isRoot", Boolean.valueOf(false));
/*  66:    */     }
/*  67: 55 */     List<? extends Tpl> tplList = this.tplService.getDirChild(root, path);
/*  68: 56 */     model.addAttribute("path", path);
/*  69: 57 */     model.addAttribute("tplList", tplList);
/*  70: 58 */     response.setHeader("Cache-Control", "no-cache");
/*  71: 59 */     response.setContentType("text/json;charset=UTF-8");
/*  72: 60 */     return "docCenter/channel/dirtree";
/*  73:    */   }
/*  74:    */   
/*  75:    */   @RequestMapping(value={"/channel/v_tpl_filetree.do"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  76:    */   public String tpltree(String path, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  77:    */   {
/*  78: 66 */     Site site = ContextTools.getSite(request);
/*  79: 67 */     String root = site.getSolutionPath();
/*  80: 68 */     if (StringUtils.isBlank(path)) {
/*  81: 69 */       path = "";
/*  82:    */     }
/*  83: 71 */     List<? extends Tpl> tplList = this.tplService.getFileChild(root, path);
/*  84: 72 */     model.addAttribute("path", path);
/*  85: 73 */     model.addAttribute("tplList", tplList);
/*  86: 74 */     response.setHeader("Cache-Control", "no-cache");
/*  87: 75 */     response.setContentType("text/json;charset=UTF-8");
/*  88: 76 */     return "docCenter/channel/filetree";
/*  89:    */   }
/*  90:    */   
/*  91:    */   @RequestMapping({"/channel/v_edittree.do"})
/*  92:    */   public String edittree(Integer parentId, Integer channelId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  93:    */   {
/*  94: 83 */     model.addAttribute("parentId", parentId);
/*  95: 84 */     Integer siteId = ContextTools.getSiteId(request);
/*  96: 85 */     Integer userId = ContextTools.getUserId(request);
/*  97: 86 */     List<Channel> list = this.service.getChannelByAdmin(userId, siteId, 
/*  98: 87 */       parentId, null, null, null, true);
/*  99: 88 */     list.remove(this.service.findById(channelId));
/* 100: 89 */     model.addAttribute("list", list);
/* 101: 90 */     response.setHeader("Cache-Control", "no-cache");
/* 102: 91 */     response.setContentType("text/json;charset=UTF-8");
/* 103: 92 */     return "docCenter/channel/edittree";
/* 104:    */   }
/* 105:    */   
/* 106:    */   @RequestMapping({"/channel/v_seltree.do"})
/* 107:    */   public String seltree(Integer parentId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 108:    */   {
/* 109: 98 */     model.addAttribute("parentId", parentId);
/* 110: 99 */     Integer siteId = ContextTools.getSiteId(request);
/* 111:100 */     Integer userId = ContextTools.getUserId(request);
/* 112:101 */     List<Channel> list = this.service.getChannelByAdmin(userId, siteId, 
/* 113:102 */       parentId, null, null, null, false);
/* 114:103 */     model.addAttribute("list", list);
/* 115:104 */     response.setHeader("Cache-Control", "no-cache");
/* 116:105 */     response.setContentType("text/json;charset=UTF-8");
/* 117:106 */     return "docCenter/channel/edittree";
/* 118:    */   }
/* 119:    */   
/* 120:    */   @RequestMapping({"/channel/v_inserttree.do"})
/* 121:    */   public String addtree(Integer parentId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 122:    */   {
/* 123:112 */     model.addAttribute("parentId", parentId);
/* 124:113 */     Integer siteId = ContextTools.getSiteId(request);
/* 125:114 */     Integer userId = ContextTools.getUserId(request);
/* 126:115 */     List<Channel> list = this.service.getChannelByAdmin(userId, siteId, 
/* 127:116 */       parentId, null, null, null, false);
/* 128:117 */     model.addAttribute("list", list);
/* 129:118 */     response.setHeader("Cache-Control", "no-cache");
/* 130:119 */     response.setContentType("text/json;charset=UTF-8");
/* 131:120 */     return "docCenter/channel/inserttree";
/* 132:    */   }
/* 133:    */   
/* 134:    */   @RequestMapping({"/channel/v_tree.do"})
/* 135:    */   public String tree(Integer parentId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 136:    */   {
/* 137:126 */     model.addAttribute("parentId", parentId);
/* 138:127 */     Integer siteId = ContextTools.getSiteId(request);
/* 139:128 */     Integer userId = ContextTools.getUserId(request);
/* 140:129 */     List<Channel> list = this.service.getChannelByAdmin(userId, siteId, 
/* 141:130 */       parentId, null, null, null, true);
/* 142:131 */     model.addAttribute("list", list);
/* 143:132 */     response.setHeader("Cache-Control", "no-cache");
/* 144:133 */     response.setContentType("text/json;charset=UTF-8");
/* 145:134 */     return "docCenter/channel/tree";
/* 146:    */   }
/* 147:    */   
/* 148:    */   @RequiresPermissions({"admin:channel:list"})
/* 149:    */   @RequestMapping({"/channel/v_list.do"})
/* 150:    */   public String list(Integer parentId, ModelMap model)
/* 151:    */   {
/* 152:140 */     model.addAttribute("parentId", parentId);
/* 153:141 */     return "docCenter/channel/list";
/* 154:    */   }
/* 155:    */   
/* 156:    */   @RequiresPermissions({"admin:channel:add"})
/* 157:    */   @RequestMapping({"/channel/v_add.do"})
/* 158:    */   public String add(Integer parentId, HttpServletRequest request, ModelMap model)
/* 159:    */   {
/* 160:148 */     Site site = ContextTools.getSite(request);
/* 161:149 */     Channel parent = null;
/* 162:150 */     if (parentId != null)
/* 163:    */     {
/* 164:151 */       parent = this.service.findById(parentId);
/* 165:152 */       model.addAttribute("parent", parent);
/* 166:153 */       model.addAttribute("parentId", parentId);
/* 167:154 */       model.addAttribute("modelList", parent.getModelList());
/* 168:    */     }
/* 169:    */     else
/* 170:    */     {
/* 171:156 */       model.addAttribute("modelList", 
/* 172:157 */         this.modelService.getList(false, null, null));
/* 173:    */     }
/* 174:159 */     List<Group> groupList = this.groupService.getList(site.getId(), null, null);
/* 175:    */     
/* 176:161 */     List<Group> viewGroups = groupList;
/* 177:    */     Collection<Group> contriGroups;
/* 179:164 */     if (parent != null) {
/* 180:165 */       contriGroups = parent.getContriGroups();
/* 181:    */     } else {
/* 182:167 */       contriGroups = groupList;
/* 183:    */     }
/* 184:169 */     model.addAttribute("viewGroups", viewGroups);
/* 185:170 */     model.addAttribute("contriGroups", contriGroups);
/* 186:171 */     model.addAttribute("contriGroupIds", Group.fetchIds(contriGroups));
/* 187:172 */     return "docCenter/channel/add";
/* 188:    */   }
/* 189:    */   
/* 190:    */   @RequiresPermissions({"admin:channel:edit"})
/* 191:    */   @RequestMapping({"/channel/v_edit.do"})
/* 192:    */   public String edit(Integer id, HttpServletRequest request, ModelMap model)
/* 193:    */   {
/* 194:178 */     Site site = ContextTools.getSite(request);
/* 195:179 */     Channel channel = this.service.findById(id);
/* 196:180 */     if (channel.getParent() != null) {
/* 197:181 */       model.addAttribute("modelList", channel.getParent().getModelList());
/* 198:    */     } else {
/* 199:183 */       model.addAttribute("modelList", 
/* 200:184 */         this.modelService.getList(false, null, null));
/* 201:    */     }
/* 202:187 */     Integer[] modelIds = ChnlTplSelection.fetchIds(channel.getTpls());
/* 203:188 */     List<Group> groupList = this.groupService.getList(site.getId(), null, null);
/* 204:189 */     List<Group> viewGroups = groupList;
/* 205:190 */     Integer[] viewGroupIds = Group.fetchIds(channel.getViewGroups());
/* 206:191 */     Channel parent = channel.getParent();
/* 207:    */     Collection<Group> contriGroups;
/* 209:194 */     if (parent != null) {
/* 210:195 */       contriGroups = parent.getContriGroups();
/* 211:    */     } else {
/* 212:197 */       contriGroups = groupList;
/* 213:    */     }
/* 214:199 */     Integer[] contriGroupIds = Group.fetchIds(channel.getContriGroups());
/* 215:200 */     model.addAttribute("chnlmodelList", channel.getModelList());
/* 216:201 */     model.addAttribute("modelIds", modelIds);
/* 217:202 */     model.addAttribute("viewGroups", viewGroups);
/* 218:203 */     model.addAttribute("viewGroupIds", viewGroupIds);
/* 219:204 */     model.addAttribute("contriGroups", contriGroups);
/* 220:205 */     model.addAttribute("contriGroupIds", contriGroupIds);
/* 221:206 */     model.addAttribute("channel", channel);
/* 222:207 */     return "docCenter/channel/edit";
/* 223:    */   }
/* 224:    */   
/* 225:    */   @RequiresPermissions({"admin:channel:save"})
/* 226:    */   @RequestMapping({"/channel/o_save.do"})
/* 227:    */   public String save(Integer parentId, Channel bean, ChannelExt ext, ChannelTxt txt, Integer[] viewGroupIds, Integer[] contriGroupIds, String[] modelIds, HttpServletRequest request, ModelMap model)
/* 228:    */   {
/* 229:215 */     Map<String, String> tpls = ServicesUtils.getRequestMapWithPrefix(
/* 230:216 */       request, "tpl_", modelIds);
/* 231:217 */     bean = this.service.save(bean, ext, txt, viewGroupIds, contriGroupIds, 
/* 232:218 */       ContextTools.getSiteId(request), parentId, modelIds, tpls);
/* 233:219 */     log.info("save Channel id={}, name={}", bean.getId(), bean.getName());
/* 234:220 */     this.logService.operating(request, "channel.log.save", "id=" + bean.getId() + 
/* 235:221 */       ";title=" + bean.getTitle());
/* 236:222 */     model.addAttribute("msg", "栏目添加成功!");
/* 237:223 */     return add(parentId, request, model);
/* 238:    */   }
/* 239:    */   
/* 240:    */   @RequiresPermissions({"admin:channel:update"})
/* 241:    */   @RequestMapping({"/channel/o_update.do"})
/* 242:    */   public String update(Channel bean, ChannelExt ext, ChannelTxt txt, Integer[] viewGroupIds, Integer[] contriGroupIds, Integer parentId, String[] modelIds, HttpServletRequest request, ModelMap model)
/* 243:    */   {
/* 244:231 */     Map<String, String> tpls = ServicesUtils.getRequestMapWithPrefix(
/* 245:232 */       request, "tpl_", modelIds);
/* 246:233 */     bean = this.service.update(bean, ext, txt, viewGroupIds, contriGroupIds, 
/* 247:234 */       parentId, modelIds, tpls);
/* 248:235 */     log.info("update Channel id={}.", bean.getId());
/* 249:236 */     this.logService.operating(request, "channel.log.update", 
/* 250:237 */       "id=" + bean.getId() + ";name=" + bean.getName());
/* 251:238 */     model.addAttribute("msg", "栏目修改成功!");
/* 252:239 */     return edit(bean.getId(), request, model);
/* 253:    */   }
/* 254:    */   
/* 255:    */   @RequestMapping({"/channel/jsonData.do"})
/* 256:    */   public String dataPageByJosn(Integer parentId, String key, String sortname, String sortorder, Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 257:    */   {
/* 258:247 */     Integer userId = ContextTools.getUserId(request);
/* 259:248 */     Integer siteId = ContextTools.getSiteId(request);
/* 260:249 */     List<Channel> list = this.service.getChannelByAdmin(userId, siteId, 
/* 261:250 */       parentId, key, sortname, sortorder, true);
/* 262:251 */     model.addAttribute("list", list);
/* 263:252 */     response.setHeader("Cache-Control", "no-cache");
/* 264:253 */     response.setContentType("text/json;charset=UTF-8");
/* 265:254 */     return "docCenter/channel/listdata";
/* 266:    */   }
/* 267:    */   
/* 268:    */   @RequiresPermissions({"admin:channel:delete"})
/* 269:    */   @RequestMapping({"/channel/o_delchnl.do"})
/* 270:    */   public String delChannel(Integer chnlId, Boolean del, Integer cid, HttpServletRequest request, ModelMap model)
/* 271:    */   {
/* 272:261 */     if ((del == null) || (del.booleanValue()))
/* 273:    */     {
/* 274:262 */       long count = this.articleService.getCountDoc(chnlId);
/* 275:263 */       if (count > 0L)
/* 276:    */       {
/* 277:264 */         model.addAttribute("msge", "请先转移或者清除该栏目下的文档!");
/* 278:265 */         return edit(chnlId, request, model);
/* 279:    */       }
/* 280:    */     }
/* 281:268 */     Channel parent = this.service.findById(chnlId).getParent();
/* 282:269 */     this.service.delChannel(chnlId, del, cid);
/* 283:270 */     model.addAttribute("msg", "删除栏目成功!");
/* 284:271 */     if (parent != null) {
/* 285:272 */       return edit(parent.getId(), request, model);
/* 286:    */     }
/* 287:274 */     return list(null, model);
/* 288:    */   }
/* 289:    */   
/* 290:    */   @RequiresPermissions({"admin:channel:delete"})
/* 291:    */   @RequestMapping({"/channel/o_ajax_delete.do"})
/* 292:    */   public void deleteChannel(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/* 293:    */     throws JSONException
/* 294:    */   {
/* 295:282 */     JSONObject json = new JSONObject();
/* 296:283 */     Channel[] beans = this.service.deleteByIds(ids);
/* 297:284 */     for (Channel bean : beans)
/* 298:    */     {
/* 299:285 */       log.info("delete Channel id={}", bean.getId());
/* 300:286 */       this.logService.operating(request, "channel.log.delete", 
/* 301:287 */         "id=" + bean.getId() + ";title=" + bean.getTitle());
/* 302:    */     }
/* 303:289 */     json.put("success", true);
/* 304:290 */     json.put("status", 1);
/* 305:291 */     ResponseUtils.renderJson(response, json.toString());
/* 306:    */   }
/* 307:    */ }



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.doccenter.action.ChannelAct

 * JD-Core Version:    0.7.0.1

 */