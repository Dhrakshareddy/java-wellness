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
@Table(name="guest_table")
public class Guest 
{
	private static final Long serialVersionUID = -1516965327693370237L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="guest_id")
	private Long guestId;
	@Column(name="password")
	private String  password;
	@Column(name="destination")
	private String destination;
	public Long getGuestId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
