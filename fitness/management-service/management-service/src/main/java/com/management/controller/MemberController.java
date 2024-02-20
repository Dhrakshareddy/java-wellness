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

import com.management.entity.Membership;
import com.management.entity.Trainer;
import com.management.service.MembershipService;
import com.management.service.TrainerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/membership")
@CrossOrigin(origins="http://localhost:4200")
public class MemberController {
	public static Logger log = LoggerFactory.getLogger(Membership.class.getSimpleName());
	@Autowired
	private MembershipService membershipService;

	@PostMapping(path = "/add")
	public ResponseEntity<Membership> save(@RequestBody Membership membership) {
		log.info("Saving membership {}", membership);
		membershipService.save(membership);
		ResponseEntity<Membership> responseEntity = new ResponseEntity<>(membership, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping(path = "/getById/{id}")
	public ResponseEntity<Membership> get(@PathVariable Long id) {
		log.info("Fetching membership  {}", id);

		Membership membership = membershipService.get(id);

		ResponseEntity<Membership> responseEntity = new ResponseEntity<>(membership, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping(path = "/getAll")
	public ResponseEntity<List<Membership>> getAll() {
		log.info("getting all membership");
		List<Membership> membership = membershipService.getAll();
		ResponseEntity<List<Membership>> responseEntity = new ResponseEntity<>(membership, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping(path = "/deleteById/{id}")
	public String deleteById(@PathVariable Long id) {
		log.info("deleting membership {}", id);

		membershipService.deleteById(id);
		return "deleted successfully";
	}

	@PutMapping(path = "/updateById/{id}")
	public Membership update(@RequestBody Membership membership) {
		Membership update = membershipService.update(membership);
		System.out.println("updated successfully");
		return update;
	}

}
