package com.springboot.best.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.best.controller.DepartmentController;
import com.springboot.best.dao.DepartmentRepository;
import com.springboot.best.dto.DepartmentDTO;
import com.springboot.best.model.Department;
import com.springboot.best.services.mapper.DepartmentConverter;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Override
	public void saveDepartment(DepartmentDTO dto) {
		// TODO Auto-generated method stub
		Department d=DepartmentConverter.toEntity(dto);
		departmentRepository.save(d);
	}

	@Override
	public List<DepartmentDTO> getDepartmentList() {
		// TODO Auto-generated method stub
		List<DepartmentDTO> deptList=departmentRepository.findAll().stream().map(DepartmentConverter::toDTO).collect(Collectors.toList());
		return deptList;
	}

	@Override
	public DepartmentDTO findById(Long id) {
		// TODO Auto-generated method stub
		DepartmentDTO dto=DepartmentConverter.toDTO(departmentRepository.findById(id).get());
		return dto;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(id);
	}

}
