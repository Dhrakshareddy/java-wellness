package com.healthservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthservice.entity.MedicalHistory;


@Service
public interface MedicalHistoryService {

	MedicalHistory saveNewMedicalHistory(MedicalHistory bean);

	MedicalHistory getById(Integer memberId);

	List<MedicalHistory> getAllMedicalHistory();

	MedicalHistory updateMedicalHistory(MedicalHistory bean);

	void deleteById(Integer memberId);

}
