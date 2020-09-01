package com.example.core.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.core.domain.Employee;
import com.example.core.repository.EmployeeRepository;
import com.example.core.service.EmpService;
import com.example.utils.CSVHelper;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmployeeRepository employeeRepositor;

	@Override
	public List<Employee> findAll() {
		return employeeRepositor.findAll();
	}

	@Override
	public Employee insertEmployee(Employee emp) {
		return employeeRepositor.save(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		return employeeRepositor.save(emp);
	}

	@Override
	public void deleteEmployee(Employee emp) {
		employeeRepositor.delete(emp);
	}

	@Override
	public Optional<Employee> findById(Employee emp) {
			return employeeRepositor.findById(emp.getId());
	}

	@Override
	public void uploadCSVFile(MultipartFile file) {
		 try {
		      List<Employee> employees = CSVHelper.csvToEmployees(file.getInputStream());
		      employeeRepositor.saveAll(employees);
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store csv data: " + e.getMessage());
		    }		
	}
	
	
}
