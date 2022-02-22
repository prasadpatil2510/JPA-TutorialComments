package com.jpademo.demo.entity;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Table(name ="employees")
@Entity
@Data
public class Employee {

	@Id
	@SequenceGenerator(name = "employee_id_seq", sequenceName = "employee_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_seq")
	private BigInteger id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	private String dob;
	
	private String gender;
	
	@Column(name="created_by")
	private Integer createdBy;
	
	@Column(name="modified_by")
	private Integer modifiedBy;
	
	@Column(name="created_tz")
	private Timestamp createdTz;
	
	@Column(name="modified_tz")
	private Timestamp modifiedTz;
	
}
