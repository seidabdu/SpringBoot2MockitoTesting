package com.springexamples.rest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springexamples.rest.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository <Employee, Long> 
{
	 
}
