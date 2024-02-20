package com.paymentservice.entity;

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
@Table(name = "membership")
public class Membership implements Serializable {
	private static final long serialVersionUID = -1516965327693370237L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "membership_id")
	private Long membershipId;
	
	@Column(name="membership_type")
	private String membershipType;
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name="membership_period")
	private String membershipPeriod;
	
	@Column(name="description")
	public String description;
	
	@Column(name="user_id")
	public Long userId;
	
	

		
	public Long getUserId() {
		return userId;
	}

	public Long getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(Long membershipId) {
		this.membershipId = membershipId;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public String getMembershipPeriod() {
		return membershipPeriod;
	}

	public void setMembershipPeriod(String membershipPeriod) {
		this.membershipPeriod = membershipPeriod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
//  @OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "user_id")
	//private UserRegistration userRegistration;
	
	
	
	

}
