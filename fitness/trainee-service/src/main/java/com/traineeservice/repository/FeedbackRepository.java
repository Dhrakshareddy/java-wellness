package com.traineeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.traineeservice.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
