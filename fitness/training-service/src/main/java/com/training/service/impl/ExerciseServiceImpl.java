package com.training.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.entity.Exercise;
import com.training.exception.ResourceNotFoundException;
import com.training.repository.ExerciseRepository;
import com.training.service.ExerciseService;

@Service
public class ExerciseServiceImpl implements ExerciseService {

	@Autowired
	private ExerciseRepository exerciseRepository;
	
	@Override
	public void save(Exercise exercise) {
		exerciseRepository.save(exercise);
		System.out.println("Save success");
	}
	
	@Override
	public void update(Exercise exercise) {
		Optional<Exercise> optional=exerciseRepository.findById(exercise.getExerciseId());
		if(optional.isEmpty()) {
			try {
					optional.orElseThrow(()->new ResourceNotFoundException("No Exercise found to update for id : "+exercise.getExerciseId()));
			}catch(ResourceNotFoundException e) {
				throw e;
			}
		}
		exerciseRepository.save(exercise);
		System.out.println("Update Success");
	}
	
	@Override
	public Exercise getById(Long id) {
		Optional<Exercise> optional=exerciseRepository.findById(id);
		if(optional.isEmpty()) {
			try {
				optional.orElseThrow(()->new ResourceNotFoundException("No Exercise found to fetch for id : "+id));
			}catch(ResourceNotFoundException e) {
				throw e;
			}
		}
		System.out.println("Fetch success");
		return optional.get();
	}

	@Override
	public List<Exercise> getAll() {
		 return exerciseRepository.findAll();
	}

	@Override
	public Exercise delete(Long id) {
		Optional<Exercise> optional=exerciseRepository.findById(id);
		if(optional.isEmpty()) {
			try {
				optional.orElseThrow(()->new ResourceNotFoundException("No Exercise found to delete for id : "+id));
			}
			catch(ResourceNotFoundException e) {
				throw e;
			}
		}
		exerciseRepository.deleteById(id);
		System.out.println("Delete success");
		return optional.get();
	}

}
