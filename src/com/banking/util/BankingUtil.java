package com.banking.util;

import java.util.Scanner;

import com.banking.storage.*;

public class BankingUtil {
	static UserStorage userStorage = new UserStorage();
	static TransStorage transStorage = new TransStorage();
	static Scanner input = new Scanner(System.in);

	public static void newAccount() {
		Boolean run = true;
		do {
			System.out.println("+-------------------------------+");
			System.out.println("| Enter Details for New Account |");
			System.out.println("+-------------------------------+");
			
			Users user = new Users();
			System.out.println("Enter A Username");
			String username = input.nextLine();
			if (username.equals("")) {
				for (int i = 0; i < 50; ++i) System.out.println();
				System.out.println("username cannot be empty");
			} else {
				System.out.println("Enter A password");
				String password = input.nextLine();
				if (password.equals("")) {
					for (int i = 0; i < 50; ++i) System.out.println();
					System.out.println("password cannot be empty");
				} else {
					System.out.println("Enter your country");
					String country = input.nextLine();
					if (country.equals("")) {
						for (int i = 0; i < 50; ++i) System.out.println();
						System.out.println("country cannot be empty");
					} else {
						
						System.out.println("Enter initial deposit");
						while (!input.hasNextFloat()) {
							System.out.println("Please enter a number");
							input.next();
						}
						int deposit = input.nextInt();
						input.nextLine();
						
						System.out.println("Please Enter a phone number");
					
						String phone = input.nextLine();
						phone=phone.replaceAll("[\\D]","");
						if (phone.length() != 10) {
							System.out.println("Not a valid Phone number. Must be 10 digits");
						} else {
							user.setName(username);
							user.setPassword(password);
							user.setPhone(phone);
							user.setSavings(deposit);
							user.setCountry(country);
							userStorage.newUser(user);
							transStorage.newAccount(user, deposit);
							run = false;
						}
						
						
					}
					
				}
			}
		}
		while (run);
	}

	public static void login() {
		Boolean run = true;
		do {
			System.out.println("+-------------------------------+");
			System.out.println("| Enter Login Infromation       |");
			System.out.println("+-------------------------------+");
			System.out.println("Enter Username");
			String username = input.nextLine();
			if (username.equals("")) {
				for (int i = 0; i < 50; ++i) System.out.println();
				System.out.println("Username cannot be empty");
			} else {
				System.out.println("Enter Password");
				String password = input.nextLine();
				for (int i = 0; i < 50; ++i) System.out.println();
				
				try {
					Users user = userStorage.login(username, password);
					action(user);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
		while (run);
	}
	
	private static void action (Users user) {
		Boolean run = true;
		do {
			System.out.println("+-------------------------------+");
			System.out.println("| Enter Your Choice of Action   |");
			System.out.println("+-------------------------------+");
			
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Funds Transfer");
			System.out.println("4. View Recent transactions");
			System.out.println("5. View Account Info");
			System.out.println("6. Log out");
			while (!input.hasNextInt()) {
				System.out.println("Please enter a number");
				input.next();
			}
			int choice = input.nextInt();
			for (int i = 0; i < 50; ++i) System.out.println();
			
			switch (choice) {
			case 1:
				deposit(user.getID());
				break;
			case 2:
				withdraw(user.getID());
				break;
			case 3:
				transfer(user.getID());
				break;
			case 4:
				transStorage.viewTrans(user.getID());
				break;
			case 5:
				userStorage.view(user.getID());
				break;
			case 6:
				run = false;
				input.close();
				System.out.println("Thank you for using Dollar Bank");
				break;
			default:
				System.out.println("Please enter a valid input");
				break;
			}
		}
		while (run);
		for (int i = 0; i < 50; ++i) System.out.println();
	}
	
	private static void withdraw(int ID) {
		Boolean run = true;
		
		System.out.println("Enter Amount To Withdraw");
		while (!input.hasNextFloat()) {
			System.out.println("Please enter a number");
			input.next();
		}
		float inp = input.nextFloat();
		try {
			userStorage.withdraw(ID, inp);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		transStorage.newWithdraw(ID, inp);
	}
	
	private static void deposit(int ID) {
		Boolean run = true;
		
		System.out.println("Enter Amount To Deposit");
		while (!input.hasNextFloat()) {
			System.out.println("Please enter a number");
			input.next();
		}
		float inp = input.nextFloat();
		userStorage.deposit(ID, inp);
		transStorage.newDeposit(ID, inp);
	}
	
	private static void transfer(int ID) {
		
		System.out.println("Enter ID of account you want to transfer money to");
		while (!input.hasNextInt()) {
			System.out.println("Please enter a number");
			input.next();
		}
		int target = input.nextInt();
		input.nextLine();
		System.out.println("Enter Amount to transfer");
		while (!input.hasNextFloat()) {
			System.out.println("Please enter a number");
			input.next();
		}
		String in = input.nextLine();
		float f = Float.parseFloat(in);
		
		try {
			userStorage.transfer(ID, target, f);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		transStorage.newTransfer(ID, target, f);
	}
	
}
