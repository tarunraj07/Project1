package com.bags.dao;

import com.bags.model.PaymentMode;

public interface PaymentModeDao {
	PaymentMode getPayment(String digi16);
	boolean updatePayment(PaymentMode paymentMode);
}
