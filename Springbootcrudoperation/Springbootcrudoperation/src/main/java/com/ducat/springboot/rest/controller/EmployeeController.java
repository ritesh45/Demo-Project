package com.ducat.springboot.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.springboot.rest.exception.RecordNotFoundException;
import com.ducat.springboot.rest.model.Employee;
import com.ducat.springboot.rest.model.EmployeeEntity;
import com.ducat.springboot.rest.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@RequestMapping(value = "/emp/all", method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
		List<EmployeeEntity> list = service.getAllEmployees();
		System.out.println("List "+list);
		return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") int id) throws RecordNotFoundException {
		EmployeeEntity entity = service.getEmployeeById(id);

		return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/emp/add", method = RequestMethod.POST)
	public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(@RequestBody EmployeeEntity emp)
			throws RecordNotFoundException {
		EmployeeEntity updated = service.createOrUpdateEmployee(emp);
		return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/emp/delete/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteEmployeeById(@PathVariable("id") int id) throws RecordNotFoundException {
		service.deleteEmployeeById(id);
		return HttpStatus.FORBIDDEN;
	}

}
