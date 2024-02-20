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
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.healthservice.bean.ResponseDto;
import com.healthservice.bean.UserBean;
import com.healthservice.entity.MedicalHistory;
import com.healthservice.service.MedicalHistoryService;

@RestController
@RequestMapping("/medicalHistory")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalHistoryController {

	@Autowired
	MedicalHistoryService service;

	@PostMapping("/save")
	public ResponseEntity<MedicalHistory> saveNewMedicalHistory(@RequestBody MedicalHistory medicalHistory) {
		System.out.println("save");
		MedicalHistory saveMedicalHistory = service.saveNewMedicalHistory(medicalHistory);

		ResponseEntity<MedicalHistory> responseEntity = new ResponseEntity<>(saveMedicalHistory, HttpStatus.CREATED);
		System.out.println("save changes");
		System.out.println("*****");
		return responseEntity;
	}

	@GetMapping("/getById/{memberId}")
    public ResponseEntity<ResponseDto> getById(@PathVariable Long memberId){
        ResponseDto responseDto = service.getById(memberId);
        
        System.out.println("member");
        return ResponseEntity.ok(responseDto);
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
	public void deleteMedicalHistory(@PathVariable Long memberId)
	{
		service.deleteById(memberId);
	}
	

	@GetMapping("/byName/{userName}")
	public ResponseEntity<List<MedicalHistory>> getMedicalHistoryByName(@PathVariable String userName) {
	    List<MedicalHistory> historyList = service.getMedicalHistoryByName(userName);
	    if (historyList.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(historyList, HttpStatus.OK);
	}

}