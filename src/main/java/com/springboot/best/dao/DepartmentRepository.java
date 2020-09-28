package com.springboot.best.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.best.model.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
