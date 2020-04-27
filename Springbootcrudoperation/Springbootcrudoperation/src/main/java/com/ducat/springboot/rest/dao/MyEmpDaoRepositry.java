package com.ducat.springboot.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ducat.springboot.rest.model.EmployeeEntity;

@Repository
public interface MyEmpDaoRepositry extends JpaRepository<EmployeeEntity, Integer> {

}
