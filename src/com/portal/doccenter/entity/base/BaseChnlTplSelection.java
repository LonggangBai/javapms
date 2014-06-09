/*  1:   */ package com.portal.doccenter.entity.base;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.entity.Channel;
/*  4:   */ import com.portal.doccenter.entity.ChnlTplSelection;
/*  5:   */ import com.portal.doccenter.entity.Model;
/*  6:   */ import java.io.Serializable;
/*  7:   */ 
/*  8:   */ public abstract class BaseChnlTplSelection
/*  9:   */   implements Serializable
/* 10:   */ {
/* 11:15 */   public static String REF = "ChnlTplSelection";
/* 12:16 */   public static String PROP_TPL_DOC = "tplDoc";
/* 13:   */   
/* 14:   */   public BaseChnlTplSelection()
/* 15:   */   {
/* 16:20 */     initialize();
/* 17:   */   }
/* 18:   */   
/* 19:26 */   private int hashCode = -2147483648;
/* 20:   */   private String tplDoc;
/* 21:   */   private Model model;
/* 22:   */   
/* 23:   */   protected void initialize() {}
/* 24:   */   
/* 25:   */   public String getTplDoc()
/* 26:   */   {
/* 27:37 */     return this.tplDoc;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public void setTplDoc(String tplDoc)
/* 31:   */   {
/* 32:47 */     this.tplDoc = tplDoc;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public Model getModel()
/* 36:   */   {
/* 37:51 */     return this.model;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public void setModel(Model model)
/* 41:   */   {
/* 42:55 */     this.model = model;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public boolean equals(Object obj)
/* 46:   */   {
/* 47:59 */     if (obj == null) {
/* 48:60 */       return false;
/* 49:   */     }
/* 50:61 */     if (!(obj instanceof Channel)) {
/* 51:62 */       return false;
/* 52:   */     }
/* 53:64 */     ChnlTplSelection t = (ChnlTplSelection)obj;
/* 54:65 */     if ((getModel().getId() == null) || (t.getModelId() == null)) {
/* 55:66 */       return false;
/* 56:   */     }
/* 57:68 */     return getModel().getId().equals(t.getModelId());
/* 58:   */   }
/* 59:   */   
/* 60:   */   public int hashCode()
/* 61:   */   {
/* 62:73 */     if (-2147483648 == this.hashCode)
/* 63:   */     {
/* 64:74 */       if (getModel().getId() == null) {
/* 65:75 */         return super.hashCode();
/* 66:   */       }
/* 67:77 */       String hashStr = getClass().getName() + ":" + 
/* 68:78 */         getModel().getId().hashCode();
/* 69:79 */       this.hashCode = hashStr.hashCode();
/* 70:   */     }
/* 71:82 */     return this.hashCode;
/* 72:   */   }
/* 73:   */   
/* 74:   */   public String toString()
/* 75:   */   {
/* 76:86 */     return super.toString();
/* 77:   */   }
/* 78:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.base.BaseChnlTplSelection
 * JD-Core Version:    0.7.0.1
 */