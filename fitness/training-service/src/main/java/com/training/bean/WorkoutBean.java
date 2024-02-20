package com.training.bean;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WorkoutBean {

	private Date workoutDate;

	private String duration;
	
	private String caloriesBurned;
	
	private String note;
	
	private Long userId;

}
