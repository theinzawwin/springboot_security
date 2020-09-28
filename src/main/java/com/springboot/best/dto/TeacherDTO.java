package com.springboot.best.dto;

import java.io.Serializable;

public class TeacherDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNrc() {
		return nrc;
	}
	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	private String name;
	private String nrc;
	private String phone;
	private String email;
	private String departmentName;
	private Long departmentId;
	public TeacherDTO() {}
	public TeacherDTO(Long id, String name, String nrc, String phone, String email,
			Long departmentId) {
		super();
		this.id = id;
		this.name = name;
		this.nrc = nrc;
		this.phone = phone;
		this.email = email;
		
		this.departmentId = departmentId;
	}
	public TeacherDTO(Long id, String name, String nrc, String phone, String email, String departmentName,
			Long departmentId) {
		super();
		this.id = id;
		this.name = name;
		this.nrc = nrc;
		this.phone = phone;
		this.email = email;
		this.departmentName = departmentName;
		this.departmentId = departmentId;
	}
	
	
}
