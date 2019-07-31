package com.example.core.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.core.domain.Emp;
import com.example.core.service.EmpService;


@RestController
@RequestMapping("/api")
public class EmpController {
	
	@Autowired(required=true)
	EmpService empService;
	
	@PostMapping(path = "/saveEmp")
	public int saveEmp(@Valid @RequestBody Emp emp) {
		return empService.saveEmp(emp);
	}

}
