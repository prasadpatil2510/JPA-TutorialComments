package com.jpademo.demo.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jpademo.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, BigInteger> {


}

