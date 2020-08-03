package com.banking;

import java.util.Scanner;

import com.banking.util.BankingUtil;

public class Main {
	BankingUtil util = new BankingUtil();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		
		Boolean run = true;
		do {
			System.out.println("+----------------------------+");
			System.out.println("|  Dollars Bank Welcomes You |");
			System.out.println("+----------------------------+");
			System.out.println("1. Create New Account");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.println("Enter an action. 1, 2, or 3");
			while (!in.hasNextInt()) {
				System.out.println("Please enter a number");
				in.next();
			}
			int a = in.nextInt();
			in.nextLine();
			for (int i = 0; i < 50; ++i) System.out.println();
			switch (a) {
			case 1: 
				BankingUtil.newAccount();
				break;
			case 2:
				BankingUtil.login();
				break;
			case 3:
				run = false;
				System.out.println("Thank You For Using Dollars Bank");
				break;
			default:
				System.out.println("Please Enter A Valid Input");
				
				break;
			}
		}
		while (run);
		in.close();
	}
}
