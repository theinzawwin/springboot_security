package com.springboot.best.dao;

import java.util.List;

import com.springboot.best.dto.BookNameAndTitleDTO;
import com.springboot.best.model.Book;

public interface BookCriteriaRepository {

	List<Book> findAllBookByCriteria();
	
	Book findBookByIdCriteria(Long id);
	
	List<Book> findAllBokkByTitleSimiler(String title);
	
	List<BookNameAndTitleDTO> findBookNameTitle();
	List<BookNameAndTitleDTO> findBookNameTitleTuple();
	List<BookNameAndTitleDTO> findBookNameTitleBuilderConstruct();
	List<BookNameAndTitleDTO> findBookNameAndCategory();
}
