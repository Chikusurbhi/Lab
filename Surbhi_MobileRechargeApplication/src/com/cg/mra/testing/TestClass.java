package com.cg.mra.testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.AmountException;
import com.cg.mra.exception.MobileNoException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class TestClass {
	AccountService serRef;

	@Before
	public void setup() {
		serRef = new AccountServiceImpl();
	}

	// Test case for checking valid mobile no
	@Test(expected = MobileNoException.class)
	public void TestOnRechargeAccountMethodV2() throws MobileNoException, AmountException {
		serRef.rechargeAccount("78945621", 123);
		serRef.rechargeAccount("7894581230", 0);
		serRef.rechargeAccount("8125407963", -45);
	}

	// Test case for checking valid amount
	@Test(expected = MobileNoException.class)
	public void TestOnRechargeAccountMethodV3() throws MobileNoException, AmountException {
		serRef.rechargeAccount("@@#^%", 45654);
		serRef.rechargeAccount(" ", -45643);
		serRef.rechargeAccount("	", -45643);
		serRef.rechargeAccount("afsfAAF#%#", -45643);
		serRef.rechargeAccount("", -45643);

	}

	// Test case for successful recharge
	@Test
	public void WhenRechargeIsSuccessfully() throws MobileNoException, AmountException {
		assertEquals(700, serRef.rechargeAccount("9010210131", 500), 0.01);
	}

	@After
	public void tearDown() {

		serRef = null;
	}

}
