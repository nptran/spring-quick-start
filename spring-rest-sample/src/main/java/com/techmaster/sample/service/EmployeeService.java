package com.techmaster.sample.service;

import java.util.List;
import java.util.Optional;

import com.techmaster.sample.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	Optional<Employee> getOneEmployee(Long id);

	void saveEmployee(Employee employee);
	
	void deleteEmployee(Long id);

}
