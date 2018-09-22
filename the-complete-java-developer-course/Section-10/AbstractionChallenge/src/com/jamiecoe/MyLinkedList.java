package com.jamiecoe;

public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            // The list was empty, so newItem becomes the head
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;

        while (currentItem != null) {
            int comparisonResultCode = currentItem.compareTo(newItem);

            if (comparisonResultCode == 0) {
                System.out.println(newItem.getValue().toString() + " already exists in List");
                return false;
            } else if (comparisonResultCode < 0) {
                // newItem is greater, move right if possible

                // If there is a next item
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // there is no next item, so insert newItem at the end
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    return true;
                }
            } else {
                // newItem is smaller, so insert it on the left

                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                } else {
                    newItem.setNext(this.root);
                    this.root.setPrevious(newItem);
                    this.root = newItem;
                }

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (this.root == null) {
            System.out.println("Your list is empty");
            return false;
        }

        if (item != null) {
            System.out.println("Deleting " + item.getValue());
        }

        ListItem currentItem = this.root;

        while (currentItem != null) {
            if (currentItem.compareTo(item) == 0) {

                if (currentItem.previous() != null) {
                    currentItem.next().setPrevious(currentItem.previous());
                } else {
                    this.root = currentItem.next();
                }

                if (currentItem.next() != null) {
                    currentItem.next().setPrevious(currentItem.previous());
                }

                return true;
            } else {
                currentItem = currentItem.next();
            }
        }

        System.out.println(item.getValue() + " does not exist in your list");
        return false;
    }

    @Override
    public void traverse(ListItem root) {
//        if (root == null) {
//            System.out.println("The list is empty");
//        } else {
//            while (root != null) {
//                System.out.println(root.getValue());
//                root = root.next()
//            }
//        }

        // recursion
        // Here we wouldn't start to return from the recursive function until we'd gone through entire record
        // If number of nodes was massive -> the call stack would overflow (error) before we'd been through it
        // BinarySearch tree (SearchTree.java) would not have this problem
        // It would return from recursive calls for each branch, rather than just one massive one
        if (root != null) {
            System.out.println("Current position = " + root.getValue());
            traverse(root.next());
        }
    }
}
