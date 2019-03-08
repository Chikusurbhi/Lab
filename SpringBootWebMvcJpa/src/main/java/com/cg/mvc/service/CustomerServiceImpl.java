package com.cg.mvc.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mvc.bean.Customer;
import com.cg.mvc.repo.ICustomerRepository;
@Transactional
@Service("service")
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	ICustomerRepository repo;	
	public ICustomerRepository getRepo() {
		return repo;
	}
	public void setRepo(ICustomerRepository repo) {
		this.repo = repo;
	}
	@Override
	public Customer addCustomer(Customer customer) {
		return repo.addCustomer(customer);
	}
	@Override
	public Customer findCustomer(int customerid) {
		return repo.findCustomer(customerid);
	}
	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return repo.updateCustomer(customer);
	}
	@Override
	public List<Customer> getCustomerList() {
		return repo.getCustomerList();
	}
	@Override
	public Customer deleteCustomer(int customerid) {
		// TODO Auto-generated method stub
		return repo.deleteCustomer(customerid);
	}
}
