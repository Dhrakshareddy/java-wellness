package com.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.entity.Progress;

public interface ProgressRepository extends JpaRepository<Progress, Long>{

}
