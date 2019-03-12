package com.bags.dao;

import java.util.List;

import com.bags.model.PlaceOrderHistory;

public interface PlaceOrderHistoryDao {	
	void addPlaceOrderHistory(PlaceOrderHistory placeOrderHistory);
	List<PlaceOrderHistory> getAllPlaceOrderHistory(String email);
}
