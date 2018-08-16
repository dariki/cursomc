package com.netcracker.cursomc.domain;

import java.util.Calendar;

import javax.persistence.Entity;

import com.netcracker.cursomc.dao.enums.PaymentType;

@Entity
public class PaymentInvoice extends Payment {

	private Calendar duoDate;
	private Calendar paymentDate;
	
	public PaymentInvoice(Integer id, PaymentType paymentType, Calendar duoDate, Calendar paymentDate) {
		super(id, paymentType);
		this.duoDate = duoDate;
		this.paymentDate = paymentDate;
	}

	public Calendar getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Calendar paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Calendar getDuoDate() {
		return duoDate;
	}

	public void setDuoDate(Calendar duoDate) {
		this.duoDate = duoDate;
	}
}
