package com.netcracker.cursomc.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class OrderItem {
	
	@EmbeddedId
	private OrderItemPK id;
	private Double discount;
	private Integer quantity;
	private Double price;
	
	public OrderItem() {}
	
	public OrderItem(Order order, Product product, Double discount, Integer quantity, Double price) {
		id = new OrderItemPK(order, product);
		this.discount = discount;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Double getDiscount() {
		return discount;
	}
	
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}

	public OrderItemPK getId() {
		return id;
	}

	public void setId(OrderItemPK id) {
		this.id = id;
	}
	
	

}
