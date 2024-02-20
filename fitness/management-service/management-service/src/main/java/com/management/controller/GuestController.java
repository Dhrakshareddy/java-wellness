package com.management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RestController;

import com.management.entity.Doctor;
import com.management.entity.Guest;
import com.management.service.DoctorService;
import com.management.service.GuestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/guest")
@CrossOrigin(origins="http://localhost:4200")
public class GuestController {
	public static Logger log = LoggerFactory.getLogger(Guest.class.getSimpleName());
	@Autowired
	private GuestService guestService;

	@PostMapping(path = "/add")
	public ResponseEntity<Guest> save(@RequestBody Guest guest) {
		log.info("Saving Guest {}", guest);
		guestService.save(guest);
		ResponseEntity<Guest> responseEntity = new ResponseEntity<>(guest, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping(path = "/getById/{id}")
	public ResponseEntity<Guest> get(@PathVariable Long id) {
		log.info("Fetching guest  {}", id);

		Guest guest = guestService.get(id);

		ResponseEntity<Guest> responseEntity = new ResponseEntity<>(guest, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping(path = "/getAll")
	public ResponseEntity<List<Guest>> getAll() {
		log.info("getting all guest");
		List<Guest> guest = guestService.getAll();
		ResponseEntity<List<Guest>> responseEntity = new ResponseEntity<>(guest, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping(path = "/deleteById/{id}")
	public String deleteById(@PathVariable Long id) {
		log.info("deleting guest {}", id);

		guestService.deleteById(id);
		return "deleted successfully";
	}

	@PutMapping(path = "/updateById/{id}")
	public Guest update(@RequestBody Guest guest) {
		Guest update = guestService.update(guest);
		System.out.println("updated successfully");
		return update;

	}

}
