package com.ducat.springboot.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducat.springboot.rest.dao.MyEmpDaoRepositry;
import com.ducat.springboot.rest.exception.RecordNotFoundException;
import com.ducat.springboot.rest.model.EmployeeEntity;

@Service
public class EmployeeService {
	@Autowired
	MyEmpDaoRepositry repository;

	public List<EmployeeEntity> getAllEmployees() {
		List<EmployeeEntity> employeeList = repository.findAll();
		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<EmployeeEntity>();
		}
	}

	public EmployeeEntity getEmployeeById(int id) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = repository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No Employee Record Exist For Given " + id);
		}
	}

	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws RecordNotFoundException {
		Optional<EmployeeEntity> emp = repository.findById(entity.getId());
		if (emp.isPresent()) {
			EmployeeEntity newEntity = emp.get();
			newEntity.setEmail(entity.getEmail());
			newEntity.setFirstName(entity.getFirstName());
			newEntity.setLastName(entity.getLastName());
			newEntity = repository.save(newEntity);
			return newEntity;
		} else {
			entity = repository.save(entity);
			return entity;
		}

	}

	public void deleteEmployeeById(int id) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = repository.findById(id);

		if (employee.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given " + id);
		}
	}

}
