package com.paymentservice.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

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

import com.paymentservice.entity.Payment;
import com.paymentservice.exceptions.ResourceNotFoundException;
import com.paymentservice.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

//	@Autowired
//	private PaymentsRepository paymentsRepository;

	@PostMapping(path = "/save")
	public ResponseEntity<Payment> save(@RequestBody Payment payments) {
		System.out.println("Saving payments {}"+ payments);
		System.out.println("saving");
		paymentService.save(payments);

		ResponseEntity<Payment> responseEntity = new ResponseEntity<>(payments, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping(path = "/{paymentId}")
	public ResponseEntity<Payment> getPatient(@PathVariable Long paymentId) throws Exception  {
		//log.info("Fetching payments {}", paymentId);
		try {
		Payment payments = paymentService.get(paymentId);
		System.out.print("payments getted successfully");
		ResponseEntity<Payment> responseEntity = new ResponseEntity<>(payments,
				HttpStatus.OK);
		System.out.println("payments getted successfully1");
		
		return responseEntity;
		}
		catch(ResourceNotFoundException e)
		
		{
			System.out.println(e.getMessage());
			
		}
		return null;
	}
	
	
	@DeleteMapping(path="/{paymentId}")
	
	public String deletePatient(@PathVariable Long paymentId)
	
	{
		
		Payment payments = paymentService.deleteById(paymentId);
		System.out.print("payments getted successfully");
		ResponseEntity<Payment> responseEntity = new ResponseEntity<>(payments,
				HttpStatus.OK);
		
		return "record deleted";
		
	}
	
	

	
//	@PutMapping(path="/update/{paymentId}")
//	public ResponseEntity<Payments> updateById(@RequestBody Payments payments) {
//		// log.info("Saving patient {}", payments);
//		System.out.println("updated successfully");
//		paymentsService.update(payments);
//
//		ResponseEntity<Payments> responseEntity = new ResponseEntity<>(payments, HttpStatus.CREATED);
//		return responseEntity;
//	}
//	
	@PutMapping("/update/{paymentId}")
    public void updateEntity(@PathVariable Long paymentId, @RequestParam String paymentMode) {
        // Perform validation or error handling as needed

		
		
		paymentService.updateEntity(paymentId, paymentMode);

       
    }
	
	
	
	


}
