package com.app.main.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.main.pojo.Cart;
import com.app.main.pojo.Items;
import com.app.main.pojo.OrderItem;
import com.app.main.pojo.OrderState;
import com.app.main.pojo.State;
import com.app.main.pojo.Unit;
import com.app.main.pojo.User;
import com.app.main.pojo.UserOrder;
import com.app.main.pojo.OrderState;
@Repository
public class ItemDaoImpl implements ItemDao {
	
	@Autowired
	EntityManager em;
	@Override
	public void addItem(Items newItem,int vendorID) {
		User currentVendor =em.find(User.class, vendorID);
		newItem.addVendor(currentVendor);
		em.persist(newItem);
	}

	@Override
	public void removeItem(int itemId) {
		Items toDelete = em.find(Items.class, itemId);
		em.remove(toDelete);
		
	}

	@Override
	public List<Items> showItemList(String type) {
		ArrayList<Items> itemList = new ArrayList<Items>();
		String jpql = "select i from Items i where i.type=:tp";
		itemList = (ArrayList<Items>) em.createQuery(jpql,Items.class).setParameter("tp", type).getResultList();
		System.out.println("***********************************"+itemList);
		return itemList;
	}
	@Override
	public List<Items> showItemList(int vendorId) {
		User vendor = em.find(User.class, vendorId);
		ArrayList<Items> itemList = new ArrayList<Items>();
		String jpql = "select i from Items i where i.vendor=:v";
		itemList = (ArrayList<Items>) em.createQuery(jpql,Items.class).setParameter("v", vendor).getResultList();
		System.out.println("***********************************"+itemList);
		return itemList;
	}

	@Override
	public void addToCart(User user, int itemId) {
		User currentUser = user;
		System.out.println("Insde addto cart method current user is"+currentUser);
		String jpql = "select i from Items i where i.itemId=:id";
		Items i = em.createQuery(jpql,Items.class).setParameter("id", itemId).getSingleResult();
		OrderItem newOrderItem = new OrderItem(1,i);
		em.persist(newOrderItem);
		i.setStock(i.getStock()-1);
		Cart currentCart = new Cart(currentUser,State.INPROGRESS);
		currentCart.setUser(currentUser);
		String jpql1 = "select c from Cart c";
		List<Cart> cartList= em.createQuery(jpql1,Cart.class).getResultList();
		if(cartList.contains(currentCart)) {
			System.out.println("in if part of addcart");
			//continue with old cart
			int index=cartList.indexOf(currentCart);
			Cart oldCart = cartList.get(index);
			oldCart.addOrderItem(newOrderItem);
			System.out.println("************************************ \n"+oldCart.getOrderList());
			System.out.println("************************************");
		}
		else {
			System.out.println("in else part of addcart");
			//create new cart for new user
			currentCart.addOrderItem(newOrderItem);
			em.persist(currentCart);
			System.out.println("************************************ \n"+currentCart.getOrderList());
			System.out.println("************************************");
		}
	
	}

	@Override
	public void updateQuanity(OrderItem Oitem,int quant) {
		String jpql = "update OrderItem set quantity=:q where id=:id";
		em.createQuery(jpql).setParameter("q", quant).setParameter("id", Oitem.getId()).executeUpdate();
		Items i = Oitem.getOrderitem();
		long stock = i.getStock();
		 stock = stock-quant;
		 String jpql2="update Items set stock=:s where itemId=:id";
		 em.createQuery(jpql2).setParameter("s", stock).setParameter("id", i.getItemId()).executeUpdate();
		 
	}

	@Override
	public void editItem(Items i) {
		int id = i.getItemId();
		String name= i.getItemName();
		double price=i.getPrice(); 
		long stock= i.getStock(); 
		Unit perUnit=i.getPerUnit(); 
		String type=i.getType();
		String jpql = "update Items set itemName=:n,price=:p,stock=:s,perUnit=:pu,type=:t where itemId=:id";
		em.createQuery(jpql).setParameter("n", name).setParameter("p", price).setParameter("s", stock).setParameter("pu", perUnit).setParameter("t", type).setParameter("id", id).executeUpdate();
		
	}

	@Override
	public void removeFromCart(OrderItem o,int cartId) {
			Cart currentCart = em.find(Cart.class, cartId);
			currentCart.removeOrderItem(o);
			OrderItem item = em.find(OrderItem.class, o.getId());
			em.remove(item);
		
	}
		
}
