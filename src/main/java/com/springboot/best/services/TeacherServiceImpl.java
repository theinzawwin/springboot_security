package com.springboot.best.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.best.dao.TeacherRepository;
import com.springboot.best.dto.TeacherDTO;
import com.springboot.best.services.mapper.TeacherConverter;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherRepository teacherRepository;
	@Override
	public void save(TeacherDTO dto) {
		// TODO Auto-generated method stub
		teacherRepository.save(TeacherConverter.toEntity(dto));
	}

	@Override
	public List<TeacherDTO> getTeacherList() {
		// TODO Auto-generated method stub
		return teacherRepository.findAll().stream().map(TeacherConverter::toDTO).collect(Collectors.toList());
	}

	@Override
	public List<TeacherDTO> getTeacherListByDepartment(Long id) {
		// TODO Auto-generated method stub
		return teacherRepository.findAll().stream().map(TeacherConverter::toDTO).filter(d->d.getDepartmentId()==id).collect(Collectors.toList());
	}

	@Override
	public TeacherDTO findById(Long id) {
		// TODO Auto-generated method stub
		return TeacherConverter.toDTO(teacherRepository.findById(id).get());
	}

}
