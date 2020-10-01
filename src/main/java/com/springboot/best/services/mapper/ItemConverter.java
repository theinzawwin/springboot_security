package com.springboot.best.services.mapper;

import com.springboot.best.dto.ItemDTO;
import com.springboot.best.dto.ItemNameAndQtyDTO;
import com.springboot.best.model.Item;

public class ItemConverter {

	public static Item toEntity(ItemDTO dto) {
		Item e=new Item();
		if(dto.getId()!=null) {
			e.setId(dto.getId());
		}
		e.setName(dto.getItemName());
		e.setPrice(dto.getItemPrice());
		e.setQty(dto.getItemQty());
		
		return e;
	}
	
	public static ItemDTO toDto(Item e) {
		ItemDTO d=new ItemDTO();
		d.setId(e.getId());
		d.setItemName(e.getName());
		d.setItemPrice(e.getPrice());
		d.setItemQty(e.getQty());
		return d;
	}
	
	public static ItemNameAndQtyDTO toDtoForNameAndQty(Item e) {
		ItemNameAndQtyDTO d=new ItemNameAndQtyDTO();
		
		d.setName(e.getName());
		
		d.setQty(e.getQty());
		return d;
	}
	
}
