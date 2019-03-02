package com.cg.mra.dao;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.AmountException;
import com.cg.mra.exception.MobileNoException;

//Interface of Dao Layer
public interface AccountDao {
	Account getAccountDetails(String mobileNo);

	double rechargeAccount(String mobileNo, double rechargeAmount) throws MobileNoException, AmountException;

}
