package com.healthservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthservice.entity.Nutrition;
import com.healthservice.service.UserNutritionService;

import java.util.List;


@RestController
@RequestMapping("nutrition")
public class NutritionController {

	@Autowired
	UserNutritionService service;
	
	@PostMapping("/save")
	public Nutrition saveNewNutrition(@RequestBody Nutrition bean)
	{
		return service.saveNewNutrition(bean);
		
	}
	
	@GetMapping("/getById/{nutritionId}")
	public Nutrition getById(@PathVariable Integer nutritionId)
	{
		return service.getById(nutritionId);
	}
	
	@GetMapping("/getAll")
	public List<Nutrition> getAll()
	{
		return service.getAllNutrition();
	}
	
	@PutMapping("/updateById")
	public Nutrition update(@RequestBody Nutrition bean)
	{
		return service.updateNutrition(bean);
		
	}

	@DeleteMapping("/deleteById/{nutritionId}")
	public void deleteStudent(@PathVariable Integer nutritionId)
	{
		 service.deleteById(nutritionId);
	}

}
