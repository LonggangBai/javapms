/*   1:    */ package com.portal.usermgr.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.doccenter.entity.Channel;
/*   6:    */ import com.portal.doccenter.service.ChannelService;
/*   7:    */ import com.portal.doccenter.service.WorkFlowService;
/*   8:    */ import com.portal.sysmgr.entity.Site;
/*   9:    */ import com.portal.usermgr.dao.DepartDao;
/*  10:    */ import com.portal.usermgr.entity.Depart;
/*  11:    */ import com.portal.usermgr.service.DepartService;
/*  12:    */ import java.util.List;
/*  13:    */ import java.util.Set;
/*  14:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  15:    */ import org.springframework.stereotype.Service;
/*  16:    */ import org.springframework.transaction.annotation.Transactional;
/*  17:    */ 
/*  18:    */ @Service
/*  19:    */ @Transactional
/*  20:    */ public class DepartServiceImpl
/*  21:    */   implements DepartService
/*  22:    */ {
/*  23:    */   private ChannelService channelService;
/*  24:    */   private WorkFlowService workFlowService;
/*  25:    */   private DepartDao dao;
/*  26:    */   
/*  27:    */   @Transactional(readOnly=true)
/*  28:    */   public Pagination getPage(Integer siteId, String sortname, String sortorder, int pageNo, int pageSize)
/*  29:    */   {
/*  30: 26 */     Pagination page = this.dao.getPage(siteId, sortname, sortorder, pageNo, 
/*  31: 27 */       pageSize);
/*  32: 28 */     return page;
/*  33:    */   }
/*  34:    */   
/*  35:    */   @Transactional(readOnly=true)
/*  36:    */   public List<Depart> getListByTag(Integer siteId)
/*  37:    */   {
/*  38: 33 */     return this.dao.getListByTag(siteId);
/*  39:    */   }
/*  40:    */   
/*  41:    */   @Transactional(readOnly=true)
/*  42:    */   public List<Depart> getAllList(Integer siteId)
/*  43:    */   {
/*  44: 38 */     return this.dao.getAllList(siteId);
/*  45:    */   }
/*  46:    */   
/*  47:    */   @Transactional(readOnly=true)
/*  48:    */   public List<Depart> getListNoParent(Integer siteId)
/*  49:    */   {
/*  50: 43 */     return this.dao.getListNoParent(siteId);
/*  51:    */   }
/*  52:    */   
/*  53:    */   @Transactional(readOnly=true)
/*  54:    */   public List<Depart> getListByParent(Integer parentId)
/*  55:    */   {
/*  56: 48 */     return this.dao.getListByParent(parentId);
/*  57:    */   }
/*  58:    */   
/*  59:    */   @Transactional(readOnly=true)
/*  60:    */   public Depart getDepartByPath(String path, Integer siteId)
/*  61:    */   {
/*  62: 53 */     return this.dao.getDepartByPath(path, siteId);
/*  63:    */   }
/*  64:    */   
/*  65:    */   @Transactional(readOnly=true)
/*  66:    */   public Depart findById(Integer id)
/*  67:    */   {
/*  68: 58 */     Depart entity = this.dao.findById(id);
/*  69: 59 */     return entity;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public Depart save(Depart bean, Site site, Integer parentId, Integer flowId, Integer[] channelIds)
/*  73:    */   {
/*  74: 64 */     if (parentId != null)
/*  75:    */     {
/*  76: 65 */       Depart parent = findById(parentId);
/*  77: 66 */       bean.setParent(parent);
/*  78: 67 */       parent.addToChilds(bean);
/*  79:    */     }
/*  80: 69 */     if (flowId != null) {
/*  81: 70 */       bean.setFlow(this.workFlowService.findById(flowId));
/*  82:    */     }
/*  83: 72 */     bean.setSite(site);
/*  84: 73 */     bean.init();
/*  85: 74 */     this.dao.save(bean);
/*  86: 75 */     if (channelIds != null) {
/*  87: 77 */       for (Integer cid : channelIds)
/*  88:    */       {
/*  89: 78 */         Channel channel = this.channelService.findById(cid);
/*  90: 79 */         channel.addToDeparts(bean);
/*  91:    */       }
/*  92:    */     }
/*  93: 82 */     String number = "-";
/*  94: 83 */     if (bean.getParent() != null) {
/*  95: 84 */       number = bean.getParent().getNumber();
/*  96:    */     }
/*  97: 86 */     bean.setNumber(number + bean.getId() + "-");
/*  98: 87 */     return bean;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public Depart update(Depart bean, Integer parentId, Integer flowId, Integer[] channelIds)
/* 102:    */   {
/* 103: 92 */     Updater<Depart> updater = new Updater(bean);
/* 104: 93 */     bean = this.dao.updateByUpdater(updater);
/* 105: 94 */     if (parentId != null)
/* 106:    */     {
/* 107: 95 */       Depart parent = findById(parentId);
/* 108: 96 */       parent.addToChilds(bean);
/* 109: 97 */       bean.getParent().getChild().remove(bean);
/* 110: 98 */       bean.setParent(parent);
/* 111:    */     }
/* 112:    */     else
/* 113:    */     {
/* 114:100 */       bean.setParent(null);
/* 115:    */     }
/* 116:102 */     if (flowId != null) {
/* 117:103 */       bean.setFlow(this.workFlowService.findById(flowId));
/* 118:    */     } else {
/* 119:105 */       bean.setFlow(null);
/* 120:    */     }
/* 121:107 */     Set<Channel> channels = bean.getChannels();
/* 122:108 */     for (Channel channel : channels) {
/* 123:109 */       channel.getDeparts().remove(bean);
/* 124:    */     }
/* 125:111 */     bean.getChannels().clear();
/* 126:112 */     if (channelIds != null) {
/* 127:114 */       for (Integer cid : channelIds)
/* 128:    */       {
/* 129:115 */         Channel channel = this.channelService.findById(cid);
/* 130:116 */         channel.addToDeparts(bean);
/* 131:    */       }
/* 132:    */     }
/* 133:119 */     String number = "-";
/* 134:120 */     if (bean.getParent() != null) {
/* 135:121 */       number = bean.getParent().getNumber();
/* 136:    */     }
/* 137:123 */     bean.setNumber(number + bean.getId() + "-");
/* 138:124 */     return bean;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public Depart deleteById(Integer id)
/* 142:    */   {
/* 143:128 */     Depart bean = this.dao.deleteById(id);
/* 144:129 */     Set<Channel> channels = bean.getChannels();
/* 145:130 */     for (Channel channel : channels) {
/* 146:131 */       channel.getDeparts().remove(bean);
/* 147:    */     }
/* 148:133 */     bean.getChannels().clear();
/* 149:134 */     Depart parent = bean.getParent();
/* 150:135 */     if (parent != null) {
/* 151:136 */       parent.getChild().remove(bean);
/* 152:    */     }
/* 153:138 */     return bean;
/* 154:    */   }
/* 155:    */   
/* 156:    */   public Depart[] deleteByIds(Integer[] ids)
/* 157:    */   {
/* 158:142 */     Depart[] beans = new Depart[ids.length];
/* 159:143 */     int i = 0;
/* 160:143 */     for (int len = ids.length; i < len; i++) {
/* 161:144 */       beans[i] = deleteById(ids[i]);
/* 162:    */     }
/* 163:146 */     return beans;
/* 164:    */   }
/* 165:    */   
/* 166:    */   @Autowired
/* 167:    */   public void setDao(DepartDao dao)
/* 168:    */   {
/* 169:155 */     this.dao = dao;
/* 170:    */   }
/* 171:    */   
/* 172:    */   @Autowired
/* 173:    */   public void setChannelService(ChannelService channelService)
/* 174:    */   {
/* 175:160 */     this.channelService = channelService;
/* 176:    */   }
/* 177:    */   
/* 178:    */   @Autowired
/* 179:    */   public void setWorkFlowService(WorkFlowService workFlowService)
/* 180:    */   {
/* 181:165 */     this.workFlowService = workFlowService;
/* 182:    */   }
/* 183:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.service.impl.DepartServiceImpl
 * JD-Core Version:    0.7.0.1
 */