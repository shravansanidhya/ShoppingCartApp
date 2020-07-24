package com.mindtree.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.dao.UserDao;
import com.mindtree.entity.Cart;
import com.mindtree.entity.User;
import com.mindtree.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public void addUser(String userName) {
		double randomDouble = Math.random();
		randomDouble = randomDouble * 100 + 1;
		int randomInt = (int) randomDouble;
		User user = new User();
		user.setUserId(randomInt);
		user.setUserName(userName);
		double randomDouble2 = Math.random();
		randomDouble2 = randomDouble * 100 + 1;
		int randomInt2 = (int) randomDouble2;
		Cart cart = new Cart();
		cart.setCartId(randomInt2);
		cart.setProducts(null);
		cart.setUser(user);
		user.setCart(cart);
		this.userDao.save(user);
		System.out.println("hello");
	}
	
}
