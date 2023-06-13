package com.app.main.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.main.pojo.Cart;
import com.app.main.pojo.Category;
import com.app.main.pojo.OrderItem;
import com.app.main.pojo.OrderState;
import com.app.main.pojo.User;
import com.app.main.pojo.UserOrder;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	EntityManager manager;
	
	public UserDaoImpl() {
		
	}
	
	@Override
	public User validate(String email, String pass) {
		try {
		String jpql = "select u from User u where u.email = :em and u.password=:pass";
		User u = manager.createQuery(jpql, User.class).setParameter("em", email)
				.setParameter("pass", pass).getSingleResult();
		return u;
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Cart findCart(User user) {
		String jpql = "select c from Cart c where c.user=:user";
		Cart c = manager.createQuery(jpql, Cart.class).setParameter("user", user).getSingleResult();
		System.out.println("************************************ \n"+c.getOrderList());
		System.out.println("************************************");
		return c;
	}

	@Override
	public List<UserOrder> finalOrderList(User u) {
		ArrayList<UserOrder> list = new ArrayList<>();
		String jpql = "select o from UserOrder o where o.user=:user";
		list=(ArrayList<UserOrder>) manager.createQuery(jpql,UserOrder.class).setParameter("user", u).getResultList();
		return list;
	}
	@Override
	public void registerUser(User user) {
		manager.persist(user);
	}

	@Override
	public List<User> getAllUsers() {
		String jpql="select u from User u ";
		
		ArrayList<User> list = new ArrayList<>();
		list=(ArrayList<User>) manager.createQuery(jpql,User.class).getResultList();
		System.out.println("here is the list"+list);
		return list;
	}

	@Override
	public void deleteUser(int userId) {
		User u=manager.find(User.class, userId);
		manager.remove(u); 
		
	}

	@Override
	public void editUser(User user) {
		int userId = user.getUserId();
		String userName = user.getUserName();
		String email = user.getEmail(); 
		String password = user.getPassword();
		String address  = user.getAddress();
		Category userType = user.getUserType();
		long contactNumber= user.getContactNumber();
		
		String jpql="update User set userName=:u,email=:e,password=:p,address=:a,userType=:t,contactNumber=:c where userId=:id";
		manager.createQuery(jpql).setParameter("u", userName).setParameter("e", email).setParameter("p", password).setParameter("a", address).setParameter("t", userType).setParameter("c", contactNumber).setParameter("id", userId).executeUpdate();
	}

	@Override
	public void removeFromCart(OrderItem o, int cartId) {
		Cart currentCart = manager.find(Cart.class, cartId);
		currentCart.removeOrderItem(o);
		manager.remove(o);
		
	}

	@Override
	public void finalUserOrder(int userId, Cart cart) {
		List<OrderItem> list = new ArrayList<OrderItem>();
		User currentUser = manager.find(User.class, userId);
		 list = cart.getOrderList();
			UserOrder finalOrder = new UserOrder(currentUser,OrderState.PAID);
			finalOrder.setPurchasedItems(list);
			Cart oldCart = manager.find(Cart.class, cart.getId());
			oldCart.getOrderList().removeAll(oldCart.getOrderList());
			manager.persist(finalOrder);
			
		
	}


}
