package com.example.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.core.domain.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
