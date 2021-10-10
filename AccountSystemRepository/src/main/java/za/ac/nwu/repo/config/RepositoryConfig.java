package za.ac.nwu.repo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("za.ac.nwu.repo.persistence")
@EntityScan(value = "za.ac.nwu.domain.persistence")
@PropertySource(value = "classpath:application-db.properties")
public class RepositoryConfig {
    private static final String[] Entity_PACKAGES_TO_SCAN = {"za.ac.nwu.domain.persistence"};
    private static final String PERSISTENCE_UNIT_NAME = "account.system.persistence";

    @Bean
    public EmbeddedDatabase dataSource(){
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.HSQL)
                .addScript("script/schema.sql")
                .addScript("script/data.sql")
                .build();

    }
@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(Entity_PACKAGES_TO_SCAN);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(buildJpaProperties());
        entityManagerFactoryBean.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
        return entityManagerFactoryBean;
}

    private Properties buildJpaProperties() {
        return null;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}
