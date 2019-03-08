package com.cg.mvc.repo;

import java.util.ArrayList;
import java.util.List;

import com.cg.mvc.bean.Customer;

public interface ICustomerRepository {

	public Customer addCustomer(Customer customer);
	public Customer findCustomer(int customerid);
	public Customer updateCustomer(Customer customer);
	public List<Customer> getCustomerList();
public Customer deleteCustomer(int custid);
}
