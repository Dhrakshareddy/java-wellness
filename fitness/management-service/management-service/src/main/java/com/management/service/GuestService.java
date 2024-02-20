package com.management.service;

import java.util.List;

import com.management.entity.Guest;
import com.management.entity.Membership;

public interface GuestService {
	void save(Guest guest);
	Guest get(Long id);
	List<Guest> getAll();
	Guest deleteById(Long id);
	Guest update(Guest guest);

}
