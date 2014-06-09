/*   1:    */ package com.portal.extrafunc.entity.base;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ 
/*   5:    */ public abstract class BaseSurveyItem
/*   6:    */   implements Serializable
/*   7:    */ {
/*   8: 17 */   public static String REF = "SurveyItem";
/*   9: 18 */   public static String PROP_NAME = "name";
/*  10: 19 */   public static String PROP_VOTES = "votes";
/*  11: 20 */   public static String PROP_PRIORITY = "priority";
/*  12:    */   private String name;
/*  13:    */   private Integer votes;
/*  14:    */   private Integer priority;
/*  15:    */   
/*  16:    */   public BaseSurveyItem()
/*  17:    */   {
/*  18: 25 */     initialize();
/*  19:    */   }
/*  20:    */   
/*  21:    */   public BaseSurveyItem(String name, Integer votes, Integer priority)
/*  22:    */   {
/*  23: 36 */     setName(name);
/*  24: 37 */     setVotes(votes);
/*  25: 38 */     setPriority(priority);
/*  26: 39 */     initialize();
/*  27:    */   }
/*  28:    */   
/*  29:    */   protected void initialize() {}
/*  30:    */   
/*  31:    */   public String getName()
/*  32:    */   {
/*  33: 60 */     return this.name;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public void setName(String name)
/*  37:    */   {
/*  38: 68 */     this.name = name;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public Integer getVotes()
/*  42:    */   {
/*  43: 77 */     return this.votes;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public void setVotes(Integer votes)
/*  47:    */   {
/*  48: 85 */     this.votes = votes;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public Integer getPriority()
/*  52:    */   {
/*  53: 94 */     return this.priority;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public void setPriority(Integer priority)
/*  57:    */   {
/*  58:102 */     this.priority = priority;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public String toString()
/*  62:    */   {
/*  63:112 */     return super.toString();
/*  64:    */   }
/*  65:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.base.BaseSurveyItem
 * JD-Core Version:    0.7.0.1
 */