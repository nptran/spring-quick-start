package com.techmaster.sample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techmaster.sample.model.Employee;
import com.techmaster.sample.service.EmployeeService;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

	EmployeeService service;

	@Autowired
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAlleEmployees() {

		List<Employee> employees = service.getAllEmployees();

		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	@PostMapping("/employees/insert")
	public ResponseEntity<Void> insertEmployee(@RequestBody Employee employee) {
		if(!service.getOneEmployee(employee.getId()).isPresent()) {
			service.saveEmployee(employee);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
	}
	
	@PutMapping("/employees/update")
	public ResponseEntity<Employee> updateEmployee(@RequestParam Long id, @Valid Employee employee) {
		if(service.getOneEmployee(id).isPresent()) {
			service.saveEmployee(employee);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/employees/delete/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
		if(service.getOneEmployee(id) != null) {
			service.deleteEmployee(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
