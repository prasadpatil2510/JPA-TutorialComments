package com.jpademo.demo.service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpademo.demo.entity.Employee;
import com.jpademo.demo.model.EmployeeDTO;
import com.jpademo.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public void saveEmployee(EmployeeDTO employeeDTO) {
		Employee employee = convertEmployeeDTOToEmployeeEntity(employeeDTO);
		employeeRepository.save(employee);//entering into DB
		
	}
	
	private Employee convertEmployeeDTOToEmployeeEntity(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setGender(employeeDTO.getGender());
		employee.setDob(employeeDTO.getDob());
		employee.setCreatedBy(1);
		employee.setCreatedTz(new Timestamp(System.currentTimeMillis()));
		employee.setModifiedBy(1);
		employee.setModifiedTz(new Timestamp(System.currentTimeMillis()));
		return employee;
	}
	
	
//	GET PART
	private EmployeeDTO convertEmployeeEntittyToEmployeeDTO(Employee employeeEntity) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setFirstName(employeeEntity.getFirstName());
		employeeDTO.setLastName(employeeEntity.getLastName());
		employeeDTO.setGender(employeeEntity.getGender());
		employeeDTO.setDob(employeeEntity.getDob());
//		employee.setCreatedBy(1);
//		employee.setCreatedTz(new Timestamp(System.currentTimeMillis()));
//		employee.setModifiedBy(1);
//		employee.setModifiedTz(new Timestamp(System.currentTimeMillis()));
		return employeeDTO;
	}
	
	

	public EmployeeDTO getEmployee(BigInteger employeeId)	 {
		// TODO Auto-generated method stub
		Optional<Employee> employeeEntityOptional = this.employeeRepository.findById(employeeId);
		EmployeeDTO employeeDTO = convertEmployeeEntittyToEmployeeDTO(employeeEntityOptional.get());
		return employeeDTO;
	}

	public void updateEmployee(BigInteger employeeID, EmployeeDTO employeeDTO) {
		Optional<Employee> optionalEmployeeEntity = employeeRepository.findById(employeeID);
		if(optionalEmployeeEntity.isPresent()) {
			Employee employeeEntity = optionalEmployeeEntity.get();
			employeeEntity = convertEmployeeDTOToEmployeeEntity(employeeEntity, employeeDTO);
			employeeEntity = employeeRepository.save(employeeEntity);
		}else {
			System.out.println("Exception to be thrown");
		}
	}
	
	private Employee convertEmployeeDTOToEmployeeEntity(Employee employeeEntity, EmployeeDTO employeeDTO) {
		employeeEntity.setFirstName(employeeDTO.getFirstName());
		employeeEntity.setLastName(employeeDTO.getLastName());
		employeeEntity.setGender(employeeDTO.getGender());
		employeeEntity.setDob(employeeDTO.getDob());
		return employeeEntity;
	}
	
}
