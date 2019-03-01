package com.cg.wa.dao;

import java.util.HashMap;

import com.cg.wa.bean.Customer;
import com.cg.wa.bean.Wallet;

public class WalletDAOImpl implements WalletDAO
{
	HashMap<String,Customer> nhmap= new HashMap<String,Customer>();
	
	
	public WalletDAOImpl()
	{
		Wallet w1= new Wallet(1,20000);
		Customer c1=new Customer("Surbhi","9897035958",w1);
		nhmap.put(c1.getPhone_no(),c1);
		

		Wallet w2= new Wallet(2,80000);
		Customer c2=new Customer("Neetu","9454666001",w2);
		nhmap.put(c2.getPhone_no(),c2);

		Wallet w3= new Wallet(3,20000);
		Customer c3=new Customer("Sudhir","9415432273",w3);
		nhmap.put(c3.getPhone_no(),c3);
		
	}

	public boolean save(Customer customer)
	{
		Customer c=nhmap.putIfAbsent(customer.getPhone_no(),customer);
		if(c==null)
			return false;
		
		return true;
		
	}

	public Customer FindByNumber(String PhoneNumber) {
		
		return nhmap.get(PhoneNumber);
	}

}
