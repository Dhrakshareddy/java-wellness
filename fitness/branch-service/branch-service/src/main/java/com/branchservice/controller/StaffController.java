package com.branchservice.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.branchservice.entity.Staff;
import com.branchservice.service.StaffService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/staff")
@CrossOrigin(origins="http://localhost:4200")
public class StaffController {

	@Autowired
	private StaffService staffService;

//	@Autowired
//	private staffRepository staffRepository;

	@PostMapping(path = "/staffadd")
	public ResponseEntity<Staff> save(@RequestBody Staff staff) {
		// log.info("Saving patient {}", staff);
		System.out.println("saving");
		staffService.save(staff);

		ResponseEntity<Staff> responseEntity = new ResponseEntity<>(staff, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping(path = "/{staffId}")
	public ResponseEntity<Staff> getPatient(@PathVariable Long staffId) {
		//log.info("Fetching staff {}", paymentId);
	Staff staff = staffService.get(staffId);
		System.out.print("staff getted successfully");
		ResponseEntity<Staff> responseEntity = new ResponseEntity<>(staff,
				HttpStatus.OK);
		System.out.println("staff getted successfully1");
		return responseEntity;
		
	}
	
	
	@DeleteMapping(path="/{staffId}")
	
	public String deletestaff(@PathVariable Long staffId)
	
	{
		
	Staff staff = staffService.deleteById(staffId);
		System.out.print("staff getted successfully");
		ResponseEntity<Staff> responseEntity = new ResponseEntity<>(staff,
				HttpStatus.OK);
		
		return "record deleted";
		
	}
	
//	@PutMapping(path="/update/{paymentId}")
//	public ResponseEntity<staff> updateById(@RequestBody staff staff) {
//		// log.info("Saving patient {}", staff);
//		System.out.println("updated successfully");
//		staffService.update(staff);
//
//		ResponseEntity<staff> responseEntity = new ResponseEntity<>(staff, HttpStatus.CREATED);
//		return responseEntity;
//	}
//	
	@PutMapping("/update/{staffId}")
    public void updateEntity(@PathVariable Long paymentId, @RequestParam String paymentMode) {
        // Perform validation or error handling as needed

		
		
		

       
    }
	
	
	
	


}
