package com.jamiecoe;

import java.util.List;

// This class uses Binary Search Tree
public class SearchTree implements NodeList {
    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;

        while (currentItem != null) {
            int comparison = currentItem.compareTo(newItem);

            if (comparison < 0) {
                // newItem goes to the right

                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // there's no more nodes to the right, so add at this point
                    currentItem.setNext(newItem);
                    return true;
                }
            } else if (comparison > 0) {
                // newItem goes to the left

                if (currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                } else {
                    // there's no more nodes to the left, so add at this point
                    currentItem.setPrevious(newItem);
                    return true;
                }
            } else {
                // Equal, so don't add
                System.out.println(newItem.getValue() + " is already present");
                return false;
            }
        }

        // Will never actually get here, but Java complains otherwise
        return false;
    }

    @Override
    public boolean removeItem(ListItem itemToRemove) {
        if (itemToRemove != null) {
            System.out.println("Deleting " + itemToRemove.getValue());
        }

        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while (currentItem != null) {
            int comparison = currentItem.compareTo(itemToRemove);
            if (comparison < 0) {
                // going to Right
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0) {
                // going to Left
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                // equal: we've found item to remove
                performRemoval(currentItem, parentItem);
                return true;
            }
        }

        System.out.println(itemToRemove.getValue() + " does not exist in list");
        return false;
    }


    // Deleting is ALOT more complicated for Binary Search Trees
    // DBs that use BST will often just flag data that needs to be deleted
    // This flagged data is ignored from searches,
    // It can be actually be deleted in out-of-hours maintenance or when DB is re-indexed

    private void performRemoval(ListItem item, ListItem parent) {
        // remove item from the tree
        if (item.next() == null) {
            // no right tree, so make parent point to left tree (which may be null)
            if (parent.next() == item) {
                // item is right child of its pa rent
                parent.setNext(item.previous());
            } else if (parent.previous() == item) {
                // item is left child of its parent
                parent.setPrevious(item.previous());
            } else {
                // parent must be item, which means we were looking at the root of the tree
                this.root = item.previous();
            }
        } else if (item.previous() == null) {
            // no left tree, so make parent point to right tree (which may be null)
            if (parent.next() == item) {
                // item is right child of its parent
                parent.setNext(item.next());
            } else if (parent.previous() == item) {
                // item is left child of its parent
                parent.setPrevious(item.next());
            } else {
                // again, we are deleting the root
                this.root = item.next();
            }
        } else {
            // neither left nor right are null, deletion is now a lot trickier!
            // From the right sub-tree, find the smallest value (i.e., the leftmost).
            ListItem current = item.next(); // Greenwich
            System.out.println("current = " + current.getValue());
            ListItem leftmostParent = item; // Deptford
            System.out.println("leftmostParent = " + leftmostParent.getValue());

            while (current.previous() != null) {
                leftmostParent = current;
                System.out.println("leftmostParent = " + leftmostParent.getValue());
                current = current.previous();
                System.out.println("current = " + current.getValue());
            }

            // Now put the smallest value into our node to be deleted
            System.out.println("Setting Root with new value " + current.getValue());
            item.setValue(current.getValue());

            // and delete the smallest
            if (leftmostParent == item) {

                // there was no leftmost node, so 'current' points to the smallest
                // node (the one that must now be deleted).
                System.out.println("Setting Root with new nextValue " + current.next().getValue());
                item.setNext(current.next());
            } else {
                // set the smallest node's parent to point to
                // the smallest node's right child (which may be null).
                leftmostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        // recursive method
        // well balanced binary tree has maximum depth of about 63
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
