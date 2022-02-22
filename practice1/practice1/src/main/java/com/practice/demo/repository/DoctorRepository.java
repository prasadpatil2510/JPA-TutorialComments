package com.practice.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.entity.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer > {

}
