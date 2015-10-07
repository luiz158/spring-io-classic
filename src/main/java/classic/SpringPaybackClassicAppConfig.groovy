package classic

import org.hibernate.jpa.HibernatePersistenceProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactoryBean
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.Database
import org.springframework.orm.jpa.vendor.HibernateJpaDialect
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.web.servlet.config.annotation.EnableWebMvc

import javax.sql.DataSource

@Configuration
@ComponentScan
class SpringPaybackClassicAppConfig {

}

@Configuration
@EnableWebMvc
class WebConfig {

}

@Configuration
@EnableJpaRepositories
class PersistenceConfig {

    @Bean
    EmbeddedDatabaseFactoryBean database() {
        return new EmbeddedDatabaseFactoryBean(
            databaseType: EmbeddedDatabaseType.H2,
            databaseName: 'spring-payback'
        )
    }

    @Bean @Autowired
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPackagesToScan('classic');
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider);
        entityManagerFactoryBean.setJpaVendorAdapter(buildJpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(buildJpaProperties());
        return entityManagerFactoryBean;
    }

    private HibernateJpaVendorAdapter buildJpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabase(Database.H2);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
        hibernateJpaVendorAdapter.setShowSql(true);
        return hibernateJpaVendorAdapter;
    }

    private Properties buildJpaProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", "create");
        return properties;
    }

    @Bean
    PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setJpaDialect(new HibernateJpaDialect());
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

}
