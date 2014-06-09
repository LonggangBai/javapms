/*   1:    */ package com.portal.sysmgr.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.file.FileWrap;
/*   4:    */ import com.javapms.basic.utils.ResponseUtils;
/*   5:    */ import com.portal.datacenter.operatedata.service.LogService;
/*   6:    */ import com.portal.sysmgr.entity.Site;
/*   7:    */ import com.portal.sysmgr.service.ResourceService;
/*   8:    */ import com.portal.sysmgr.utils.ContextTools;
/*   9:    */ import java.io.IOException;
/*  10:    */ import java.util.List;
/*  11:    */ import javax.servlet.http.HttpServletRequest;
/*  12:    */ import javax.servlet.http.HttpServletResponse;
/*  13:    */ import org.apache.commons.lang.StringUtils;
/*  14:    */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/*  15:    */ import org.json.JSONException;
/*  16:    */ import org.json.JSONObject;
/*  17:    */ import org.slf4j.Logger;
/*  18:    */ import org.slf4j.LoggerFactory;
/*  19:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  20:    */ import org.springframework.stereotype.Controller;
/*  21:    */ import org.springframework.ui.ModelMap;
/*  22:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  23:    */ import org.springframework.web.bind.annotation.RequestParam;
/*  24:    */ import org.springframework.web.multipart.MultipartFile;
/*  25:    */ 
/*  26:    */ @Controller
/*  27:    */ public class ResourceAct
/*  28:    */ {
/*  29: 39 */   private static final Logger log = LoggerFactory.getLogger(ResourceAct.class);
/*  30:    */   @Autowired
/*  31:    */   private LogService logService;
/*  32:    */   private ResourceService resourceService;
/*  33:    */   
/*  34:    */   @RequestMapping({"/res/v_tree.do"})
/*  35:    */   public String tree(String path, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  36:    */   {
/*  37: 44 */     Site site = ContextTools.getSite(request);
/*  38: 45 */     String root = site.getResSolutionPath();
/*  39: 46 */     if (StringUtils.isBlank(path)) {
/*  40: 47 */       path = "";
/*  41:    */     }
/*  42: 49 */     List<? extends FileWrap> resList = this.resourceService.listFile(root, path, 
/*  43: 50 */       true);
/*  44: 51 */     model.addAttribute("path", path);
/*  45: 52 */     model.addAttribute("resList", resList);
/*  46: 53 */     response.setHeader("Cache-Control", "no-cache");
/*  47: 54 */     response.setContentType("text/json;charset=UTF-8");
/*  48: 55 */     return "sysMgr/resMgr/tree";
/*  49:    */   }
/*  50:    */   
/*  51:    */   @RequiresPermissions({"admin:res:list"})
/*  52:    */   @RequestMapping({"/res/v_list.do"})
/*  53:    */   public String list(String path, HttpServletRequest request, ModelMap model)
/*  54:    */   {
/*  55: 61 */     model.addAttribute("path", path);
/*  56: 62 */     return "sysMgr/resMgr/list";
/*  57:    */   }
/*  58:    */   
/*  59:    */   @RequiresPermissions({"admin:res:createdir"})
/*  60:    */   @RequestMapping({"/res/o_create_dir.do"})
/*  61:    */   public String createDir(String path, String dirName, HttpServletRequest request, ModelMap model)
/*  62:    */   {
/*  63: 69 */     Site site = ContextTools.getSite(request);
/*  64: 70 */     String root = site.getResSolutionPath();
/*  65: 71 */     if (StringUtils.isBlank(path)) {
/*  66: 72 */       path = "";
/*  67:    */     }
/*  68: 74 */     this.resourceService.createDir(root + path, dirName);
/*  69: 75 */     model.addAttribute("path", path);
/*  70: 76 */     model.addAttribute("msg", "目录新建成功!");
/*  71: 77 */     return list(path, request, model);
/*  72:    */   }
/*  73:    */   
/*  74:    */   @RequiresPermissions({"admin:res:add"})
/*  75:    */   @RequestMapping({"/res/v_add.do"})
/*  76:    */   public String add(String path, HttpServletRequest request, ModelMap model)
/*  77:    */   {
/*  78: 83 */     model.addAttribute("path", path);
/*  79: 84 */     return "sysMgr/resMgr/add";
/*  80:    */   }
/*  81:    */   
/*  82:    */   @RequiresPermissions({"admin:res:edit"})
/*  83:    */   @RequestMapping({"/res/v_edit.do"})
/*  84:    */   public String edit(String name, HttpServletRequest request, ModelMap model)
/*  85:    */     throws IOException
/*  86:    */   {
/*  87: 91 */     Site site = ContextTools.getSite(request);
/*  88: 92 */     String root = site.getResSolutionPath();
/*  89: 93 */     model.addAttribute("source", this.resourceService.readFile(root + name));
/*  90: 94 */     model.addAttribute("name", name);
/*  91: 95 */     model.addAttribute("filename", 
/*  92: 96 */       name.substring(name.lastIndexOf('/') + 1));
/*  93: 97 */     return "sysMgr/resMgr/edit";
/*  94:    */   }
/*  95:    */   
/*  96:    */   @RequiresPermissions({"admin:res:save"})
/*  97:    */   @RequestMapping({"/res/o_save.do"})
/*  98:    */   public String save(String path, String filename, String source, HttpServletRequest request, ModelMap model)
/*  99:    */     throws IOException
/* 100:    */   {
/* 101:104 */     Site site = ContextTools.getSite(request);
/* 102:105 */     String root = site.getResSolutionPath();
/* 103:106 */     if (StringUtils.isBlank(path)) {
/* 104:107 */       path = "";
/* 105:    */     }
/* 106:109 */     this.resourceService.createFile(root + path, filename, source);
/* 107:110 */     this.logService.operating(request, "添加资源", "filename=" + filename);
/* 108:111 */     model.addAttribute("msg", "资源创建成功!");
/* 109:112 */     return add(path, request, model);
/* 110:    */   }
/* 111:    */   
/* 112:    */   @RequiresPermissions({"admin:res:update"})
/* 113:    */   @RequestMapping({"/res/o_update.do"})
/* 114:    */   public String update(String name, String source, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 115:    */     throws IOException
/* 116:    */   {
/* 117:120 */     Site site = ContextTools.getSite(request);
/* 118:121 */     String root = site.getResSolutionPath();
/* 119:122 */     this.resourceService.updateFile(root + name, source);
/* 120:123 */     log.info("update Resource name={}.", name);
/* 121:124 */     this.logService.operating(request, "修改资源", "filename=" + name);
/* 122:125 */     model.addAttribute("msg", "资源修改成功!");
/* 123:126 */     return edit(name, request, model);
/* 124:    */   }
/* 125:    */   
/* 126:    */   @RequestMapping({"/res/jsonData.do"})
/* 127:    */   public String dataPageByJosn(String path, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 128:    */   {
/* 129:132 */     Site site = ContextTools.getSite(request);
/* 130:133 */     String root = site.getResSolutionPath();
/* 131:134 */     log.debug("list Res root: {}", root);
/* 132:135 */     if (StringUtils.isBlank(path)) {
/* 133:136 */       path = "";
/* 134:    */     }
/* 135:138 */     model.addAttribute("path", path);
/* 136:139 */     model.addAttribute("list", this.resourceService.listFile(root, path, false));
/* 137:140 */     response.setHeader("Cache-Control", "no-cache");
/* 138:141 */     response.setContentType("text/json;charset=UTF-8");
/* 139:142 */     return "sysMgr/resMgr/listdata";
/* 140:    */   }
/* 141:    */   
/* 142:    */   @RequiresPermissions({"admin:res:delete"})
/* 143:    */   @RequestMapping({"/res/o_ajax_delete.do"})
/* 144:    */   public void deleteGroup(String[] names, HttpServletRequest request, HttpServletResponse response)
/* 145:    */     throws JSONException
/* 146:    */   {
/* 147:149 */     JSONObject json = new JSONObject();
/* 148:150 */     Site site = ContextTools.getSite(request);
/* 149:151 */     String root = site.getResSolutionPath();
/* 150:152 */     this.resourceService.delete(root, names);
/* 151:153 */     json.put("success", true);
/* 152:154 */     json.put("status", 1);
/* 153:155 */     ResponseUtils.renderJson(response, json.toString());
/* 154:    */   }
/* 155:    */   
/* 156:    */   @RequiresPermissions({"admin:res:rename"})
/* 157:    */   @RequestMapping(value={"/res/o_rename.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 158:    */   public String renameSubmit(String path, String origName, String distName, HttpServletRequest request, ModelMap model)
/* 159:    */   {
/* 160:163 */     Site site = ContextTools.getSite(request);
/* 161:164 */     String root = site.getResSolutionPath();
/* 162:165 */     if (StringUtils.isBlank(path)) {
/* 163:166 */       path = "";
/* 164:    */     }
/* 165:168 */     String orig = root + path + "/" + origName;
/* 166:169 */     String dist = root + path + "/" + distName;
/* 167:170 */     this.resourceService.rename(orig, dist);
/* 168:171 */     log.info("name Resource from {} to {}", orig, dist);
/* 169:172 */     model.addAttribute("path", path);
/* 170:173 */     model.addAttribute("msg", "资源重命名成功!");
/* 171:174 */     return list(path, request, model);
/* 172:    */   }
/* 173:    */   
/* 174:    */   @RequiresPermissions({"admin:res:swfupload"})
/* 175:    */   @RequestMapping(value={"/res/o_swfupload.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 176:    */   public void swfUpload(String path, @RequestParam(value="resatt", required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 177:    */     throws IllegalStateException, IOException
/* 178:    */   {
/* 179:184 */     Site site = ContextTools.getSite(request);
/* 180:185 */     String root = site.getResSolutionPath();
/* 181:186 */     if (StringUtils.isBlank(path)) {
/* 182:187 */       path = "";
/* 183:    */     }
/* 184:189 */     this.resourceService.saveFile(root + path, file);
/* 185:190 */     log.info("file upload seccess: {}, size:{}.", 
/* 186:191 */       file.getOriginalFilename(), Long.valueOf(file.getSize()));
/* 187:192 */     ResponseUtils.renderText(response, "");
/* 188:    */   }
/* 189:    */   
/* 190:    */   @Autowired
/* 191:    */   public void setResourceService(ResourceService resourceService)
/* 192:    */   {
/* 193:201 */     this.resourceService = resourceService;
/* 194:    */   }
/* 195:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.action.ResourceAct
 * JD-Core Version:    0.7.0.1
 */