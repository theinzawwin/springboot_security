package com.springboot.best.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.best.model.Teacher;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
