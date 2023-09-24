package com.bank;

public class User {
	public static int id;
	public static String name;
	public static String username;
	public static String password;
	public static float balance;
	public static int accno;
	public static int getAccno() {
		return accno;
	}
	public static void setAccno(int accno) {
		User.accno = accno;
	}
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		User.id = id;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		User.name = name;
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		User.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		User.password = password;
	}
	public static float getBalance() {
		return balance;
	}
	public static void setBalance(float balance) {
		User.balance = balance;
	}

}
