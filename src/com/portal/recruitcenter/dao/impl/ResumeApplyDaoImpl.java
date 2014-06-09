/*   1:    */ package com.portal.recruitcenter.dao.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.recruitcenter.dao.ResumeApplyDao;
/*   6:    */ import com.portal.recruitcenter.entity.ResumeApply;
/*   7:    */ import org.hibernate.Criteria;
/*   8:    */ import org.hibernate.Query;
/*   9:    */ import org.hibernate.Session;
/*  10:    */ import org.hibernate.criterion.Criterion;
/*  11:    */ import org.springframework.stereotype.Repository;
/*  12:    */ 
/*  13:    */ @Repository
/*  14:    */ public class ResumeApplyDaoImpl
/*  15:    */   extends HibernateBaseDao<ResumeApply, Integer>
/*  16:    */   implements ResumeApplyDao
/*  17:    */ {
/*  18:    */   public Pagination getPage(int pageNo, int pageSize)
/*  19:    */   {
/*  20: 15 */     Criteria crit = createCriteria(new Criterion[0]);
/*  21: 16 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/*  22: 17 */     return page;
/*  23:    */   }
/*  24:    */   
/*  25:    */   public Pagination getPageByTag(Integer personalId, Integer companyId, int pageNo, int pageSize)
/*  26:    */   {
/*  27: 36 */     return null;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public ResumeApply getApply(Integer resumeId, Integer jobId)
/*  31:    */   {
/*  32: 45 */     return null;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public int deleteByCompanyId(Integer companyId)
/*  36:    */   {
/*  37: 49 */     String hql = "delete from ResumeApply bean where bean.job.id in (select j.id from JobPost j where j.company.id=:companyId)";
/*  38:    */     
/*  39: 51 */     return getSession().createQuery(hql)
/*  40: 52 */       .setParameter("companyId", companyId).executeUpdate();
/*  41:    */   }
/*  42:    */   
/*  43:    */   public int deleteByJobId(Integer jobId)
/*  44:    */   {
/*  45: 56 */     String hql = "delete from ResumeApply bean where bean.job.id=:jobId";
/*  46: 57 */     return getSession().createQuery(hql).setParameter("jobId", jobId)
/*  47: 58 */       .executeUpdate();
/*  48:    */   }
/*  49:    */   
/*  50:    */   public int deleteByResumelId(Integer resumeId)
/*  51:    */   {
/*  52: 62 */     String hql = "delete from ResumeApply bean where bean.resume.id=:resumeId";
/*  53: 63 */     return getSession().createQuery(hql).setParameter("resumeId", resumeId)
/*  54: 64 */       .executeUpdate();
/*  55:    */   }
/*  56:    */   
/*  57:    */   public int deleteByPersonalId(Integer personalId)
/*  58:    */   {
/*  59: 68 */     String hql = "delete from ResumeApply bean where bean.resume.id in (select r.id from Resume r where r.personal.id=:personalId)";
/*  60:    */     
/*  61: 70 */     return getSession().createQuery(hql)
/*  62: 71 */       .setParameter("personalId", personalId).executeUpdate();
/*  63:    */   }
/*  64:    */   
/*  65:    */   public int deleteByMetierId(Integer metierId)
/*  66:    */   {
/*  67: 75 */     String hql = "delete from ResumeApply bean where bean.job.id in (select j.id from JobPost j where j.metier.id=:metierId)";
/*  68:    */     
/*  69: 77 */     return getSession().createQuery(hql).setParameter("metierId", metierId)
/*  70: 78 */       .executeUpdate();
/*  71:    */   }
/*  72:    */   
/*  73:    */   public ResumeApply findById(Integer id)
/*  74:    */   {
/*  75: 82 */     ResumeApply entity = (ResumeApply)get(id);
/*  76: 83 */     return entity;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public ResumeApply save(ResumeApply bean)
/*  80:    */   {
/*  81: 87 */     getSession().save(bean);
/*  82: 88 */     return bean;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public ResumeApply deleteById(Integer id)
/*  86:    */   {
/*  87: 92 */     ResumeApply entity = (ResumeApply)super.get(id);
/*  88: 93 */     if (entity != null) {
/*  89: 94 */       getSession().delete(entity);
/*  90:    */     }
/*  91: 96 */     return entity;
/*  92:    */   }
/*  93:    */   
/*  94:    */   protected Class<ResumeApply> getEntityClass()
/*  95:    */   {
/*  96:101 */     return ResumeApply.class;
/*  97:    */   }
/*  98:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.impl.ResumeApplyDaoImpl
 * JD-Core Version:    0.7.0.1
 */