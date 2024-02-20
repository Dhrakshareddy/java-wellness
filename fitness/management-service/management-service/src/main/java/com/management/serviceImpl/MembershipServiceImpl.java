package com.management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.entity.Membership;
import com.management.entity.Trainer;
import com.management.exception.ResourceNotFoundException;
import com.management.repository.DoctorRepository;
import com.management.repository.MembershipRepository;
import com.management.service.MembershipService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MembershipServiceImpl implements MembershipService {
	@Autowired
	private MembershipRepository membershipRepository;

	@Override
	public void save(Membership membership) {
		membershipRepository.save(membership);
	}

	@Override
	public List<Membership> getAll() {
		return membershipRepository.findAll();
	}

	@Override
	public Membership deleteById(Long id) {
		Optional<Membership> optional = membershipRepository.findById(id);
		if (optional.isEmpty()) {
			try {
				optional.orElseThrow(() -> new ResourceNotFoundException("No membership found to delete for id:" + id));
			} catch (ResourceNotFoundException e) {
				throw e;
			}
		}
		membershipRepository.deleteById(id);
		System.out.println("fetching successfully");
		return optional.get();
	}

	@Override
	public Membership update(Membership membership) {
		Optional<Membership> optional = membershipRepository.findById(membership.getMembershipId());
		if (optional.isEmpty()) {
			try {
				optional.orElseThrow(
						() -> new ResourceNotFoundException("No trainer found to update :" + membership.getType()));
			} catch (ResourceNotFoundException e) {
				throw e;
			}
		}
		membershipRepository.save(membership);
		System.out.println("updated successfully");
		return membership;

	}

	@Override
	public Membership get(Long id) {
		Optional<Membership> optional = membershipRepository.findById(id);
		if (optional.isEmpty()) {
			try {
				optional.orElseThrow(() -> new ResourceNotFoundException("No membership found to fetch for id:" + id));
			} catch (ResourceNotFoundException e) {
				throw e;
			}
		}
		System.out.println("fetching successfully");
		return optional.get();
	}

}
