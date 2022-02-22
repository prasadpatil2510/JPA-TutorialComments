package com.practice.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.dto.DoctorDto;
import com.practice.demo.service.DoctorService;

@RestController
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	
	@PostMapping(path="/doctors")
	public ResponseEntity<?> saveDoctor(@RequestBody DoctorDto doctorDto){
		
		return null;
		
	}
}
