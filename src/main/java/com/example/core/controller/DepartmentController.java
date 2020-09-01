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

import com.example.core.domain.Department;
import com.example.core.service.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired(required = true)
	DepartmentService departmentService;

	@GetMapping(value = "/departmentList")
	public List<Department> getDepartments() {
		return departmentService.findAll();
	}

	@GetMapping(value = "/department")
	public Optional<Department> getDepartmentsById(@RequestBody Department dep) {
		return departmentService.findById(dep);
	}
	
	@PostMapping(value = "/createDep")
	public Department createDepartment(@RequestBody Department dep) {
		return departmentService.insertDepartment(dep);
	}
	
	@PutMapping(value = "/updateDep")
	public Department updateDepartment(@RequestBody Department dep) {
		return departmentService.updateDepartment(dep);
	}

	@DeleteMapping(value = "/deleteDepById")
	public void deleteDepartment(@RequestBody Department dep) {
		departmentService.deleteDepartment(dep);
	}

}
