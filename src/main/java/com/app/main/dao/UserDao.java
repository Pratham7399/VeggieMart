package com.app.main.dao;

import java.util.List;

import com.app.main.pojo.Cart;
import com.app.main.pojo.OrderItem;
import com.app.main.pojo.User;
import com.app.main.pojo.UserOrder;

public interface UserDao {
	User validate(String email,String pass);
	Cart findCart(User user);
	List<UserOrder> finalOrderList(User u);
	void registerUser(User user);
	List<User> getAllUsers();
	void deleteUser(int userId);
	void editUser(User user);
	void removeFromCart(OrderItem o,int cartId);
	void finalUserOrder(int userId,Cart cart);
}
