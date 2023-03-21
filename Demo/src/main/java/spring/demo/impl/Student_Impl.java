package spring.demo.impl;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.demo.config.AppConfig;
import spring.demo.config.BeanConfig;
import spring.demo.model.Student;
import spring.demo.model.StudentAuto;

public class Student_Impl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//----------Using Method 1 ----
//		AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);
//		Student s1 = context.getBean("student",Student.class);
//		System.out.println(s1);

		
//---------- Using Method 2---------
		
//		ApplicationContext  context = new AnnotationConfigApplicationContext(BeanConfig.class);
//		Student s1 = context.getBean("getStudent",Student.class);
//		System.out.println(s1);
		
		
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		StudentAuto s1 = context.getBean("getStudentAuto", StudentAuto.class);
		//System.out.println(s1);
		
	}

}
