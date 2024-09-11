package br.com.julio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.julio.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
	
}
