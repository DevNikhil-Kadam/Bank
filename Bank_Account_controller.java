package org.nik.controller;

import java.util.Scanner;

import org.nik.dao.Bank_Account_dao;
import org.nik.dto.Account;
import org.nik.dto.Bank;

public class Bank_Account_controller {

	public static void main(String[] args) {
		Bank_Account_dao dao=new Bank_Account_dao();
		Scanner sc=new Scanner(System.in);
		Scanner sw=new Scanner(System.in);
		
		boolean option=true;
		System.out.println("**********WELCOME TO UNIVERSAL BANK**********");
		while (option) {
			System.out.println("===============================================");
			System.out.println("ENTER 1 FOR BANK DETAILS AND ACCOUNT DETAILS");
			System.out.println("ENTER 2 FOR DEPOSIT");
			System.out.println("ENTER 3 FOR WITHDRAW");
			System.out.println("ENTER 4 FOR UPDATE");
			System.out.println("ENTER 5 FOR FIND");
			System.out.println("ENTER 6 FOR DISPLAY ALL");
			System.out.println("ENTER 7 FOR DELETE");
			System.out.println("ENTER 8 FOR EXIT");
			System.out.println("===SELECT THE NUMBER===");
			
			int swi=sw.nextInt();
			switch (swi) {
			case 1:{
				Bank bank=new Bank();
				Account account=new Account();
				System.out.println("Enter Bank Details: ");
				System.out.println("---------------------");
				System.out.println("Bank name: ");
				String bn=sc.nextLine();
				bank.setBname(bn);
				System.out.println("Location: ");
				String lc=sc.next();
				bank.setLoc(lc);
				System.out.println("IFSC code: ");
				String ifc=sc.next();
				bank.setIfsc(ifc);
				
				System.out.println("Enter Account Details");
				System.out.println("----------------------");
				System.out.println("Customer Name: ");
				String cn=sc.next();
				account.setName(cn);
				System.out.println("Account No: ");
				long ac=sc.nextLong();
				account.setAccno(ac);
				System.out.println("Date of Birth");
				String dob1=sc.next();
				account.setDob(dob1);
				System.out.println("Pincode");
				int pn=sc.nextInt();
				account.setPin(pn);
				System.out.println("Enter Money");
				int mn=sc.nextInt();
				account.setMoney(mn);
				
				Scanner sq=new Scanner(System.in);
				
				System.out.println("Enter 1 TO SAVE BANK ACCOUNT");
				System.out.println("Enter 2 TO SAVE ONLY ACCOUNT");
				
				int i=sq.nextInt();
				switch (i) {
				case 1:
					bank.setAccount(account);
					dao.saveBank(bank);
					break;
					
				case 2:
					dao.saveAccount(account);
					break;
				}
				dao.listQueryBank();
				break;
			}
			
			case 2:{
				Scanner se=new Scanner(System.in);
				System.out.println("Enter Account Number: ");
				long swu=se.nextLong();
				System.out.println("Enter Deposit Money: ");
				double swr=se.nextDouble();
				dao.deposit(swu, swr);
				dao.listQueryBank();
			}
			break;
			
			case 3:{
				Scanner se=new Scanner(System.in);
				System.out.println("Enter Account Number");
				long swu=se.nextLong();
				System.out.println("Enter Withdraw Amount");
				double swr=se.nextDouble();
				dao.withdraw(swu, swr);
				dao.listQueryBank();
			}
			break;
			
			case 4:{
				Bank bank=new Bank();
				Account account=new Account();
				System.out.println("Enter Bank Details: ");
				System.out.println("---------------------");
				System.out.println("Bank Name: ");
				String bn=sc.nextLine();
				bank.setBname(bn);
				System.out.println("Location: ");
				String lc=sc.next();
				bank.setLoc(lc);
				System.out.println("IFSC code: ");
				String ifc=sc.next();
				bank.setIfsc(ifc);
				
				System.out.println("Enter Account Details: ");
				System.out.println("------------------------");
				System.out.println("Customer Name: ");
				String cn=sc.next();
				account.setName(cn);
				System.out.println("Account No: ");
				long ac=sc.nextLong();
				account.setAccno(ac);
				System.out.println("Date of Birth");
				String dob1=sc.next();
				account.setDob(dob1);
				System.out.println("Pincode: ");
				int pn=sc.nextInt();
				account.setPin(pn);
				System.out.println("Enter Money");
				int mn=sc.nextInt();
				account.setMoney(mn);
				
				bank.setAccount(account);
				
				Scanner se=new Scanner(System.in);
				System.out.println("Enter 1 for Update Bank");
				System.out.println("Enter 2 for Update Account");
				int u=se.nextInt();
				switch(u) {
				case 1:
					dao.updateBank(bank);
					break;
				case 2:
					dao.updateAccount(account);
					break;
				}
				dao.listQueryBank();
				break;
			}
			
			case 5:{
				Scanner se=new Scanner(System.in);
				System.out.println("Enter 1 for Find Bank and Customer Account");
				System.out.println("Enter 2 for find Customer Account");
				int u=se.nextInt();
				switch(u) {
				case 1:
					System.out.println("Enter IFSC code: ");
					String fb=sc.next();
					dao.findBank(fb);
					break;
				case 2:
					System.out.println("Enter Account No: ");
					long act=sc.nextLong();
					dao.findAccount(act);
					break;
				}
				break;
			}
			
			case 6:{
				Scanner se=new Scanner(System.in);
				System.out.println("Enter 1 for Display Bank");
				System.out.println("Enter 2 for Display Account");
				int u=se.nextInt();
				switch(u) {
				case 1:
					dao.listQueryBank();
					break;
				case 2:
					dao.listQueryAccount();
					break;
				}
				break;
			}
			
			case 7:{
				Scanner se=new Scanner(System.in);
				System.out.println("Enter 1 for Delete Bank");
				System.out.println("Enter 2 for Delete Account");
				int u=se.nextInt();
				switch (u) {
				case 1:
					System.out.println("Enter IFSC Code: ");
					String fb=sc.next();
					dao.deleteBank(fb);
					break;

				case 2:
					System.out.println("Enter Account Number: ");
					int fu=sc.nextInt();
					dao.deleteAccount(fu);
					break;
				}
				dao.listQueryBank();
				break;
			}
			
			case 8:
				System.out.println("Thank You......!!!!!");
				System.out.println("Please visit again");
				option=false;
				break;
				default:{
					System.out.println("Invalid Selection");
					break;
				}
				
			}				
			}
			
	}

}
