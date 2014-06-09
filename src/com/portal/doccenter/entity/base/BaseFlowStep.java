/*   1:    */ package com.portal.doccenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.entity.FlowStep;
/*   4:    */ import com.portal.doccenter.entity.WorkFlow;
/*   5:    */ import com.portal.usermgr.entity.Role;
/*   6:    */ import java.io.Serializable;
/*   7:    */ 
/*   8:    */ public abstract class BaseFlowStep
/*   9:    */   implements Serializable
/*  10:    */ {
/*  11: 15 */   public static String REF = "FlowStep";
/*  12: 16 */   public static String PROP_FLOW = "flow";
/*  13: 17 */   public static String PROP_STEP = "step";
/*  14: 18 */   public static String PROP_ID = "id";
/*  15:    */   
/*  16:    */   public BaseFlowStep()
/*  17:    */   {
/*  18: 22 */     initialize();
/*  19:    */   }
/*  20:    */   
/*  21:    */   public BaseFlowStep(Integer id)
/*  22:    */   {
/*  23: 29 */     setId(id);
/*  24: 30 */     initialize();
/*  25:    */   }
/*  26:    */   
/*  27:    */   public BaseFlowStep(Integer id, WorkFlow flow, Integer step)
/*  28:    */   {
/*  29: 39 */     setId(id);
/*  30: 40 */     setFlow(flow);
/*  31: 41 */     setStep(step);
/*  32: 42 */     initialize();
/*  33:    */   }
/*  34:    */   
/*  35: 48 */   private int hashCode = -2147483648;
/*  36:    */   private Integer id;
/*  37:    */   private Integer step;
/*  38:    */   private WorkFlow flow;
/*  39:    */   private Role role;
/*  40:    */   
/*  41:    */   protected void initialize() {}
/*  42:    */   
/*  43:    */   public Integer getId()
/*  44:    */   {
/*  45: 66 */     return this.id;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public void setId(Integer id)
/*  49:    */   {
/*  50: 76 */     this.id = id;
/*  51: 77 */     this.hashCode = -2147483648;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public Integer getStep()
/*  55:    */   {
/*  56: 84 */     return this.step;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void setStep(Integer step)
/*  60:    */   {
/*  61: 94 */     this.step = step;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public WorkFlow getFlow()
/*  65:    */   {
/*  66:101 */     return this.flow;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setFlow(WorkFlow flow)
/*  70:    */   {
/*  71:111 */     this.flow = flow;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public Role getRole()
/*  75:    */   {
/*  76:115 */     return this.role;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setRole(Role role)
/*  80:    */   {
/*  81:119 */     this.role = role;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public boolean equals(Object obj)
/*  85:    */   {
/*  86:123 */     if (obj == null) {
/*  87:124 */       return false;
/*  88:    */     }
/*  89:125 */     if (!(obj instanceof FlowStep)) {
/*  90:126 */       return false;
/*  91:    */     }
/*  92:128 */     FlowStep flowStep = (FlowStep)obj;
/*  93:129 */     if ((getId() == null) || (flowStep.getId() == null)) {
/*  94:130 */       return false;
/*  95:    */     }
/*  96:132 */     return getId().equals(flowStep.getId());
/*  97:    */   }
/*  98:    */   
/*  99:    */   public int hashCode()
/* 100:    */   {
/* 101:137 */     if (-2147483648 == this.hashCode)
/* 102:    */     {
/* 103:138 */       if (getId() == null) {
/* 104:139 */         return super.hashCode();
/* 105:    */       }
/* 106:141 */       String hashStr = getClass().getName() + ":" + 
/* 107:142 */         getId().hashCode();
/* 108:143 */       this.hashCode = hashStr.hashCode();
/* 109:    */     }
/* 110:146 */     return this.hashCode;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public String toString()
/* 114:    */   {
/* 115:150 */     return super.toString();
/* 116:    */   }
/* 117:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.base.BaseFlowStep
 * JD-Core Version:    0.7.0.1
 */