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

import com.traineeservice.entity.Attendance;
import com.traineeservice.service.AttendanceService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path="attendance")
public class AttendanceController {
	
	public static Logger log = LoggerFactory.getLogger(Attendance.class.getSimpleName());
	@Autowired
	private AttendanceService attendanceService;

	@PostMapping("/save")
	public ResponseEntity<Attendance> save(@RequestBody Attendance attendance) {
		log.info("Saving attendance", attendance);
		attendanceService.save(attendance);

		ResponseEntity<Attendance> responseEntity = new ResponseEntity<>(attendance, HttpStatus.CREATED);

		return responseEntity;
	}

	@GetMapping(path = "/getById/{id}")
	public ResponseEntity<Attendance> get(@PathVariable Long id) {
		log.info("Fetching attendance{}", id);

		Attendance attendance = attendanceService.get(id);

		ResponseEntity<Attendance> responseEntity = new ResponseEntity<>(attendance, HttpStatus.OK);

		return responseEntity;
	}

	@GetMapping(path = "/getAll")
	public ResponseEntity<List<Attendance>> getAll() {
		log.info("getting all attendance");
		List<Attendance> attendance = attendanceService.getAll();
		ResponseEntity<List<Attendance>> responseEntity = new ResponseEntity<>(attendance, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping(path = "/deleteById/{id}")
	public String deleteById(@PathVariable Long id) {
		log.info("deleting attendance{}", id);

		attendanceService.deleteById(id);
		return "deleted successfully";
	}

	@DeleteMapping(path = "/deleteAll")
	public void deleteAll() {

		attendanceService.deleteAll();

	}

	@PutMapping(path="/updateById/{id}")
	public ResponseEntity<Attendance> update(@RequestBody Attendance attendance)
	{
		Attendance attendanceUpdate  =attendanceService.update(attendance);
				ResponseEntity<Attendance> responseEntity = new ResponseEntity<>(attendanceUpdate,HttpStatus.OK);
		return responseEntity;
	}

}
