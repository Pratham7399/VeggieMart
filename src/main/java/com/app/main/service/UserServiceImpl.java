package com.app.main.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.main.dao.ItemDao;
import com.app.main.dao.UserDao;
import com.app.main.pojo.Cart;
import com.app.main.pojo.Category;
import com.app.main.pojo.OrderItem;
import com.app.main.pojo.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private ItemDao itemDao;
	@Autowired 
	private UserDao userDao;

	@Override
	public User login(HttpSession session,String email, String pass) {
		//map.addAttribute("item_list", itemDao.showItemList());
		User currentUser = userDao.validate(email, pass);
		
		if(currentUser!=null) {
			session.setAttribute("user_details", currentUser);
			return	currentUser;	
		}
		else
			return null;
		
	}

	@Override
	public User login(String email, String pass) {
		User currentUser = userDao.validate(email, pass);
		System.out.println("############################"+currentUser);
		return currentUser;
	}

	@Override
	public Cart findCart(User u) {
		
		return userDao.findCart(u);
	}

	@Override
	public void updateQuantity(OrderItem o, int quant) {
		itemDao.updateQuanity(o, quant);
		
	}
	@Override
	public void registerUser(User user) {
		userDao.registerUser(user);
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

	@Override
	public void deleteUser(int userId) {
		userDao.deleteUser(userId);
		
	}

	@Override
	public void editUser(User user) {
		userDao.editUser(user);
		


	}

	@Override
	public void removeFromCart(OrderItem o, int cartId) {
		userDao.removeFromCart(o, cartId);
		
	}

	@Override
	public void completeOrder(int userId,Cart cart) {
		userDao.finalUserOrder(userId, cart);
		
	}
	


	

}
