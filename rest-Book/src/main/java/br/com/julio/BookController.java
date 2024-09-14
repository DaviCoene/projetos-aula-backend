package br.com.julio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.julio.model.Book;
import br.com.julio.services.BookServices;

@RestController
@RequestMapping("/person")
public class BookController {

	@Autowired
	private BookServices services;
	
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Book findById(
			@PathVariable(value = "id") Long id) throws Exception {
		return services.findById(id);
	}	
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> findAll() throws Exception {
		return services.findAll();
	}	
	
	@RequestMapping(method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)			
	public Book create(@RequestBody Book book) throws Exception {
		return services.create(book);
	}
	
	@RequestMapping(method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)			
	public Book update(@RequestBody Book book) throws Exception {
		return services.create(book);
	}
	
	@RequestMapping(method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)			
	public ResponseEntity<?> delete(@RequestBody Long id) throws Exception {
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
