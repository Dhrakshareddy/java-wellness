package com.traineeservice.service;

import java.util.List;

import com.traineeservice.entity.Attendance;



public interface AttendanceService {
	void save(Attendance attendance);

	Attendance get(Long id);

	List<Attendance> getAll();

	String deleteById(Long id);

	void deleteAll();
	Attendance update(Attendance attendance);
}
