/*   1:    */ package com.portal.sysmgr.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.utils.ResponseUtils;
/*   4:    */ import com.javapms.basic.utils.ServicesUtils;
/*   5:    */ import com.portal.datacenter.operatedata.service.LogService;
/*   6:    */ import com.portal.doccenter.entity.ArticleType;
/*   7:    */ import com.portal.doccenter.service.ArticleTypeService;
/*   8:    */ import com.portal.doccenter.service.ModelService;
/*   9:    */ import com.portal.sysmgr.entity.Site;
/*  10:    */ import com.portal.sysmgr.service.ResourceService;
/*  11:    */ import com.portal.sysmgr.service.SiteService;
/*  12:    */ import com.portal.sysmgr.service.TplService;
/*  13:    */ import com.portal.sysmgr.utils.ContextTools;
/*  14:    */ import com.portal.sysmgr.utils.Tpl;
/*  15:    */ import java.util.List;
/*  16:    */ import javax.servlet.http.HttpServletRequest;
/*  17:    */ import javax.servlet.http.HttpServletResponse;
/*  18:    */ import org.apache.commons.lang.StringUtils;
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
/*  30:    */ public class TemplateAct
/*  31:    */ {
/*  32: 43 */   private static final Logger log = LoggerFactory.getLogger(TemplateAct.class);
/*  33:    */   @Autowired
/*  34:    */   private LogService logService;
/*  35:    */   private TplService tplService;
/*  36:    */   private ResourceService resourceService;
/*  37:    */   private SiteService siteService;
/*  38:    */   private ArticleTypeService typeService;
/*  39:    */   @Autowired
/*  40:    */   private ModelService modelService;
/*  41:    */   
/*  42:    */   @RequestMapping(value={"/tpl/v_tpl_dirtree.do"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  43:    */   public String dirtree(String path, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  44:    */   {
/*  45: 48 */     Site site = ContextTools.getSite(request);
/*  46: 49 */     String root = site.getSolutionPath();
/*  47: 50 */     log.debug("tree path={}", root);
/*  48: 51 */     if (StringUtils.isBlank(path))
/*  49:    */     {
/*  50: 52 */       model.addAttribute("isRoot", Boolean.valueOf(true));
/*  51: 53 */       path = "";
/*  52:    */     }
/*  53:    */     else
/*  54:    */     {
/*  55: 55 */       model.addAttribute("isRoot", Boolean.valueOf(false));
/*  56:    */     }
/*  57: 57 */     List<? extends Tpl> tplList = this.tplService.getDirChild(root, path);
/*  58: 58 */     model.addAttribute("path", path);
/*  59: 59 */     model.addAttribute("tplList", tplList);
/*  60: 60 */     response.setHeader("Cache-Control", "no-cache");
/*  61: 61 */     response.setContentType("text/json;charset=UTF-8");
/*  62: 62 */     return "sysMgr/tplMgr/dirtree";
/*  63:    */   }
/*  64:    */   
/*  65:    */   @RequestMapping(value={"/tpl/v_tpl_filetree.do"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  66:    */   public String tpltree(String path, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  67:    */   {
/*  68: 68 */     Site site = ContextTools.getSite(request);
/*  69: 69 */     String root = site.getSolutionPath();
/*  70: 70 */     if (StringUtils.isBlank(path)) {
/*  71: 71 */       path = "";
/*  72:    */     }
/*  73: 73 */     List<? extends Tpl> tplList = this.tplService.getFileChild(root, path);
/*  74: 74 */     model.addAttribute("path", path);
/*  75: 75 */     model.addAttribute("tplList", tplList);
/*  76: 76 */     response.setHeader("Cache-Control", "no-cache");
/*  77: 77 */     response.setContentType("text/json;charset=UTF-8");
/*  78: 78 */     return "sysMgr/tplMgr/filetree";
/*  79:    */   }
/*  80:    */   
/*  81:    */   @RequestMapping({"/tpl/v_tree.do"})
/*  82:    */   public String tree(String path, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  83:    */   {
/*  84: 84 */     Site site = ContextTools.getSite(request);
/*  85: 85 */     String root = site.getSolutionPath();
/*  86: 86 */     log.debug("tree path={}", root);
/*  87: 87 */     if (StringUtils.isBlank(path))
/*  88:    */     {
/*  89: 88 */       model.addAttribute("isRoot", Boolean.valueOf(true));
/*  90: 89 */       path = "";
/*  91:    */     }
/*  92:    */     else
/*  93:    */     {
/*  94: 91 */       model.addAttribute("isRoot", Boolean.valueOf(false));
/*  95:    */     }
/*  96: 93 */     List<? extends Tpl> tplList = this.tplService.getChild(root, path);
/*  97: 94 */     model.addAttribute("path", path);
/*  98: 95 */     model.addAttribute("tplList", tplList);
/*  99: 96 */     response.setHeader("Cache-Control", "no-cache");
/* 100: 97 */     response.setContentType("text/json;charset=UTF-8");
/* 101: 98 */     return "sysMgr/tplMgr/tree";
/* 102:    */   }
/* 103:    */   
/* 104:    */   @RequiresPermissions({"admin:tpl:list"})
/* 105:    */   @RequestMapping(value={"/tpl/v_list.do"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 106:    */   public String list(String path, HttpServletRequest request, ModelMap model)
/* 107:    */   {
/* 108:104 */     model.addAttribute("path", path);
/* 109:105 */     return "sysMgr/tplMgr/list";
/* 110:    */   }
/* 111:    */   
/* 112:    */   @RequiresPermissions({"admin:tpl:createdir"})
/* 113:    */   @RequestMapping({"/tpl/o_create_dir.do"})
/* 114:    */   public String createDir(String path, String dirName, HttpServletRequest request, ModelMap model)
/* 115:    */   {
/* 116:112 */     Site site = ContextTools.getSite(request);
/* 117:113 */     String root = site.getSolutionPath();
/* 118:114 */     if (StringUtils.isBlank(path)) {
/* 119:115 */       path = "";
/* 120:    */     }
/* 121:117 */     this.tplService.save(root + path + "/" + dirName, null, true);
/* 122:118 */     model.addAttribute("path", path);
/* 123:119 */     model.addAttribute("msg", "目录新建成功!");
/* 124:120 */     return list(path, request, model);
/* 125:    */   }
/* 126:    */   
/* 127:    */   @RequiresPermissions({"admin:tpl:add"})
/* 128:    */   @RequestMapping(value={"/tpl/v_add.do"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 129:    */   public String add(String path, HttpServletRequest request, ModelMap model)
/* 130:    */   {
/* 131:126 */     List<ArticleType> typeList = this.typeService.getList(false, null, null);
/* 132:127 */     model.addAttribute("path", path);
/* 133:128 */     model.addAttribute("modelList", this.modelService.getList(false, null, null));
/* 134:129 */     model.addAttribute("typeList", typeList);
/* 135:130 */     return "sysMgr/tplMgr/add";
/* 136:    */   }
/* 137:    */   
/* 138:    */   @RequiresPermissions({"admin:tpl:edit"})
/* 139:    */   @RequestMapping(value={"/tpl/v_edit.do"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 140:    */   public String edit(HttpServletRequest request, ModelMap model)
/* 141:    */   {
/* 142:136 */     Site site = ContextTools.getSite(request);
/* 143:137 */     String name = ServicesUtils.getQueryParam(request, "name");
/* 144:138 */     List<ArticleType> typeList = this.typeService.getList(false, null, null);
/* 145:139 */     String root = site.getSolutionPath();
/* 146:140 */     model.addAttribute("tpl", this.tplService.get(root, name));
/* 147:141 */     model.addAttribute("modelList", this.modelService.getList(false, null, null));
/* 148:142 */     model.addAttribute("typeList", typeList);
/* 149:143 */     return "sysMgr/tplMgr/edit";
/* 150:    */   }
/* 151:    */   
/* 152:    */   @RequiresPermissions({"admin:tpl:save"})
/* 153:    */   @RequestMapping({"/tpl/o_save.do"})
/* 154:    */   public String save(String path, String filename, String source, HttpServletRequest request, ModelMap model)
/* 155:    */   {
/* 156:150 */     Site site = ContextTools.getSite(request);
/* 157:151 */     String root = site.getSolutionPath();
/* 158:152 */     if (StringUtils.isBlank(path)) {
/* 159:153 */       path = "";
/* 160:    */     }
/* 161:155 */     String name = root + path + "/" + filename + ".html";
/* 162:156 */     this.tplService.save(name, source, false);
/* 163:157 */     model.addAttribute("path", path);
/* 164:158 */     log.info("save Tpl name={}", filename);
/* 165:159 */     this.logService.operating(request, "创建模板", "filename=" + filename);
/* 166:160 */     model.addAttribute("msg", "模板创建成功!");
/* 167:161 */     return add(path, request, model);
/* 168:    */   }
/* 169:    */   
/* 170:    */   @RequiresPermissions({"admin:tpl:update"})
/* 171:    */   @RequestMapping(value={"/tpl/o_update.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 172:    */   public String update(String name, String source, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 173:    */   {
/* 174:169 */     Site site = ContextTools.getSite(request);
/* 175:170 */     String root = site.getSolutionPath();
/* 176:171 */     this.tplService.update(root + name, source);
/* 177:172 */     log.info("update Tpl name={}.", name);
/* 178:173 */     this.logService.operating(request, "添加模板", "filename=" + name);
/* 179:174 */     model.addAttribute("msg", "模板修改成功!");
/* 180:175 */     return edit(request, model);
/* 181:    */   }
/* 182:    */   
/* 183:    */   @RequestMapping({"/tpl/jsonData.do"})
/* 184:    */   public String dataPageByJosn(String path, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 185:    */   {
/* 186:181 */     Site site = ContextTools.getSite(request);
/* 187:182 */     String root = site.getSolutionPath();
/* 188:183 */     log.debug("list Template root: {}", root);
/* 189:184 */     if (StringUtils.isBlank(path)) {
/* 190:185 */       path = "";
/* 191:    */     }
/* 192:187 */     model.addAttribute("path", path);
/* 193:188 */     model.addAttribute("list", this.tplService.getChild(root, path));
/* 194:189 */     response.setHeader("Cache-Control", "no-cache");
/* 195:190 */     response.setContentType("text/json;charset=UTF-8");
/* 196:191 */     return "sysMgr/tplMgr/listdata";
/* 197:    */   }
/* 198:    */   
/* 199:    */   @RequiresPermissions({"admin:tpl:delete"})
/* 200:    */   @RequestMapping({"/tpl/o_ajax_delete.do"})
/* 201:    */   public void deleteGroup(String[] names, HttpServletRequest request, HttpServletResponse response)
/* 202:    */     throws JSONException
/* 203:    */   {
/* 204:198 */     JSONObject json = new JSONObject();
/* 205:199 */     Site site = ContextTools.getSite(request);
/* 206:200 */     String root = site.getSolutionPath();
/* 207:201 */     this.tplService.delete(root, names);
/* 208:202 */     json.put("success", true);
/* 209:203 */     json.put("status", 1);
/* 210:204 */     ResponseUtils.renderJson(response, json.toString());
/* 211:    */   }
/* 212:    */   
/* 213:    */   @RequiresPermissions({"admin:tpl:rename"})
/* 214:    */   @RequestMapping(value={"/tpl/o_rename.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 215:    */   public String renameSubmit(String path, String origName, String distName, HttpServletRequest request, ModelMap model)
/* 216:    */   {
/* 217:212 */     Site site = ContextTools.getSite(request);
/* 218:213 */     String root = site.getSolutionPath();
/* 219:214 */     String orig = root + path + "/" + origName;
/* 220:215 */     String dist = root + path + "/" + distName;
/* 221:216 */     this.tplService.rename(orig, dist);
/* 222:217 */     log.info("name Tpl from {} to {}", orig, dist);
/* 223:218 */     model.addAttribute("path", path);
/* 224:219 */     model.addAttribute("msg", "模板重命名成功!");
/* 225:220 */     return list(path, request, model);
/* 226:    */   }
/* 227:    */   
/* 228:    */   @RequiresPermissions({"admin:tpl:setting"})
/* 229:    */   @RequestMapping({"/tpl/v_setting.do"})
/* 230:    */   public String setting(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 231:    */   {
/* 232:227 */     Site site = ContextTools.getSite(request);
/* 233:228 */     String[] styles = this.resourceService.getStyles(site.getTplPath());
/* 234:229 */     model.addAttribute("styles", styles);
/* 235:230 */     model.addAttribute("defStyle", site.getTplStyle());
/* 236:231 */     return "sysMgr/tplMgr/setting";
/* 237:    */   }
/* 238:    */   
/* 239:    */   @RequiresPermissions({"admin:tpl:deftemplate"})
/* 240:    */   @RequestMapping({"/tpl/o_def_template.do"})
/* 241:    */   public void defTempate(String style, HttpServletRequest request, HttpServletResponse response)
/* 242:    */   {
/* 243:238 */     Site site = ContextTools.getSite(request);
/* 244:239 */     this.siteService.updateTplStyle(site.getId(), style);
/* 245:240 */     ResponseUtils.renderJson(response, "{'success':true}");
/* 246:    */   }
/* 247:    */   
/* 248:    */   @Autowired
/* 249:    */   public void setTplManager(TplService tplService)
/* 250:    */   {
/* 251:254 */     this.tplService = tplService;
/* 252:    */   }
/* 253:    */   
/* 254:    */   @Autowired
/* 255:    */   public void setResourceService(ResourceService resourceService)
/* 256:    */   {
/* 257:259 */     this.resourceService = resourceService;
/* 258:    */   }
/* 259:    */   
/* 260:    */   @Autowired
/* 261:    */   public void setSiteService(SiteService siteService)
/* 262:    */   {
/* 263:264 */     this.siteService = siteService;
/* 264:    */   }
/* 265:    */   
/* 266:    */   @Autowired
/* 267:    */   public void setTypeService(ArticleTypeService typeService)
/* 268:    */   {
/* 269:269 */     this.typeService = typeService;
/* 270:    */   }
/* 271:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.action.TemplateAct
 * JD-Core Version:    0.7.0.1
 */