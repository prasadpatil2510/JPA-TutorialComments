package com.practice.demo.mapperimpl;

import org.springframework.stereotype.Component;

import com.practice.demo.dto.DoctorDto;
import com.practice.demo.entity.Doctor;
import com.practice.demo.mapper.DoctorDtoMapper;

@Component
public class DoctorDtoMapperImpl implements DoctorDtoMapper{

	public Doctor toEntity(DoctorDto doctorDto) {
		if(doctorDto == null) {
			return null;
		}
		
		Doctor doctor = new Doctor();
		doctor.setId(doctorDto.getId());
		doctor.setName(doctorDto.getName());
		doctor.setAge(doctorDto.getAge());
		return doctor;
	}
}
