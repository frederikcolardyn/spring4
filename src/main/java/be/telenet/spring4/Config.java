package be.telenet.spring4;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hsqldb.Server;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by frederik on 10/11/14.
 */
@Configuration
@ComponentScan("be.telenet.spring4")
@EnableWebMvc
@EnableCaching
@EnableTransactionManagement
public class Config {

    private Log log = LogFactory.getLog(this.getClass());
    private Server server;

    @PostConstruct
    public void init(){
        server = new Server();
        server.setDatabaseName(0, "mock");
        server.setDatabasePath(0, "/tmp/mock.db");
        server.setLogWriter(null);
        server.setErrWriter(null);
        server.start();
        log.info("HSQL in memory database started.");
    }

    @PreDestroy
    public void stop(){
        server.stop();
    }

    @Bean
    public CacheManager createCache(){
        return new ConcurrentMapCacheManager();
    }

    @Bean
    public DataSource createDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        driverManagerDataSource.setUrl("jdbc:hsqldb:hsql://localhost/mock");
        driverManagerDataSource.setUsername("sa");
        driverManagerDataSource.setPassword("");
        return driverManagerDataSource;
    }

    @Bean
    public EntityManagerFactory createEntityManager(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPersistenceUnitName("mock");
        entityManagerFactoryBean.setJpaVendorAdapter(new org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter());
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        jpaProperties.setProperty("hibernate.show_sql", "false");
        jpaProperties.setProperty("hibernate.format_sql", "false");
        // jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean.getNativeEntityManagerFactory();
    }

    @Bean
    public JpaTransactionManager createTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}
