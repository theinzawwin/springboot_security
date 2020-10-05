package com.springboot.best.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.best.dao.ItemRepository;
import com.springboot.best.dto.ItemDTO;
import com.springboot.best.dto.ItemNameAndQtyDTO;
import com.springboot.best.model.Item;
import com.springboot.best.services.mapper.ItemConverter;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemRepository itemRepository;
	@Override
	public void save(ItemDTO dto) {
		// TODO Auto-generated method stub
		Item i=ItemConverter.toEntity(dto);
		itemRepository.save(i);
	}

	@Override
	public List<ItemDTO> findAll() {
		// TODO Auto-generated method stub
		List<Item> items=itemRepository.findAll();
		return items.stream().map(ItemConverter::toDto).collect(Collectors.toList());
	}

	@Override
	public ItemDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		itemRepository.deleteById(id);
	}
	
	public List<ItemNameAndQtyDTO> findItemNameQtyList(){
		List<Item> items=itemRepository.findAll();
		return items.stream().map(ItemConverter::toDtoForNameAndQty).collect(Collectors.toList());
	}

	@Override
	public ItemDTO findItemByIdForCriteria(Long id) {
		// TODO Auto-generated method stub
		return ItemConverter.toDto(itemRepository.findItemById(id));
	}

}
