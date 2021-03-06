package com.netcracker.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.netcracker.cursomc.dao.enums.CustomerType;

@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String socialSecurity;
	private Integer customerType;
	
	@OneToMany(mappedBy = "customer")
	private List<Address> addresses = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "PHONE")
	private Set<String> phones = new HashSet<>();
	
	@OneToMany(mappedBy = "customer")
	private Set<Order> orders = new HashSet<>();
	
	public Customer() {}

	public Customer(Integer id, String name, String email, String socialSecurity, CustomerType customerType) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.socialSecurity = socialSecurity;
		this.customerType = customerType.getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	public CustomerType getCustomerType() {
		return CustomerType.getCustomerType(this.customerType);
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType.getId();
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public void setCustomerType(Integer customerType) {
		this.customerType = customerType;
	}
	
	
}
