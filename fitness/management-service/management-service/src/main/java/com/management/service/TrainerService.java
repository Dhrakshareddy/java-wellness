package com.management.service;

import java.util.List;

import com.management.bean.TrainerBean;
import com.management.bean.TrainerLoginBean;
import com.management.entity.Trainer;
import com.management.entity.User;

public interface TrainerService {

	void save(Trainer trainer);
	Trainer get(Long id);
	List<Trainer> getAll();
	Trainer deleteById(Long id);
	Trainer update(Trainer trainer);
	
	Trainer validateLogin(TrainerLoginBean trainerLoginBean);

}
