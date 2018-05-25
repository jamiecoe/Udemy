package com.jamiecoe;

public class Main {

    public static void main(String[] args) {
        // create a new object of type Car
        Car porsche = new Car();
        Car holden = new Car();

        BankAccount myAccount = new BankAccount(1245, 0.00f, "Jamie", "jamie@jamie", "0901291029");
        myAccount.setBalance(100f);
        myAccount.depositFunds(5f);
        myAccount.withdrawFunds(500f);
        myAccount.withdrawFunds(5f);

        VipCustomer customer1 = new VipCustomer("jamie", 20);
        System.out.println(customer1.getName());
    }
}
