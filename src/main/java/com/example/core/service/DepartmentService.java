package com.example.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.core.domain.Department;

@Component
public interface DepartmentService {
	
	public List<Department> findAll();
	
	public Optional<Department> findById(Department dep);

	public Department insertDepartment(Department dep);

	public Department updateDepartment(Department dep);

	public void deleteDepartment(Department dep);


}
