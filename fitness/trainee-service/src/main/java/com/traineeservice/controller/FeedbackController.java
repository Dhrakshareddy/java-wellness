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

import com.traineeservice.entity.Feedback;
import com.traineeservice.service.FeedbackService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path="feedback")
public class FeedbackController {
	public static Logger log = LoggerFactory.getLogger(Feedback.class.getSimpleName());
	@Autowired
	private FeedbackService feedbackService;

	@PostMapping("/save")
	public ResponseEntity<Feedback> save(@RequestBody Feedback feedback) {
		log.info("Saving feedback", feedback);
		feedbackService.save(feedback);

		ResponseEntity<Feedback> responseEntity = new ResponseEntity<>(feedback, HttpStatus.CREATED);

		return responseEntity;
	}

	@GetMapping(path = "/getById/{id}")
	public ResponseEntity<Feedback> get(@PathVariable Long id) {
		log.info("Fetching feedback {}", id);

		Feedback feedback = feedbackService.get(id);

		ResponseEntity<Feedback> responseEntity = new ResponseEntity<>(feedback, HttpStatus.OK);

		return responseEntity;
	}

	@GetMapping(path = "/getAll")
	public ResponseEntity<List<Feedback>> getAll() {
		log.info("getting all achievement");
		List<Feedback> feedback = feedbackService.getAll();
		ResponseEntity<List<Feedback>> responseEntity = new ResponseEntity<>(feedback, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping(path = "/deleteById/{id}")
	public String deleteById(@PathVariable Long id) {
		log.info("deleting feedback{}", id);

		feedbackService.deleteById(id);
		return "deleted successfully";
	}

	@DeleteMapping(path = "/deleteAll")
	public void deleteAll() {

		feedbackService.deleteAll();

	}

	@PutMapping(path="/updateById/{id}")
	public ResponseEntity<Feedback> update(@RequestBody Feedback feedback)
	{
		Feedback feedbackUpdate  =feedbackService.update(feedback);
				ResponseEntity<Feedback> responseEntity = new ResponseEntity<>(feedbackUpdate,HttpStatus.OK);
		return responseEntity;
	}
}
