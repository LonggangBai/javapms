/*   1:    */ package com.portal.recruitcenter.dao.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.recruitcenter.dao.CompanyInfoDao;
/*   6:    */ import com.portal.recruitcenter.entity.CompanyInfo;
/*   7:    */ import java.util.Date;
/*   8:    */ import org.hibernate.Criteria;
/*   9:    */ import org.hibernate.Session;
/*  10:    */ import org.hibernate.criterion.Criterion;
/*  11:    */ import org.springframework.stereotype.Repository;
/*  12:    */ 
/*  13:    */ @Repository
/*  14:    */ public class CompanyInfoDaoImpl
/*  15:    */   extends HibernateBaseDao<CompanyInfo, Integer>
/*  16:    */   implements CompanyInfoDao
/*  17:    */ {
/*  18:    */   public Pagination getPage(int pageNo, int pageSize)
/*  19:    */   {
/*  20: 17 */     Criteria crit = createCriteria(new Criterion[0]);
/*  21: 18 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/*  22: 19 */     return page;
/*  23:    */   }
/*  24:    */   
/*  25:    */   public Pagination getPageByTag(String key, Integer industryId, Integer natureId, Boolean havejob, Byte workexp, Integer worktype, Boolean commend, Boolean vip, int pageNo, int pageSize)
/*  26:    */   {
/*  27: 67 */     return null;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public Pagination getPageByApply(String key, Integer natureId, Integer industryId, Date startTime, Date endTime, int pageNo, int pageSize)
/*  31:    */   {
/*  32:103 */     return null;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public Pagination getPageBySelect(String key, Integer natureId, Integer industryId, Date startTime, Date endTime, int pageNo, int pageSize)
/*  36:    */   {
/*  37:140 */     return null;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public CompanyInfo findById(Integer id)
/*  41:    */   {
/*  42:144 */     CompanyInfo entity = (CompanyInfo)get(id);
/*  43:145 */     return entity;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public CompanyInfo save(CompanyInfo bean)
/*  47:    */   {
/*  48:149 */     getSession().save(bean);
/*  49:150 */     return bean;
/*  50:    */   }
/*  51:    */   
/*  52:    */   public CompanyInfo deleteById(Integer id)
/*  53:    */   {
/*  54:154 */     CompanyInfo entity = (CompanyInfo)super.get(id);
/*  55:155 */     if (entity != null) {
/*  56:156 */       getSession().delete(entity);
/*  57:    */     }
/*  58:158 */     return entity;
/*  59:    */   }
/*  60:    */   
/*  61:    */   protected Class<CompanyInfo> getEntityClass()
/*  62:    */   {
/*  63:163 */     return CompanyInfo.class;
/*  64:    */   }
/*  65:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.impl.CompanyInfoDaoImpl
 * JD-Core Version:    0.7.0.1
 */