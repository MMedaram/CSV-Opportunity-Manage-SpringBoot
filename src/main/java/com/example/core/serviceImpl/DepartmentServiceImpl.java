package com.example.core.serviceImpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core.domain.Department;
import com.example.core.repository.DepartmentRepository;
import com.example.core.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	@Override
	public Department insertDepartment(Department dep) {
		return departmentRepository.save(dep);
	}

	@Override
	public Department updateDepartment(Department dep) {
		return departmentRepository.save(dep);
	}

	@Override
	public void deleteDepartment(Department dep) {
		departmentRepository.delete(dep);
	}

	@Override
	public Optional<Department> findById(Department dep) {
			return departmentRepository.findById(dep.getId());
	}

}
