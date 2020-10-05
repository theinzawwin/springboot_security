package com.springboot.best.dao;

import java.util.List;

import com.springboot.best.model.Item;

public interface ItemCustomCriteriaRepository {

	List<Item> findItemList();
	List<Item> findItemListByQuery();
	Item findItemById(Long id);
	
}
