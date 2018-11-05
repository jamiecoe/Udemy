package com.jamiecoe;

public class BankAccount {
    private int accountNum;
    private float balance;
    private String customerName;
    private String email;
    private String telephoneNo;

    // constructor function always has same name as class
    // it only needs an access modifier
    public BankAccount() {
        // you can call one constructor from inside another one with `this`
        // useful for setting default values
        this(1234, 12f, "default", "default", "default telephone number");
    }

    // you can have multiple constructors with different numbers of parameters
    public BankAccount(int accountNum, float balance, String customerName, String email, String telephoneNo) {
        this.accountNum = accountNum;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.telephoneNo = telephoneNo;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public void depositFunds(float deposit) {
        System.out.println("deposited " + deposit + "£");
        balance += deposit;
        System.out.println("New balance = " + balance);
    }

    public void withdrawFunds(float withdrawal) {
        if (balance - withdrawal < 0) {
            System.out.println("Insufficient funds");
        } else {
            System.out.println("withdrawing " + withdrawal + "£");
            balance -= withdrawal;
            System.out.println("New balance = " + balance);
        }
    }
}
