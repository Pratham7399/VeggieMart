package com.app.main.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_item")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int quantity;
	@OneToOne()
	private Items orderitem;
	public OrderItem() {
		// TODO Auto-generated constructor stub
	} 
	// List<OrderItem> list = cart.getOrderList()-----> 
	
	public OrderItem(int quantity, Items orderitem) {
		super();
		this.quantity = quantity;
		this.orderitem = orderitem;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Items getOrderitem() {
		return orderitem;
	}
	public void setOrderitem(Items orderitem) {
		this.orderitem = orderitem;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", quantity=" + quantity + ", Orderitem=" + orderitem + "]";
	}
	
	
}
