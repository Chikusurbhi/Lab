package com.cg.mra.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.AmountException;
import com.cg.mra.exception.MobileNoException;

public class AccountDaoImpl implements AccountDao {
	// Map for storing data
	Map<String, Account> accountEntry;

	public AccountDaoImpl() {
		// creating object of HashMap
		accountEntry = new HashMap<>();
		// Storing the values in HashMap
		accountEntry.put("9010210131", new Account("Prepaid", "Vaishali", 200));
		accountEntry.put("9823920123", new Account("Prepaid", "Megha", 453));
		accountEntry.put("9932012345", new Account("Prepaid", "Vikas", 631));
		accountEntry.put("9010210132", new Account("Prepaid", "Anju", 521));
		accountEntry.put("9010210133", new Account("Prepaid", "Tushar", 632));
		// In question duplicate Mobile numbers are given that's why I have modified
		// last two mobile numbers.

	}

	// getAccountDetails method for getting the details of account on accepting the
	// mobile number
	@Override
	public Account getAccountDetails(String mobileNo) {
		Account a = accountEntry.get(mobileNo);
		if (a == null)
			System.out.println("Given account id Does Not Exists");
		return a;

	}

	// rechargeAccount method for adding the amount with the current balance in
	// account on accepting mobile number and recharge amount
	@Override
	public double rechargeAccount(String mobileNo, double rechargeAmount) throws MobileNoException, AmountException {
		double nab;
		Account a = accountEntry.get(mobileNo);
		if (a == null) {
			System.out.println("Cannot Recharge Account as Given Mobile No Does Not Exists");
			throw new MobileNoException();
		} else {
			nab = a.getAccountBalance() + rechargeAmount;
			a.setAccountBalance(nab);
			System.out.println("Your Account Recharged Successfully");
			System.out.println("Hello  " + a.getCustomerName() + ",Available Balance is" + a.getAccountBalance());

		}
		return nab;
	}
}