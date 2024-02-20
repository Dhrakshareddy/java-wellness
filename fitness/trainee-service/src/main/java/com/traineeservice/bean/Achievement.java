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
public class Achievement {
//	@NotNull(message="id is required")
	private Long id;

	private String achievementType;

	private Date dateCompleted;

	private String description;

//	private Long profileId;
}
