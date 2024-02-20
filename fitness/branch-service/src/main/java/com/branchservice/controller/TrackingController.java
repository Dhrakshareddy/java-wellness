package com.branchservice.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.branchservice.entity.Tracking;
import com.branchservice.service.TrackingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/Tracking")
public class TrackingController {

	@Autowired
	private TrackingService trackingService;

//	@Autowired
//	private TrackingRepository TrackingRepository;

	@PostMapping(path = "/add")
	public ResponseEntity<Tracking> save(@RequestBody Tracking tracking) {
		// log.info("Saving patient {}", Tracking);
		System.out.println("saving");
		trackingService.save(tracking);

		ResponseEntity<Tracking> responseEntity = new ResponseEntity<>(tracking, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping(path = "/{trackingId}")
	public ResponseEntity<Tracking> getPatient(@PathVariable Long trackingId) {
		//log.info("Fetching Tracking {}", paymentId);
		Tracking Tracking = trackingService.get(trackingId);
		System.out.print("Tracking getted successfully");
		ResponseEntity<Tracking> responseEntity = new ResponseEntity<>(Tracking,
				HttpStatus.OK);
		System.out.println("Tracking getted successfully1");
		return responseEntity;
		
	}
	
	
	@DeleteMapping(path="/{TrackingId}")
	
	public String deleteTracking(@PathVariable Long trackingId)
	
	{
		
	Tracking Tracking = trackingService.deleteById(trackingId);
		System.out.print("Tracking getted successfully");
		ResponseEntity<Tracking> responseEntity = new ResponseEntity<>(Tracking,
				HttpStatus.OK);
		
		return "record deleted";
		
	}
	
//	@PutMapping(path="/update/{paymentId}")
//	public ResponseEntity<Tracking> updateById(@RequestBody Tracking Tracking) {
//		// log.info("Saving patient {}", Tracking);
//		System.out.println("updated successfully");
//		TrackingService.update(Tracking);
//
//		ResponseEntity<Tracking> responseEntity = new ResponseEntity<>(Tracking, HttpStatus.CREATED);
//		return responseEntity;
//	}
//	
	@PutMapping("/update/{staffId}")
    public void updateEntity(@PathVariable Long paymentId, @RequestParam String paymentMode) {
        // Perform validation or error handling as needed

		
		
		

       
    }
	
	
	
	


}
