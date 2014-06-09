/*   1:    */ package com.portal.recruitcenter.dao.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.recruitcenter.dao.ResumeDao;
/*   6:    */ import com.portal.recruitcenter.entity.Resume;
/*   7:    */ import java.util.List;
/*   8:    */ import org.hibernate.Criteria;
/*   9:    */ import org.hibernate.Query;
/*  10:    */ import org.hibernate.Session;
/*  11:    */ import org.hibernate.criterion.Criterion;
/*  12:    */ import org.hibernate.criterion.Restrictions;
/*  13:    */ import org.springframework.stereotype.Repository;
/*  14:    */ 
/*  15:    */ @Repository
/*  16:    */ public class ResumeDaoImpl
/*  17:    */   extends HibernateBaseDao<Resume, Integer>
/*  18:    */   implements ResumeDao
/*  19:    */ {
/*  20:    */   public Pagination getPage(Integer infoId, int pageNo, int pageSize)
/*  21:    */   {
/*  22: 18 */     Criteria crit = createCriteria(new Criterion[0]);
/*  23: 19 */     crit.add(Restrictions.eq("personal.id", infoId));
/*  24: 20 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/*  25: 21 */     return page;
/*  26:    */   }
/*  27:    */   
/*  28:    */   public Pagination getPageByTag(String key, Integer personalId, Integer metierId, Integer industryId, Integer specialId, Byte wage, Byte edu, Byte minwork, Byte maxwork, Boolean gender, Boolean show, int pageNo, int pageSize)
/*  29:    */   {
/*  30: 79 */     return null;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public List<Resume> getList(Integer personalId)
/*  34:    */   {
/*  35: 85 */     return null;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public Resume getResumeByDef(Integer personalId)
/*  39:    */   {
/*  40: 91 */     return null;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public Resume getResumeByName(Integer personalId)
/*  44:    */   {
/*  45: 97 */     return null;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public int deleteByPersonalId(Integer personalId)
/*  49:    */   {
/*  50:101 */     String hql = "delete from Resume bean where bean.personal.id=:personalId";
/*  51:102 */     return getSession().createQuery(hql)
/*  52:103 */       .setParameter("personalId", personalId).executeUpdate();
/*  53:    */   }
/*  54:    */   
/*  55:    */   public Resume findById(Integer id)
/*  56:    */   {
/*  57:107 */     Resume entity = (Resume)get(id);
/*  58:108 */     return entity;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public Resume save(Resume bean)
/*  62:    */   {
/*  63:112 */     getSession().save(bean);
/*  64:113 */     return bean;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public Resume deleteById(Integer id)
/*  68:    */   {
/*  69:117 */     Resume entity = (Resume)super.get(id);
/*  70:118 */     if (entity != null) {
/*  71:119 */       getSession().delete(entity);
/*  72:    */     }
/*  73:121 */     return entity;
/*  74:    */   }
/*  75:    */   
/*  76:    */   protected Class<Resume> getEntityClass()
/*  77:    */   {
/*  78:126 */     return Resume.class;
/*  79:    */   }
/*  80:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.impl.ResumeDaoImpl
 * JD-Core Version:    0.7.0.1
 */