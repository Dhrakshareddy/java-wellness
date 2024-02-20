package com.management.bean;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
@Setter
@Getter

@AllArgsConstructor
@ToString
public class TrainerBean {
	private Long trainerId;
	private String name;
	private String password;
	
	private String age;
	private Integer yearOfExperience;
	private String shiftTimings;
	private String certification;
	private String contactNumber;
	private String role;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Integer getYearOfExperience() {
		return yearOfExperience;
	}
	public void setYearOfExperience(Integer yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}
	public String getShiftTimings() {
		return shiftTimings;
	}
	public void setShiftTimings(String shiftTimings) {
		this.shiftTimings = shiftTimings;
	}
	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	TrainerBean(Long trainerId, String name, String age, Integer yearOfExperience, String shiftTimings,
			String certification, String contactNumber) {
		super();
		this.trainerId = trainerId;
		this.name = name;
		this.age = age;
		this.yearOfExperience = yearOfExperience;
		this.shiftTimings = shiftTimings;
		this.certification = certification;
		this.contactNumber = contactNumber;
	}
	TrainerBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	
 	

}
