package com.example.core.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.core.domain.Emp;

@Repository
public class EmpDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int saveEmp(Emp emp) {
		
		 String query="INSERT INTO emp(name,address,designation,salary)VALUES('"+emp.getName()+"','"+emp.getAddress()+"','"+emp.getDesignation()+"','"+emp.getSalary()+"')";  
		 return jdbcTemplate.update(query);  
		}

}
