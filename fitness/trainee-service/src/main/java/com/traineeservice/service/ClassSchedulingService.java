package com.traineeservice.service;

import java.util.List;


import com.traineeservice.entity.ClassScheduling;

public interface ClassSchedulingService {
	void save(ClassScheduling scheduling);

	ClassScheduling get(Long id);

	List<ClassScheduling> getAll();

	String deleteById(Long id);

	void deleteAll();
	ClassScheduling update(ClassScheduling scheduling);
}
