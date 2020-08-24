package com.example.core.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.core.domain.Employee;
import com.example.core.service.EmpService;

@RestController
@RequestMapping("/api")
public class EmpController {

	@Autowired(required = true)
	EmpService employeeService;

	@GetMapping(value = "/employeeList")
	public List<Employee> getEmployees() {
		return employeeService.findAll();
	}

	@GetMapping(value = "/employee")
	public Optional<Employee> getEmployeesById(@RequestBody Employee emp) {
		return employeeService.findById(emp);
	}
	
	@PostMapping(value = "/createEmp")
	public Employee createEmployee(@RequestBody Employee emp) {
		return employeeService.insertEmployee(emp);
	}
	
	@PutMapping(value = "/updateEmp")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return employeeService.updateEmployee(emp);
	}

	@DeleteMapping(value = "/deleteEmpById")
	public void deleteEmployee(@RequestBody Employee emp) {
		employeeService.deleteEmployee(emp);
	}

}
