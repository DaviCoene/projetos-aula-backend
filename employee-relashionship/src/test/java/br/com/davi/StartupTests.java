package br.com.davi;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.davi.model.Address;
import br.com.davi.model.Department;
import br.com.davi.model.Employee;
import jakarta.transaction.Transactional;

@SpringBootTest
class StartupTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	Logger logger = Logger.getLogger(StartupTests.class.getName());

	@Test
	@Transactional
	void contextLoads() {
		var department = departmentRepository.findById(1L).orElseThrow();
		departmentRepository.deleteById(department.getId());
	}

	void teste1() {
		Employee employee = new Employee();
		employee.setFirstName("Davi");
		employee.setLastName("Rosa");
		employee.setGender("Homem");

		var newEmployee = employeeRepository.save(employee);

		Address address = new Address();

		address.setStreetName("898");
		address.setStreetNumber(6545);
		address.setZipCode("6545");

		var newAddress = addressRepository.save(address);

		newEmployee.setAddress(newAddress);
		employeeRepository.save(newEmployee);

	}

	void teste2() {
		Department department = new Department();

		department.setName("Engenharia");

		var newDepartment = departmentRepository.save(department);

		for (int i = 1; i <= 8; i++) {
			Employee employee = new Employee();
			employee.setFirstName("First name: " + i);
			employee.setLastName("First name: " + i);
			employee.setGender("Male");
			employee.setDepartment(newDepartment);
			employeeRepository.save(employee);
		}
	}

	void teste3() {
		var department = departmentRepository.findById(1L).orElseThrow();
		logger.info(department.getName());
		for (Employee e : (department.getEmployees())) {
			logger.info(e.getFirstName());
		}
		;

	}
}
