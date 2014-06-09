/*   1:    */ package com.portal.govcenter.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.govcenter.dao.MailboxDao;
/*   6:    */ import com.portal.govcenter.entity.Mailbox;
/*   7:    */ import com.portal.govcenter.entity.MailboxExt;
/*   8:    */ import com.portal.govcenter.service.MailboxExtService;
/*   9:    */ import com.portal.govcenter.service.MailboxService;
/*  10:    */ import com.portal.govcenter.service.MailboxTypeService;
/*  11:    */ import com.portal.sysmgr.entity.Site;
/*  12:    */ import com.portal.usermgr.entity.Admin;
/*  13:    */ import com.portal.usermgr.entity.Depart;
/*  14:    */ import com.portal.usermgr.entity.User;
/*  15:    */ import com.portal.usermgr.service.DepartService;
/*  16:    */ import java.sql.Timestamp;
/*  17:    */ import org.apache.commons.lang.StringUtils;
/*  18:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  19:    */ import org.springframework.stereotype.Service;
/*  20:    */ import org.springframework.transaction.annotation.Transactional;
/*  21:    */ 
/*  22:    */ @Service
/*  23:    */ @Transactional
/*  24:    */ public class MailboxServiceImpl
/*  25:    */   implements MailboxService
/*  26:    */ {
/*  27:    */   private MailboxDao dao;
/*  28:    */   private MailboxTypeService typeService;
/*  29:    */   private MailboxExtService extService;
/*  30:    */   private DepartService departService;
/*  31:    */   
/*  32:    */   @Transactional(readOnly=true)
/*  33:    */   public Pagination getPage(String name, Integer siteId, User user, Integer typeId, int pageNo, int pageSize)
/*  34:    */   {
/*  35: 29 */     Integer departId = null;
/*  36: 30 */     if (!user.getAdmin().haveAllManage(siteId))
/*  37:    */     {
/*  38: 31 */       Depart depart = user.getAdmin().getDepart(siteId);
/*  39: 32 */       if (depart != null) {
/*  40: 33 */         departId = depart.getId();
/*  41:    */       }
/*  42:    */     }
/*  43: 36 */     Pagination page = this.dao.getPage(name, siteId, departId, typeId, pageNo, 
/*  44: 37 */       pageSize);
/*  45: 38 */     return page;
/*  46:    */   }
/*  47:    */   
/*  48:    */   @Transactional(readOnly=true)
/*  49:    */   public Mailbox findById(Integer id)
/*  50:    */   {
/*  51: 43 */     Mailbox entity = this.dao.findById(id);
/*  52: 44 */     return entity;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public Mailbox save(Mailbox bean, MailboxExt ext, Site site, Integer departId, Integer typeId)
/*  56:    */   {
/*  57: 49 */     bean.setType(this.typeService.findById(typeId));
/*  58: 50 */     if (departId != null) {
/*  59: 51 */       bean.setDepart(this.departService.findById(departId));
/*  60:    */     }
/*  61: 53 */     bean.setSite(site);
/*  62: 54 */     bean.init();
/*  63: 55 */     this.dao.save(bean);
/*  64: 56 */     this.extService.save(bean, ext);
/*  65: 57 */     return bean;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public Mailbox update(Mailbox bean, MailboxExt ext, User user, Integer siteId)
/*  69:    */   {
/*  70: 62 */     Updater<Mailbox> updater = new Updater(bean);
/*  71: 63 */     bean = this.dao.updateByUpdater(updater);
/*  72: 64 */     if (!StringUtils.isBlank(ext.getReply()))
/*  73:    */     {
/*  74: 65 */       bean.setReplyTime(new Timestamp(System.currentTimeMillis()));
/*  75: 66 */       bean.setDepart(user.getAdmin().getDepart(siteId));
/*  76: 67 */       bean.setStatus(Mailbox.DEALED);
/*  77:    */     }
/*  78: 69 */     this.extService.update(bean, ext);
/*  79: 70 */     return bean;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public Mailbox showMailbox(Integer id)
/*  83:    */   {
/*  84: 74 */     Mailbox bean = this.dao.findById(id);
/*  85: 75 */     if (bean.getShow().booleanValue()) {
/*  86: 76 */       bean.setShow(Boolean.valueOf(false));
/*  87:    */     } else {
/*  88: 78 */       bean.setShow(Boolean.valueOf(true));
/*  89:    */     }
/*  90: 80 */     return bean;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public Mailbox forwardMailbox(Integer id, Integer departId)
/*  94:    */   {
/*  95: 84 */     Mailbox bean = this.dao.findById(id);
/*  96: 85 */     bean.setDepart(this.departService.findById(departId));
/*  97: 86 */     bean.setStatus(Mailbox.FORWARD);
/*  98: 87 */     return bean;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public Mailbox backMailbox(Integer id)
/* 102:    */   {
/* 103: 91 */     Mailbox bean = this.dao.findById(id);
/* 104: 92 */     bean.setDepart(null);
/* 105: 93 */     bean.setStatus(Mailbox.BACK);
/* 106: 94 */     return bean;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public Mailbox deleteById(Integer id)
/* 110:    */   {
/* 111: 98 */     Mailbox bean = this.dao.deleteById(id);
/* 112: 99 */     return bean;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public Mailbox[] deleteByIds(Integer[] ids)
/* 116:    */   {
/* 117:103 */     Mailbox[] beans = new Mailbox[ids.length];
/* 118:104 */     int i = 0;
/* 119:104 */     for (int len = ids.length; i < len; i++) {
/* 120:105 */       beans[i] = deleteById(ids[i]);
/* 121:    */     }
/* 122:107 */     return beans;
/* 123:    */   }
/* 124:    */   
/* 125:    */   @Autowired
/* 126:    */   public void setDao(MailboxDao dao)
/* 127:    */   {
/* 128:117 */     this.dao = dao;
/* 129:    */   }
/* 130:    */   
/* 131:    */   @Autowired
/* 132:    */   public void setTypeService(MailboxTypeService typeService)
/* 133:    */   {
/* 134:122 */     this.typeService = typeService;
/* 135:    */   }
/* 136:    */   
/* 137:    */   @Autowired
/* 138:    */   public void setExtService(MailboxExtService extService)
/* 139:    */   {
/* 140:127 */     this.extService = extService;
/* 141:    */   }
/* 142:    */   
/* 143:    */   @Autowired
/* 144:    */   public void setDepartService(DepartService departService)
/* 145:    */   {
/* 146:132 */     this.departService = departService;
/* 147:    */   }
/* 148:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.govcenter.service.impl.MailboxServiceImpl
 * JD-Core Version:    0.7.0.1
 */