package com.branchservice.service;

import com.branchservice.entity.Staff;

public interface StaffService {

	void save(Staff Staff);

	Staff get(Long staffId);

	Staff deleteById(Long staffId);

	//void update(staff staff);

	

	void updateEntity(Long staffId, String staffMode);

}
