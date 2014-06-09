/*   1:    */
package com.portal.doccenter.service.impl;
/*   2:    */ 
/*   3:    */

import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.doccenter.dao.ChannelDao;
/*   6:    */ import com.portal.doccenter.entity.Channel;
/*   7:    */ import com.portal.doccenter.entity.ChannelExt;
/*   8:    */ import com.portal.doccenter.entity.ChannelTxt;
/*   9:    */ import com.portal.doccenter.entity.ChnlTplSelection;
/*  10:    */ import com.portal.doccenter.entity.Model;
/*  11:    */ import com.portal.doccenter.service.ChannelExtService;
/*  12:    */ import com.portal.doccenter.service.ChannelService;
/*  13:    */ import com.portal.doccenter.service.ChannelTxtService;
/*  14:    */ import com.portal.doccenter.service.ModelService;
/*  15:    */ import com.portal.sysmgr.service.SiteService;
/*  16:    */ import com.portal.usermgr.entity.Admin;
/*  17:    */ import com.portal.usermgr.entity.Depart;
/*  18:    */ import com.portal.usermgr.entity.Group;
/*  19:    */ import com.portal.usermgr.entity.User;
/*  20:    */ import com.portal.usermgr.service.GroupService;
/*  21:    */ import com.portal.usermgr.service.UserService;
/*  22:    */ import java.util.Iterator;
/*  23:    */ import java.util.List;
/*  24:    */ import java.util.Map;
/*  25:    */ import java.util.Set;
/*  26:    */ import org.apache.commons.lang.StringUtils;
/*  27:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  28:    */ import org.springframework.stereotype.Service;
/*  29:    */ import org.springframework.transaction.annotation.Transactional;

