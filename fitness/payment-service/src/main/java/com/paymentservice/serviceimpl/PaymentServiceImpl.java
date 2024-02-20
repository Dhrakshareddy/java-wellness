package com.paymentservice.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentservice.bean.PaymentInfoBean;
import com.paymentservice.entity.Payment;
import com.paymentservice.exceptions.ResourceNotFoundException;
import com.paymentservice.repository.PaymentRepository;
import com.paymentservice.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public void save(Payment payments) {
		paymentRepository.save(payments);

	}

	@Override
	public Payment get(Long paymentId) throws Exception{
		
		
		Optional<Payment> optional= paymentRepository.findById(paymentId);
		
//		 if(optional.isPresent())
//			{
//			optional.get();
//			}else {
//				try {
//					optional.orElseThrow(() -> new IllegalArgumentException("Payment not found with id-" + paymentId));
//				}
//				catch(Exception e){
//					
//					System.out.println("exception handled");
//					
//				}
//			
//			};
//		
//			return optional.get();
		
		
		 if(optional.isEmpty())
			{
		
			try {
					optional.orElseThrow(() -> new ResourceNotFoundException("Payment not found with id-" + paymentId));
			}
			catch(ResourceNotFoundException e){
				
				System.out.println("exception handled");
				throw e;
				
			}
			
			};
				return optional.get();
		
		
				
	}

	@Override
	public Payment deleteById(Long paymentId) {
		
		return null;	

}



	 
	 @Transactional
public void updateEntity(Long paymentId, String paymentMode) {
	Payment payments = paymentRepository.findById(paymentId).orElse(null);
	if(payments!=null)
	{
	payments.setPaymentMode(paymentMode);
	paymentRepository.save(payments);
	}
	
}
	 
	 @Override
		public List<PaymentInfoBean> getPaymentMembership() {
			return paymentRepository.getPaymentMembership();
		}
}
