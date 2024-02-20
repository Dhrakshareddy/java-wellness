package com.traineeservice.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "achievement")
public class Achievement implements Serializable {

	private static final long serialVersionUID = -1516965327693370237L;

	@Id
	@Column(name = "achievement_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "achievement_type")
	private String achievementType;

	@Column(name = "date_completed")
	private Date dateCompleted;

	@Column(name = "description")
	private String description;
//	@OneToOne
//	@JoinColumn(name="profile_id")
//	private Long profileId;

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
