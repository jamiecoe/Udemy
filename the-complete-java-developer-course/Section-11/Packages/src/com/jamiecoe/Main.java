package com.jamiecoe;

// You can have two classes with the same name, but from different packages
// However, you can only import ONE class with the same name at the top
import javax.xml.soap.Node;
//import javafx.scene.Node; // this isn't allowed!


public class Main {

    public static void main(String[] args) {
	    Node node = null;
	    // You can refer to a class with the same name but from a different package
        // However you have to use the full reference:
        javafx.scene.Node anotherNode = null;
    }
}

