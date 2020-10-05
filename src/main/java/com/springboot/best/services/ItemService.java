package com.springboot.best.services;

import java.util.List;

import com.springboot.best.dto.ItemDTO;
import com.springboot.best.dto.ItemNameAndQtyDTO;

public interface ItemService {

	void save(ItemDTO dto);
	List<ItemDTO> findAll();
	ItemDTO findById(Long id);
	void delete(Long id);
	ItemDTO findItemByIdForCriteria(Long id);
 List<ItemNameAndQtyDTO> findItemNameQtyList();
}
