package com.jamiecoe;

public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return null;
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
        return false;
    }

    @Override
    public void traverse(ListItem root) {

    }
}
