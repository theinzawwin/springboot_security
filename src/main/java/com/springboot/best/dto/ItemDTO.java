package com.springboot.best.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemDTO implements Serializable{

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
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemQty() {
		return itemQty;
	}
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
	public Double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	@JsonProperty("iname")
	private String itemName;
	private int itemQty;
	private Double itemPrice;
	
	public ItemDTO() {}
	public ItemDTO(String itemName, int itemQty, Double itemPrice) {
		super();
		this.itemName = itemName;
		this.itemQty = itemQty;
		this.itemPrice = itemPrice;
	}
	
}
