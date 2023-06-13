package com.app.main.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.app.main.pojo.Items;
import com.app.main.pojo.OrderItem;
import com.app.main.pojo.User;
import com.app.main.pojo.UserOrder;

public interface ItemDao {
	void addItem(Items newItem,int vendorId);
	void removeItem(int itemId);
	List<Items> showItemList(String type);
	List<Items> showItemList(int vendorId);
	void addToCart(User user,int itemId);
	void updateQuanity(OrderItem item,int quant);
	void editItem(Items i);
	void removeFromCart(OrderItem o,int cartId);
}
