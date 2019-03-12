package com.cg.mvc.service;

import java.util.List;

import com.cg.mvc.bean.Customer;


public interface ICustomerService {

	public Customer addCustomer(Customer customer);
	public Customer findCustomer(int customerid);
	public Customer updateCustomer(Customer customer);
	public Customer deleteCustomer(int customerid);
	public List<Customer> getCustomerList();
}
