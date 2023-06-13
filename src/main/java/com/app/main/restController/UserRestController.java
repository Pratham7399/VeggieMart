package com.app.main.restController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.main.dao.ItemDao;
import com.app.main.dto.LoginData;
import com.app.main.pojo.Cart;
import com.app.main.pojo.Items;
import com.app.main.pojo.OrderItem;
import com.app.main.pojo.User;
import com.app.main.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping
public class UserRestController {
	public UserRestController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private UserService userService;
	@Autowired
	private ItemDao idao;

	@PostMapping("/user")
	public ResponseEntity<?> login(@RequestBody LoginData data) {
		System.out.println("in login method of user");
		String email = data.getEmail();
		String pass = data.getPass();
		return new ResponseEntity<>(userService.login(email, pass), HttpStatus.CREATED);
	}

	@PostMapping("/cart")
	public Cart findCart(@RequestBody User u) {
		return userService.findCart(u);
	}

	@PutMapping("/cart/{task}")
	public void updateQuantity(@RequestBody OrderItem i, @PathVariable String task) {
		System.out.println(i.getId() + "  " + i);
		if (task.equals("increase")) {
			int quant = i.getQuantity() + 1;
			System.out.println(quant);
			userService.updateQuantity(i, quant);
		}
		if (task.equals("decrease")) {
			int quant = i.getQuantity() - 1;
			if (quant > 0)
				userService.updateQuantity(i, quant);
		}
	}

	@PostMapping("/register")
	public void registerUser(@RequestBody User user) {
		userService.registerUser(user);

	}

	@GetMapping("/profile0")
	public List<User> getAllUsers() {

		return userService.getAllUsers();
	}

	@DeleteMapping("/profile0/{userId}")
	public void deleteUser(@PathVariable int userId) {
		userService.deleteUser(userId);
	}

	@PutMapping("/editUser")
	public void editUser(@RequestBody User user) {
		userService.editUser(user);
	}

	@PostMapping("/payment/{userId}")
	public void completeOrder(@PathVariable int userId, @RequestBody Cart cart) {
		System.out.println("in user rest com or"+userId+cart);
		userService.completeOrder(userId, cart);
	}
}
