package com.healthservice.service;

import java.util.List;

import com.healthservice.bean.ResponseDto;
import com.healthservice.bean.UserBean;
import com.healthservice.entity.MedicalHistory;

public interface MedicalHistoryService {

	MedicalHistory saveNewMedicalHistory(MedicalHistory medicalHistory);

	ResponseDto getById(Long memberId);

	List<MedicalHistory> getAllMedicalHistory();

	MedicalHistory updateMedicalHistory(MedicalHistory bean);

	void deleteById(Long memberId);
	
	List<MedicalHistory> getMedicalHistoryByName(String userName);
	

}