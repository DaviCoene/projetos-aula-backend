package br.com.julio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julio.BookRepository;
import br.com.julio.exception.ResourceNotFoundException;
import br.com.julio.model.Book;

@Service
public class BookServices {


	private Logger logger = Logger.getLogger(BookServices.class.getName());
	
	@Autowired
	private BookRepository repository;
	
	
	public Book findById(Long id) {
		logger.info("Finding one book...");
		

		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found for id"));
	}
	
	public List<Book> findAll() {
		logger.info("Find all books...");
		
		
		return repository.findAll();
	}
	

	public Book create(Book book) {
		logger.info("Creating one book...");
		return repository.save(book);
	}
	
	public Book update(Book book) {
		logger.info("Updating one book...");
		var entity = findById(book.getId());
		
		entity.setTitle(book.getTitle());
		entity.setAuthor(book.getAuthor());
		entity.setISBN(book.getISBN());
		entity.setData(book.getData());
		
		
		
		
		return repository.save(entity);
	}	
	
	public void delete(Long id) {
		logger.info("Deleting one book...");
		
		var entity = findById(id);
		
		repository.delete(entity);
	}		
}
