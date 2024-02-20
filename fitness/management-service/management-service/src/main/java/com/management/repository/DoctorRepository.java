package com.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.management.entity.Doctor;
import com.management.entity.Trainer;
import com.management.entity.User;

@EnableJpaRepositories
public interface DoctorRepository  extends JpaRepository<Doctor, Long> {

	

	

	Doctor findByName(String doctorName);

}
