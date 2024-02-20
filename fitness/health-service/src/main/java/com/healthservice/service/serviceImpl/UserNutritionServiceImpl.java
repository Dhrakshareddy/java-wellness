package com.healthservice.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthservice.entity.Nutrition;
import com.healthservice.exception.ResourceNotFoundException;
import com.healthservice.repository.UserNutritionRepository;
import com.healthservice.service.UserNutritionService;


@Service
public class UserNutritionServiceImpl implements UserNutritionService {
	
	@Autowired
	UserNutritionRepository repository;

	@Override
	public Nutrition saveNewNutrition(Nutrition bean) {
		// TODO Auto-generated method stub
		return repository.save(bean);
	}

	@Override
	public Nutrition getById(Integer nutritionId) {
		// TODO Auto-generated method stub
		return repository.findById(nutritionId).get();
	}

	@Override
	public List<Nutrition> getAllNutrition() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Nutrition updateNutrition(Nutrition bean) {
		Optional<Nutrition> optional=repository.findById(bean.getNutritionId());
		if(optional.isPresent())
		{
			repository.save(bean);
		}
		
		return bean;
	
		
	}

	@Override
	public void deleteById(Integer nutritionId) {
		// TODO Auto-generated method stub
		Optional<Nutrition> optional=repository.findById(nutritionId);
		if(optional.isPresent())
		{
			repository.deleteById(nutritionId);
			
		}
		
		else optional.orElseThrow(()->new ResourceNotFoundException("no record to delete"));
		
		//return "data deleted";
	}
}
