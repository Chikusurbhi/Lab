package com.cg.wa.dao;

import com.cg.wa.bean.Customer;

public interface WalletDAO {
	boolean save(Customer customer);
	Customer FindByNumber(String PhoneNumber);
	
	
	
	
	}
