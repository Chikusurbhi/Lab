package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.AmountException;
import com.cg.mra.exception.MobileNoException;

public interface AccountService {
	Account getAccountDetails(String mobileNo) throws MobileNoException;

	double rechargeAccount(String mobileNo, double rechargeAmount) throws MobileNoException, AmountException;

}
