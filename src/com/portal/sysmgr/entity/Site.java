/*   1:    */ package com.portal.sysmgr.entity;
/*   2:    */ 
/*   3:    */ import com.portal.sysmgr.entity.base.BaseSite;
/*   4:    */ import java.util.Collection;
/*   5:    */ import org.apache.commons.lang.StringUtils;
/*   6:    */ 
/*   7:    */ public class Site
/*   8:    */   extends BaseSite
/*   9:    */ {
/*  10:    */   private static final long serialVersionUID = 1L;
/*  11:    */   public static final String PROTOCOL = "http://";
/*  12:    */   
/*  13:    */   public String getUrl()
/*  14:    */   {
/*  15: 21 */     StringBuilder sb = new StringBuilder();
/*  16: 22 */     sb.append("http://");
/*  17: 23 */     sb.append(getDomain());
/*  18: 24 */     if ((getPort() != null) && (!getPort().equals(Integer.valueOf(80))))
/*  19:    */     {
/*  20: 25 */       sb.append(":");
/*  21: 26 */       sb.append(getPort());
/*  22:    */     }
/*  23: 28 */     if (getContextPath() != null) {
/*  24: 29 */       sb.append(getContextPath());
/*  25:    */     }
/*  26: 31 */     sb.append("/");
/*  27: 32 */     return sb.toString();
/*  28:    */   }
/*  29:    */   
/*  30:    */   public String getTplPath()
/*  31:    */   {
/*  32: 41 */     return "/WEB-INF/tpl/" + getPath();
/*  33:    */   }
/*  34:    */   
/*  35:    */   public String getSolutionPath()
/*  36:    */   {
/*  37: 50 */     return "/WEB-INF/tpl/" + getPath() + "/" + getTplStyle();
/*  38:    */   }
/*  39:    */   
/*  40:    */   public String getResPath()
/*  41:    */   {
/*  42: 59 */     return "/skin/" + getPath();
/*  43:    */   }
/*  44:    */   
/*  45:    */   public String getResSolutionPath()
/*  46:    */   {
/*  47: 68 */     return "/skin/" + getPath() + "/" + getTplStyle();
/*  48:    */   }
/*  49:    */   
/*  50:    */   public String getUploadPath()
/*  51:    */   {
/*  52: 77 */     return "/member/upload/" + getPath();
/*  53:    */   }
/*  54:    */   
/*  55:    */   public String getDefImg()
/*  56:    */   {
/*  57: 81 */     String skin = "/skin/" + getPath() + "/" + 
/*  58: 82 */       getTplStyle();
/*  59: 83 */     return skin + "/img/nophoto.gif";
/*  60:    */   }
/*  61:    */   
/*  62:    */   public static Integer[] fetchIds(Collection<Site> sites)
/*  63:    */   {
/*  64: 87 */     if (sites == null) {
/*  65: 88 */       return null;
/*  66:    */     }
/*  67: 90 */     Integer[] ids = new Integer[sites.size()];
/*  68: 91 */     int i = 0;
/*  69: 92 */     for (Site s : sites) {
/*  70: 93 */       ids[(i++)] = s.getId();
/*  71:    */     }
/*  72: 95 */     return ids;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void init()
/*  76:    */   {
/*  77: 99 */     if (StringUtils.isBlank(getTplStyle())) {
/*  78:100 */       setTplStyle("default");
/*  79:    */     }
/*  80:    */   }
/*  81:    */   
/*  82:    */   public Site() {}
/*  83:    */   
/*  84:    */   public Site(Integer id)
/*  85:    */   {
/*  86:113 */     super(id);
/*  87:    */   }
/*  88:    */   
/*  89:    */   public Site(Integer id, String domain, String path, String name, String tplStyle, Boolean recover)
/*  90:    */   {
/*  91:123 */     super(id, domain, path, name, tplStyle, recover);
/*  92:    */   }
/*  93:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.entity.Site
 * JD-Core Version:    0.7.0.1
 */