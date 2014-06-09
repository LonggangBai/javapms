/*  1:   */ package com.portal.datacenter.docdata.action.fnt;
/*  2:   */ 
/*  3:   */ import com.portal.datacenter.docdata.service.ProgramDownloadService;
/*  4:   */ import java.io.BufferedInputStream;
/*  5:   */ import java.io.File;
/*  6:   */ import java.io.FileInputStream;
/*  7:   */ import java.io.FileNotFoundException;
/*  8:   */ import java.io.IOException;
/*  9:   */ import java.io.OutputStream;
/* 10:   */ import javax.servlet.ServletContext;
/* 11:   */ import javax.servlet.http.HttpServletRequest;
/* 12:   */ import javax.servlet.http.HttpServletResponse;
/* 13:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 14:   */ import org.springframework.stereotype.Controller;
/* 15:   */ import org.springframework.ui.ModelMap;
/* 16:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 17:   */ 
/* 18:   */ @Controller
/* 19:   */ public class ProgramDownloadAct
/* 20:   */ {
/* 21:   */   private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
/* 22:   */   @Autowired
/* 23:   */   private ServletContext ctx;
/* 24:   */   @Autowired
/* 25:   */   private ProgramDownloadService programDownloadService;
/* 26:   */   
/* 27:   */   @RequestMapping(value={"/pgdowload.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 28:   */   public void programDownload(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 29:   */   {
/* 30:37 */     File file = new File(this.ctx.getRealPath("/release/javapms-1.2-beta.zip"));
/* 31:38 */     response.setContentType("text/html; charset=UTF-8");
/* 32:39 */     response.setContentType("application/x-msdownload");
/* 33:40 */     response.setHeader("Content-Disposition", 
/* 34:41 */       "attachment;filename=javapms-1.2-beta.zip");
/* 35:42 */     response.setContentLength((int)file.length());
/* 36:43 */     this.programDownloadService.updateCount();
/* 37:   */     try
/* 38:   */     {
/* 39:46 */       FileInputStream fis = new FileInputStream(file);
/* 40:47 */       BufferedInputStream buff = new BufferedInputStream(fis);
/* 41:48 */       byte[] b = new byte[1024];
/* 42:49 */       long k = 0L;
/* 43:   */       try
/* 44:   */       {
/* 45:52 */         OutputStream myout = response.getOutputStream();
/* 46:53 */         while (k < file.length())
/* 47:   */         {
/* 48:54 */           int j = buff.read(b, 0, 1024);
/* 49:55 */           k += j;
/* 50:56 */           myout.write(b, 0, j);
/* 51:   */         }
/* 52:58 */         myout.flush();
/* 53:   */       }
/* 54:   */       catch (IOException e)
/* 55:   */       {
/* 56:60 */         e.printStackTrace();
/* 57:   */       }
/* 58:   */       return;
/* 59:   */     }
/* 60:   */     catch (FileNotFoundException e)
/* 61:   */     {
/* 62:63 */       e.printStackTrace();
/* 63:   */     }
/* 64:   */   }
/* 65:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.docdata.action.fnt.ProgramDownloadAct
 * JD-Core Version:    0.7.0.1
 */