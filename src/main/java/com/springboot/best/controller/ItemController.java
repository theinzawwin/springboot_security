package com.springboot.best.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.best.dao.ItemRepository;
import com.springboot.best.dto.ItemDTO;
import com.springboot.best.dto.ItemNameAndQtyDTO;
import com.springboot.best.model.Item;
import com.springboot.best.services.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	@PostMapping("/save_item")
	public ResponseEntity<?> saveItem(@RequestBody ItemDTO item){
		itemService.save(item);
		return ResponseEntity.status(HttpStatus.CREATED).body(true);
	}
	@GetMapping("/items")
	public ResponseEntity<List<ItemDTO>> findAllItem(){
		return ResponseEntity.status(HttpStatus.OK).body(itemService.findAll());
	}
	@GetMapping("/items/name_and_qty")
	public ResponseEntity<List<ItemNameAndQtyDTO>> findAllNameAndQty(){
		return ResponseEntity.status(HttpStatus.OK).body(itemService.findItemNameQtyList());
	}
	@DeleteMapping("/items/{id}")
	public ResponseEntity<?> deleteById(@PathVariable(value = "id") Long id){
		itemService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("successfully deleted");
	}
	@PostMapping("/item_param_save")
	public ResponseEntity<?> itemSave(@RequestParam(value="itemName")String name,@RequestParam(value="itemPrice")Double price,@RequestParam(value="itemQty") int qty){
		ItemDTO item=new ItemDTO(name, qty, price);
		itemService.save(item);
		return ResponseEntity.status(HttpStatus.CREATED).body(true);
	}
	
}
