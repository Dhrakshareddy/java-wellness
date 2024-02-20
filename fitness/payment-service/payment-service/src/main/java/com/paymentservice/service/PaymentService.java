package com.paymentservice.service;

import java.util.List;

import com.paymentservice.bean.PaymentInfoBean;
import com.paymentservice.entity.Payment;

public interface PaymentService {

	void save(Payment payment);

	Payment get(Long paymentId) throws Exception;

	Payment deleteById(Long paymentId);

	//void update(Payments payments);

	

	void updateEntity(Long paymentId, String paymentMode);
	
	List<PaymentInfoBean> getPaymentMembership();

}
