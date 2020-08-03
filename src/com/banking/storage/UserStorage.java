package com.banking.storage;

import java.util.ArrayList;

public class UserStorage {
	private ArrayList<Users> users = new ArrayList<Users>();
	int i = 1;
	
	public void newUser(Users user) {
		if (user.getName().equals("")) {
			for (int i = 0; i < 50; ++i) System.out.println();
			System.out.println("No username");
			return;
		}
		if (user.getPassword().equals("")) {
			for (int i = 0; i < 50; ++i) System.out.println();
			System.out.println("No password");
			return;
		}
		//add password formatting, like caps and special characters
		if (user.getCountry().equals("")) {
			for (int i = 0; i < 50; ++i) System.out.println();
			System.out.println("No country");
			return;
		}
		user.setID(i);
		i++;
		users.add(user);
		System.out.println("User created");
		for (int i = 0; i < 50; ++i) System.out.println();
	}
	
	public Users login(String name, String password) throws Exception {
		for( Users user: users) {
			if (user.getName().equals(name)) {
				if (user.getPassword().equals(password)) {
					return user;
				}
				throw new Exception("Incorrect Password");
			}
		}
		throw new Exception("No known user");
	}

	public void withdraw(int id, float amount) throws Exception{
		Users user = findUser(id);
		int u = users.indexOf(user);
		
		if (user.getSavings() - amount < 0) {
			for (int i = 0; i < 50; ++i) System.out.println();
			throw new Exception("Insufficient Funds");
		}
		
		user.setSavings(user.getSavings() - amount);
		for (int i = 0; i < 50; ++i) System.out.println();
		System.out.println("New Balance is " + user.getSavings());
		users.set(u, user);
	}
	
	public void deposit(int id, float amount) {
		Users user = findUser(id);
		int u = users.indexOf(user);
		user.setSavings(user.getSavings() + amount);
		for (int i = 0; i < 50; ++i) System.out.println();
		System.out.println("New Balance is " + user.getSavings());
		users.set(u, user);
	}
	
	public void view(int id) {
		Users user = findUser(id);
		for (int i = 0; i < 50; ++i) System.out.println();
		System.out.println("Account Name: " + user.getName());
		System.out.println("Account ID: " + user.getID());
		System.out.println("Account Balance: " + user.getSavings());
		System.out.println("Account Country: " + user.getCountry());
		System.out.println("Account Phone Number: " + user.getPhone());
	}
	
	public void transfer (int id, int target, float amount) throws Exception {
		Users user = findUser(id);
		Users tgt = findUser(target);
		int u = users.indexOf(user);
		int t = users.indexOf(tgt);
		
		if (tgt == null) {
			for (int i = 0; i < 50; ++i) System.out.println();
			throw new Exception("No such target account");
		}
		
		if (user.getSavings() - amount < 0) {
			for (int i = 0; i < 50; ++i) System.out.println();
			throw new Exception("Insufficient Funds");
		}
		
		for (int i = 0; i < 50; ++i) System.out.println();
		user.setSavings(user.getSavings() - amount);
		System.out.println("New balance is " + user.getSavings());
		tgt.setSavings(tgt.getSavings() + amount);
		System.out.println("Transfer Successful");
		
		users.set(u, user);
		users.set(t, tgt);
	}
	
	
	private Users findUser(int ID) {
		for( Users user: users) {
			if (user.getID() == ID) {
				return user;
			}
		}
		return null;
	}


}
