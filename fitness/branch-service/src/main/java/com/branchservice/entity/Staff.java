package com.branchservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "staff")
public class Staff implements Serializable {
	private static final long serialVersionUID = -1516965327693370237L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "staff_id")
	private Long staffId;
	@Column(name="staff_name")
	private String staffName;
	
	@Column(name="staff_role")
	private String staffRole;
	
	@Column(name="shift_start_time")
	public String shiftStartTime;
	
	@Column(name="shift_end_time")
	public String shiftEndTime;
	
	
	
	

}
