package com.javapms.basic.ehcache;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.ObjectExistsException;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.config.ConfigurationFactory;
import net.sf.ehcache.config.DiskStoreConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class EhCacheFacotryBean
        implements FactoryBean<CacheManager>, InitializingBean, DisposableBean {
    private final Logger log = LoggerFactory.getLogger(EhCacheFacotryBean.class);
    private Resource configLocation;
    private Resource diskStoreLocation;
    private String cacheManagerName;
    private CacheManager cacheManager;

    public void setConfigLocation(Resource configLocation) {
        this.configLocation = configLocation;
    }

    public void setdiskStoreLocation(Resource diskStoreLocation) {
        this.diskStoreLocation = diskStoreLocation;
    }

    public void setCacheManagerName(String cacheManagerName) {
        this.cacheManagerName = cacheManagerName;
    }

    public void afterPropertiesSet()
            throws IOException, CacheException {
        this.log.info("Initializing EHCache CacheManager");
        Configuration config = null;
        if (this.configLocation != null) {
            config =
                    ConfigurationFactory.parseConfiguration(this.configLocation.getInputStream());
            if (this.diskStoreLocation != null) {
                DiskStoreConfiguration dc = new DiskStoreConfiguration();
                dc.setPath(this.diskStoreLocation.getFile().getAbsolutePath());
                try {
                    config.addDiskStore(dc);
                } catch (ObjectExistsException e) {
                    this.log.warn("if you want to config distStore in spring, please remove diskStore in config file!",
                            e);
                }
            }
        }
        if (config != null) {
            this.cacheManager = new CacheManager(config);
        } else {
            this.cacheManager = new CacheManager();
        }
        if (this.cacheManagerName != null) {
            this.cacheManager.setName(this.cacheManagerName);
        }
    }

    public CacheManager getObject() {
        return this.cacheManager;
    }

    public Class<? extends CacheManager> getObjectType() {
        return this.cacheManager != null ? this.cacheManager.getClass() :
                CacheManager.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public void destroy() {
        this.log.info("Shutting down EHCache CacheManager");
        this.cacheManager.shutdown();
    }
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.javapms.basic.ehcache.EhCacheFacotryBean

 * JD-Core Version:    0.7.0.1

 */