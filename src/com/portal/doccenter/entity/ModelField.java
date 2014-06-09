/*  1:   */ package com.portal.doccenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.entity.base.BaseModelField;
/*  4:   */ import org.apache.commons.lang.StringUtils;
/*  5:   */ 
/*  6:   */ public class ModelField
/*  7:   */   extends BaseModelField
/*  8:   */ {
/*  9:   */   private static final long serialVersionUID = 1L;
/* 10:   */   
/* 11:   */   public void init()
/* 12:   */   {
/* 13:11 */     if (getSingle() == null) {
/* 14:12 */       setSingle(Boolean.valueOf(true));
/* 15:   */     }
/* 16:14 */     if (getEconomy() == null) {
/* 17:15 */       setEconomy(Boolean.valueOf(false));
/* 18:   */     }
/* 19:17 */     if (getShow() == null) {
/* 20:18 */       setShow(Boolean.valueOf(true));
/* 21:   */     }
/* 22:20 */     if (getRequired() == null) {
/* 23:21 */       setRequired(Boolean.valueOf(true));
/* 24:   */     }
/* 25:   */   }
/* 26:   */   
/* 27:   */   public String getDataTypeString()
/* 28:   */   {
/* 29:26 */     int dataType = getDataType().intValue();
/* 30:27 */     if (dataType == 1) {
/* 31:28 */       return "aaaaa";
/* 32:   */     }
/* 33:30 */     if (dataType == 2) {
/* 34:31 */       return "aaaaa";
/* 35:   */     }
/* 36:33 */     if (dataType == 3) {
/* 37:34 */       return "aaa";
/* 38:   */     }
/* 39:36 */     if (dataType == 4) {
/* 40:37 */       return "aaa";
/* 41:   */     }
/* 42:39 */     if (dataType == 5) {
/* 43:40 */       return "aa";
/* 44:   */     }
/* 45:42 */     if (dataType == 6) {
/* 46:43 */       return "aa";
/* 47:   */     }
/* 48:45 */     if (dataType == 7) {
/* 49:46 */       return "aaa";
/* 50:   */     }
/* 51:48 */     if (dataType == 8) {
/* 52:49 */       return "aaa";
/* 53:   */     }
/* 54:51 */     if (dataType == 9) {
/* 55:52 */       return "aa";
/* 56:   */     }
/* 57:54 */     return "aa";
/* 58:   */   }
/* 59:   */   
/* 60:   */   public void emptyToNull()
/* 61:   */   {
/* 62:59 */     if (StringUtils.isBlank(getSize())) {
/* 63:60 */       setSize(null);
/* 64:   */     }
/* 65:   */   }
/* 66:   */   
/* 67:   */   public ModelField() {}
/* 68:   */   
/* 69:   */   public ModelField(Integer id)
/* 70:   */   {
/* 71:73 */     super(id);
/* 72:   */   }
/* 73:   */   
/* 74:   */   public ModelField(Integer id, Model model, String name, String label, Integer dataType, Boolean single, Boolean economy, Boolean display)
/* 75:   */   {
/* 76:85 */     super(id, model, name, label, dataType, single, economy, display);
/* 77:   */   }
/* 78:   */ }



/* Location:           F:\jspaa\aaaaaa\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.doccenter.entity.ModelField

 * JD-Core Version:    0.7.0.1

 */