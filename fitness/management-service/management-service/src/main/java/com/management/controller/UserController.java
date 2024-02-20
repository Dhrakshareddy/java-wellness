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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.bean.LoginBean;
import com.management.bean.UserBean;
import com.management.entity.User;
import com.management.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	public static Logger log = LoggerFactory.getLogger(User.class.getSimpleName());
	@Autowired
	private UserService userService;

	@GetMapping("/check")
	public String demo() {
		System.out.println("hello");
		return "hello";
	}
	
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		log.info("Saving user {}", user);
		userService.saveUser(user);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(user, HttpStatus.CREATED);
		return responseEntity;
	}
	@PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginBean loginBean) {

		User user = userService.validateLogin(loginBean);

        if (user!=null) {
        	System.out.println(user+"login successfull");
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
	
	@GetMapping("/ByName{name}")
	public ResponseEntity<List<User>>getUserByName(@PathVariable String name){
		List<User>userList=userService.getUserByName(name);
		if(userList.isEmpty()) {
			return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(userList,HttpStatus.OK);
	}

	@GetMapping(path = "/getById/{id}")
	public ResponseEntity<User> getUserbyId(@PathVariable Long id) throws Exception {
		log.info("Fetching user  {}", id);
		// try {
		User user = userService.getUserById(id);
		// System.out.println("Getting user details successfully");
		ResponseEntity<User> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
		System.out.println("Getting user details  successfully");
		return responseEntity;
//		} catch (ResourceNotFoundException e) {
//			System.out.println(e.getMessage());
//		}

		// return null;
	}

	@GetMapping(path = "/getAll")
	public ResponseEntity<List<User>> getAll() {
		log.info("getting all user");
		List<User> user = userService.getAll();
		ResponseEntity<List<User>> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
	return responseEntity;
	}
//
	@DeleteMapping(path = "/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		log.info("deleting user {}", id);

	userService.deleteById(id);
	
		return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
	}
//
//	@PutMapping(path = "/updateById/{id}")
//	public User update(@RequestBody User user) {
//		User update = userService.update(user);
//		System.out.println("updated successfully");
//		return update;
//	}

}
