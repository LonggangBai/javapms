/*   1:    */ package com.portal.datacenter.docdata.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.datacenter.docdata.entity.ProgramDownload;
/*   4:    */ import java.io.Serializable;
/*   5:    */ 
/*   6:    */ public abstract class BaseProgramDownload
/*   7:    */   implements Serializable
/*   8:    */ {
/*   9: 17 */   public static String REF = "ProgramDownload";
/*  10: 18 */   public static String PROP_COUNT = "count";
/*  11: 19 */   public static String PROP_ID = "id";
/*  12:    */   
/*  13:    */   public BaseProgramDownload()
/*  14:    */   {
/*  15: 24 */     initialize();
/*  16:    */   }
/*  17:    */   
/*  18:    */   public BaseProgramDownload(Integer id)
/*  19:    */   {
/*  20: 31 */     setId(id);
/*  21: 32 */     initialize();
/*  22:    */   }
/*  23:    */   
/*  24:    */   public BaseProgramDownload(Integer id, Integer count)
/*  25:    */   {
/*  26: 42 */     setId(id);
/*  27: 43 */     setCount(count);
/*  28: 44 */     initialize();
/*  29:    */   }
/*  30:    */   
/*  31: 51 */   private int hashCode = -2147483648;
/*  32:    */   private Integer id;
/*  33:    */   private Integer count;
/*  34:    */   
/*  35:    */   protected void initialize() {}
/*  36:    */   
/*  37:    */   public Integer getId()
/*  38:    */   {
/*  39: 68 */     return this.id;
/*  40:    */   }
/*  41:    */   
/*  42:    */   public void setId(Integer id)
/*  43:    */   {
/*  44: 76 */     this.id = id;
/*  45: 77 */     this.hashCode = -2147483648;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public Integer getCount()
/*  49:    */   {
/*  50: 87 */     return this.count;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public void setCount(Integer count)
/*  54:    */   {
/*  55: 95 */     this.count = count;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public boolean equals(Object obj)
/*  59:    */   {
/*  60:102 */     if (obj == null) {
/*  61:102 */       return false;
/*  62:    */     }
/*  63:103 */     if (!(obj instanceof ProgramDownload)) {
/*  64:103 */       return false;
/*  65:    */     }
/*  66:105 */     ProgramDownload programDownload = (ProgramDownload)obj;
/*  67:106 */     if ((getId() == null) || (programDownload.getId() == null)) {
/*  68:106 */       return false;
/*  69:    */     }
/*  70:107 */     return getId().equals(programDownload.getId());
/*  71:    */   }
/*  72:    */   
/*  73:    */   public int hashCode()
/*  74:    */   {
/*  75:112 */     if (-2147483648 == this.hashCode)
/*  76:    */     {
/*  77:113 */       if (getId() == null) {
/*  78:113 */         return super.hashCode();
/*  79:    */       }
/*  80:115 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/*  81:116 */       this.hashCode = hashStr.hashCode();
/*  82:    */     }
/*  83:119 */     return this.hashCode;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public String toString()
/*  87:    */   {
/*  88:124 */     return super.toString();
/*  89:    */   }
/*  90:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.docdata.entity.base.BaseProgramDownload
 * JD-Core Version:    0.7.0.1
 */