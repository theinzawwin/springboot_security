package com.springboot.best.services.mapper;

import com.springboot.best.dto.TeacherDTO;
import com.springboot.best.model.Teacher;

public class TeacherConverter {

	public static Teacher toEntity(TeacherDTO dto) {
		
		Teacher t=new Teacher();
		if(dto.getId()!=null) {
			t.setId(dto.getId());
		}
		t.setName(dto.getName());
		t.setEmail(dto.getEmail());
		t.setPhone(dto.getPhone());
		t.setNrc(dto.getNrc());
		if(dto.getDepartmentId()!=null) {
			t.getDepartment().setId(dto.getDepartmentId());
		}
		return t;
	}
	public static TeacherDTO toDTO(Teacher t) {
		
		TeacherDTO dto=new TeacherDTO(t.getId(),t.getName(),t.getNrc(),t.getPhone(),t.getEmail(),t.getDepartment().getName(),t.getDepartment().getId());
		return dto;
	}
}
