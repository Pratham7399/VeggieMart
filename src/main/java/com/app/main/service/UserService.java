package com.app.main.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.main.pojo.Cart;
import com.app.main.pojo.OrderItem;
import com.app.main.pojo.User;

public interface UserService {
		User login(HttpSession session,@RequestParam String email,@RequestParam String pass);
		User login(String email,String pass);
		Cart findCart(User u);
		void updateQuantity(OrderItem o,int quant);
		void editUser(User user);
		void deleteUser(int userId);
		List<User> getAllUsers();
		void registerUser(User user);
		void removeFromCart(OrderItem o,int cartId);
		void completeOrder(int userId,Cart cart);
}
