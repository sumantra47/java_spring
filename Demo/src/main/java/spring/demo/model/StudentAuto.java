package spring.demo.model;

import org.springframework.beans.factory.annotation.Autowired;

public class StudentAuto {
	
	private String name;
	private String city;
	
	
	@Autowired
	private Subject subject;
	

	@Override
	public String toString() {
		return "StudentAuto [name=" + name + ", city=" + city + ", subject=" + subject + "]";
	}
	
	
//	public StudentAuto(String name, String city, Subject subject) {
//		super();
//		this.name = name;
//		this.city = city;
//		this.subject = subject;
//	}


	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
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
