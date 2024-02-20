package com.healthservice.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.healthservice.entity.MedicalHistory;
import com.healthservice.entity.Nutrition;

import com.healthservice.bean.NutritionBean;
import com.healthservice.bean.ResponseDto;
import com.healthservice.bean.UserBean;
import com.healthservice.exception.ResourceNotFoundException;
import com.healthservice.repository.UserNutritionRepository;
import com.healthservice.service.UserNutritionService;


@Service
public class UserNutritionServiceImpl implements UserNutritionService {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	UserNutritionRepository repository;

	@Override
	public Nutrition saveNewNutrition(Nutrition bean) {
		// TODO Auto-generated method stub
		return repository.save(bean);
	}

//	@Override
//	public Nutrition getById(Integer nutritionId) {
//		// TODO Auto-generated method stub
//		return repository.findById(nutritionId).get();
//	}

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
	
	private NutritionBean mapToNutrition(Nutrition nutrition) {
		NutritionBean nutritionBean=new NutritionBean();
		nutritionBean.setFoodItem(nutrition.getFoodItem());
		nutritionBean.setCaloriesToBeconsumed(nutrition.getCaloriesToBeconsumed());
		nutritionBean.setProteinToBeconsumed(nutrition.getProteinToBeconsumed());
		nutritionBean.setCarbohydratesToBeconsumed(nutrition.getCarbohydratesToBeconsumed());
		nutritionBean.setFatsToBeconsumed(nutrition.getFatsToBeconsumed());
		nutritionBean.setFiberToBeconsumed(nutrition.getFiberToBeconsumed());
		nutritionBean.setVitaminsAndMineralsToBeconsumed(nutrition.getVitaminsAndMineralsToBeconsumed());
		nutritionBean.setSugarToBeconsumed(nutrition.getSugarToBeconsumed());
		nutritionBean.setSodiumToBeconsumed(nutrition.getSodiumToBeconsumed());
	return nutritionBean;	
	}
	
	@Override
	public ResponseDto getById(Integer nutritionId) {
		ResponseDto responseDto = new ResponseDto();
		 System.out.println("response dto object created");
       Nutrition nutrition = repository.findById(nutritionId).get();
     org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
     headers.setContentType(MediaType.APPLICATION_JSON);
     NutritionBean nutritionBean = mapToNutrition(nutrition);
HttpEntity<String> httpEntity=new HttpEntity<>(headers);
       ResponseEntity<UserBean> responseEntity = restTemplate.exchange("http://localhost:8081/user/getById/" + nutrition.getNutritionId(),HttpMethod.GET,httpEntity,
            UserBean.class);

       UserBean userBean = responseEntity.getBody();

       System.out.println(responseEntity.getStatusCode());

       responseDto.setNutritionbean(nutritionBean);
       responseDto.setUserBean(userBean);

       return responseDto;
	}
	
	@Override
	public List<Nutrition> getNutrition(String userName) {
		// TODO Auto-generated method stub
		return repository.findByUserName(userName);
	}
	
}
