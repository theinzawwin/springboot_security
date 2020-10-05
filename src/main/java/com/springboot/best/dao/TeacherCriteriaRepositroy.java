package com.springboot.best.dao;

import java.util.List;

import com.springboot.best.dto.TeacherNameAndDeptNameDTO;

public interface TeacherCriteriaRepositroy {

	
	List<TeacherNameAndDeptNameDTO> getTeacherNameAndDeptList();
	//List<TeacherNameAndDeptNameDTO> getTeacherListByDepartmentCriteria(Long deptId);
	
}
