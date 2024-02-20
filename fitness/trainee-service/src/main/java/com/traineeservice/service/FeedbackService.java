package com.traineeservice.service;

import java.util.List;


import com.traineeservice.entity.Feedback;

public interface FeedbackService {
	void save(Feedback feedback);

	Feedback get(Long id);

	List<Feedback> getAll();

	String deleteById(Long id);

	void deleteAll();
	Feedback update(Feedback feedback);
}
