package com.springboot.best.dto;

public class BookNameAndTitleDTO {

	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	private String title;
	public BookNameAndTitleDTO(String name, String title) {
		super();
		this.name = name;
		this.title = title;
	}
	public BookNameAndTitleDTO() {}
	
}
