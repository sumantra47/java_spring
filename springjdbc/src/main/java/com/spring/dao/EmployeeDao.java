package com.spring.dao;

import java.util.List;

import com.spring.model.Employee;



public interface EmployeeDao {
	
	public int insert(Employee Emp);
	
	public Employee getEmployee(int empId);
	
	public List<Employee> getAllEmployee();
	

}
