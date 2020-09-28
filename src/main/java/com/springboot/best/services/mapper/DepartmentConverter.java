package com.springboot.best.services.mapper;

import com.springboot.best.dto.DepartmentDTO;
import com.springboot.best.model.Department;

public class DepartmentConverter {

	public static Department toEntity(DepartmentDTO dto) {
		Department d=new Department();
		if(dto.getId()!=null) {
			d.setId(dto.getId());
		}
		d.setName(dto.getName());
		return d;
	}
	
	public static DepartmentDTO toDTO(Department dept) {
		DepartmentDTO dto=new DepartmentDTO();
		dto.setId(dept.getId());
		dto.setName(dept.getName());
		return dto;
	}
}
