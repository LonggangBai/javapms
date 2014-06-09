/*   1:    */ package com.portal.usermgr.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.usermgr.dao.MemberDao;
/*   6:    */ import com.portal.usermgr.entity.Group;
/*   7:    */ import com.portal.usermgr.entity.Member;
/*   8:    */ import com.portal.usermgr.entity.User;
/*   9:    */ import com.portal.usermgr.service.GroupService;
/*  10:    */ import com.portal.usermgr.service.MemberService;
/*  11:    */ import com.portal.usermgr.service.UserService;
/*  12:    */ import java.sql.Timestamp;
/*  13:    */ import java.util.Set;
/*  14:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  15:    */ import org.springframework.stereotype.Service;
/*  16:    */ import org.springframework.transaction.annotation.Transactional;
/*  17:    */ 
/*  18:    */ @Service
/*  19:    */ @Transactional
/*  20:    */ public class MemberServiceImpl
/*  21:    */   implements MemberService
/*  22:    */ {
/*  23:    */   private MemberDao dao;
/*  24:    */   private UserService userService;
/*  25:    */   private GroupService groupService;
/*  26:    */   
/*  27:    */   @Transactional(readOnly=true)
/*  28:    */   public Pagination getPage(int pageNo, int pageSize)
/*  29:    */   {
/*  30: 23 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/*  31: 24 */     return page;
/*  32:    */   }
/*  33:    */   
/*  34:    */   @Transactional(readOnly=true)
/*  35:    */   public Pagination getPage(String key, Integer siteId, Integer groupId, String sortname, String sortorder, int pageNo, int pageSize)
/*  36:    */   {
/*  37: 30 */     return this.dao.getPage(key, siteId, groupId, sortname, sortorder, pageNo, 
/*  38: 31 */       pageSize);
/*  39:    */   }
/*  40:    */   
/*  41:    */   @Transactional(readOnly=true)
/*  42:    */   public Member findById(Integer id)
/*  43:    */   {
/*  44: 36 */     Member entity = this.dao.findById(id);
/*  45: 37 */     return entity;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public Member registerMember(User user, Member member, String ip, Integer groupId)
/*  49:    */   {
/*  50: 42 */     member.setRegisterIp(ip);
/*  51: 43 */     member.setLastLoginIp(ip);
/*  52: 44 */     if (groupId != null) {
/*  53: 45 */       member.addToGroups(this.groupService.findById(groupId));
/*  54:    */     }
/*  55: 47 */     this.userService.save(user);
/*  56: 48 */     member.setUser(user);
/*  57: 49 */     save(member);
/*  58: 50 */     user.setMember(member);
/*  59: 51 */     return member;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public Member updateMember(User user, Member member, Integer groupId, Integer siteId)
/*  63:    */   {
/*  64: 56 */     if (findById(user.getId()) != null)
/*  65:    */     {
/*  66: 57 */       member = update(member);
/*  67:    */     }
/*  68:    */     else
/*  69:    */     {
/*  70: 59 */       member.setUser(user);
/*  71: 60 */       member = save(member);
/*  72: 61 */       user.setMember(member);
/*  73:    */     }
/*  74: 63 */     this.userService.update(user);
/*  75: 64 */     if ((groupId != null) && 
/*  76: 65 */       (!groupId.equals(member.getGroup(siteId).getId())))
/*  77:    */     {
/*  78: 66 */       member.getGroups().remove(member.getGroup(siteId));
/*  79: 67 */       member.addToGroups(this.groupService.findById(groupId));
/*  80:    */     }
/*  81: 70 */     return member;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public void updateLoginInfo(User user, String lastLoginIp)
/*  85:    */   {
/*  86: 74 */     Member member = findById(user.getId());
/*  87: 75 */     if (member != null)
/*  88:    */     {
/*  89: 76 */       member.setLastLoginIp(lastLoginIp);
/*  90: 77 */       member.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
/*  91: 78 */       if (member.getRegisterIp() == null) {
/*  92: 79 */         member.setRegisterIp(lastLoginIp);
/*  93:    */       }
/*  94: 81 */       member.setLoginCount(Integer.valueOf(member.getLoginCount().intValue() + 1));
/*  95:    */     }
/*  96:    */   }
/*  97:    */   
/*  98:    */   public Member save(Member bean)
/*  99:    */   {
/* 100: 86 */     bean.init();
/* 101: 87 */     this.dao.save(bean);
/* 102: 88 */     return bean;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public Member update(Member bean)
/* 106:    */   {
/* 107: 92 */     Updater<Member> updater = new Updater(bean);
/* 108: 93 */     bean = this.dao.updateByUpdater(updater);
/* 109: 94 */     return bean;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public Member updatePass(Integer memberId, String password)
/* 113:    */   {
/* 114: 98 */     User user = this.userService.updatePass(memberId, password);
/* 115: 99 */     return user.getMember();
/* 116:    */   }
/* 117:    */   
/* 118:    */   public Member deleteById(Integer id)
/* 119:    */   {
/* 120:103 */     Member bean = this.dao.deleteById(id);
/* 121:104 */     this.userService.deleteById(id);
/* 122:105 */     return bean;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public Member[] deleteByIds(Integer[] ids)
/* 126:    */   {
/* 127:109 */     Member[] beans = new Member[ids.length];
/* 128:110 */     int i = 0;
/* 129:110 */     for (int len = ids.length; i < len; i++) {
/* 130:111 */       beans[i] = deleteById(ids[i]);
/* 131:    */     }
/* 132:113 */     return beans;
/* 133:    */   }
/* 134:    */   
/* 135:    */   @Autowired
/* 136:    */   public void setDao(MemberDao dao)
/* 137:    */   {
/* 138:122 */     this.dao = dao;
/* 139:    */   }
/* 140:    */   
/* 141:    */   @Autowired
/* 142:    */   public void setUserService(UserService userService)
/* 143:    */   {
/* 144:127 */     this.userService = userService;
/* 145:    */   }
/* 146:    */   
/* 147:    */   @Autowired
/* 148:    */   public void setGroupService(GroupService groupService)
/* 149:    */   {
/* 150:132 */     this.groupService = groupService;
/* 151:    */   }
/* 152:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.service.impl.MemberServiceImpl
 * JD-Core Version:    0.7.0.1
 */