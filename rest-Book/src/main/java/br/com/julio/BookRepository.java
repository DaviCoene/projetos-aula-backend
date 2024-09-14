package br.com.julio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.julio.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
}
