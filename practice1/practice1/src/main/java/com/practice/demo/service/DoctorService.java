package com.practice.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.practice.demo.dto.DoctorDto;
import com.practice.demo.entity.Doctor;
import com.practice.demo.mapper.DoctorMapper;
import com.practice.demo.mapperimpl.DoctorDtoMapperImpl;
import com.practice.demo.mapperimpl.DoctorMapperImpl;
import com.practice.demo.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	DoctorRepository doctorRepository;
	
	public void saveDoctor(DoctorDto doctorDto) {
		Doctor doctor = new DoctorDto();
		doctor.
		doctorRepository.save(doctor);
	}
	
	
}
