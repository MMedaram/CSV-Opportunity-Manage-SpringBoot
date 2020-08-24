package com.example.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.core.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
}
