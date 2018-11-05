package com.jamiecoe;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<Integer>();

        intList.add(1);
        intList.add(3);
        intList.add(4);
        // intList = [1, 3, 4]

        intList.add(1, 2); // adds value '2' at index 1
        // intList = [1, 2, 3, 4]
        // all values after insert have to be moved up (computationally expensive with big arrays!)
        // same when a value is removed, all values after have to be moved down (also computationally expensive)

        // LinkedLists store a value AND the memory location of the next item
        // Inserting or removing values becomes much less expensive
        // because you only need to update the memory address of the value in front of the new value
        // The rest of the array is unaffected
        // Java's garbage collection functionality will automatically remove unused items eg:
        // 'jamie' -> 'tom' -> 'jane'
        // change 'jamie' to point to 'jane', 'tom' is removed by garbage collection
    }
}

