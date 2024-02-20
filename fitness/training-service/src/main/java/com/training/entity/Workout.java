package com.training.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name="workout")
public class Workout implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="workout_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long workoutId;
	
	@Column(name="workout_date")
	private Date workoutDate;
	
	@Column(name="duration")
	private String duration;
	
	@Column(name="calories_burned")
	private String caloriesBurned;
	
	@Column(name="note")
	private String note;
	
	@Column(name="user_id")
	private Long userId;

	public Long getWorkoutId() {
		// TODO Auto-generated method stub
		return null;
	}

}