package com.cg.wa.bean;

public class Customer
{
	private String name;
	private String phone_no;
	private Wallet wallet;
	public Customer(String name, String phone_no, Wallet wallet) {
		super();
		this.name = name;
		this.phone_no = phone_no;
		this.wallet = wallet;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	public String toString() {
		return "Customer [name=" + name + ", phone_no=" + phone_no
				+ ", wallet=" + wallet + "]";
	}
	
	

}
