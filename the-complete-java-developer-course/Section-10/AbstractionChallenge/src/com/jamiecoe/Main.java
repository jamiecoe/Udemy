package com.jamiecoe;

public class Main {

    public static void main(String[] args) {
//        MyLinkedList myLinkedList = new MyLinkedList(null);
//
//        myLinkedList.traverse(myLinkedList.getRoot());
//
//        String towns = "Deptford Greenwich Peckham Lewisham Brockley Deptford";
//        String[] townList = towns.split(" ");
//
//        for (String town: townList) {
//            myLinkedList.addItem(new Node(town));
//        }
//
//        myLinkedList.traverse(myLinkedList.getRoot());
//
//        myLinkedList.removeItem(new Node("Deptford"));
//        myLinkedList.removeItem(new Node("Amersham"));
//
//        myLinkedList.traverse(myLinkedList.getRoot());
//
//        MyLinkedList myEmptyList = new MyLinkedList(null);
//        myEmptyList.removeItem(new Node("Something"));


        SearchTree mySearchTree = new SearchTree(null);

        String towns = "Deptford Greenwich Peckham Lewisham Brockley Deptford";
        String[] townList = towns.split(" ");

        for (String town: townList) {
            mySearchTree.addItem(new Node(town));
        }

        System.out.println("=========");
        mySearchTree.traverse(mySearchTree.getRoot());
        System.out.println("=========");

        mySearchTree.removeItem(new Node("Deptford"));

        System.out.println("=========");
        mySearchTree.traverse(mySearchTree.getRoot());
        System.out.println("=========");
        System.out.println("root = " + mySearchTree.getRoot().getValue());
    }
}
