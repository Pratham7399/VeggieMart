
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	@Column(name="state")
	private State currentState;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="cart_id")
	private List<OrderItem> orderList= new ArrayList<>();
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(User user, State currentState) {
		super();
		this.user = user;
		this.currentState = currentState;
		
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

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	public List<OrderItem> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderItem> orderList) {
		this.orderList = orderList;
	}
	//helper methods
	public void addOrderItem(OrderItem i) {
		orderList.add(i);
	}
	public void removeOrderItem(OrderItem i) {
		orderList.remove(i);
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + ", currentState=" + currentState + ", OrderList=" + orderList
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	
	
	
}
