package com.practice.demo.mapper;

import org.mapstruct.Mapper;
import com.practice.demo.dto.DoctorDto;
import com.practice.demo.entity.Doctor;

@Mapper(componentModel="spring")
public interface DoctorMapper {
	DoctorDto toDto(Doctor doctor);
}
	

