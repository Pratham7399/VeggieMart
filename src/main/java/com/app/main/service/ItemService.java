package com.app.main.service;

import java.util.List;

import com.app.main.pojo.Items;
import com.app.main.pojo.OrderItem;
import com.app.main.pojo.User;

public interface ItemService {
	List<Items> getAllItem(String type);
	void addNewItemToCart(User u,int itemId);
	void addItem(Items i,int vendorId);
	void deleteItem(int itemId);
	List<Items>getAllItemsByVendor(int vendorID);
	void editItem(Items i);
	void removeFromCart(OrderItem o,int cartId);
}
