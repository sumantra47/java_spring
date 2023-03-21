package com.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.model.Employee;

//Method ---2 using Component Scan
@Component
//Method---2 ----
public class EmployeeDaoImpl implements EmployeeDao {

	// Method ---2----
	@Autowired
	// Method ---2---
	private JdbcTemplate jdbctemplate;

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public int insert(Employee Emp) {
		// TODO Auto-generated method stu
		String query = "INSERT INTO EMPLOYEE(EMPID,EMPNAME,SALARY,DEPT) VALUES(?,?,?,?)";
		int result = this.jdbctemplate.update(query, Emp.getEmpId(), Emp.getEmpName(), Emp.getEmpSalary(),
				Emp.getEmpDept());
		return result;
	}

	// Using Row Mapper for single return object
	@Override
	public Employee getEmployee(int empId) {
		// fetch single employee data
		String query = "SELECT * FROM EMPLOYEE WHERE EMPID =?";
		RowMapperImpl rowMapper = new RowMapperImpl();
		// use queryForObject for single object return
		Employee emp = this.jdbctemplate.queryForObject(query, rowMapper, empId);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// fetch all employee
		String query = "SELECT * FROM EMPLOYEE";
		//
		
		RowMapperImpl rowMapper = new RowMapperImpl();
		List<Employee> empList = this.jdbctemplate.query(query,new RowMapperImpl());
		
		return empList;
	}

}
