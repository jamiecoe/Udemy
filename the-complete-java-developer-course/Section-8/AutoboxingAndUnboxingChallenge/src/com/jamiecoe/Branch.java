package com.jamiecoe;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addNewCustomer(String name, double initialTransaction) {
        int index = findCustomerIndex(name);

        if (index < 0) {
            customers.add(new Customer(name, initialTransaction));
        } else {
            System.out.println("Customer " + name + " already exists");
        }
    }

    public void addCustomerTransaction(String customerName, double newTransaction) {
        int index = findCustomerIndex(customerName);

        if (index >= 0) {
            customers.get(index).addTransaction(newTransaction);
        } else {
            System.out.println("Customer " + customerName + " does not exist");
        }
    }

    public void displayAllCustomers(boolean viewTransactions) {
        for (Customer customer: customers) {
            System.out.println(customer.getName());

            if (viewTransactions) {
                ArrayList<Double> transactions = customer.getTransactions();
                for (int i = 0; i < transactions.size(); i++) {
                    System.out.println("   " + (i + 1) + ". " + transactions.get(i));
                }
            }
        }
    }

    private int findCustomerIndex(String name) {
        for (int i = 0; i < customers.size(); i++) {
            String customerName = customers.get(i).getName();
            if (customerName.equals(name)) {
                return i;
            }
        }

        return -1;
    }
}
