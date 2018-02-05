package com.sample.samplespringbatch.configurations;

import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.sample.samplespringbatch.reader",
    entityManagerFactoryRef = "orderEntityManager",
    transactionManagerRef = "orderTransactionManager"
)
public class JPAConfiguration {

  @Autowired
  private Environment env;

  @Bean
  @Primary
  public LocalContainerEntityManagerFactoryBean orderEntityManager() {
    LocalContainerEntityManagerFactoryBean em
        = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(orderDataSource());
    em.setPackagesToScan(
        new String[] { "com.sample.samplespringbatch" });

    HibernateJpaVendorAdapter vendorAdapter
        = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    HashMap<String, Object> properties = new HashMap<>();
    properties.put("hibernate.hbm2ddl.auto",
        "create-drop");
    properties.put("hibernate.dialect",
        "org.hibernate.dialect.H2Dialect");
    em.setJpaPropertyMap(properties);

    return em;
  }

  @Primary
  @Bean
  public DataSource orderDataSource() {

    DriverManagerDataSource dataSource
        = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.h2.Driver");
    dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
    dataSource.setUsername("sa");
    dataSource.setPassword("");

    return dataSource;
  }

  @Primary
  @Bean
  public PlatformTransactionManager orderTransactionManager() {

    JpaTransactionManager transactionManager
        = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(
        orderEntityManager().getObject());
    return transactionManager;
  }

}
