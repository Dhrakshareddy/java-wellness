package com.training.bean;

public class ExerciseBean {

	private Long exerciseId;
	
	private String exerciseName;

	private String description;

	private String exerciseType;

	private Integer numberOfSets;
	
	private String equipmentNeeded;

	public Long getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(Long exerciseId) {
		this.exerciseId = exerciseId;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExerciseType() {
		return exerciseType;
	}

	public void setExerciseType(String exerciseType) {
		this.exerciseType = exerciseType;
	}

	public Integer getNumberOfSets() {
		return numberOfSets;
	}

	public void setNumberOfSets(Integer numberOfSets) {
		this.numberOfSets = numberOfSets;
	}

	public String getEquipmentNeeded() {
		return equipmentNeeded;
	}

	public void setEquipmentNeeded(String equipmentNeeded) {
		this.equipmentNeeded = equipmentNeeded;
	}

	@Override
	public String toString() {
		return "ExerciseBean [exerciseId=" + exerciseId + ", exerciseName=" + exerciseName + ", description="
				+ description + ", exerciseType=" + exerciseType + ", numberOfSets=" + numberOfSets
				+ ", equipmentNeeded=" + equipmentNeeded + "]";
	}
}
