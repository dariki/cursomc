package com.netcracker.cursomc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.netcracker.cursomc.dao.enums.PaymentType;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer paymentType;
	
	public Payment(Integer id, PaymentType paymentType) {
		super();
		this.id = id;
		this.paymentType = paymentType.getId();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public PaymentType getPaymentType() {
		return PaymentType.getPaymentType(paymentType);
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType.getId();
	}
	
}
