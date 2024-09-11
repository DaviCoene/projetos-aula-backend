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

import br.com.julio.model.Person;
import br.com.julio.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices services;
	
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(
			@PathVariable(value = "id") Long id) throws Exception {
		return services.findById(id);
	}	
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() throws Exception {
		return services.findAll();
	}	
	
	@RequestMapping(method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)			
	public Person create(@RequestBody Person person) throws Exception {
		return services.create(person);
	}
	
	@RequestMapping(method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)			
	public Person update(@RequestBody Person person) throws Exception {
		return services.update(person);
	}	
	
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {		
		services.delete(id);
		return ResponseEntity.noContent().build();
	}	
}
