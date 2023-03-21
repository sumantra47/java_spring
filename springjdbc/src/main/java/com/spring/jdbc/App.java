package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.config.jdbcConfig;
import com.spring.config.jdbcConfig1;
import com.spring.dao.EmployeeDao;
import com.spring.model.Employee;

//Select quickarchetype from org.maven.archetype
public class App 
{
    public static void main( String[] args )
    {
    	//Method ---1 
        //ApplicationContext context = new AnnotationConfigApplicationContext(jdbcConfig.class);
        
        //Method ---2
        ApplicationContext context = new AnnotationConfigApplicationContext(jdbcConfig1.class);
        EmployeeDao empDao = context.getBean("employeeDaoImpl",EmployeeDao.class);
        // Insert query
//        Employee e1 = new Employee(1201,"Arunima",(float) 34578.20,"IT");
//        int result = empDao.insert(e1);
       
        //System.out.println("Number of Insert : "+result);
        //System.out.println(empDao.getEmployee(1200));
        
        List<Employee> empList = empDao.getAllEmployee();
        empList.forEach(e-> System.out.println(e));
        
        
        
    }
}
