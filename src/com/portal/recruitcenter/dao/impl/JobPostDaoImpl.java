/*   1:    */ package com.portal.recruitcenter.dao.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.recruitcenter.dao.JobPostDao;
/*   6:    */ import com.portal.recruitcenter.entity.JobPost;
/*   7:    */ import java.util.Iterator;
/*   8:    */ import org.hibernate.Query;
/*   9:    */ import org.hibernate.Session;
/*  10:    */ import org.springframework.stereotype.Repository;
/*  11:    */ 
/*  12:    */ @Repository
/*  13:    */ public class JobPostDaoImpl
/*  14:    */   extends HibernateBaseDao<JobPost, Integer>
/*  15:    */   implements JobPostDao
/*  16:    */ {
/*  17:    */   public Pagination getPage(String key, Integer companyId, Integer metierId, Integer industryId, Byte wage, Byte edu, Integer natureId, Byte scale, Byte gender, Byte workExp, Integer minAge, Integer maxAge, String jobType, Boolean show, int pageNo, int pageSize)
/*  18:    */   {
/*  19:101 */     return null;
/*  20:    */   }
/*  21:    */   
/*  22:    */   public Pagination getPageByTag(String key, Integer companyId, Integer metierId, Integer industryId, Byte wage, Byte edu, Integer natureId, Byte scale, Byte gender, Byte workExp, Integer minAge, Integer maxAge, String jobType, Boolean checkTime, Boolean show, int pageNo, int pageSize)
/*  23:    */   {
/*  24:196 */     return null;
/*  25:    */   }
/*  26:    */   
/*  27:    */   public int countByCompanyId(Integer companyId)
/*  28:    */   {
/*  29:200 */     String hql = "select count(*) from JobPost bean where bean.company.id=:companyId";
/*  30:    */     
/*  31:202 */     Query query = getSession().createQuery(hql);
/*  32:203 */     query.setParameter("companyId", companyId);
/*  33:204 */     return ((Number)query.iterate().next()).intValue();
/*  34:    */   }
/*  35:    */   
/*  36:    */   public int deleteByCompanyId(Integer companyId)
/*  37:    */   {
/*  38:208 */     String hql = "delete from JobPost bean where bean.company.id=:companyId";
/*  39:209 */     return getSession().createQuery(hql)
/*  40:210 */       .setParameter("companyId", companyId).executeUpdate();
/*  41:    */   }
/*  42:    */   
/*  43:    */   public int deleteByMetierId(Integer metierId)
/*  44:    */   {
/*  45:214 */     String hql = "delete from JobPost bean where bean.metier.id=:metierId";
/*  46:215 */     return getSession().createQuery(hql).setParameter("metierId", metierId)
/*  47:216 */       .executeUpdate();
/*  48:    */   }
/*  49:    */   
/*  50:    */   public JobPost findById(Integer id)
/*  51:    */   {
/*  52:220 */     JobPost entity = (JobPost)get(id);
/*  53:221 */     return entity;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public JobPost save(JobPost bean)
/*  57:    */   {
/*  58:225 */     getSession().save(bean);
/*  59:226 */     return bean;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public JobPost deleteById(Integer id)
/*  63:    */   {
/*  64:230 */     JobPost entity = (JobPost)super.get(id);
/*  65:231 */     if (entity != null) {
/*  66:232 */       getSession().delete(entity);
/*  67:    */     }
/*  68:234 */     return entity;
/*  69:    */   }
/*  70:    */   
/*  71:    */   protected Class<JobPost> getEntityClass()
/*  72:    */   {
/*  73:239 */     return JobPost.class;
/*  74:    */   }
/*  75:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.impl.JobPostDaoImpl
 * JD-Core Version:    0.7.0.1
 */