package com.spring.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.spring" })
public class beanConfig {

	@Bean
	public DataSource getDataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("devuser");
		ds.setPassword("pwd2");
		return ds;
	}

	/*
	 * LocalSessionFactoryBean Needs the below 3 objects to function DataSource
	 * HibernateProperties Annotated Class
	 */
	@Bean
	public SessionFactory getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		// DataSource
		factoryBean.setDataSource(getDataSource());
		Properties props = new Properties();
		// Setting Hibernate properties
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		factoryBean.setHibernateProperties(props);
		// Annotated Class
		factoryBean.setPackagesToScan("com.spring.model");

		try {
			factoryBean.afterPropertiesSet(); /* this method  builds and exposes the session factory. */
		} catch (IOException e) {
			e.printStackTrace();
		}

		return factoryBean.getObject();

	}

	@Bean
	public HibernateTemplate getHibernateTemplate() {

		HibernateTemplate hibernateTempalate = new HibernateTemplate();

		hibernateTempalate.setSessionFactory(getSessionFactory());
		return hibernateTempalate;

	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory());
		return transactionManager;
	}

}
