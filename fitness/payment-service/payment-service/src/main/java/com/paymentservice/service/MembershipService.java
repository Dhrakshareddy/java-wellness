package com.paymentservice.service;

import com.paymentservice.bean.ResponseDto;
import com.paymentservice.entity.Membership;


public interface MembershipService {
//
	
//
//	Membership get(Long membershipId);
//
//	Membership deleteById(Long membershipId);
//
//	//void update(Membership Membership);
//
//	
//
//	void updateEntity(Long paymentId, String paymentMode);
//	
     
//	Membership saveMembershipBean(Membership membership);

	

	ResponseDto getMembership(Long membershipId);
	
	Membership saveMembership(Membership membership);



	


}
