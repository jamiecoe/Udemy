package com.jamiecoe;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank natwest = new Bank("Natwest");

    public static void main(String[] args) {

        boolean quit = false;

        while (!quit) {
            System.out.println("Enter an option:");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    quit = true;
                    System.out.println("Goodbye!");
                    break;
                case 1:
                    addBranch();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    addTransaction();
                    break;
                case 4:
                    viewAllCustomers();
                    break;
            }
        }
    }

    public static void addBranch() {
        System.out.println("Enter a branch name:");
        String branchName = scanner.nextLine();
        natwest.addBranch(branchName);
        natwest.displayBranchNames();
    }

    public static void addCustomer() {
        System.out.println("Add a new customer!");
        System.out.println("Enter branch name:");
        String branchName = scanner.nextLine();

        System.out.println("Enter customer name");
        String customerName = scanner.nextLine();

        System.out.println("Enter intial transaction");
        double initialTransaction = scanner.nextDouble();

        natwest.addNewCustomer(customerName, branchName, initialTransaction);
        natwest.displayBranchCustomers(branchName, true);
    }

    public static void addTransaction() {
        System.out.println("Add a transaction!");
        System.out.println("Enter branch name:");
        String branchName = scanner.nextLine();

        System.out.println("Enter customer name");
        String customerName = scanner.nextLine();

        System.out.println("Enter new transaction");
        double newTransaction = scanner.nextDouble();

        natwest.addCustomerTransaction(customerName, branchName, newTransaction);
        natwest.displayBranchCustomers(branchName, true);
    }

    public static void viewAllCustomers() {
        System.out.println("View all customers!");
        System.out.println("Enter branch name:");
        String branchName = scanner.nextLine();

        System.out.println("With transactions?");
        boolean withTransactions = scanner.nextBoolean();

        natwest.displayBranchCustomers(branchName, withTransactions);
    }

}
