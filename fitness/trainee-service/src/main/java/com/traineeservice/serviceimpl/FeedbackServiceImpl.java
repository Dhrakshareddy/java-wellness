package com.traineeservice.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traineeservice.entity.Feedback;
import com.traineeservice.exception.NoSuchRecordFoundException;
import com.traineeservice.repository.FeedbackRepository;
import com.traineeservice.service.FeedbackService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FeedbackServiceImpl implements FeedbackService {
	public static Logger log = LoggerFactory.getLogger(FeedbackService.class.getSimpleName());
	@Autowired

	private FeedbackRepository feedbackRepository;

	@Override
	public void save(Feedback feedback) {
		feedbackRepository.save(feedback);
		log.info("feedback details saved ", feedback);
	}

	@Override
	public Feedback get(Long id) {
		Optional<Feedback> optional = feedbackRepository.findById(id);
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
	public List<Feedback> getAll() {

		return feedbackRepository.findAll();
	}

	@Override
	public String deleteById(Long id) {
		Optional<Feedback> optional = feedbackRepository.findById(id);
		if (optional.isEmpty()) {
			try {
				optional.orElseThrow(() -> new NoSuchRecordFoundException("Provide correct details "));
			} catch (NoSuchRecordFoundException e) {
				throw e;
			}

		} else {
			feedbackRepository.deleteById(id);

		}

		return "deleted";
	}

	@Override
	public void deleteAll() {
		feedbackRepository.deleteAll();
	}

	@Override
	public Feedback update(Feedback feedback) {
		Optional<Feedback> optional = feedbackRepository.findById(feedback.getFeedbackId());
		if (optional.isEmpty()) {
			try {
				optional.orElseThrow(() -> new NoSuchRecordFoundException("Provide correct details "));

			} catch (NoSuchRecordFoundException e) {
				throw e;
			}
		} else {
			feedbackRepository.save(feedback);

		}
		return feedback;
	}
}
