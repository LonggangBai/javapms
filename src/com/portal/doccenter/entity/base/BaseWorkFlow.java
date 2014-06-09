/*   1:    */ package com.portal.doccenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.entity.FlowStep;
/*   4:    */ import com.portal.doccenter.entity.WorkFlow;
/*   5:    */ import com.portal.sysmgr.entity.Site;
/*   6:    */ import java.io.Serializable;
/*   7:    */ import java.util.Date;
/*   8:    */ import java.util.Set;
/*   9:    */ 
/*  10:    */ public abstract class BaseWorkFlow
/*  11:    */   implements Serializable
/*  12:    */ {
/*  13: 15 */   public static String REF = "WorkFlow";
/*  14: 16 */   public static String PROP_DEPART = "depart";
/*  15: 17 */   public static String PROP_NAME = "name";
/*  16: 18 */   public static String PROP_DESCRIPTION = "description";
/*  17: 19 */   public static String PROP_CREATE_TIME = "createTime";
/*  18: 20 */   public static String PROP_ID = "id";
/*  19:    */   
/*  20:    */   public BaseWorkFlow()
/*  21:    */   {
/*  22: 24 */     initialize();
/*  23:    */   }
/*  24:    */   
/*  25:    */   public BaseWorkFlow(Integer id)
/*  26:    */   {
/*  27: 31 */     setId(id);
/*  28: 32 */     initialize();
/*  29:    */   }
/*  30:    */   
/*  31:    */   public BaseWorkFlow(Integer id, Site site, String name, Date createTime)
/*  32:    */   {
/*  33: 42 */     setId(id);
/*  34: 43 */     setSite(site);
/*  35: 44 */     setName(name);
/*  36: 45 */     setCreateTime(createTime);
/*  37: 46 */     initialize();
/*  38:    */   }
/*  39:    */   
/*  40: 52 */   private int hashCode = -2147483648;
/*  41:    */   private Integer id;
/*  42:    */   private String name;
/*  43:    */   private String description;
/*  44:    */   private Integer stepCount;
/*  45:    */   private Date createTime;
/*  46:    */   private Site site;
/*  47:    */   private Set<FlowStep> flowSteps;
/*  48:    */   
/*  49:    */   protected void initialize() {}
/*  50:    */   
/*  51:    */   public Integer getId()
/*  52:    */   {
/*  53: 75 */     return this.id;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public void setId(Integer id)
/*  57:    */   {
/*  58: 85 */     this.id = id;
/*  59: 86 */     this.hashCode = -2147483648;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public String getName()
/*  63:    */   {
/*  64: 93 */     return this.name;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public void setName(String name)
/*  68:    */   {
/*  69:103 */     this.name = name;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public String getDescription()
/*  73:    */   {
/*  74:110 */     return this.description;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public void setDescription(String description)
/*  78:    */   {
/*  79:120 */     this.description = description;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public Integer getStepCount()
/*  83:    */   {
/*  84:124 */     return this.stepCount;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public void setStepCount(Integer stepCount)
/*  88:    */   {
/*  89:128 */     this.stepCount = stepCount;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public Date getCreateTime()
/*  93:    */   {
/*  94:135 */     return this.createTime;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public void setCreateTime(Date createTime)
/*  98:    */   {
/*  99:145 */     this.createTime = createTime;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public Site getSite()
/* 103:    */   {
/* 104:149 */     return this.site;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public void setSite(Site site)
/* 108:    */   {
/* 109:153 */     this.site = site;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public Set<FlowStep> getFlowSteps()
/* 113:    */   {
/* 114:160 */     return this.flowSteps;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public void setFlowSteps(Set<FlowStep> flowSteps)
/* 118:    */   {
/* 119:171 */     this.flowSteps = flowSteps;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public boolean equals(Object obj)
/* 123:    */   {
/* 124:175 */     if (obj == null) {
/* 125:176 */       return false;
/* 126:    */     }
/* 127:177 */     if (!(obj instanceof WorkFlow)) {
/* 128:178 */       return false;
/* 129:    */     }
/* 130:180 */     WorkFlow workFlow = (WorkFlow)obj;
/* 131:181 */     if ((getId() == null) || (workFlow.getId() == null)) {
/* 132:182 */       return false;
/* 133:    */     }
/* 134:184 */     return getId().equals(workFlow.getId());
/* 135:    */   }
/* 136:    */   
/* 137:    */   public int hashCode()
/* 138:    */   {
/* 139:189 */     if (-2147483648 == this.hashCode)
/* 140:    */     {
/* 141:190 */       if (getId() == null) {
/* 142:191 */         return super.hashCode();
/* 143:    */       }
/* 144:193 */       String hashStr = getClass().getName() + ":" + 
/* 145:194 */         getId().hashCode();
/* 146:195 */       this.hashCode = hashStr.hashCode();
/* 147:    */     }
/* 148:198 */     return this.hashCode;
/* 149:    */   }
/* 150:    */   
/* 151:    */   public String toString()
/* 152:    */   {
/* 153:202 */     return super.toString();
/* 154:    */   }
/* 155:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.base.BaseWorkFlow
 * JD-Core Version:    0.7.0.1
 */