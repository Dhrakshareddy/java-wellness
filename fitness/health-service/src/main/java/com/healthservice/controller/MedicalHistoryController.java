package com.healthservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthservice.entity.MedicalHistory;

import com.healthservice.service.MedicalHistoryService;



@RestController
@RequestMapping("medicalHistory")
public class MedicalHistoryController {

	
	@Autowired
	MedicalHistoryService service;
	
	@PostMapping("/save")
	public MedicalHistory saveNewMedicalHistory(@RequestBody MedicalHistory bean)
	{
		return service.saveNewMedicalHistory(bean);
		
	}
	
	@GetMapping("/getById/{memberId}")
	public MedicalHistory getById(@PathVariable Integer memberId)
	{
		return service.getById(memberId);
	}
	
	@GetMapping("/getAll")
	public List<MedicalHistory> getAll()
	{
		return service.getAllMedicalHistory();
	}
	
	@PutMapping("/updateById")
	public MedicalHistory updateMedicalHistory(@RequestBody MedicalHistory bean)
	{
		return service.updateMedicalHistory(bean);
		
	}

	@DeleteMapping("/deleteById/{memberId}")
	public void deleteMedicalHistory(@PathVariable Integer memberId)
	{
		service.deleteById(memberId);
	}
}
