package com.healthservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "medicalhistory")
public class MedicalHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;
	private String dateOfAssessment;
	private int bloodPressure;
	private int heartRate;
	private String allergies;
	private String medications;
	private String chronicCondition;
	private String familyMedicalHistory;
	private String previousInjuryOrSurgery;
	private int fitnessLevel;
	private Integer physicianContactNumber;
	//private Long userId;
	private String userName;

}