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
@Table(name="progress")
public class Progress implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="progress_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long progressId;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="weight")
	private Double weight;
	
	@Column(name="fitness_test_results")
	private Double fitnessTestResults;

	public Long getProgressId() {
		// TODO Auto-generated method stub
		return null;
	}

}
