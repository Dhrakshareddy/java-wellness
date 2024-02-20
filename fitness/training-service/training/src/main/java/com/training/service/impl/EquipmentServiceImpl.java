package com.training.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.entity.Equipment;
import com.training.exception.ResourceNotFoundException;
import com.training.repository.EquipmentRepository;
import com.training.service.EquipmentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EquipmentServiceImpl implements EquipmentService {

	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Override
	public void save(Equipment equipment) {
		equipmentRepository.save(equipment);
		System.out.println("Save success");
	}

	@Override
	public void update(Equipment equipment) {
		Optional<Equipment> optional=equipmentRepository.findById(equipment.getEquipmentId());
		if(optional.isPresent()) {
			equipmentRepository.save(equipment);
			System.out.println("Update Success");
		}else {
			optional.orElseThrow(()->new ResourceNotFoundException("No equipment found to update for id : "+equipment.getEquipmentId()));
		}
		
	}
	
	@Override
	public Equipment getById(Long id) {
		Optional<Equipment> optional=equipmentRepository.findById(id);
		if(optional.isPresent()) {
			equipmentRepository.deleteById(id);
			System.out.println("Delete success");
			return optional.get();
		}else {
			optional.orElseThrow(()->new ResourceNotFoundException("No Equipment found to delete for id : "+id));
		}
		return null;
	}
	
	@Override
	public List<Equipment> getAll() {
		 return equipmentRepository.findAll();
	}

	@Override
	public Equipment delete(Long id) {
		Optional<Equipment> optional=equipmentRepository.findById(id);
		if(optional.isPresent()) {
			System.out.println("Fetch success");
			return optional.get();
		}else {
			optional.orElseThrow(()->new ResourceNotFoundException("No Equipment found to fetch for id : "+id));
		}
		return null;
	}

	

}
