package com.example.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.core.domain.Employee;
@Component
public interface EmpService {


	public List<Employee> findAll();
	
	public Optional<Employee> findById(Employee emp);

	public Employee insertEmployee(Employee emp);

	public Employee updateEmployee(Employee emp);

	public void deleteEmployee(Employee emp);

	public void uploadCSVFile(MultipartFile file);


}
