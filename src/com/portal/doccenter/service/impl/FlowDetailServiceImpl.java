/*  1:   */ package com.portal.doccenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.doccenter.dao.FlowDetailDao;
/*  6:   */ import com.portal.doccenter.entity.Article;
/*  7:   */ import com.portal.doccenter.entity.FlowDetail;
/*  8:   */ import com.portal.doccenter.service.FlowDetailService;
/*  9:   */ import com.portal.usermgr.entity.Role;
/* 10:   */ import com.portal.usermgr.entity.User;
/* 11:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 12:   */ import org.springframework.stereotype.Service;
/* 13:   */ import org.springframework.transaction.annotation.Transactional;
/* 14:   */ 
/* 15:   */ @Service
/* 16:   */ @Transactional
/* 17:   */ public class FlowDetailServiceImpl
/* 18:   */   implements FlowDetailService
/* 19:   */ {
/* 20:   */   private FlowDetailDao dao;
/* 21:   */   
/* 22:   */   @Transactional(readOnly=true)
/* 23:   */   public Pagination getPage(int pageNo, int pageSize)
/* 24:   */   {
/* 25:21 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 26:22 */     return page;
/* 27:   */   }
/* 28:   */   
/* 29:   */   @Transactional(readOnly=true)
/* 30:   */   public FlowDetail getLastFlowDetail(Integer docId)
/* 31:   */   {
/* 32:27 */     return this.dao.getLastFlowDetail(docId);
/* 33:   */   }
/* 34:   */   
/* 35:   */   @Transactional(readOnly=true)
/* 36:   */   public FlowDetail findById(Integer id)
/* 37:   */   {
/* 38:32 */     FlowDetail entity = this.dao.findById(id);
/* 39:33 */     return entity;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public FlowDetail saveCheck(Article doc, User user, Role role)
/* 43:   */   {
/* 44:37 */     FlowDetail bean = new FlowDetail();
/* 45:38 */     bean.setChecked(Boolean.valueOf(true));
/* 46:39 */     bean.setDoc(doc);
/* 47:40 */     bean.setUser(user);
/* 48:41 */     bean.setRole(role);
/* 49:42 */     FlowDetail fd = getLastFlowDetail(doc.getId());
/* 50:43 */     if (fd != null) {
/* 51:44 */       bean.setPriority(Integer.valueOf(fd.getPriority().intValue() + 1));
/* 52:   */     }
/* 53:46 */     bean.init();
/* 54:47 */     this.dao.save(bean);
/* 55:48 */     return bean;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public FlowDetail saveReturn(Article doc, User user, Role role, String reason, boolean initial)
/* 59:   */   {
/* 60:53 */     FlowDetail bean = new FlowDetail();
/* 61:54 */     bean.setChecked(Boolean.valueOf(false));
/* 62:55 */     bean.setBackInitial(Boolean.valueOf(initial));
/* 63:56 */     bean.setReason(reason);
/* 64:57 */     bean.setDoc(doc);
/* 65:58 */     bean.setUser(user);
/* 66:59 */     bean.setRole(role);
/* 67:60 */     FlowDetail fd = getLastFlowDetail(doc.getId());
/* 68:61 */     if (fd != null) {
/* 69:62 */       bean.setPriority(Integer.valueOf(fd.getPriority().intValue() + 1));
/* 70:   */     }
/* 71:64 */     bean.init();
/* 72:65 */     this.dao.save(bean);
/* 73:66 */     return bean;
/* 74:   */   }
/* 75:   */   
/* 76:   */   public FlowDetail update(FlowDetail bean)
/* 77:   */   {
/* 78:70 */     Updater<FlowDetail> updater = new Updater(bean);
/* 79:71 */     bean = this.dao.updateByUpdater(updater);
/* 80:72 */     return bean;
/* 81:   */   }
/* 82:   */   
/* 83:   */   public FlowDetail deleteById(Integer id)
/* 84:   */   {
/* 85:76 */     FlowDetail bean = this.dao.deleteById(id);
/* 86:77 */     return bean;
/* 87:   */   }
/* 88:   */   
/* 89:   */   public FlowDetail[] deleteByIds(Integer[] ids)
/* 90:   */   {
/* 91:81 */     FlowDetail[] beans = new FlowDetail[ids.length];
/* 92:82 */     int i = 0;
/* 93:82 */     for (int len = ids.length; i < len; i++) {
/* 94:83 */       beans[i] = deleteById(ids[i]);
/* 95:   */     }
/* 96:85 */     return beans;
/* 97:   */   }
/* 98:   */   
/* 99:   */   @Autowired
/* :0:   */   public void setDao(FlowDetailDao dao)
/* :1:   */   {
/* :2:92 */     this.dao = dao;
/* :3:   */   }
/* :4:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.impl.FlowDetailServiceImpl
 * JD-Core Version:    0.7.0.1
 */