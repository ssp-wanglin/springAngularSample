package spring.test.model;

import java.io.Serializable;

public class Account implements Serializable{
	
	private String id;
	
	private String name;

	private String password;
	
	private int balance;
	
	public Account() {}
	
	public Account(String id, String name, String password, int balance) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String toString() {
		return "Account[id = "+id +",name ="+ name + " ,balance = "+balance+"]";
	}
	
	

}
