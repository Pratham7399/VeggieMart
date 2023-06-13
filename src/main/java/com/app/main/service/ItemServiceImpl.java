package com.app.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.main.dao.ItemDao;
import com.app.main.pojo.Items;
import com.app.main.pojo.OrderItem;
import com.app.main.pojo.User;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
	public ItemServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private ItemDao idao;
	
	@Override
	public List<Items> getAllItem(String type) {
		
		return idao.showItemList(type);
	}

	@Override
	public void addNewItemToCart(User u,int itemId) {
		
		idao.addToCart(u, itemId);
	}

	@Override
	public void addItem(Items i,int vendorId) {
		idao.addItem(i, vendorId);
		
	}
	@Override
	public void deleteItem(int itemId) {
		idao.removeItem(itemId);
	}

	@Override
	public List<Items> getAllItemsByVendor(int vendorID) {
		
		return idao.showItemList(vendorID);
	}

	@Override
	public void editItem(Items i) {
		idao.editItem(i);
		
	}

	@Override
	public void removeFromCart(OrderItem o, int cartId) {
		idao.removeFromCart(o, cartId);
		
	}

}
