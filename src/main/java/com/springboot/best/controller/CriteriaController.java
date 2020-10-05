package com.springboot.best.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.best.dao.BookRepository;
import com.springboot.best.dto.BookNameAndTitleDTO;
import com.springboot.best.model.Book;

@RestController
@RequestMapping(value="/books")
public class CriteriaController {

	@Autowired
	private BookRepository bookRepository;
	

	
	@PostMapping("/save")
	public ResponseEntity<?> saveBook(@RequestBody Book book){
		Book b=bookRepository.save(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(b);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> findAllBookList(){
		return ResponseEntity.status(HttpStatus.OK).body(bookRepository.findAllBookByCriteria());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Book> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(bookRepository.findBookByIdCriteria(id));
	}
	@GetMapping("/find_by_title/{title}")
	public ResponseEntity<List<Book>> findAllBookByTitle(@PathVariable String title){
		
		List<Book> bookList=bookRepository.findAllBokkByTitleSimiler(title);
		return ResponseEntity.status(HttpStatus.OK).body(bookList);
	}
	@GetMapping("/book_name_author")
	public ResponseEntity<List<BookNameAndTitleDTO>> findBookAuthor(){
		
		//List<BookNameAndTitleDTO> bookList=bookRepository.findBookNameTitleTuple();//tuple //bookRepository.findBookNameTitle(); // for Object[]
		List<BookNameAndTitleDTO> bookList=bookRepository.findBookNameAndCategory();
		return ResponseEntity.status(HttpStatus.OK).body(bookList);
	}
	
}
