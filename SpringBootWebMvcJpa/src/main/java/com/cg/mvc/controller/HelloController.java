package com.cg.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mvc.bean.Customer;
import com.cg.mvc.bean.Employee;
import com.cg.mvc.exception.IdNotFindException;

import com.cg.mvc.service.ICustomerService;

@RestController
public class HelloController
{
	@Autowired
	ICustomerService service;
	
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String displayHello() {
		return "Hello";
	}
	
	@RequestMapping(value="/getEmployee",method=RequestMethod.GET,produces="application/json")
	public Employee getEmployeeDetails() {
		Employee emp=new Employee();
		emp.setFirstName("Yogini");
		emp.setLastName("Naik");
		emp.setEmail("yogini@gmail.com");
		emp.setMobileNo("1234567890");
		return emp;
		
	}
	
	@RequestMapping(value="/addEmployee",method=RequestMethod.POST)
	public String addEmployee(@RequestParam("fname")String firstname,
			                   @RequestParam("lname")String lastname,
			                   @RequestParam("mobno")String mobno,
			                   @RequestParam("email")String email)
	{
		Employee emp=new Employee();
		emp.setFirstName(firstname);
		emp.setLastName(lastname);
		emp.setMobileNo(mobno);
		emp.setEmail(email);
		return "Employee Added Successfully";
	}
	
	
	/*@RequestMapping(value="/addCustomer",method=RequestMethod.POST,produces="application/json")
	public Customer addCustomer(@RequestParam("firstname")String firstname,
            @RequestParam("lastname")String lastname,
            @RequestParam("age")int age,
            @RequestParam("city")String city,
            @RequestParam("mobno")String mobno,
            @RequestParam("email")String email)*/
	@RequestMapping(value="/addCustomer",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		
		 customer=service.addCustomer(customer);
		
		return customer;
	}
	
	@RequestMapping(value="/getCustomer/{custid}",produces="application/json",method=RequestMethod.POST) 
	public Customer findCustomer(@PathVariable int custid)
	{
		Customer customer=service.findCustomer(custid);
		
		return customer;
	}
	
	@RequestMapping(value="/updateCustomer",consumes="application/json",method=RequestMethod.POST,produces="application/json")
	public Customer updateCustomer(@RequestBody Customer customer) 
	{
		 customer=service.updateCustomer(customer);
		return customer;
	}
		
	@RequestMapping(value="/deleteCustomer/{cusid}",produces="application/json",consumes="application/json",method=RequestMethod.POST)
	public Customer deleteCustomer(@PathVariable int cusid)
	{
		Customer customer=service.deleteCustomer(cusid);
		return customer;
	}
	

	@RequestMapping(value="/getCustomerList",produces="application/json")
	public List<Customer> getCustomerList()
	{
		List<Customer> list=service.getCustomerList();
		return list;
	}
	
	@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Id does not exists")
	@ExceptionHandler({IdNotFindException.class})
	public void handleotherException()
	{
		
	}
	
}
