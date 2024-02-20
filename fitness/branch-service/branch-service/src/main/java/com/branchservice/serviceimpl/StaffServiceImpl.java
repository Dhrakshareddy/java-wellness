package com.branchservice.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.branchservice.entity.Staff;
import com.branchservice.repository.StaffRepository;
import com.branchservice.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	StaffRepository StaffRepository;

	@Override
	public void save(Staff Staff) {
		StaffRepository.save(Staff);

	}

	@Override
	public Staff get(Long staffId) {
		
		return StaffRepository.findById(staffId).orElseThrow(
				() -> new IllegalArgumentException("Patient not found with id-" + staffId));
	}

	@Override
	public Staff deleteById(Long staffId) {
		
		return null;	

}



	 
	 @Transactional
public void updateEntity(Long staffId, String staffMode) {
	Staff Staff = StaffRepository.findById(staffId).orElse(null);
	if(Staff!=null)
	{
	
	StaffRepository.save(Staff);
	}
	
}
}
