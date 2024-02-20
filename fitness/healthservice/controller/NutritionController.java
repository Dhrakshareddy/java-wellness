package com.healthservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthservice.bean.ResponseDto;
import com.healthservice.entity.MedicalHistory;
import com.healthservice.entity.Nutrition;
import com.healthservice.service.UserNutritionService;

@RestController
@RequestMapping("/nutrition")
@CrossOrigin(origins="http://localhost:4200")
public class NutritionController {

	@Autowired
	UserNutritionService service;

	@PostMapping("/save")
	public ResponseEntity<Nutrition> saveNewNutrition(@RequestBody Nutrition nutrition) {
		System.out.println("save");
		Nutrition saveNutrition = service.saveNewNutrition(nutrition);

		ResponseEntity<Nutrition> responseEntity = new ResponseEntity<>(saveNutrition, HttpStatus.CREATED);
		System.out.println("save changes");
		return responseEntity;
	}
	@GetMapping("/getById/{nutritionId}")
	 public ResponseEntity<ResponseDto> getById(@PathVariable Integer nutritionId){
        ResponseDto responseDto = service.getById(nutritionId);
        
        System.out.println("member");
        return ResponseEntity.ok(responseDto);
    }

	@GetMapping("/getAll")
	public List<Nutrition> getAll() {
		return service.getAllNutrition();
	}

	@PutMapping("/updateById")
	public Nutrition update(@RequestBody Nutrition bean) {
		return service.updateNutrition(bean);

	}

	@DeleteMapping("/deleteById/{nutritionId}")
	public void deleteStudent(@PathVariable Integer nutritionId) {
		service.deleteById(nutritionId);
	}
	

	@GetMapping("/byName/{userName}")
	public ResponseEntity<List<Nutrition>> getNutritionByName(@PathVariable String userName) {
	    List<Nutrition> nutritionList = service.getNutrition(userName);
	    if (nutritionList.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(nutritionList, HttpStatus.OK);
	}

}
