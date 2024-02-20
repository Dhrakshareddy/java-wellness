package com.branchservice.service;

import com.branchservice.entity.Tracking;

public interface TrackingService {

	void save(Tracking Tracking);

	Tracking get(Long trackingId);

	Tracking deleteById(Long trackingId);

	//void update(Payments payments);

	

	void updateEntity(Long paymentId, String paymentMode);

}
