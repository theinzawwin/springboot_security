package com.springboot.best.services;

import java.util.List;

import com.springboot.best.dto.TeacherDTO;
import com.springboot.best.dto.TeacherNameAndDeptNameDTO;

public interface TeacherService {

	void save(TeacherDTO dto);
	List<TeacherDTO> getTeacherList();
	List<TeacherDTO> getTeacherListByDepartment(Long id);
	TeacherDTO findById(Long id);
	List<TeacherNameAndDeptNameDTO> findTeacherNameAndDeptName();
}
