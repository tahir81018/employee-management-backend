package com.employeemanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.entities.Employee;
import com.employeemanagement.models.Response;
import com.employeemanagement.services.EmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
@CrossOrigin(value = "*")
public class EmployeeController {

	// declarations

	@Autowired
	EmployeeService employeeService;

	// methods

	@GetMapping("")
	public ResponseEntity<List<Employee>> getEmployees() {
		return ResponseEntity.ok(employeeService.getEmployees());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}

	@PostMapping("")
	public ResponseEntity<Response> saveEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.saveEmployee(employee));
	}

	@PutMapping("")
	public ResponseEntity<Response> updateEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.saveEmployee(employee));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteEmployeeById(@PathVariable int id) {
		return ResponseEntity.ok(employeeService.deleteEmployeeById(id));
	}

}
