/*  1:   */ package com.portal.sysmgr.action;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.upload.FileRepository;
/*  4:   */ import com.javapms.basic.utils.ResponseUtils;
/*  5:   */ import com.portal.sysmgr.entity.Site;
/*  6:   */ import com.portal.sysmgr.utils.ContextTools;
/*  7:   */ import javax.servlet.http.HttpServletRequest;
/*  8:   */ import javax.servlet.http.HttpServletResponse;
/*  9:   */ import org.json.JSONException;
/* 10:   */ import org.json.JSONObject;
/* 11:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 12:   */ import org.springframework.stereotype.Controller;
/* 13:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 14:   */ import org.springframework.web.bind.annotation.RequestParam;
/* 15:   */ import org.springframework.web.multipart.MultipartFile;
/* 16:   */ 
/* 17:   */ @Controller
/* 18:   */ public class UploadFileAct
/* 19:   */ {
/* 20:   */   @Autowired
/* 21:   */   private FileRepository fileRepository;
/* 22:   */   
/* 23:   */   @RequestMapping({"/kind/o_upload_file.do"})
/* 24:   */   public void uploadImg(@RequestParam(value="imgFile", required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response)
/* 25:   */     throws JSONException
/* 26:   */   {
/* 27:27 */     JSONObject json = new JSONObject();
/* 28:28 */     Site site = ContextTools.getSite(request);
/* 29:29 */     String fileUrl = this.fileRepository.uploadFile(file, site.getUploadPath());
/* 30:30 */     json.put("error", 0);
/* 31:31 */     json.put("url", "../.." + fileUrl);
/* 32:32 */     ResponseUtils.renderText(response, json.toString());
/* 33:   */   }
/* 34:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.action.UploadFileAct
 * JD-Core Version:    0.7.0.1
 */