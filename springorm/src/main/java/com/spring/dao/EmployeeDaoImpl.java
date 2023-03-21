package com.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.spring.model.Employee;

//Method ---2 using Component Scan
@Component
//Method---2 ----
public class EmployeeDaoImpl implements EmployeeDao {

	// Method ---2----
	@Autowired
	// Method ---2---
	private HibernateTemplate hibernatetemplate;

	public HibernateTemplate getHibernatetemplate() {
		return hibernatetemplate;
	}

	public void setHibernatetemplate(HibernateTemplate hibernatetemplate) {
		this.hibernatetemplate = hibernatetemplate;
	}

	@Override
	@Transactional /* used only for write operation */
	public int insert(Employee Emp) {
		// TODO Auto-generated method stu
		int result = (int)this.hibernatetemplate.save(Emp);
		return result;
	}

	// Using Row Mapper for single return object
	@Override
	public Employee getEmployee(int empId) {
		// fetch single employee data
		Employee emp = this.hibernatetemplate.get(Employee.class, empId);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// fetch all employee
		List<Employee> empList = this.hibernatetemplate.loadAll(Employee.class);
		
		return empList;
	}

	@Override
	@Transactional
	public void delete(int empId) {
		// TODO Auto-generated method stub
		Employee emp = this.hibernatetemplate.get(Employee.class, empId);
		this.hibernatetemplate.delete(emp);
		
	}

	@Override
	@Transactional
	public void update(Employee emp) {
		// TODO Auto-generated method stub
		this.hibernatetemplate.update(emp);
		
	}

}
