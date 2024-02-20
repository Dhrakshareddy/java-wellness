package com.branchservice.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tracking")
public class Tracking implements Serializable {
	private static final long serialVersionUID = -1516965327693370237L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tracking_id")
	private Long trackingId;
	
	@Column(name="tracking_date")
	private Date date;
	
	@Column(name="branch_name")
	private String sleepHours;
	
	@Column(name="branch_address")
	private String caloriesBurned;
	
	
	
	
	// @OneToMany(mappedBy = "userregistration", cascade = CascadeType.ALL, orphanRemoval = true)
	//private UserRegistration userRegistration;
	
	//  @OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "user_id")
   //private Excercise excercise;
	
//  @OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "nutrition_id")
	//private Nutrition nutrition;
	
	
	
	

}
