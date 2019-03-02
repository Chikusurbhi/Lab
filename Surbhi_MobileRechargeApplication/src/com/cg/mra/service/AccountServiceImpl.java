package com.cg.mra.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.exception.AmountException;
import com.cg.mra.exception.MobileNoException;

public class AccountServiceImpl implements AccountService {
	// Reference object of Dao Layer
	AccountDao daoref = new AccountDaoImpl();

	// Overridden method of Interface which is throwing MobileNoException
	@Override
	public Account getAccountDetails(String mobileNo) throws MobileNoException {

		if (!validateMobNo(mobileNo))
			throw new MobileNoException();
		else
			return daoref.getAccountDetails(mobileNo);

	}

	// Overridden method of Interface which is throwing MobileNoException and
	// AmountException
	@Override
	public double rechargeAccount(String mobileNo, double rechargeAmount) throws MobileNoException, AmountException {
		if (!validateAmount(rechargeAmount))
			throw new AmountException();
		else if (!validateMobNo(mobileNo))
			throw new MobileNoException();
		return daoref.rechargeAccount(mobileNo, rechargeAmount);
	}

	// Method to validate the mobile number using pattern class
	public boolean validateMobNo(String mobNo) {
		// TODO Auto-generated method stub
		Pattern pat = Pattern.compile("[6-9][0-9]{9}");
		Matcher mat = pat.matcher(mobNo);
		return mat.matches();
	}

	// Method to validate the amount
	public boolean validateAmount(double reAmt) {
		// TODO Auto-generated method stub
		Pattern pat = Pattern.compile("[1-9][0-9.]{0,15}");
		Matcher mat = pat.matcher(String.valueOf(reAmt));
		return mat.matches();
	}

}
