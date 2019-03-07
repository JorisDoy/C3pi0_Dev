package com.indra.iopen.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    @Profile("dev")
    public CacheManager cacheManagerInMemory() {

        return new ConcurrentMapCacheManager();
    }

    @Bean
    @Profile("prod")
    public EhCacheCacheManager cacheManagerProd(final net.sf.ehcache.CacheManager cm) {
        final EhCacheCacheManager manager = new EhCacheCacheManager(cm);

        return manager;
    }

    @Bean
    @Profile("prod")
    public EhCacheManagerFactoryBean ehCache() {
        final EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
        bean.setConfigLocation(new ClassPathResource("cache/ehcache.xml"));
        return bean;
    }
}
