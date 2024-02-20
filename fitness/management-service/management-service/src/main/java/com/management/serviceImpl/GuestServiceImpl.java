package com.management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.entity.Guest;
import com.management.entity.Trainer;
import com.management.entity.User;
import com.management.exception.ResourceNotFoundException;
import com.management.repository.GuestRepository;
import com.management.service.GuestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GuestServiceImpl implements GuestService {

	@Autowired
	private GuestRepository guestRepository;

	@Override
	public void save(Guest guest) {
		guestRepository.save(guest);
	}

	@Override
	public Guest get(Long id) {
		Optional<Guest> optional = guestRepository.findById(id);
		if (optional.isEmpty()) {
			try {
				optional.orElseThrow(() -> new ResourceNotFoundException("No guest found to fetch for id:" + id));
			} catch (ResourceNotFoundException e) {
				throw e;
			}
		}
		System.out.println("fetching successfully");
		return optional.get();

	}

	@Override
	public List<Guest> getAll() {
		return guestRepository.findAll();

	}

	public Guest deleteById(Long id) {
		Optional<Guest> optional = guestRepository.findById(id);
		if (optional.isEmpty()) {
			try {
				optional.orElseThrow(() -> new ResourceNotFoundException("No guest found to delete for id:" + id));
			} catch (ResourceNotFoundException e) {
				throw e;
			}
		}
		guestRepository.deleteById(id);
		System.out.println("fetching successfully");
		return optional.get();
	}

	public Guest update(Guest guest) {
		Optional<Guest> optional = guestRepository.findById(guest.getGuestId());
		if (optional.isEmpty()) {
			try {
				optional.orElseThrow(
						() -> new ResourceNotFoundException("No guest found to update :" + guest.getGuestId()));
			} catch (ResourceNotFoundException e) {
				throw e;
			}
		}
		guestRepository.save(guest);
		System.out.println("updated successfully");
		return guest;

	}
}
