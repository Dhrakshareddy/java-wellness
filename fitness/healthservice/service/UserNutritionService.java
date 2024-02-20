package com.healthservice.service;

import java.util.List;

import com.healthservice.bean.ResponseDto;
import com.healthservice.entity.MedicalHistory;
import com.healthservice.entity.Nutrition;

public interface UserNutritionService {

	Nutrition saveNewNutrition(Nutrition bean);

	ResponseDto getById(Integer nutritionId);

	List<Nutrition> getAllNutrition();

	Nutrition updateNutrition(Nutrition bean);

	void deleteById(Integer nutritionId);
	List<Nutrition> getNutrition(String userName);
	


}
