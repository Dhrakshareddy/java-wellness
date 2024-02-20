package com.healthservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthservice.entity.Nutrition;



@Repository
public interface UserNutritionRepository extends JpaRepository<Nutrition, Integer>{

	

}
