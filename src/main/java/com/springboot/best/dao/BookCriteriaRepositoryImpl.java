package com.springboot.best.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.springboot.best.dto.BookNameAndTitleDTO;
import com.springboot.best.model.Book;
import com.springboot.best.model.BookCategory;
//@Repository
public class BookCriteriaRepositoryImpl implements BookCriteriaRepository {
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Book> findAllBookByCriteria() {
		// TODO Auto-generated method stub
		 CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
	 
	        Root<Book> book = cq.from(Book.class);
	       /* Predicate authorNamePredicate = cb.equal(book.get("author"), authorName);
	        Predicate titlePredicate = cb.like(book.get("title"), "%" + title + "%");
	        cq.where(authorNamePredicate, titlePredicate);
	 			*/
	        TypedQuery<Book> query = em.createQuery(cq);
	        return query.getResultList();
	}
	@Override
	public Book findBookByIdCriteria(Long id) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<Book> cq=cb.createQuery(Book.class);
		 Root<Book> book = cq.from(Book.class);
		 Predicate idPred=cb.equal(book.get("id"), id);
		 cq.where(idPred);
		 TypedQuery<Book> query=em.createQuery(cq);
		return query.getSingleResult();
	}
	@Override
	public List<Book> findAllBokkByTitleSimiler(String title) {
		// TODO Auto-generated method stub
		 CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
	 
	        Root<Book> book = cq.from(Book.class);
	      // Predicate authorNamePredicate = cb.equal(book.get("author"), authorName);
	        Predicate titlePredicate = cb.like(book.get("title"), "%" + title + "%");
	        cq.where( titlePredicate);
	 		
	        TypedQuery<Book> query = em.createQuery(cq);
	        return query.getResultList();
	}
	@Override
	public List<BookNameAndTitleDTO> findBookNameTitle() {
		// TODO Auto-generated method stub
		 CriteriaBuilder cb = em.getCriteriaBuilder();
	       
	        CriteriaQuery<Object[]> q = cb.createQuery(Object[].class);
	        Root<Book> c = q.from(Book.class);
	        q.select(cb.array(c.get("name"), c.get("author")));
	        List<Object[]> results = em.createQuery(q).getResultList();
	        List<BookNameAndTitleDTO> resultList=new ArrayList<BookNameAndTitleDTO>();
	        /*for (Object[] result : results) {
	        	resultList.add(new BookNameAndTitleDTO((String)result[0], (String)result[1]));
	        }
	        */
	        resultList=results.stream().map(b->new BookNameAndTitleDTO((String)b[0], (String)b[1])).collect(Collectors.toList());
	        return resultList;
	}
	@Override
	public List<BookNameAndTitleDTO> findBookNameTitleTuple() {
		// TODO Auto-generated method stub
		 CriteriaBuilder cb = em.getCriteriaBuilder();
	       
	        CriteriaQuery<Tuple> q = cb.createTupleQuery();
	        Root<Book> c = q.from(Book.class);
	        q.select(cb.tuple(c.get("name"), c.get("author")));
	        List<Tuple> results = em.createQuery(q).getResultList();
	        List<BookNameAndTitleDTO> resultList=new ArrayList<BookNameAndTitleDTO>();
	        /*for (Object[] result : results) {
	        	resultList.add(new BookNameAndTitleDTO((String)result[0], (String)result[1]));
	        }
	        */
	        resultList=results.stream().map(b->new BookNameAndTitleDTO((String)b.get(0), (String)b.get(1))).collect(Collectors.toList());
	        return resultList;
	}
	@Override
	public List<BookNameAndTitleDTO> findBookNameTitleBuilderConstruct() {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
	       
        CriteriaQuery<BookNameAndTitleDTO> q = cb.createQuery(BookNameAndTitleDTO.class);
        Root<Book> c = q.from(Book.class);
        q.select(cb.construct(BookNameAndTitleDTO.class,
        	      c.get("name"), c.get("author")));
        List<BookNameAndTitleDTO> results = em.createQuery(q).getResultList();
        List<BookNameAndTitleDTO> resultList=new ArrayList<BookNameAndTitleDTO>();
        /*for (Object[] result : results) {
        	resultList.add(new BookNameAndTitleDTO((String)result[0], (String)result[1]));
        }
        */
       // resultList=results.stream().map(b->new BookNameAndTitleDTO((String)b.get(0), (String)b.get(1))).collect(Collectors.toList());
        return results;
	}
	@Override
	public List<BookNameAndTitleDTO> findBookNameAndCategory() {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
	       
        CriteriaQuery<BookNameAndTitleDTO> q = cb.createQuery(BookNameAndTitleDTO.class);
        Root<Book> c = q.from(Book.class);
        Join<Book,BookCategory> bc=c.join("bookCategory",JoinType.LEFT);
        q.select(cb.construct(BookNameAndTitleDTO.class,
        	      c.get("name"), bc.get("name")));
        List<BookNameAndTitleDTO> results = em.createQuery(q).getResultList();
        List<BookNameAndTitleDTO> resultList=new ArrayList<BookNameAndTitleDTO>();
        
        return results;
		
	}

}
