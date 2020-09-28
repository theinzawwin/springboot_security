package com.springboot.best.services;

import java.util.List;

import com.springboot.best.dto.DepartmentDTO;

public interface DepartmentService {

	void saveDepartment(DepartmentDTO dto);
	List<DepartmentDTO> getDepartmentList();
	DepartmentDTO findById(Long id);
	void delete(Long id);
}
