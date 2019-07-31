package com.example.core.service;

import org.springframework.stereotype.Component;

import com.example.core.domain.Emp;
@Component
public interface EmpService {

	public int saveEmp(Emp emp);

}
