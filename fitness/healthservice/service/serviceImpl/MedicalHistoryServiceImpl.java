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

import com.healthservice.bean.MedicalHistoryBean;
import com.healthservice.bean.ResponseDto;
import com.healthservice.bean.UserBean;
import com.healthservice.entity.MedicalHistory;
import com.healthservice.exception.ResourceNotFoundException;
import com.healthservice.repository.MedicalHistoryRepository;
import com.healthservice.service.MedicalHistoryService;

@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	MedicalHistoryRepository repository;

	@Override
	public MedicalHistory saveNewMedicalHistory(MedicalHistory medicalHistory) {
		// TODO Auto-generated method stub
		return repository.save(medicalHistory);
	}

	@Override
	public List<MedicalHistory> getAllMedicalHistory() {
		// TODO Auto-generated method stub
		return repository.findAll();
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

	
	private MedicalHistoryBean mapToMedicalHistory(MedicalHistory medicalHistory) {
		MedicalHistoryBean medicalHistoryBean = new MedicalHistoryBean();
		medicalHistoryBean.setMemberId(medicalHistory.getMemberId());
		medicalHistoryBean.setDateOfAssessment(medicalHistory.getDateOfAssessment());
		medicalHistoryBean.setBloodPressure(medicalHistory.getBloodPressure());
		medicalHistoryBean.setHeartRate(medicalHistory.getHeartRate());
		medicalHistoryBean.setAllergies(medicalHistory.getAllergies());
		medicalHistoryBean.setMedications(medicalHistory.getMedications());
		medicalHistoryBean.setChronicCondition(medicalHistory.getChronicCondition());
		medicalHistoryBean.setFamilyMedicalHistory(medicalHistory.getFamilyMedicalHistory());
		medicalHistoryBean.setPreviousInjuryOrSurgery(medicalHistory.getPreviousInjuryOrSurgery());
		medicalHistoryBean.setFitnessLevel(medicalHistory.getFitnessLevel());  
		medicalHistoryBean.setPhysicianContactNumber(medicalHistory.getPhysicianContactNumber());
		return medicalHistoryBean;
	}


	@Override
	public ResponseDto getById(Long memberId) {
		ResponseDto responseDto = new ResponseDto();
		 System.out.println("response dto object created");
       MedicalHistory medicalHistory = repository.findById(memberId).get();
     org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
     headers.setContentType(MediaType.APPLICATION_JSON);
     MedicalHistoryBean medicalHistoryBean = mapToMedicalHistory(medicalHistory);
HttpEntity<String> httpEntity=new HttpEntity<>(headers);
       ResponseEntity<UserBean> responseEntity = restTemplate.exchange("http://localhost:8081/user/getById/" + medicalHistory.getMemberId(),HttpMethod.GET,httpEntity,
            UserBean.class);

       UserBean userBean = responseEntity.getBody();

       System.out.println(responseEntity.getStatusCode());

       responseDto.setMedicalHistory(medicalHistoryBean);
       responseDto.setUserBean(userBean);

       return responseDto;
	}



	


	@Override
	public void deleteById(Long memberId) {
			Optional<MedicalHistory> optional=repository.findById(memberId);
			if(optional.isPresent())
			{
				repository.deleteById(memberId);
				
			}
			
			else optional.orElseThrow(()->new ResourceNotFoundException("no record to delete"));
			
			//return "data deleted";
		}

	@Override
	public List<MedicalHistory> getMedicalHistoryByName(String userName) {
		// TODO Auto-generated method stub
		return repository.findByUserName(userName);
	}
	
	


}
		