package spring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.demo.model.Student;
import spring.demo.model.StudentAuto;
import spring.demo.model.Subject;

@Configuration
public class BeanConfig {
	
	//Method 2 using Bean----
	
		@Bean
		public Subject getSubject() {
			System.out.println("Call from here");
			return new Subject();
			
		}
	
	
//		@Bean
//		public Student getStudent() {
//			
//			Student student = new Student(getSubject());
//			
//			return student;
//		}
		
		@Bean
		public StudentAuto getStudentAuto() {
			
			StudentAuto studentAuto = new StudentAuto();
			return studentAuto;
		}
	//Method 2------------

}
