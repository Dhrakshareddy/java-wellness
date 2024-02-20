package com.training.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.entity.Progress;
import com.training.exception.ResourceNotFoundException;
import com.training.repository.ProgressRepository;
import com.training.service.ProgressService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProgressServiceImpl implements ProgressService {

	@Autowired
	private ProgressRepository progressRepository;
	
	@Override
	public void save(Progress progress) {
		progressRepository.save(progress);
		System.out.println("Save success");
	}

	@Override
	public void update(Progress progress) {
		Optional<Progress> optional=progressRepository.findById(progress.getProgressId());
		if(optional.isPresent()) {
			progressRepository.save(progress);
			System.out.println("Update Success");
		}else {
			optional.orElseThrow(()->new ResourceNotFoundException("No Progress found to update for id : "+progress.getProgressId()));
		}
	}

	@Override
	public Progress getById(Long id) {
		Optional<Progress> optional=progressRepository.findById(id);
		if(optional.isPresent()) {
			System.out.println("Fetch success");
			return optional.get();
		}else {
			optional.orElseThrow(()->new ResourceNotFoundException("No Progress found to fetch for id : "+id));
		}
		return null;
	}
	
	@Override
	public List<Progress> getAll() {
		 return progressRepository.findAll();
	}

	@Override
	public Progress delete(Long id) {
		Optional<Progress> optional=progressRepository.findById(id);
		if(optional.isPresent()) {
			progressRepository.deleteById(id);
			System.out.println("Delete success");
			return optional.get();
		}else {
			optional.orElseThrow(()->new ResourceNotFoundException("No Progress found to delete for id : "+id));
		}
		return null;
	}
}
