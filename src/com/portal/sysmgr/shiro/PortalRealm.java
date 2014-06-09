/*  1:   */ package com.portal.sysmgr.shiro;
/*  2:   */ 
/*  3:   */ import com.portal.sysmgr.entity.Site;
/*  4:   */ import com.portal.sysmgr.utils.ContextTools;
/*  5:   */ import com.portal.usermgr.entity.Admin;
/*  6:   */ import com.portal.usermgr.entity.User;
/*  7:   */ import com.portal.usermgr.service.UserService;
/*  8:   */ import java.util.Collection;
/*  9:   */ import java.util.Iterator;
/* 10:   */ import java.util.Set;
/* 11:   */ import org.apache.commons.lang.StringUtils;
/* 12:   */ import org.apache.shiro.authc.AuthenticationException;
/* 13:   */ import org.apache.shiro.authc.AuthenticationInfo;
/* 14:   */ import org.apache.shiro.authc.AuthenticationToken;
/* 15:   */ import org.apache.shiro.authc.SimpleAuthenticationInfo;
/* 16:   */ import org.apache.shiro.authc.UsernamePasswordToken;
/* 17:   */ import org.apache.shiro.authz.AuthorizationInfo;
/* 18:   */ import org.apache.shiro.authz.SimpleAuthorizationInfo;
/* 19:   */ import org.apache.shiro.realm.AuthorizingRealm;
/* 20:   */ import org.apache.shiro.subject.PrincipalCollection;
/* 21:   */ import org.apache.shiro.util.CollectionUtils;
/* 22:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 23:   */ 
/* 24:   */ public class PortalRealm
/* 25:   */   extends AuthorizingRealm
/* 26:   */ {
/* 27:   */   private UserService userService;
/* 28:   */   
/* 29:   */   protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
/* 30:   */     throws AuthenticationException
/* 31:   */   {
/* 32:34 */     UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
/* 33:35 */     User user = this.userService.findByUsername(token.getUsername());
/* 34:36 */     if (user != null) {
/* 35:37 */       return new SimpleAuthenticationInfo(user.getUsername(), 
/* 36:38 */         user.getPassword(), getName());
/* 37:   */     }
/* 38:40 */     return null;
/* 39:   */   }
/* 40:   */   
/* 41:   */   protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
/* 42:   */   {
/* 43:45 */     String username = 
/* 44:46 */       (String)principals.fromRealm(getName()).iterator().next();
/* 45:47 */     if (!StringUtils.isBlank(username))
/* 46:   */     {
/* 47:48 */       User user = this.userService.findByUsername(username);
/* 48:49 */       Site site = ContextTools.getSite();
/* 49:50 */       if ((user != null) && (site != null))
/* 50:   */       {
/* 51:51 */         SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
/* 52:52 */         if (user.getAdmin() != null)
/* 53:   */         {
/* 54:53 */           Set<String> perms = user.getAdmin().getPerms(site.getId());
/* 55:54 */           if (!CollectionUtils.isEmpty(perms)) {
/* 56:55 */             auth.setStringPermissions(perms);
/* 57:   */           }
/* 58:57 */           return auth;
/* 59:   */         }
/* 60:59 */         auth.setObjectPermissions(null);
/* 61:60 */         return auth;
/* 62:   */       }
/* 63:   */     }
/* 64:64 */     return null;
/* 65:   */   }
/* 66:   */   
/* 67:   */   @Autowired
/* 68:   */   public void setUserService(UserService userService)
/* 69:   */   {
/* 70:71 */     this.userService = userService;
/* 71:   */   }
/* 72:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.shiro.PortalRealm
 * JD-Core Version:    0.7.0.1
 */