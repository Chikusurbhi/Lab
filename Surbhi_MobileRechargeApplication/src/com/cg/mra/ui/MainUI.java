package com.cg.mra.ui;

import java.util.Scanner;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.AmountException;
import com.cg.mra.exception.MobileNoException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class MainUI {

	public static void main(String[] args) throws MobileNoException {
		int choice;
		// creating reference of service layer
		AccountService serref = new AccountServiceImpl();
		Scanner scanner = new Scanner(System.in);
		// Displaying the menu for user
		System.out.println("1) Account Balance Enquiry");
		System.out.println("2) Recharge Amount");
		System.out.println("3) Exit");
		// do while method
		do {
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			// switch for all the cases
			switch (choice) {
			// case 1 is for showing balance
			case 1: {
				System.out.println("Enter Mobile No:");
				scanner.nextLine();
				try {
					String mn = scanner.nextLine();
					if (serref.getAccountDetails(mn) == null) {
						throw new MobileNoException();
					} else {
						Account b = serref.getAccountDetails(mn);
						System.out.println("Your current balance is:" + b.getAccountBalance());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Invalid Mobile Number");
				}
			}
				break;
			// case 2 is for recharging account
			case 2: {
				System.out.println("Enter Mobile No:");
				scanner.nextLine();
				String mn = scanner.nextLine();
				System.out.println("Enter Recharge Amount:");
				double rb = scanner.nextDouble();

				try {
					double a = serref.rechargeAccount(mn, rb);
					Account a1 = serref.getAccountDetails(mn);
				} catch (AmountException e) {
					System.out.println("Invalid Amount");
				} catch (MobileNoException e) {
					// TODO Auto-generated catch block
					System.out.println("Mobile nuumber doesn't exists");
				}
			}
				break;
			case 3:
				System.exit(0);
			}

		} while (choice != 3);

	}
}
