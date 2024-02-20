package com.management.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.management.bean.LoginBean;
import com.management.bean.UserBean;
import com.management.entity.Trainer;
import com.management.entity.User;
import com.management.exception.ResourceNotFoundException;
import com.management.repository.UserRepository;
import com.management.service.UserService;

import jakarta.persistence.Id;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public User saveUser(User user) {
		user.setRole("USER");
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		 Optional<User> optional = userRepository.findById(id);	
		  if(optional.isEmpty()) {
			  try {
				  optional.orElseThrow(()->new ResourceNotFoundException("No user found to fetch for id:"+id));
			  }catch (ResourceNotFoundException e) {
				throw e;
			}
		  }
		  System.out.println("fetching successfully");
		  return optional.get();
		  
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}
//
	@Override
	public void deleteById(Long id) {
		
		  Optional<User> optional = userRepository.findById(id);	
//	  if(optional.isEmpty()) {
//		  try {
//			  optional.orElseThrow(()->new ResourceNotFoundException("No user found to delete for id:"+id));
//		  }catch (ResourceNotFoundException e) {
//			throw e;
//		}
//	  }
	  userRepository.deleteById(id);
	  System.out.println("fetching successfully");
	 
	}
	@Override
	public User validateLogin(LoginBean loginBean) {
	    User user = userRepository.findByName(loginBean.getName());
	    System.out.println(user);

	    if (user != null) {
	    	User registrationBean = new User();
	       // beanToEntity(registrationBean, user);

	        if (user.getPassword().equals(loginBean.getPassword())) {
	        	System.out.println(user.getPassword());
	        	System.out.println(loginBean.getPassword());
	            return user;
	        } else {
	            try {
	                throw new PasswordMismatchException("password is wrong");
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }
	    	    return user;

	        }
	    } 
	    else {
	        try {
	            throw new UserNameNotFoundException("incorrect EmailId");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            
	        }
	       
	    }
		return user;
	}
//
//	@Override
//	public User update(User user) {
//		Optional<User> optional = userRepository.findById(user.getUserId());
//		if(optional.isEmpty()) {
//		try {
//			optional.orElseThrow(()-> new ResourceNotFoundException("No user found to update :"+user.getUserId()
//			));
//		}catch (ResourceNotFoundException e) {
//			throw e;
//		}
//	}
//		userRepository.save(user);
//		System.out.println("updated successfully");
//		return user;
//
//
//	}
//	
	@Override
	public List<User> getUserByName(String name) {
		return (List<User>) userRepository.findByName(name);
	}
	
	



}
