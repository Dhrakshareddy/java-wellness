package com.training.service;

import java.util.List;

import com.training.entity.Equipment;

public interface EquipmentService {

	void save(Equipment equipment);

	void update(Equipment equipment);
	
	Equipment getById(Long id);

	List<Equipment> getAll();

	Equipment delete(Long id);

}
