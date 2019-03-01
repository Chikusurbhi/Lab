package com.cg.wa.ui;

import java.util.Scanner;

import com.cg.wa.service.WalletService;
import com.cg.wa.service.WalletServiceImpl;

public class Client {

	public static void main(String[] args)
	{ 
		WalletService serref=new WalletServiceImpl();
		Scanner scanner= new Scanner(System.in);
		int choice;
		System.out.println("1.Create Account");
		System.out.println("2.Show Balance");
		System.out.println("3.Fund Transfer");
		System.out.println("4.Deposit Amount");
		System.out.println("5.WithDraw Amount");
		
		do
		{
			System.out.println("Enter your choice:");
			choice=scanner.nextInt();
			switch(choice)
			{
			case 1:{
				    System.out.println("Enter the name");
				    String n=scanner.next();
				    System.out.println("Enter phone no");
				    String pn=scanner.next();
				    System.out.println("Enter the amount");
				    double a=scanner.nextDouble();
				    System.out.println(serref.createAccount(n, pn, a));
			       }
			       break;
			case 2:{
				   System.out.println("Enter the phone no");
				   String pn=scanner.next();
				   System.out.println(serref.showBalance(pn).getWallet().getBalance());
			       }
			       break;
			case 3:{
				    System.out.println("Enter the amount to be transfered");
				    double a=scanner.nextDouble();
				    System.out.println("Enter the source mobile no");
				    String s=scanner.next();
				    System.out.println("Enter the target mobile no");
				    String t=scanner.next();
				    System.out.println(serref.fundTransfer(s, t, a));
			       }
			        break;
			case 4:{
				    System.out.println("Enter the phone no");
				    String pn=scanner.next();
				    System.out.println("Enter the amount");
				    double a=scanner.nextDouble();
				    System.out.println(serref.depositAmount(pn, a));
				    }
			        break;
			case 5:{
				System.out.println("Enter the phone no");
			    String pn=scanner.next();
			    System.out.println("Enter the amount");
			    double a=scanner.nextDouble();
			    System.out.println(serref.withdrawAmount(pn, a));
			    }
			    break;
			case 6:{
				   System.exit(0);
			}
			    
			}
			
		}while(choice!=6);

	}

}
