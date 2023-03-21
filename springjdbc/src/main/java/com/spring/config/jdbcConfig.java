package com.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.dao.EmployeeDao;
import com.spring.dao.EmployeeDaoImpl;

@Configuration
public class jdbcConfig {
	// DriverManagerDataSource -- implements DataSource Interface internally
	@Bean
	public DataSource getDataSource(){
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("devuser");
		ds.setPassword("pwd2");
		return ds;
	}
	
	// Jdbctemplate class looks for datasource to connect to db
	@Bean
	public JdbcTemplate getjdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	// to set up jdbctemplate in employee class to insert data
	@Bean
	public EmployeeDao getEmployeeDao() {
		
		EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
		employeeDao.setJdbctemplate(getjdbcTemplate());
		return employeeDao;
		
	}
	

}
