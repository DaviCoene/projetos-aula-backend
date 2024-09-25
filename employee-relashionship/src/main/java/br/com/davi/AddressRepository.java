package br.com.davi;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.davi.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
