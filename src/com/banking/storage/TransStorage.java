package com.banking.storage;

import java.util.ArrayList;
import java.util.Collections;

public class TransStorage {
	private ArrayList<Transactions> TRANS = new ArrayList<Transactions>();
	int i = 1;
	
	public void newWithdraw(int ID, float amount) {
		Transactions trans = new Transactions(Transactions.Type.withdraw, i);
		i++;
		trans.setUserID(ID);
		trans.setTargetID(ID);
		trans.setValue(amount);
		TRANS.add(trans);
	}
	
	public void newDeposit(int ID, float amount) {
		Transactions trans = new Transactions(Transactions.Type.deposit, i);
		i++;
		trans.setUserID(ID);
		trans.setTargetID(ID);
		trans.setValue(amount);
		TRANS.add(trans);
	}
	
	public void newTransfer(int user, int target, float amount)  {
		Transactions trans = new Transactions(Transactions.Type.transfer, i);
		i++;
		trans.setUserID(user);
		trans.setTargetID(target);
		trans.setValue(amount);
		TRANS.add(trans);
	}
	
	public void newAccount(Users user, float amount)  {
		Transactions trans = new Transactions(Transactions.Type.create, i);
		i++;
		trans.setUserID(user.getID());
		trans.setTargetID(user.getID());
		trans.setValue(amount);
		TRANS.add(trans);
	}
	
	public void viewTrans(int id) {
		ArrayList<Transactions> tran = new ArrayList<Transactions>();
		for(Transactions tr: TRANS) {
			if (tr.getUserID() == id) {
				tran.add(tr);
			}
		}

		for (int i = tran.size() - 1; i >= tran.size()- 5; i--) {
			if (i >= 0) {
				Transactions tr = TRANS.get(i);
				System.out.println("+-------------------------------------------+");
				System.out.println("Transaction ID: " + tr.getID());
				System.out.println("	Transaction User ID: " + tr.getUserID());
				System.out.println("	Transaction target ID: " + tr.getTargetID());
				System.out.println("	Transaction amount: " + tr.getValue());
				System.out.println("	Transaction type: " + tr.getType());
				System.out.println("+-------------------------------------------+");
				System.out.println();
			}
		}
		
	}
	
}
