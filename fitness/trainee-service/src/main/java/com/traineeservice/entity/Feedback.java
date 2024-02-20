package com.traineeservice.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
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
@Table(name = "feedback")
public class Feedback implements Serializable {
	private static final long serialVersionUID = -1516965327693370237L;

	@Id
	@Column(name = "feedback_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long feedbackId;

	@Column(name = "feedback_text")
	private String text;

	@Column(name = "feedback_date")
	private Date date;

	@Column(name = "rating")
	private Integer rating;

	public Long getFeedbackId() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@OneToOne
//	@JoinColumn(name="profile_id")
//	private Long profileId;
}
