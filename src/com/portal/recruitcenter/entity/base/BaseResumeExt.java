/*   1:    */ package com.portal.recruitcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.recruitcenter.entity.Resume;
/*   4:    */ import com.portal.recruitcenter.entity.ResumeExt;
/*   5:    */ import java.io.Serializable;
/*   6:    */ 
/*   7:    */ public abstract class BaseResumeExt
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10: 17 */   public static String REF = "ResumeExt";
/*  11: 18 */   public static String PROP_SKILL_SPECIAL = "skillSpecial";
/*  12: 19 */   public static String PROP_RESUME = "resume";
/*  13: 20 */   public static String PROP_WORK_EXP = "workExp";
/*  14: 21 */   public static String PROP_EVALUATE = "evaluate";
/*  15: 22 */   public static String PROP_ID = "id";
/*  16:    */   
/*  17:    */   public BaseResumeExt()
/*  18:    */   {
/*  19: 27 */     initialize();
/*  20:    */   }
/*  21:    */   
/*  22:    */   public BaseResumeExt(Integer id)
/*  23:    */   {
/*  24: 34 */     setId(id);
/*  25: 35 */     initialize();
/*  26:    */   }
/*  27:    */   
/*  28: 42 */   private int hashCode = -2147483648;
/*  29:    */   private Integer id;
/*  30:    */   private String evaluate;
/*  31:    */   private String skillSpecial;
/*  32:    */   private String workExp;
/*  33:    */   private Resume resume;
/*  34:    */   
/*  35:    */   protected void initialize() {}
/*  36:    */   
/*  37:    */   public Integer getId()
/*  38:    */   {
/*  39: 64 */     return this.id;
/*  40:    */   }
/*  41:    */   
/*  42:    */   public void setId(Integer id)
/*  43:    */   {
/*  44: 72 */     this.id = id;
/*  45: 73 */     this.hashCode = -2147483648;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public String getEvaluate()
/*  49:    */   {
/*  50: 83 */     return this.evaluate;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public void setEvaluate(String evaluate)
/*  54:    */   {
/*  55: 91 */     this.evaluate = evaluate;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public String getSkillSpecial()
/*  59:    */   {
/*  60:100 */     return this.skillSpecial;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public void setSkillSpecial(String skillSpecial)
/*  64:    */   {
/*  65:108 */     this.skillSpecial = skillSpecial;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public String getWorkExp()
/*  69:    */   {
/*  70:117 */     return this.workExp;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public void setWorkExp(String workExp)
/*  74:    */   {
/*  75:125 */     this.workExp = workExp;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public Resume getResume()
/*  79:    */   {
/*  80:134 */     return this.resume;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public void setResume(Resume resume)
/*  84:    */   {
/*  85:142 */     this.resume = resume;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public boolean equals(Object obj)
/*  89:    */   {
/*  90:149 */     if (obj == null) {
/*  91:149 */       return false;
/*  92:    */     }
/*  93:150 */     if (!(obj instanceof ResumeExt)) {
/*  94:150 */       return false;
/*  95:    */     }
/*  96:152 */     ResumeExt resumeExt = (ResumeExt)obj;
/*  97:153 */     if ((getId() == null) || (resumeExt.getId() == null)) {
/*  98:153 */       return false;
/*  99:    */     }
/* 100:154 */     return getId().equals(resumeExt.getId());
/* 101:    */   }
/* 102:    */   
/* 103:    */   public int hashCode()
/* 104:    */   {
/* 105:159 */     if (-2147483648 == this.hashCode)
/* 106:    */     {
/* 107:160 */       if (getId() == null) {
/* 108:160 */         return super.hashCode();
/* 109:    */       }
/* 110:162 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 111:163 */       this.hashCode = hashStr.hashCode();
/* 112:    */     }
/* 113:166 */     return this.hashCode;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public String toString()
/* 117:    */   {
/* 118:171 */     return super.toString();
/* 119:    */   }
/* 120:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.base.BaseResumeExt
 * JD-Core Version:    0.7.0.1
 */