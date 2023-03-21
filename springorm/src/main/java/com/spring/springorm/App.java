package com.spring.springorm;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.config.beanConfig;
import com.spring.dao.EmployeeDao;
import com.spring.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//Method ---2
        ApplicationContext context = new AnnotationConfigApplicationContext(beanConfig.class);
        EmployeeDao empDao = context.getBean("employeeDaoImpl",EmployeeDao.class);
        // Insert query
//        Employee e1 = new Employee(1201,"Arunima",(float) 34578.20,"IT");
//        int result = empDao.insert(e1);
       
        //System.out.println("Number of Insert : "+result);
        System.out.println(empDao.getEmployee(1200));
        
//        List<Employee> empList = empDao.getAllEmployee();
//        empList.forEach(e-> System.out.println(e));
//        
    }
}
