package com.studentcertificate.studentcertificate;

import java.util.Properties;
import javax.sql.DataSource;

import com.studentcertificate.service.CertificateService;
import com.studentcertificate.service.CertificateServiceImpl;
import com.studentcertificate.service.StudentService;
import com.studentcertificate.service.StudentServiceImpl;
import com.studentcertificate.service.UserService;
import com.studentcertificate.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement
public class DBConfiguration {
    @Value("${db.driver}")
    private String DRIVER;
    @Value("${db.password}")
    private String PASSWORD;
    @Value("${db.url}")
    private String URL;
    @Value("${db.username}")
    private String USERNAME;
    @Value("${hibernate.dialect}")
    private String DIALECT;
    @Value("${hibernate.show_sql}")
    private String SHOW_SQL;
    @Value("${hibernate.hbm2ddl.auto}")
    private String HBM2DDL_AUTO;
    @Value("${entitymanager.packagesToScan}")
    private String PACKAGES_TO_SCAN;
    @Value("${hibernate.enable_lazy_load_no_trans}")
    private String enable_lazy_load_no_trans;
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(PACKAGES_TO_SCAN);
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", DIALECT);
        hibernateProperties.put("hibernate.show_sql", SHOW_SQL);
        hibernateProperties.put("hibernate.hbm2ddl.auto", HBM2DDL_AUTO);
        // hibernateProperties.put("hibernate.enable_lazy_load_no_trans",enable_lazy_load_no_trans);
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }
    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
    @Bean
    public CertificateService certificateService(){
        return new CertificateServiceImpl();
    }
    @Bean
    public StudentService studentService(){
        return new StudentServiceImpl();
    }

}