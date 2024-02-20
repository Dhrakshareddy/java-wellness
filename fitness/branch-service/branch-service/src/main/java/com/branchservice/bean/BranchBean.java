package com.branchservice.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


public class BranchBean  {
	private static final long serialVersionUID = -1516965327693370237L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "branch_id")
	private Long branchId;
	@Column(name="branch_name")
	private String branchName;
	
	@Column(name="branch_address")
	private String branchAddress;
	
	@Column(name="contact_info")
	public Long contactInfo;

	
	
	
	
//  @OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "user_id")
	//private UserRegistration userRegistration;
	
	

}
