package com.branchservice.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.branchservice.entity.Tracking;
import com.branchservice.repository.TrackingRepository;
import com.branchservice.service.TrackingService;

@Service
public class TrackingServiceImpl implements TrackingService {

	@Autowired
	TrackingRepository TrackingRepository;

	@Override
	public void save(Tracking Tracking) {
		TrackingRepository.save(Tracking);

	}

	@Override
	public Tracking get(Long paymentId) {
		
		return TrackingRepository.findById(paymentId).orElseThrow(
				() -> new IllegalArgumentException("Patient not found with id-" + paymentId));
	}

	@Override
	public Tracking deleteById(Long trackingId) {
		
		return null;	

}



	 
	 @Transactional
public void updateEntity(Long trackingId, String paymentMode) {
	Tracking Tracking = TrackingRepository.findById(trackingId).orElse(null);
	if(Tracking!=null)
	{
	
	TrackingRepository.save(Tracking);
	}
	
}
}
