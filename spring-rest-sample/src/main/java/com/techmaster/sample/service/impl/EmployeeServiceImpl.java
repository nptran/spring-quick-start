package com.techmaster.sample.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techmaster.sample.model.Employee;
import com.techmaster.sample.repository.EmployeeRepository;
import com.techmaster.sample.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository repository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		repository.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<Employee> getOneEmployee(Long id) {
		return repository.findById(id);
	}


}
