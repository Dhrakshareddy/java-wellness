package com.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="doctor_profile")
public class Doctor 
{
	private static final Long serialVersionUID = -1516965327693370237L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="doctor_id")
	private Long doctorId;
	@Column(name="name")
	private String name;
	@Column(name="password")
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="year_of_experience")
	private Integer yearOfExperience;
	@Column(name="contact_no")
	private String contactNumber;
	@Column(name="shift_timings")
	private String shiftTimings;
	@Column(name="specialization")
	private String specialization;
	@Column(name="gender")
	private String gender;
	@Column(name="role")
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getDoctorId() {
		// TODO Auto-generated method stub
		return doctorId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getYearOfExperience() {
		return yearOfExperience;
	}
	public void setYearOfExperience(Integer yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getShiftTimings() {
		return shiftTimings;
	}
	public void setShiftTimings(String shiftTimings) {
		this.shiftTimings = shiftTimings;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	Doctor(Long doctorId, String name, String password, Integer yearOfExperience, String contactNumber,
			String shiftTimings, String specialization, String gender, String role) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.password = password;
		this.yearOfExperience = yearOfExperience;
		this.contactNumber = contactNumber;
		this.shiftTimings = shiftTimings;
		this.specialization = specialization;
		this.gender = gender;
		this.role = role;
	}
	
	

	
	
	
}
