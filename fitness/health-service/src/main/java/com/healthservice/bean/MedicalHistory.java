package com.healthservice.bean;

import java.sql.Date;




public class MedicalHistory {

	
	private Long memberId;
	private Date dateOfAssessment;
	private float bloodPressure;
	private float heartRate;
	private String allergies;
	private String medications;
	private String chronicCondition;
	private String familyMedicalHistory;
	private String previousInjuryOrSurgery;
	private float fitnessLevel;
	private Integer physicianContactNumber;
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public Date getDateOfAssessment() {
		return dateOfAssessment;
	}
	public void setDateOfAssessment(Date dateOfAssessment) {
		this.dateOfAssessment = dateOfAssessment;
	}
	public float getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(float bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	public float getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(float heartRate) {
		this.heartRate = heartRate;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public String getMedications() {
		return medications;
	}
	public void setMedications(String medications) {
		this.medications = medications;
	}
	public String getChronicCondition() {
		return chronicCondition;
	}
	public void setChronicCondition(String chronicCondition) {
		this.chronicCondition = chronicCondition;
	}
	public String getFamilyMedicalHistory() {
		return familyMedicalHistory;
	}
	public void setFamilyMedicalHistory(String familyMedicalHistory) {
		this.familyMedicalHistory = familyMedicalHistory;
	}
	public String getPreviousInjuryOrSurgery() {
		return previousInjuryOrSurgery;
	}
	public void setPreviousInjuryOrSurgery(String previousInjuryOrSurgery) {
		this.previousInjuryOrSurgery = previousInjuryOrSurgery;
	}
	public float getFitnessLevel() {
		return fitnessLevel;
	}
	public void setFitnessLevel(float fitnessLevel) {
		this.fitnessLevel = fitnessLevel;
	}
	public Integer getPhysicianContactNumber() {
		return physicianContactNumber;
	}
	public void setPhysicianContactNumber(Integer physicianContactNumber) {
		this.physicianContactNumber = physicianContactNumber;
	}
	
	public MedicalHistory(Long memberId, Date dateOfAssessment, float bloodPressure, float heartRate,
			String allergies, String medications, String chronicCondition, String familyMedicalHistory,
			String previousInjuryOrSurgery, float fitnessLevel, Integer physicianContactNumber) {
		super();
		this.memberId = memberId;
		this.dateOfAssessment = dateOfAssessment;
		this.bloodPressure = bloodPressure;
		this.heartRate = heartRate;
		this.allergies = allergies;
		this.medications = medications;
		this.chronicCondition = chronicCondition;
		this.familyMedicalHistory = familyMedicalHistory;
		this.previousInjuryOrSurgery = previousInjuryOrSurgery;
		this.fitnessLevel = fitnessLevel;
		this.physicianContactNumber = physicianContactNumber;
	}
	private MedicalHistory()
	{
		
	}
	@Override
	public String toString() {
		return "MedicalHistoryBean [memberId=" + memberId + ", dateOfAssessment=" + dateOfAssessment
				+ ", bloodPressure=" + bloodPressure + ", heartRate=" + heartRate + ", allergies=" + allergies
				+ ", medications=" + medications + ", chronicCondition=" + chronicCondition + ", familyMedicalHistory="
				+ familyMedicalHistory + ", previousInjuryOrSurgery=" + previousInjuryOrSurgery + ", fitnessLevel="
				+ fitnessLevel + ", physicianContactNumber=" + physicianContactNumber + "]";
	}
}
