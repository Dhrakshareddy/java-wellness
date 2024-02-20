package com.management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.bean.LoginBean;
import com.management.bean.TrainerBean;
import com.management.bean.TrainerLoginBean;
import com.management.entity.Trainer;
import com.management.entity.User;
import com.management.exception.ResourceNotFoundException;
import com.management.repository.TrainerRepository;
import com.management.service.TrainerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TrainerServiceImpl implements TrainerService {
	@Autowired
	private TrainerRepository trainerRepository;

	public void save(Trainer trainer) {
		trainer.setRole("TRAINER");
		trainerRepository.save(trainer);
	}

	public Trainer get(Long id) {
		Optional<Trainer> optional = trainerRepository.findById(id);
		if (optional.isEmpty()) {
			try {
				optional.orElseThrow(() -> new ResourceNotFoundException("No trainer found to fetch for id:" + id));
			} catch (ResourceNotFoundException e) {
				throw e;
			}
		}
		System.out.println("fetching successfully");
		return optional.get();

	}

	public List<Trainer> getAll() {

		return trainerRepository.findAll();
	}

	public Trainer deleteById(Long id) {
		Optional<Trainer> optional = trainerRepository.findById(id);
		if (optional.isEmpty()) {
			try {
				optional.orElseThrow(() -> new ResourceNotFoundException("No trainer found to delete for id:" + id));
			} catch (ResourceNotFoundException e) {
				throw e;
			}
		}
		trainerRepository.deleteById(id);
		System.out.println("fetching successfully");
		return optional.get();

	}

	public Trainer update(Trainer trainer) {
		Optional<Trainer> optional = trainerRepository.findById(trainer.getTrainerId());
		if (optional.isEmpty()) {
			try {
				optional.orElseThrow(
						() -> new ResourceNotFoundException("No trainer found to update :" + trainer.getTrainerId()));
			} catch (ResourceNotFoundException e) {
				throw e;
			}
		}
		trainerRepository.save(trainer);
		System.out.println("updated successfully");
		return trainer;

	}
	
	@Override
	public Trainer validateLogin(TrainerLoginBean trainerLoginBean) {
	    Trainer trainer = trainerRepository.findByName(trainerLoginBean.getName());
	    System.out.println(trainer);

	    if (trainer != null) {
	    	Trainer registrationBean = new Trainer();
	       // beanToEntity(registrationBean, user);

	        if (trainer.getPassword().equals(trainerLoginBean.getPassword())) {
	        	System.out.println(trainer.getPassword());
	        	System.out.println(trainerLoginBean.getPassword());
	            return trainer;
	        } else {
	            try {
	                throw new PasswordMismatchException("password is wrong");
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }
	    	    return trainer;

	        }
	    } 
	    else {
	        try {
	            throw new UserNameNotFoundException("incorrect EmailId");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            
	        }
	       
	    }
		return trainer;
	}
}
