package com.jamiecoe;

public class Main {

    public static void main(String[] args) {
	    Account jamiesAccount = new Account("Jamie");
	    jamiesAccount.deposit(1000);
	    jamiesAccount.withdraw(500);
	    jamiesAccount.withdraw(-200);
	    jamiesAccount.deposit(-20);
	    jamiesAccount.calculateBalance();

        System.out.println("Jamie's balance = " + jamiesAccount.getBalance());
    }
}
