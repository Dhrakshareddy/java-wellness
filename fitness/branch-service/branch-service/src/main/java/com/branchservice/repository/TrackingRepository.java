package com.branchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.branchservice.entity.Tracking;

@Repository
@EnableJpaRepositories
public interface TrackingRepository extends JpaRepository<Tracking, Long> {

	//void updateById(Payments payments);

}
