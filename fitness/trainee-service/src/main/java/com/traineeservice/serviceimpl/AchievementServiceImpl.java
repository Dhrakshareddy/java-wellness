package com.traineeservice.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traineeservice.entity.Achievement;
import com.traineeservice.exception.NoSuchRecordFoundException;
import com.traineeservice.repository.AchievementRepository;
import com.traineeservice.service.AchievementService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AchievementServiceImpl implements AchievementService {
	public static Logger log = LoggerFactory.getLogger(Achievement.class.getSimpleName());
	
	@Autowired

	private AchievementRepository achievementRepository;

	@Override
	public void save(Achievement achievement) {
		achievementRepository.save(achievement);
		log.info("achievement details saved ", achievement);
	
	}

	@Override
	public Achievement get(Long id) {

		Optional<Achievement> optional = achievementRepository.findById(id);
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
	public List<Achievement> getAll() {

		return achievementRepository.findAll();
	}

	@Override
	public String deleteById(Long id) {
		Optional<Achievement> optional = achievementRepository.findById(id);
		if (optional.isEmpty()) {
			try {
				optional.orElseThrow(() -> new NoSuchRecordFoundException("Provide correct details "));
			} catch (NoSuchRecordFoundException e) {
				throw e;
			}

		} else {
			achievementRepository.deleteById(id);

		}

		return "deleted";
	}

	@Override
	public void deleteAll() {
		achievementRepository.deleteAll();
	}

	@Override
	public Achievement update(Achievement achievement) {

		Optional<Achievement> optional = achievementRepository.findById(achievement.getId());
		if (optional.isEmpty()) {
			try {
				optional.orElseThrow(() -> new NoSuchRecordFoundException("Provide correct details "));

			} catch (NoSuchRecordFoundException e) {
				throw e;
			}
		} else {
			achievementRepository.save(achievement);

		}
		return achievement;
	}

}
