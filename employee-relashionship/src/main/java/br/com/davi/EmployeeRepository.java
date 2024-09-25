package br.com.davi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.davi.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
