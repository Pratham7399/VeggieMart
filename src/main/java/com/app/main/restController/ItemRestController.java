package com.app.main.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.main.dao.ItemDao;
import com.app.main.pojo.Items;
import com.app.main.pojo.OrderItem;
import com.app.main.pojo.User;
import com.app.main.service.ItemService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class ItemRestController {
	public ItemRestController() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * @Autowired private ItemDao idao;
	 */
	@Autowired
	private ItemService iservice;
	
	@GetMapping("items/{type}")
	public List<Items> allItems(@PathVariable String type){
		return iservice.getAllItem(type);
	}
	@PostMapping("items/fruits/{itemId}")
	public void addNewItemToCart(@RequestBody User u,@PathVariable int itemId) {
		iservice.addNewItemToCart(u, itemId);
	}
	@PostMapping("/addItem/{vendorId}")
	public void addItem(@RequestBody Items i,@PathVariable int vendorId) {
		iservice.addItem(i, vendorId);
	}
	@GetMapping("/profile/{vendorId}")
	public List<Items> allVendorItems(@PathVariable int vendorId) {
		return iservice.getAllItemsByVendor(vendorId);
	}
	@DeleteMapping("/profile/{itemId}")
	public void deleteItem(@PathVariable int itemId){
		iservice.deleteItem(itemId);
	}
	@PutMapping("/editItem")
	public void editItem(@RequestBody Items i) {
		iservice.editItem(i);
	}
	@PostMapping("/cart/{cartId}")
	public void removeFromCart(@RequestBody OrderItem OrderI,@PathVariable int cartId) {
		iservice.removeFromCart(OrderI, cartId);
	}
}
