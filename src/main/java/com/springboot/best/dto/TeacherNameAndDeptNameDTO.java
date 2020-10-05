package com.springboot.best.dto;

import java.io.Serializable;

public class TeacherNameAndDeptNameDTO implements Serializable{

	private String teacherName;
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	private String deptName;
	public TeacherNameAndDeptNameDTO(String teacherName, String deptName) {
		super();
		this.teacherName = teacherName;
		this.deptName = deptName;
	}
	public TeacherNameAndDeptNameDTO() {}
	
}
