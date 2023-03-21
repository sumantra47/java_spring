package spring.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//Method 1 --------
//@Component // add spring spring-webmvc depencies in pom.xml
//Method 1 --------


public class Student {
	
	// DI
	private Subject subject;
	
	
	public Student(Subject subject) {
		super();
		this.subject = subject;
	}



	public Subject getSubject() {
		return subject;
	}



	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	
	@Value("sumantra")
	private String name;
	@Value("kolkata")
	private String city;
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", city=" + city + "]";
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
