package com.jpademo.demo.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpademo.demo.entity.Employee;
import com.jpademo.demo.model.EmployeeDTO;
import com.jpademo.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@PostMapping(path="/employees")
	public ResponseEntity<?> saveEmployees(@RequestBody EmployeeDTO employeeDto){
		employeeService.saveEmployee(employeeDto);
		return ResponseEntity.ok("Employee is saved");
	};
	
	@GetMapping(path = "/employees/{employeeId}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable ("employeeId") BigInteger employeeId){
		EmployeeDTO employeeDTO = employeeService.getEmployee(employeeId);
		return ResponseEntity.ok(employeeDTO);
	}
	
	@PutMapping(path= "/employees/{employeeId}")
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable ("employeeId") BigInteger employeeId){
		
		employeeService.updateEmployee(employeeId, employeeDTO);
		return ResponseEntity.ok("Employee is updated");
	}
	
}
