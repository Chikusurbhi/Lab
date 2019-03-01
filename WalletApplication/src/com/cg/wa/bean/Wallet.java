package com.cg.wa.bean;

public class Wallet {
	private int id;
	private double balance;
	public Wallet(int id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String toString() {
		return "Wallet [id=" + id + ", balance=" + balance + "]";
	}
	
	

}
