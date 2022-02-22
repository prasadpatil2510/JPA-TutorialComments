package com.practice.demo.mapperimpl;

import org.springframework.stereotype.Component;

import com.practice.demo.dto.DoctorDto;
import com.practice.demo.entity.Doctor;
import com.practice.demo.mapper.DoctorMapper;

@Component
public class DoctorMapperImpl implements DoctorMapper{
	
	@Override
	public DoctorDto toDto(Doctor doctor) {
		if(doctor == null) {
			return null;
		}
		
		DoctorDto doctorDto = new DoctorDto();
		doctorDto.setId(doctor.getId());
		doctorDto.setName(doctor.getName());
		doctorDto.setAge(doctor.getAge());
		return doctorDto;
	}
}
