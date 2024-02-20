package com.healthservice.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthservice.entity.MedicalHistory;
import com.healthservice.exception.ResourceNotFoundException;
import com.healthservice.repository.MedicalHistoryRepository;
import com.healthservice.service.MedicalHistoryService;

@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService {
	
	@Autowired
	MedicalHistoryRepository repository;

	@Override
	public MedicalHistory saveNewMedicalHistory(MedicalHistory bean) {
		// TODO Auto-generated method stub
		return repository.save(bean);
	}

	@Override
	public MedicalHistory getById(Integer memberId) {
		// TODO Auto-generated method stub
		return repository.findById(memberId).get();
	}

	@Override
	public List<MedicalHistory> getAllMedicalHistory() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	
	@Override
	public void deleteById(Integer memberId) {
		Optional<MedicalHistory> optional=repository.findById(memberId);
		if(optional.isPresent())
		{
			repository.deleteById(memberId);
			
		}
		
		else optional.orElseThrow(()->new ResourceNotFoundException("no record to delete"));
		
		//return "data deleted";
	}

	@Override
	public MedicalHistory updateMedicalHistory(MedicalHistory bean) {
		// TODO Auto-generated method stub
		Optional<MedicalHistory> optional=repository.findById(bean.getMemberId());
		if(optional.isPresent())
		{
			repository.save(bean);
		}
		
		return bean;
	}

}
