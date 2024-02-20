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

import com.management.bean.LoginBean;
import com.management.bean.TrainerLoginBean;
import com.management.entity.Membership;
import com.management.entity.Trainer;
import com.management.entity.User;
import com.management.exception.ResourceNotFoundException;
import com.management.service.MembershipService;
import com.management.service.TrainerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/trainer")
@CrossOrigin(origins="http://localhost:4200")
public class TrainerController {
	public static Logger log = LoggerFactory.getLogger(Membership.class.getSimpleName());
	@Autowired
	private TrainerService trinerService;

	@PostMapping(path = "/add")
	public ResponseEntity<Trainer> save(@RequestBody Trainer trainer) {
		log.info("Saving trainer {}", trainer);
		trinerService.save(trainer);
		ResponseEntity<Trainer> responseEntity = new ResponseEntity<>(trainer, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping(path = "/getById/{id}")
	public ResponseEntity<Trainer> get(@PathVariable Long id) {
		log.info("Fetching trainer  {}", id);

		Trainer trainer = trinerService.get(id);

		ResponseEntity<Trainer> responseEntity = new ResponseEntity<>(trainer, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping(path = "/getAll")
	public ResponseEntity<List<Trainer>> getAll() {
		log.info("getting all trainer");
		List<Trainer> trainer = trinerService.getAll();
		ResponseEntity<List<Trainer>> responseEntity = new ResponseEntity<>(trainer, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping(path = "/deleteById/{id}")
	public String deleteById(@PathVariable long id) {
		log.info("deleting trainer {}", id);

		trinerService.deleteById(id);
		return "deleted successfully";
	}

	@PutMapping(path = "/updateById/{id}")
	public Trainer update(@RequestBody Trainer trainer) {
		Trainer update = trinerService.update(trainer);
		System.out.println("updated successfully");
		return update;
	}
	@PostMapping("/login")
    public ResponseEntity<Trainer> login(@RequestBody TrainerLoginBean trainerLoginBean) {

		Trainer trainer = trinerService.validateLogin(trainerLoginBean);

        if (trainer!=null) {
        	System.out.println(trainer+"login successfull");
            return ResponseEntity.ok(trainer);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }


}
