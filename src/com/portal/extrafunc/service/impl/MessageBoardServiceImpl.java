/*   1:    */ package com.portal.extrafunc.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.extrafunc.dao.MessageBoardDao;
/*   6:    */ import com.portal.extrafunc.entity.MessageBoard;
/*   7:    */ import com.portal.extrafunc.entity.MessageBoardExt;
/*   8:    */ import com.portal.extrafunc.service.MessageBoardExtService;
/*   9:    */ import com.portal.extrafunc.service.MessageBoardService;
/*  10:    */ import com.portal.extrafunc.service.MessageTypeService;
/*  11:    */ import com.portal.sysmgr.entity.Site;
/*  12:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  13:    */ import org.springframework.stereotype.Service;
/*  14:    */ import org.springframework.transaction.annotation.Transactional;
/*  15:    */ 
/*  16:    */ @Service
/*  17:    */ @Transactional
/*  18:    */ public class MessageBoardServiceImpl
/*  19:    */   implements MessageBoardService
/*  20:    */ {
/*  21:    */   private MessageBoardDao dao;
/*  22:    */   private MessageTypeService typeService;
/*  23:    */   private MessageBoardExtService extService;
/*  24:    */   
/*  25:    */   @Transactional(readOnly=true)
/*  26:    */   public Pagination getPage(String name, Integer siteId, Boolean show, String sortname, String sortorder, int pageNo, int pageSize)
/*  27:    */   {
/*  28: 23 */     Pagination page = this.dao.getPage(name, siteId, show, sortname, sortorder, 
/*  29: 24 */       pageNo, pageSize);
/*  30: 25 */     return page;
/*  31:    */   }
/*  32:    */   
/*  33:    */   @Transactional(readOnly=true)
/*  34:    */   public MessageBoard findById(Integer id)
/*  35:    */   {
/*  36: 30 */     MessageBoard entity = this.dao.findById(id);
/*  37: 31 */     return entity;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public MessageBoard save(String title, String name, String mobile, String email, String address, String zipcode, Integer typeId, String content, Site site)
/*  41:    */   {
/*  42: 37 */     MessageBoard board = new MessageBoard();
/*  43: 38 */     MessageBoardExt ext = new MessageBoardExt();
/*  44: 39 */     board.setTitle(title);
/*  45: 40 */     board.setName(name);
/*  46: 41 */     board.setMobile(mobile);
/*  47: 42 */     board.setEmail(email);
/*  48: 43 */     board.setAddress(address);
/*  49: 44 */     board.setZipcode(zipcode);
/*  50: 45 */     ext.setContent(content);
/*  51: 46 */     save(board, ext, site, typeId);
/*  52: 47 */     return board;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public MessageBoard save(MessageBoard bean, MessageBoardExt ext, Site site, Integer typeId)
/*  56:    */   {
/*  57: 52 */     if (typeId != null) {
/*  58: 53 */       bean.setType(this.typeService.findById(typeId));
/*  59:    */     } else {
/*  60: 55 */       bean.setType(this.typeService.getUniqueType(site.getId()));
/*  61:    */     }
/*  62: 57 */     bean.setSite(site);
/*  63: 58 */     bean.init();
/*  64: 59 */     this.dao.save(bean);
/*  65: 60 */     this.extService.save(bean, ext);
/*  66: 61 */     return bean;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public MessageBoard update(MessageBoard bean, MessageBoardExt ext, Integer typeId)
/*  70:    */   {
/*  71: 66 */     Updater<MessageBoard> updater = new Updater(bean);
/*  72: 67 */     bean = this.dao.updateByUpdater(updater);
/*  73: 68 */     if (typeId != null) {
/*  74: 69 */       bean.setType(this.typeService.findById(typeId));
/*  75:    */     }
/*  76: 71 */     this.extService.update(ext);
/*  77: 72 */     return bean;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public MessageBoard showBoard(Integer id)
/*  81:    */   {
/*  82: 76 */     MessageBoard board = findById(id);
/*  83: 77 */     if (board.getShow().booleanValue()) {
/*  84: 78 */       board.setShow(Boolean.valueOf(false));
/*  85:    */     } else {
/*  86: 80 */       board.setShow(Boolean.valueOf(true));
/*  87:    */     }
/*  88: 82 */     return board;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public MessageBoard deleteById(Integer id)
/*  92:    */   {
/*  93: 86 */     MessageBoard bean = this.dao.deleteById(id);
/*  94: 87 */     return bean;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public MessageBoard[] deleteByIds(Integer[] ids)
/*  98:    */   {
/*  99: 91 */     MessageBoard[] beans = new MessageBoard[ids.length];
/* 100: 92 */     int i = 0;
/* 101: 92 */     for (int len = ids.length; i < len; i++) {
/* 102: 93 */       beans[i] = deleteById(ids[i]);
/* 103:    */     }
/* 104: 95 */     return beans;
/* 105:    */   }
/* 106:    */   
/* 107:    */   @Autowired
/* 108:    */   public void setDao(MessageBoardDao dao)
/* 109:    */   {
/* 110:104 */     this.dao = dao;
/* 111:    */   }
/* 112:    */   
/* 113:    */   @Autowired
/* 114:    */   public void setTypeService(MessageTypeService typeService)
/* 115:    */   {
/* 116:109 */     this.typeService = typeService;
/* 117:    */   }
/* 118:    */   
/* 119:    */   @Autowired
/* 120:    */   public void setExtService(MessageBoardExtService extService)
/* 121:    */   {
/* 122:114 */     this.extService = extService;
/* 123:    */   }
/* 124:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.impl.MessageBoardServiceImpl
 * JD-Core Version:    0.7.0.1
 */