package com.healthservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthservice.entity.MedicalHistory;
import com.healthservice.entity.Nutrition;

public interface UserNutritionRepository extends JpaRepository<Nutrition, Integer> {
	List<Nutrition> findByUserName(String userName);
	}