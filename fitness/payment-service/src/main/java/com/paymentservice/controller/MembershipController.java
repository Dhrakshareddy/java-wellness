package com.paymentservice.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paymentservice.bean.ResponseDto;
import com.paymentservice.entity.Membership;
import com.paymentservice.service.MembershipService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/membership")
public class MembershipController {

	@Autowired
	private MembershipService membershipService;
	
	
    @GetMapping(path="/{id}")
    public ResponseEntity<ResponseDto> getMembership(@PathVariable("id") Long membershipId){
        ResponseDto responseDto = membershipService.getMembership(membershipId);
        
        System.out.println("member");
        return ResponseEntity.ok(responseDto);
    }

//	@Autowired
//	private MembershipRepository MembershipRepository;

	@PostMapping(path = "/save")
	public ResponseEntity<Membership> saveMembership(@RequestBody Membership membership) {
		// log.info("Saving patient {}", Membership);
		
		Membership savedMembership=  membershipService.saveMembership(membership);
		
		ResponseEntity<Membership> responseEntity = new ResponseEntity<>(savedMembership, HttpStatus.CREATED);
		System.out.println("save changes");
		return responseEntity;
		
		
	}
	
//	@GetMapping(path = "/{membershipId}")
//	public ResponseEntity<Membership> getMembership(@PathVariable Long membershipId) {
//		//log.info("Fetching Membership {}", paymentId);
//		ResponseDto membership = membershipService.getMembership(membershipId);
//		System.out.print("Membership getted successfully");
//		ResponseEntity<Membership> responseEntity = new ResponseEntity<>(membership,
//				HttpStatus.OK);
//		System.out.println("Membership getted successfully1");
//		return responseEntity;
//		
//	}
	
	
//	@DeleteMapping(path="/{membershipId}")
//	
//	public String deletePatient(@PathVariable Long membershipId)
//	
//	{
//		
//		Membership membership = membershipService.deleteById(membershipId);
//		System.out.print("Membership getted successfully");
//		ResponseEntity<Membership> responseEntity = new ResponseEntity<>(membership,
//				HttpStatus.OK);
//	  
//		return "record deleted";
//		
//	}
	
	
	
//	@PutMapping(path="/update/{paymentId}")
//	public ResponseEntity<Membership> updateById(@RequestBody Membership Membership) {
//		// log.info("Saving patient {}", Membership);
//		System.out.println("updated successfully");
//		MembershipService.update(Membership);
//
//		ResponseEntity<Membership> responseEntity = new ResponseEntity<>(Membership, HttpStatus.CREATED);
//		return responseEntity;
//	}
//	
//	@PutMapping("/update/{membershipId}")
//    public void updateEntity(@PathVariable Long membershipId, @RequestParam String membershipType) {
//        // Perform validation or error handling as needed
//
//		
//		
//		membershipService.updateEntity(membershipId, membershipType);
//
//       
//    }
	
	
	
	


}
