package com.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="membership_table")
public class Membership {
	private static final Long serialVersionUID = -1516965327693370237L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="membership_id")
	private Long membershipId;
	@Column(name="type")
	private String type;
	@Column(name="period")
	private String period;
	@Column(name="description")
	private String description;
	public Long getMembershipId() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
