/*   1:    */ package com.portal.doccenter.dao.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.doccenter.dao.ChannelDao;
/*   6:    */ import com.portal.doccenter.entity.Channel;
/*   7:    */ import java.util.List;
/*   8:    */ import org.apache.commons.lang.StringUtils;
/*   9:    */ import org.hibernate.Criteria;
/*  10:    */ import org.hibernate.Session;
/*  11:    */ import org.hibernate.criterion.Criterion;
/*  12:    */ import org.hibernate.criterion.Order;
/*  13:    */ import org.hibernate.criterion.Restrictions;
/*  14:    */ import org.hibernate.type.IntegerType;
/*  15:    */ import org.springframework.stereotype.Repository;
/*  16:    */ 
/*  17:    */ @Repository
/*  18:    */ public class ChannelDaoImpl
/*  19:    */   extends HibernateBaseDao<Channel, Integer>
/*  20:    */   implements ChannelDao
/*  21:    */ {
/*  22:    */   public List<Channel> getChannelListByTag(Integer siteId, Integer parentId, boolean alone, boolean show, boolean cacheable, int count)
/*  23:    */   {
/*  24: 23 */     Criteria crit = getChannelByTag(siteId, parentId, alone, show);
/*  25: 24 */     return findByCriteria(crit);
/*  26:    */   }
/*  27:    */   
/*  28:    */   public Pagination getChannelPageByTag(Integer siteId, Integer parentId, boolean alone, boolean show, boolean cacheable, int pageNo, int pageSize)
/*  29:    */   {
/*  30: 30 */     Criteria crit = getChannelByTag(siteId, parentId, alone, show);
/*  31: 31 */     crit.setCacheable(cacheable);
/*  32: 32 */     return findByCriteria(crit, pageNo, pageSize);
/*  33:    */   }
/*  34:    */   
/*  35:    */   private Criteria getChannelByTag(Integer siteId, Integer parentId, boolean alone, boolean show)
/*  36:    */   {
/*  37: 37 */     Criteria crit = createCriteria(new Criterion[0]);
/*  38: 38 */     if (parentId != null)
/*  39:    */     {
/*  40: 39 */       crit.add(Restrictions.eq("parent.id", parentId));
/*  41:    */     }
/*  42:    */     else
/*  43:    */     {
/*  44: 41 */       crit.add(Restrictions.eq("site.id", siteId));
/*  45: 42 */       crit.add(Restrictions.isNull("parent.id"));
/*  46:    */     }
/*  47: 44 */     if (show) {
/*  48: 45 */       crit.add(Restrictions.eq("show", Boolean.valueOf(true)));
/*  49:    */     }
/*  50: 47 */     if (!alone) {
/*  51: 48 */       crit.add(Restrictions.eq("alone", Boolean.valueOf(false)));
/*  52:    */     }
/*  53: 50 */     crit.addOrder(Order.asc("priority"));
/*  54: 51 */     crit.addOrder(Order.asc("id"));
/*  55: 52 */     return crit;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public List<Channel> getChannelByAdmin(Integer siteId, Integer departId, Integer parentId, String key, String sortname, String sortorder, boolean alone)
/*  59:    */   {
/*  60: 58 */     Criteria crit = createCriteria(new Criterion[0]);
/*  61: 59 */     if (departId != null)
/*  62:    */     {
/*  63: 60 */       crit.createAlias("departs", "depart");
/*  64: 61 */       crit.add(Restrictions.eq("depart.id", departId));
/*  65:    */     }
/*  66:    */     else
/*  67:    */     {
/*  68: 63 */       crit.add(Restrictions.eq("site.id", siteId));
/*  69:    */     }
/*  70: 65 */     if (parentId != null) {
/*  71: 66 */       crit.add(Restrictions.eq("parent.id", parentId));
/*  72:    */     } else {
/*  73: 68 */       crit.add(Restrictions.isNull("parent.id"));
/*  74:    */     }
/*  75: 70 */     if (!StringUtils.isBlank(key)) {
/*  76: 71 */       crit.add(Restrictions.or(
/*  77: 72 */         Restrictions.like("name", "%" + key + "%"), 
/*  78: 73 */         Restrictions.like("path", "%" + key + "%")));
/*  79:    */     }
/*  80: 75 */     if (!alone) {
/*  81: 76 */       crit.add(Restrictions.eq("alone", Boolean.valueOf(false)));
/*  82:    */     }
/*  83: 78 */     if (!StringUtils.isBlank(sortname))
/*  84:    */     {
/*  85: 79 */       if ("asc".equals(sortorder)) {
/*  86: 80 */         crit.addOrder(Order.asc(sortname));
/*  87:    */       } else {
/*  88: 82 */         crit.addOrder(Order.desc(sortname));
/*  89:    */       }
/*  90:    */     }
/*  91:    */     else
/*  92:    */     {
/*  93: 85 */       crit.addOrder(Order.asc("priority"));
/*  94: 86 */       crit.addOrder(Order.asc("id"));
/*  95:    */     }
/*  96: 88 */     return findByCriteria(crit);
/*  97:    */   }
/*  98:    */   
/*  99:    */   public List<Channel> getChannelByModel(Integer parentId, Integer modelId, Integer departId, Integer siteId)
/* 100:    */   {
/* 101: 93 */     StringBuffer sb = new StringBuffer("{alias}.channel_id in ");
/* 102: 94 */     sb.append("(select e.chnl_id from tq_chnl_tpl_selection e where e.model_id=?)");
/* 103: 95 */     Criteria crit = createCriteria(new Criterion[0]);
/* 104: 96 */     crit.add(Restrictions.sqlRestriction(sb.toString(), modelId, 
/* 105: 97 */       IntegerType.INSTANCE));
/* 106: 98 */     if (departId != null)
/* 107:    */     {
/* 108: 99 */       crit.createAlias("departs", "depart");
/* 109:100 */       crit.add(Restrictions.eq("depart.id", departId));
/* 110:    */     }
/* 111:102 */     crit.add(Restrictions.eq("site.id", siteId));
/* 112:103 */     if (parentId != null) {
/* 113:104 */       crit.add(Restrictions.eq("parent.id", parentId));
/* 114:    */     } else {
/* 115:106 */       crit.add(Restrictions.isNull("parent.id"));
/* 116:    */     }
/* 117:108 */     crit.add(Restrictions.eq("alone", Boolean.valueOf(false)));
/* 118:109 */     crit.addOrder(Order.asc("priority"));
/* 119:110 */     crit.addOrder(Order.asc("id"));
/* 120:111 */     return findByCriteria(crit);
/* 121:    */   }
/* 122:    */   
/* 123:    */   public Channel findByNumber(String number)
/* 124:    */   {
/* 125:115 */     Criteria crit = createCriteria(new Criterion[0]);
/* 126:116 */     crit.add(Restrictions.eq("chnlNumber", number));
/* 127:117 */     return (Channel)findUnique(crit);
/* 128:    */   }
/* 129:    */   
/* 130:    */   public Channel findById(Integer id)
/* 131:    */   {
/* 132:121 */     Channel entity = (Channel)get(id);
/* 133:122 */     return entity;
/* 134:    */   }
/* 135:    */   
/* 136:    */   public Channel findByPath(String path, Integer siteId, boolean cacheable)
/* 137:    */   {
/* 138:126 */     Criteria crit = createCriteria(new Criterion[0]);
/* 139:127 */     crit.add(Restrictions.eq("path", path));
/* 140:128 */     crit.add(Restrictions.eq("site.id", siteId));
/* 141:129 */     crit.setCacheable(cacheable);
/* 142:130 */     return (Channel)findUnique(crit);
/* 143:    */   }
/* 144:    */   
/* 145:    */   public Channel save(Channel bean)
/* 146:    */   {
/* 147:134 */     getSession().save(bean);
/* 148:135 */     return bean;
/* 149:    */   }
/* 150:    */   
/* 151:    */   public Channel deleteById(Integer id)
/* 152:    */   {
/* 153:139 */     Channel entity = (Channel)super.get(id);
/* 154:140 */     if (entity != null) {
/* 155:141 */       getSession().delete(entity);
/* 156:    */     }
/* 157:143 */     return entity;
/* 158:    */   }
/* 159:    */   
/* 160:    */   protected Class<Channel> getEntityClass()
/* 161:    */   {
/* 162:148 */     return Channel.class;
/* 163:    */   }
/* 164:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.impl.ChannelDaoImpl
 * JD-Core Version:    0.7.0.1
 */