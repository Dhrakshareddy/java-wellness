package com.branchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.branchservice.entity.Staff;

@Repository
@EnableJpaRepositories
public interface StaffRepository extends JpaRepository<Staff, Long> {

	//void updateById(Payments payments);

}
