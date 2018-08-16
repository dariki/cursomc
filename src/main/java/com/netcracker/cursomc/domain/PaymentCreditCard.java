package com.netcracker.cursomc.domain;

import javax.persistence.Entity;

import com.netcracker.cursomc.dao.enums.PaymentType;

@Entity
public class PaymentCreditCard extends Payment {

	private Integer numberOfInstallment;
	
	public PaymentCreditCard(Integer id, PaymentType paymentType, Integer numberOfInstallment) {
		super(id, paymentType);
		this.numberOfInstallment = numberOfInstallment;
	}

	public Integer getNumberOfInstallment() {
		return numberOfInstallment;
	}

	public void setNumberOfInstallment(Integer numberOfInstallment) {
		this.numberOfInstallment = numberOfInstallment;
	}
}
