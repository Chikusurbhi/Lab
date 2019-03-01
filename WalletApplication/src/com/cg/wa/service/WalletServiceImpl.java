package com.cg.wa.service;

import java.util.HashMap;

import com.cg.wa.bean.Customer;
import com.cg.wa.bean.Wallet;
import com.cg.wa.dao.WalletDAO;
import com.cg.wa.dao.WalletDAOImpl;

public class WalletServiceImpl implements WalletService
{
	HashMap<String,Customer> nhmap= new HashMap<String,Customer>();
	WalletDAO DAOref;
	public WalletServiceImpl()
	{
		DAOref=new WalletDAOImpl();
	}

	public Customer createAccount(String Name, String PhoneNumber, double Amount) {
		 int id = 0;
		Wallet w= new Wallet(id, Amount);
		Customer c=new Customer(Name,PhoneNumber,w);
		DAOref.save(c);
		return c;
	}

	public Customer showBalance(String mobileNumber) {
		Customer c=DAOref.FindByNumber(mobileNumber);
		return c;
	}

	public Customer fundTransfer(String sourceMobileNumber,
			String targetMobileNumber, double amount) {
		Customer source=DAOref.FindByNumber(sourceMobileNumber);
		Customer target=DAOref.FindByNumber(targetMobileNumber);
		target.getWallet().setBalance(target.getWallet().getBalance()+amount);
		source.getWallet().setBalance(source.getWallet().getBalance()-amount);
		return target;
	}

	public Customer depositAmount(String mobileNumber, double amount) {
		Customer c=DAOref.FindByNumber(mobileNumber);
		c.getWallet().setBalance(c.getWallet().getBalance()+amount);
		return c;
	}

	public Customer withdrawAmount(String mobileNumber, double amount) {
		Customer c=DAOref.FindByNumber(mobileNumber);
		c.getWallet().setBalance(c.getWallet().getBalance()-amount);
		return c;
	}

}
