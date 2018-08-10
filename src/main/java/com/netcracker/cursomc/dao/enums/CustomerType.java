package com.netcracker.cursomc.dao.enums;

public enum CustomerType {
	
	PERSON(1, "Person"),
	COMPANY(2, "Company");
	
	private Integer id;
	private String description;
	
	private CustomerType(Integer id, String description) {
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
	
	public static CustomerType getCustomerType(Integer id) {
		CustomerType customerTypeSelected = null;
		
		for (CustomerType customerType : CustomerType.values()) {
			if(customerType.getId() == id) {
				customerTypeSelected = customerType;
			}
		}
		
		return customerTypeSelected;
	}

}
