package com.paymentservice.serviceimpl;

//import org.apache.catalina.realm.JNDIRealm.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.paymentservice.bean.MembershipBean;
import com.paymentservice.bean.ResponseDto;
import com.paymentservice.bean.UserBean;
import com.paymentservice.entity.Membership;
import com.paymentservice.repository.MembershipRepository;
import com.paymentservice.service.MembershipService;

@Service
public class MembershipServiceImpl implements MembershipService {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private MembershipRepository membershipRepository;

//	@Override
//	public Membership save(Membership membership) {
//		return membershipRepository.save(membership);
//
//	}
//
//	@Override
//	public Membership get(Long membershipId) {
//		
//		return membershipRepository.findById(membershipId).orElseThrow(
//				() -> new IllegalArgumentException("member not found with id-" + membershipId));
//	}
//
//	@Override
//	public Membership deleteById(Long membershipId) {
//		
//		return null;	
//
//}
//
//
//
//	 
//	 @Transactional
//public void updateEntity(Long membershipId, String membershipType) {
//	membershipRepository.findById(membershipId).orElse(null);
//	
//	
	
//	  if(membership!=null) 
//	  { membership.setPaymentMode(paymentMode);
//	  membershipRepository.save(membership); 
//	  }
	 
//}
//	 
//	 @Override
//	    public Membership saveMembership(Membership membership) {
//	        return membershipRepository.save(membership);
//	    }

	

	private MembershipBean mapToMembership(Membership membership) {
		MembershipBean membershipBean = new MembershipBean();
		membershipBean.setMembershipId(membership.getMembershipId());
		membershipBean.setMembershipType(membership.getMembershipType());
		membershipBean.setMembershipPeriod(membership.getMembershipPeriod());
		membershipBean.setDescription(membership.getDescription());
		membershipBean.setUserId(membership.getUserId());
		
		
	        	        return membershipBean;
	}

	@Override
	public ResponseDto getMembership(Long membershipId) {
		
		ResponseDto responseDto = new ResponseDto();
		 System.out.println("response dto object created");
        Membership membership = membershipRepository.findById(membershipId).get();
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
       headers.setContentType(MediaType.APPLICATION_JSON);
        MembershipBean membershipBean = mapToMembership(membership);
HttpEntity<String> httpEntity=new HttpEntity<>(headers);
        ResponseEntity<UserBean> responseEntity = restTemplate
        		 .exchange("http://localhost:8082/user/getById/" + membership.getUserId(),HttpMethod.GET,httpEntity,
                UserBean.class);

        UserBean userBean = responseEntity.getBody();

        System.out.println(responseEntity.getStatusCode());

        responseDto.setMembership(membershipBean);
        responseDto.setUserBean(userBean);

        return responseDto;
	}

	

	@Override
	public Membership saveMembership(Membership membership) {
		// TODO Auto-generated method stub
		return membershipRepository.save(membership);
	}

//	@Override
//	public ResponseDto getMember(Long membershipId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
//	@Override
//	public Membership saveMembership(Membership membership) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	}
