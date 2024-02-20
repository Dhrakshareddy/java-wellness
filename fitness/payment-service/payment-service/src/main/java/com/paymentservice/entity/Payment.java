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
@Table(name = "payments")
public class Payment implements Serializable {
	private static final long serialVersionUID = -1516965327693370237L;

	
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
	
	@Column(name="status")
	private Boolean status;
	
	public  String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate( String paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public Double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	@Column(name = "membership_id")
	private Long membershipId;
	
	
	
	//  @OneToOne(fetch = FetchType.LAZY)
	    //@JoinColumn(name = "membership_id")
		//private Membership membership;
	

}
