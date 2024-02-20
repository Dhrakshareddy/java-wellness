package com.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.management.entity.Trainer;

@EnableJpaRepositories
public interface TrainerRepository extends JpaRepository<Trainer, Long> {

	

	Trainer findByName(String name);

}
