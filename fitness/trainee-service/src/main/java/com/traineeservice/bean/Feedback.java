package com.traineeservice.bean;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Feedback {
	@NotNull(message = "id is required")	
	private Long feedbackId;

	private String text;

	private Date date;

	private Integer rating;

//	private Long profileId;
}
