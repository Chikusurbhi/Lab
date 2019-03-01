package com.cg.wa.service;

import com.cg.wa.bean.Customer;


public interface WalletService {
	Customer createAccount(String Name,String PhoneNumber,double Amount);
	public Customer showBalance(String mobileNumber) ;
	public Customer fundTransfer(String sourceMobileNumber,String targetMobileNumber,double amount);
	public Customer depositAmount(String mobileNumber,double amount) ;
	public Customer withdrawAmount(String mobileNumber,double amount) ;

	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


