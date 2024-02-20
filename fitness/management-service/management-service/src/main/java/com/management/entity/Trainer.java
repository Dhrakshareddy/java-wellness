package com.management.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@Table(name="trainer_profile")
public class Trainer implements Serializable {
	private static final Long serialVersionUID = -1516965327693370237L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="trainer_id")
	private Long trainerId;
	@Column(name="trainer_name")
	private String name;
	@Column(name="password")
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="age")
	private String age;
	@Column(name="year_of_experience")
	private Integer yearOfExperience;
	@Column(name="shift_timings")
	private String shiftTimings;
	@Column(name="certification")
	private String certification;
	@Column(name="contact_No")
	private String contactNumber;
	@Column(name="role")
	private String role;
public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	//	@OneToMany(mapped="trainer_profile",cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<User>user =new ArrayList<>();
	public Long getTrainerId() {
		// TODO Auto-generated method stub
		return trainerId;
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
	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}
	Trainer(Long trainerId, String name, String age, Integer yearOfExperience, String shiftTimings,
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
	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


}
