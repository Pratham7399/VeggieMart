package com.app.main.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_order")
public class UserOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	@Column(name="order_state")
	private OrderState state;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumns(@JoinColumn(name="order_id"))
	private List<OrderItem> purchasedItems = new ArrayList<>();
	
	public UserOrder() {
		// TODO Auto-generated constructor stub
	}

	public UserOrder(User user, OrderState state) {
		super();
		this.user = user;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}

	public List<OrderItem> getPurchasedItems() {
		return purchasedItems;
	}

	public void setPurchasedItems(List<OrderItem> purchasedItems) {
		this.purchasedItems = purchasedItems;
	}

	@Override
	public String toString() {
		return "UserOrder [id=" + id + ", user=" + user + ", state=" + state + ", purchasedItems=" + purchasedItems
				+ "]";
	}
	
	
}
