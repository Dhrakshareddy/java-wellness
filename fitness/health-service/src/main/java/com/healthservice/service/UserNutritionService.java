package com.healthservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthservice.entity.Nutrition;






@Service
public interface UserNutritionService {

	Nutrition saveNewNutrition(Nutrition bean);

	Nutrition getById(Integer nutritionId);

	List<Nutrition> getAllNutrition();

	Nutrition updateNutrition(Nutrition bean);

	void deleteById(Integer nutritionId);



}
