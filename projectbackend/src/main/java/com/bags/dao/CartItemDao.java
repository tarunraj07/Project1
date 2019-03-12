package com.bags.dao;

import java.util.List;

import com.bags.model.CartItem;
import com.bags.model.User;

public interface CartItemDao {
	User getUser(String Email);
	void saveOrUpdateCartItem(CartItem cartItem);
	List<CartItem> getCartItem(String email);
	void removeCartItem(int itemId);
	CartItem getCartItemId(int itemId);
}
