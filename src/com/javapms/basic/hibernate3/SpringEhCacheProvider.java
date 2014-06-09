package com.javapms.basic.hibernate3;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.ObjectExistsException;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.config.ConfigurationFactory;
import net.sf.ehcache.config.DiskStoreConfiguration;
import net.sf.ehcache.hibernate.EhCache;
import org.hibernate.cache.Cache;
import org.hibernate.cache.CacheProvider;
import org.hibernate.cache.Timestamper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

public final class SpringEhCacheProvider
        implements CacheProvider {
    private static final Logger log = LoggerFactory.getLogger(SpringEhCacheProvider.class);
    private Resource configLocation;
    private Resource diskStoreLocation;
    private CacheManager manager;

    public void setConfigLocation(Resource configLocation) {
        this.configLocation = configLocation;
    }

    public void setDiskStoreLocation(Resource diskStoreLocation) {
        this.diskStoreLocation = diskStoreLocation;
    }

    public final Cache buildCache(String name, Properties properties)
            throws org.hibernate.cache.CacheException {
        try {
            Ehcache cache = this.manager.getEhcache(name);
            if (cache == null) {
                String s = "Could not find a specific ehcache configuration for cache named [{}]; using defaults.";
                log.warn(s, name);
                this.manager.addCache(name);
                cache = this.manager.getEhcache(name);
                log.debug("started EHCache region: " + name);
            }
            return new EhCache(cache);
        } catch (net.sf.ehcache.CacheException e) {
            throw new org.hibernate.cache.CacheException(e);
        }
    }

    public final long nextTimestamp() {
        return Timestamper.next();
    }

    public final void start(Properties properties)
            throws org.hibernate.cache.CacheException {
        if (this.manager != null) {
            String s = "Attempt to restart an already started EhCacheProvider. Use sessionFactory.close()  between repeated calls to buildSessionFactory. Using previously created EhCacheProvider. If this behaviour is required, consider using SingletonEhCacheProvider.";


            log.warn(s);
            return;
        }
        Configuration config = null;
        label133:

        try {
            if (this.configLocation != null) {
                config = ConfigurationFactory.parseConfiguration(this.configLocation
                        .getInputStream());
                if (this.diskStoreLocation != null) {
                    DiskStoreConfiguration dc = new DiskStoreConfiguration();
                    dc.setPath(this.diskStoreLocation.getFile()
                            .getAbsolutePath());
                    try {
                        config.addDiskStore(dc);
                    } catch (ObjectExistsException e) {
                        String s = "if you want to config distStore in spring, please remove diskStore in config file!";

                        log.warn(s, e);
                    }
                }
            }
            if (config == null) {
                break label133;
            }
        } catch (IOException e) {
            log.warn("create ehcache config failed!", e);
        }
        this.manager = new CacheManager(config);
        return;
    }

    public final void stop() {
        if (this.manager != null) {
            this.manager.shutdown();
            this.manager = null;
        }
    }

    public final boolean isMinimalPutsEnabledByDefault() {
        return false;
    }
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.javapms.basic.hibernate3.SpringEhCacheProvider

 * JD-Core Version:    0.7.0.1

 */