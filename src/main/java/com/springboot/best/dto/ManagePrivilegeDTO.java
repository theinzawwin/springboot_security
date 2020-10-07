package com.springboot.best.dto;

import java.io.Serializable;
import java.util.List;



public class ManagePrivilegeDTO implements Serializable {
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<PrivilegeChoiceDTO> getPrivilegeList() {
		return privilegeList;
	}
	public void setPrivilegeList(List<PrivilegeChoiceDTO> privilegeList) {
		this.privilegeList = privilegeList;
	}
	private Long userId;
	private List<PrivilegeChoiceDTO> privilegeList;

}
