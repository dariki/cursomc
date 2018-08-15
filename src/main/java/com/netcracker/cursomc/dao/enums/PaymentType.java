package com.netcracker.cursomc.dao.enums;

public enum PaymentType {
	
	PERSON(1, "Person"),
	COMPANY(2, "Company");
	
	private Integer id;
	private String description;
	
	private PaymentType(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String name) {
		this.description = name;
	}
	
	public static PaymentType getPaymentType(Integer id) {
		PaymentType paymentTypeSelected = null;
		
		for (PaymentType paymentType : PaymentType.values()) {
			if(paymentType.getId() == id) {
				paymentTypeSelected = paymentType;
			}
		}
		
		return paymentTypeSelected;
	}

}
