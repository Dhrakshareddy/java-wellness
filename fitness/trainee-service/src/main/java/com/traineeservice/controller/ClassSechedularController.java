package com.traineeservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RestController;

import com.traineeservice.entity.ClassScheduling;
import com.traineeservice.service.ClassSchedulingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path="classSchedular")

public class ClassSechedularController {
	public static Logger log = LoggerFactory.getLogger(ClassScheduling.class.getSimpleName());
	@Autowired
	private ClassSchedulingService classSchedulingService;

	@PostMapping("/save")
	public ResponseEntity<ClassScheduling> save(@RequestBody ClassScheduling scheduling) {
		log.info("Saving classscheduling", scheduling);
		classSchedulingService.save(scheduling);

		ResponseEntity<ClassScheduling> responseEntity = new ResponseEntity<>(scheduling, HttpStatus.CREATED);

		return responseEntity;
	}

	@GetMapping(path = "/getById/{id}")
	public ResponseEntity<ClassScheduling> get(@PathVariable Long id) {
		log.info("Fetching Schedule {}", id);

ClassScheduling classScheduling = classSchedulingService.get(id);

		ResponseEntity<ClassScheduling> responseEntity = new ResponseEntity<>(classScheduling, HttpStatus.OK);

		return responseEntity;
	}

	@GetMapping(path = "/getAll")
	public ResponseEntity<List<ClassScheduling>> getAll() {
		log.info("getting all Schedules");
		List<ClassScheduling> scheduling = classSchedulingService.getAll();
		ResponseEntity<List<ClassScheduling>> responseEntity = new ResponseEntity<>(scheduling, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping(path = "/deleteById/{id}")
	public String deleteById(@PathVariable Long id) {
		log.info("deleting schedule{}", id);

		classSchedulingService.deleteById(id);
		return "deleted successfully";
	}

	@DeleteMapping(path = "/deleteAll")
	public void deleteAll() {

		classSchedulingService.deleteAll();

	}

	@PutMapping(path="/updateById/{id}")
	public ResponseEntity<ClassScheduling> update(@RequestBody ClassScheduling classScheduling)
	{
		ClassScheduling scheduleUpdate  =classSchedulingService.update(classScheduling);
				ResponseEntity<ClassScheduling> responseEntity = new ResponseEntity<>(scheduleUpdate,HttpStatus.OK);
		return responseEntity;
	}

}
