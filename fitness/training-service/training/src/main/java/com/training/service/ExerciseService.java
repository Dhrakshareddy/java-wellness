package com.training.service;

import java.util.List;

import com.training.entity.Exercise;

public interface ExerciseService {

	void save(Exercise exercise);

	void update(Exercise exercise);
	
	Exercise getById(Long id);
	
	List<Exercise> getAll();

	Exercise delete(Long id);

}
