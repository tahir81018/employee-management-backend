package com.employeemanagement.services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import com.employeemanagement.entities.Employee;
import com.employeemanagement.enums.Status;
import com.employeemanagement.models.Response;
import com.employeemanagement.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	// Declarations

	@Autowired
	EmployeeRepository employeeRepository;

	// Methods

	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).orElseThrow();
	}

	public Response saveEmployee(Employee employee) {
		try {
			employee.setTotalBilled(employee.getMonthlyRate() * employee.getMonthsWorked());

			employeeRepository.save(employee);
			return new Response(Status.SUCCESS, "Employee has been successfully updated");

		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalError("Internal Server Error");
		}
	}

	public Response deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
		return new Response(Status.SUCCESS, "Employee has been removed");
	}

}
