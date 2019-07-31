package com.example.core.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core.domain.Emp;
import com.example.core.repository.EmpDao;
import com.example.core.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDao empDao;
	@Override
	public int saveEmp(Emp emp) {
		return empDao.saveEmp(emp);
	}

	
}
