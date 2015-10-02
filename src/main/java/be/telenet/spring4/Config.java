package be.telenet.spring4;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by frederik on 10/11/14.
 */
@Configuration
@ComponentScan("be.telenet.spring4")
@EnableWebMvc
@EnableCaching
@EnableTransactionManagement
public class Config extends WebMvcConfigurerAdapter {

    private Log log = LogFactory.getLog(this.getClass());

    @Bean
    public CacheManager createCache() {
        return new ConcurrentMapCacheManager();
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/");
    }

}
