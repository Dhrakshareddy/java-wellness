package com.traineeservice.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traineeservice.entity.ClassScheduling;
import com.traineeservice.exception.NoSuchRecordFoundException;
import com.traineeservice.repository.ClassSchedulingRepository;
import com.traineeservice.service.ClassSchedulingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClassSchedulingServiceImpl implements ClassSchedulingService {
	public static Logger log = LoggerFactory.getLogger(ClassSchedulingService.class.getSimpleName());
	@Autowired

	private ClassSchedulingRepository classSchedulingRepository;

	@Override
	public void save(ClassScheduling scheduling) {
		classSchedulingRepository.save(scheduling);
		log.info("attendance details saved ", scheduling);
	}

	@Override
	public ClassScheduling get(Long id) {
		Optional<ClassScheduling> optional = classSchedulingRepository.findById(id);
		if (optional.isEmpty()) {
			try {
				optional.orElseThrow(() -> new NoSuchRecordFoundException("Provide correct details "));
			} catch (NoSuchRecordFoundException e) {
				throw e;
			}
		}
		System.out.println("fetched successfully");
		return optional.get();

	}

	@Override
	public List<ClassScheduling> getAll() {

		return  classSchedulingRepository.findAll();
	}

	@Override
	public String deleteById(Long id) {
		Optional<ClassScheduling> optional = classSchedulingRepository.findById(id);
		if (optional.isEmpty()) {
			try {
				optional.orElseThrow(() -> new NoSuchRecordFoundException("Provide correct details "));
			} catch (NoSuchRecordFoundException e) {
				throw e;
			}

		} else {
			classSchedulingRepository.deleteById(id);

		}

		return "deleted";
	}

	@Override
	public void deleteAll() {
		classSchedulingRepository.deleteAll();
	}

	@Override
	public  ClassScheduling update(ClassScheduling scheduling) {
		Optional<ClassScheduling> optional = classSchedulingRepository.findById(scheduling.getClassId());
		if (optional.isEmpty()) {
			try {
				optional.orElseThrow(() -> new NoSuchRecordFoundException("Provide correct details "));

			} catch (NoSuchRecordFoundException e) {
				throw e;
			}
		} else {
			classSchedulingRepository.save(scheduling);

		}
		return scheduling;
	}


}
