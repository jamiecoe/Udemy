package com.jamiecoe;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<Branch>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void addBranch(String name) {
        int index = findBranchIndex(name);

        if (index < 0) {
            branches.add(new Branch(name));
        } else {
            System.out.println("Branch " + name + " already exists");
        }
    }

    public void addNewCustomer(String customerName, String branchName, double initialTransaction) {
        int index = findBranchIndex(branchName);

        if (index >= 0) {
            branches.get(index).addNewCustomer(customerName, initialTransaction);
        } else {
            System.out.println("Branch " + branchName + " does not exist");
        }
    }

    public void addNewCustomer(String customerName, String branchName) {
        addNewCustomer(customerName, branchName, 0.0);
    }

    public void addCustomerTransaction(String customerName, String branchName, double newTransaction) {
        int index = findBranchIndex(branchName);

        if (index >= 0) {
            branches.get(index).addCustomerTransaction(customerName, newTransaction);
        } else {
            System.out.println("Branch " + branchName + " does not exist");
        }
    }

    public void displayBranchNames() {
        for (Branch branch: branches) {
            System.out.println(branch.getName());
        }
    }

    public void displayBranchCustomers(String branchName, boolean viewTransactions) {
        int index = findBranchIndex(branchName);

        if (index >= 0) {
            branches.get(index).displayAllCustomers(viewTransactions);
        } else {
            System.out.println("Branch " + branchName + " does not exist");
        }
    }

    private int findBranchIndex(String name) {
        for (int i = 0; i < branches.size(); i++) {
            String branchName = branches.get(i).getName();
            if (branchName.equals(name)) {
                return i;
            }
        }

        return -1;
    }
}