/*  30:    */
/*  31:    */
@Service
/*  32:    */
@Transactional
/*  33:    */ public class ChannelServiceImpl
/*  34:    */ implements ChannelService
/*  35:    */ {
    /*  36:    */   private SiteService siteService;
    /*  37:    */   private ChannelExtService channelExtService;
    /*  38:    */   private ChannelTxtService channelTxtService;
    /*  39:    */   private UserService userService;
    /*  40:    */   private GroupService groupService;
    /*  41:    */   private ModelService modelService;
    /*  42:    */   private ChannelDao dao;

    /*  43:    */
/*  44:    */
    @Transactional(readOnly = true)
/*  45:    */ public List<Channel> getChannelListByTag(Integer siteId, Integer parentId, boolean alone, boolean show, boolean cacheable, int count)
/*  46:    */ {
/*  47: 38 */
        return this.dao.getChannelListByTag(siteId, parentId, alone, show,
/*  48: 39 */       cacheable, count);
/*  49:    */
    }

    /*  50:    */
/*  51:    */
    @Transactional(readOnly = true)
/*  52:    */ public Pagination getChannelPageByTag(Integer siteId, Integer parentId, boolean alone, boolean show, boolean cacheable, int pageNo, int pageSize)
/*  53:    */ {
/*  54: 46 */
        return this.dao.getChannelPageByTag(siteId, parentId, alone, show,
/*  55: 47 */       cacheable, pageNo, pageSize);
/*  56:    */
    }

    /*  57:    */
/*  58:    */
    @Transactional(readOnly = true)
/*  59:    */ public List<Channel> getChannelByAdmin(Integer userId, Integer siteId, Integer parentId, String key, String sortname, String sortorder, boolean alone)
/*  60:    */ {
/*  61: 54 */
        User user = this.userService.findById(userId);
/*  62: 55 */
        Depart depart = user.getAdmin().getDepart(siteId);
/*  63: 56 */
        Integer departId = null;
/*  64: 57 */
        if ((!user.getAdmin().getAllChannel(siteId).booleanValue()) && (depart != null)) {
/*  65: 58 */
            departId = depart.getId();
/*  66:    */
        }
/*  67: 60 */
        return this.dao.getChannelByAdmin(siteId, departId, parentId, key, sortname,
/*  68: 61 */       sortorder, alone);
/*  69:    */
    }

    /*  70:    */
/*  71:    */
    @Transactional(readOnly = true)
/*  72:    */ public List<Channel> getChannelByModel(Integer parentId, Integer modelId, Integer userId, Integer siteId)
/*  73:    */ {
/*  74: 67 */
        User user = this.userService.findById(userId);
/*  75: 68 */
        Depart depart = user.getAdmin().getDepart(siteId);
/*  76: 69 */
        if (user.getAdmin().getAllChannel(siteId).booleanValue()) {
/*  77: 70 */
            return this.dao.getChannelByModel(parentId, modelId, null, siteId);
/*  78:    */
        }
/*  79: 72 */
        return this.dao.getChannelByModel(parentId, modelId, depart.getId(),
/*  80: 73 */       siteId);
/*  81:    */
    }

    /*  82:    */
/*  83:    */
    @Transactional(readOnly = true)
/*  84:    */ public Channel findByNumber(String number)
/*  85:    */ {
/*  86: 79 */
        return this.dao.findByNumber(number);
/*  87:    */
    }

    /*  88:    */
/*  89:    */
    @Transactional(readOnly = true)
/*  90:    */ public Channel findById(Integer id)
/*  91:    */ {
/*  92: 84 */
        Channel entity = this.dao.findById(id);
/*  93: 85 */
        return entity;
/*  94:    */
    }

    /*  95:    */
/*  96:    */
    @Transactional(readOnly = true)
/*  97:    */ public Channel findByPath(String path, Integer siteId)
/*  98:    */ {
/*  99: 90 */
        return this.dao.findByPath(path, siteId, false);
/* 100:    */
    }

    /* 101:    */
/* 102:    */
    @Transactional(readOnly = true)
/* 103:    */ public Channel findByPathForTag(String path, Integer siteId)
/* 104:    */ {
/* 105: 95 */
        return this.dao.findByPath(path, siteId, true);
/* 106:    */
    }

    /* 107:    */
/* 108:    */
    public Channel save(Channel bean, ChannelExt ext, ChannelTxt txt, Integer[] viewGroupIds, Integer[] contriGroupIds, Integer siteId, Integer parentId, String[] modelIds, Map<String, String> tpls)
/* 109:    */ {
/* 110:101 */
        if (parentId != null)
/* 111:    */ {
/* 112:102 */
            Channel parent = findById(parentId);
/* 113:103 */
            bean.setParent(parent);
/* 114:104 */
            parent.addToChilds(bean);
/* 115:    */
        }
/* 116:106 */
        bean.setSite(this.siteService.findById(siteId));
/* 117:    */
        String value;
/* 118:    */
        ChnlTplSelection cs = null;
/* 119:107 */
        if (tpls != null)
/* 120:    */ {
/* 121:108 */
            Set<String> keys = tpls.keySet();
/* 122:109 */
            for (String key : keys)
/* 123:    */ {
/* 124:110 */
                value = (String) tpls.get(key);
/* 125:111 */
                cs = new ChnlTplSelection();
/* 126:112 */
                Model m = this.modelService.findById(Integer.valueOf(Integer.parseInt(key)));
/* 127:113 */
                if (!StringUtils.isBlank(value)) {
/* 128:114 */
                    cs.setTplDoc(value);
/* 129:    */
                } else {
/* 130:116 */
                    cs.setTplDoc(m.getTplDoc());
/* 131:    */
                }
/* 132:118 */
                cs.setModel(m);
/* 133:119 */
                bean.addToTpls(cs);
/* 134:    */
            }
/* 135:    */
        }
/* 136:122 */
        bean.init();
/* 137:123 */
        this.dao.save(bean);
/* 138:124 */
        this.channelExtService.save(ext, bean);
/* 139:125 */
        this.channelTxtService.save(txt, bean);
/* 140:127 */
        if ((viewGroupIds != null) && (viewGroupIds.length > 0))
/* 141:    */ {
/* 142:128 */
            value = viewGroupIds.length + "";
/* 143:128 */
            for (int str1 = 0; str1 < Integer.parseInt(value); str1++)
/* 144:    */ {
/* 145:128 */
                Integer gid = cs.getModelId();
/* 146:129 */
                Group g = this.groupService.findById(gid);
/* 147:130 */
                bean.addToViewGroups(g);
/* 148:    */
            }
/* 149:    */
        }
/* 150:133 */
        if ((contriGroupIds != null) && (contriGroupIds.length > 0))
/* 151:    */ {
/* 152:134 */
            value = contriGroupIds.length + "";
/* 153:134 */
            for (int str2 = 0; str2 < Integer.parseInt(value); str2++)
/* 154:    */ {
/* 155:134 */
                Integer gid = cs.getModelId();
/* 156:135 */
                Group g = this.groupService.findById(gid);
/* 157:136 */
                bean.addToContriGroups(g);
/* 158:    */
            }
/* 159:    */
        }
/* 160:139 */
        String number = "-";
/* 161:140 */
        if (bean.getParent() != null) {
/* 162:141 */
            number = bean.getParent().getNumber();
/* 163:    */
        }
/* 164:143 */
        bean.setNumber(number + bean.getId() + "-");
/* 165:144 */
        return bean;
/* 166:    */
    }

    /* 167:    */
/* 168:    */
    public Channel update(Channel bean, ChannelExt ext, ChannelTxt txt, Integer[] viewGroupIds, Integer[] contriGroupIds, Integer parentId, String[] modelIds, Map<String, String> tpls)
/* 169:    */ {
/* 170:150 */
        Updater<Channel> updater = new Updater(bean);
/* 171:151 */
        bean = this.dao.updateByUpdater(updater);
/* 172:152 */
        String number = "-";
/* 173:153 */
        Channel c = bean.getParent();
/* 174:154 */
        if (c != null) {
/* 175:155 */
            c.getChild().remove(bean);
/* 176:    */
        }
/* 177:157 */
        if (parentId != null)
/* 178:    */ {
/* 179:158 */
            Channel parent = findById(parentId);
/* 180:159 */
            number = findById(parentId).getNumber();
/* 181:160 */
            parent.addToChilds(bean);
/* 182:161 */
            bean.getParent().getChild().remove(bean);
/* 183:162 */
            bean.setParent(parent);
/* 184:    */
        }
/* 185:    */
        else
/* 186:    */ {
/* 187:164 */
            bean.setParent(null);
/* 188:    */
        }
/* 189:166 */
        bean.setNumber(number + bean.getId() + "-");
/* 190:167 */
        this.channelExtService.update(ext);
/* 191:168 */
        this.channelTxtService.update(txt, bean);
/* 192:169 */
        for (Group g : bean.getViewGroups()) {
/* 193:170 */
            g.getViewChannels().remove(bean);
/* 194:    */
        }
/* 195:172 */
        bean.getViewGroups().clear();
/* 196:173 */
        if ((viewGroupIds != null) && (viewGroupIds.length > 0)) {
/* 197:175 */
            for (Integer gid : viewGroupIds)
/* 198:    */ {
/* 199:176 */
                Group g = this.groupService.findById(gid);
/* 200:177 */
                bean.addToViewGroups(g);
/* 201:    */
            }
/* 202:    */
        }
/* 203:180 */
        for (Object gid = bean.getContriGroups().iterator(); ((Iterator) gid).hasNext(); )
/* 204:    */ {
/* 205:180 */
            Group g = (Group) ((Iterator) gid).next();
/* 206:181 */
            g.getContriChannels().remove(bean);
/* 207:    */
        }
/* 208:183 */
        bean.getContriGroups().clear();
/* 209:184 */
        if ((contriGroupIds != null) && (contriGroupIds.length > 0)) {
/* 210:186 */
            for (Integer gid : contriGroupIds)
/* 211:    */ {
/* 212:187 */
                Group g = this.groupService.findById(gid);
/* 213:188 */
                bean.addToContriGroups(g);
/* 214:    */
            }
/* 215:    */
        }
/* 216:191 */
        bean.getTpls().clear();
/* 217:192 */
        if (tpls != null)
/* 218:    */ {
/* 219:193 */
            Set<String> keys = tpls.keySet();
/* 220:194 */
            for (String key : keys)
/* 221:    */ {
/* 222:195 */
                String value = (String) tpls.get(key);
/* 223:196 */
                ChnlTplSelection cs = new ChnlTplSelection();
/* 224:197 */
                cs.setTplDoc(value);
/* 225:198 */
                cs.setModel(this.modelService.findById(Integer.valueOf(Integer.parseInt(key))));
/* 226:199 */
                bean.addToTpls(cs);
/* 227:    */
            }
/* 228:    */
        }
/* 229:202 */
        return bean;
/* 230:    */
    }

    /* 231:    */
/* 232:    */
    public Channel delChannel(Integer id, Boolean del, Integer cid)
/* 233:    */ {
/* 234:206 */
        Channel c = this.dao.findById(id);
/* 235:207 */
        if (del != null) {
/* 236:208 */
            if (del.booleanValue())
/* 237:    */ {
/* 238:209 */
                if ((c.getChild() != null) && (c.getChild().size() > 0)) {
/* 239:210 */
                    delChild(c.getChild());
/* 240:    */
                }
/* 241:    */
            }
/* 242:213 */
            else if ((c.getChild() != null) && (c.getChild().size() > 0)) {
/* 243:214 */
                moveChild(c.getChild(), cid);
/* 244:    */
            }
/* 245:    */
        }
/* 246:218 */
        deleteById(c.getId());
/* 247:219 */
        return null;
/* 248:    */
    }

    /* 249:    */
/* 250:    */
    private void delChild(Set<Channel> childs)
/* 251:    */ {
/* 252:223 */
        for (Channel c : childs)
/* 253:    */ {
/* 254:224 */
            if ((c.getChild() != null) && (c.getChild().size() > 0)) {
/* 255:225 */
                delChild(c.getChild());
/* 256:    */
            }
/* 257:227 */
            deleteById(c.getId());
/* 258:    */
        }
/* 259:    */
    }

    /* 260:    */
/* 261:    */
    private void moveChild(Set<Channel> childs, Integer cid)
/* 262:    */ {
/* 263:232 */
        for (Channel c : childs)
/* 264:    */ {
/* 265:233 */
            Channel parent = findById(cid);
/* 266:234 */
            parent.addToChilds(c);
/* 267:235 */
            c.getParent().getChild().remove(c);
/* 268:236 */
            c.setParent(parent);
/* 269:237 */
            c.setNumber(parent.getNumber() + c.getId() + "-");
/* 270:    */
        }
/* 271:    */
    }

    /* 272:    */
/* 273:    */
    public Channel deleteById(Integer id)
/* 274:    */ {
/* 275:242 */
        Channel entity = this.dao.findById(id);
/* 276:243 */
        for (Group group : entity.getViewGroups()) {
/* 277:244 */
            group.getViewChannels().remove(entity);
/* 278:    */
        }
/* 279:246 */
        for (Group group : entity.getContriGroups()) {
/* 280:247 */
            group.getContriChannels().remove(entity);
/* 281:    */
        }
/* 282:249 */
        for (Depart depart : entity.getDeparts()) {
/* 283:250 */
            depart.getChannels().remove(entity);
/* 284:    */
        }
/* 285:252 */
        if (entity.getParent() != null) {
/* 286:253 */
            entity.getParent().getChild().remove(entity);
/* 287:    */
        }
/* 288:255 */
        Channel parent = entity.getParent();
/* 289:256 */
        if (parent != null) {
/* 290:257 */
            parent.getChild().remove(entity);
/* 291:    */
        }
/* 292:259 */
        entity = this.dao.deleteById(id);
/* 293:260 */
        return entity;
/* 294:    */
    }

    /* 295:    */
/* 296:    */
    public Channel[] deleteByIds(Integer[] ids)
/* 297:    */ {
/* 298:264 */
        Channel[] beans = new Channel[ids.length];
/* 299:265 */
        int i = 0;
/* 300:265 */
        for (int len = ids.length; i < len; i++) {
/* 301:266 */
            beans[i] = deleteById(ids[i]);
/* 302:    */
        }
/* 303:268 */
        return beans;
/* 304:    */
    }

    /* 305:    */
/* 306:    */
    public Channel[] updatePriority(Integer[] ids, Integer[] priority)
/* 307:    */ {
/* 308:272 */
        int len = ids.length;
/* 309:273 */
        Channel[] beans = new Channel[len];
/* 310:274 */
        for (int i = 0; i < len; i++)
/* 311:    */ {
/* 312:275 */
            beans[i] = findById(ids[i]);
/* 313:276 */
            beans[i].setPriority(priority[i]);
/* 314:    */
        }
/* 315:278 */
        return beans;
/* 316:    */
    }

    /* 317:    */
/* 318:    */
    @Autowired
/* 319:    */ public void setSiteService(SiteService siteService)
/* 320:    */ {
/* 321:291 */
        this.siteService = siteService;
/* 322:    */
    }

    /* 323:    */
/* 324:    */
    @Autowired
/* 325:    */ public void setChannelExtService(ChannelExtService channelExtService)
/* 326:    */ {
/* 327:296 */
        this.channelExtService = channelExtService;
/* 328:    */
    }

    /* 329:    */
/* 330:    */
    @Autowired
/* 331:    */ public void setChannelTxtService(ChannelTxtService channelTxtService)
/* 332:    */ {
/* 333:301 */
        this.channelTxtService = channelTxtService;
/* 334:    */
    }

    /* 335:    */
/* 336:    */
    @Autowired
/* 337:    */ public void setModelService(ModelService modelService)
/* 338:    */ {
/* 339:306 */
        this.modelService = modelService;
/* 340:    */
    }

    /* 341:    */
/* 342:    */
    @Autowired
/* 343:    */ public void setUserService(UserService userService)
/* 344:    */ {
/* 345:311 */
        this.userService = userService;
/* 346:    */
    }

    /* 347:    */
/* 348:    */
    @Autowired
/* 349:    */ public void setGroupService(GroupService groupService)
/* 350:    */ {
/* 351:316 */
        this.groupService = groupService;
/* 352:    */
    }

    /* 353:    */
/* 354:    */
    @Autowired
/* 355:    */ public void setDao(ChannelDao dao)
/* 356:    */ {
/* 357:321 */
        this.dao = dao;
/* 358:    */
    }
/* 359:    */
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.doccenter.service.impl.ChannelServiceImpl

 * JD-Core Version:    0.7.0.1

 */