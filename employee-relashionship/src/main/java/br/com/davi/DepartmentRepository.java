package br.com.davi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.davi.model.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
