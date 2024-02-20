package com.paymentservice.bean;


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


public class PaymentBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private Long paymentId;
	
	
	@Column(name = "payment_amount")
	private Double paymentAmount;
	
	/* @NotBlank(message = "mode is mandatory") */
	@Column(name = "payment_mode")
	private String paymentMode;
	
	@Column(name="payment_date")
	
	
	private String paymentDate;
	
	private MembershipBean membership;
	
	
	
	
	//  @OneToOne(fetch = FetchType.LAZY)
	    //@JoinColumn(name = "membership_id")
		//private Membership membership;
	

}
