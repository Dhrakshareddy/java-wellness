package com.management.bean;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter

@ToString
public class Membership {
	private Long membershipId;
	private String type;
	private String period;
	private String description;
	public Long getMembershipId() {
		return membershipId;
	}
	public void setMembershipId(Long membershipId) {
		this.membershipId = membershipId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Membership(Long membershipId, String type, String period, String description) {
		super();
		this.membershipId = membershipId;
		this.type = type;
		this.period = period;
		this.description = description;
	}
	public Membership() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Membership [membershipId=" + membershipId + ", type=" + type + ", period=" + period + ", description="
				+ description + "]";
	}
	
   
}
