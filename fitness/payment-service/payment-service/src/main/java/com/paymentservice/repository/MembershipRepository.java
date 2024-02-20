package com.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.paymentservice.entity.Membership;

@Repository
@EnableJpaRepositories
public interface MembershipRepository extends JpaRepository<Membership, Long> {

	//void updateById(Payments payments);

}
