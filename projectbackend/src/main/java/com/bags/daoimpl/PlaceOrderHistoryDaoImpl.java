package com.bags.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bags.dao.PlaceOrderHistoryDao;
import com.bags.model.PlaceOrderHistory;

@Repository("placeOrderHistoryDaoImpl")
@Transactional
public class PlaceOrderHistoryDaoImpl implements PlaceOrderHistoryDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addPlaceOrderHistory(PlaceOrderHistory placeOrderHistory) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(placeOrderHistory);
	}

	public List<PlaceOrderHistory> getAllPlaceOrderHistory(String email) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from PlaceOrderHistory where user.email=?");
		query.setString(0, email);
		List<PlaceOrderHistory> placeOrderHistory=query.list();
		return placeOrderHistory;
	}

}
