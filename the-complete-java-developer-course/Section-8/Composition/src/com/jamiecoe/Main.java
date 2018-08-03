package com.jamiecoe;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(20, 20, 4);
	    Case theCase = new Case("220B", "Dell", "240", dimensions);


	    Monitor monitor = new Monitor("27inch Beast", "acer", 27, new Resolution(2540, 1440));

	    Motherboard motherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");

	    PC pc = new PC(theCase, monitor, motherboard);

	    Bedroom bedroom = new Bedroom(pc);

	    String bedFrameMaterial = bedroom.getBedFrameMaterial();

//		System.out.println(bedFrameMaterial);
    }

    public static boolean isPerfectNumber(int num) {
    	if (num < 1) {
			return false;
		} else {
			int factorCounter = 1;
			int perfectNumberTotal = 0;

    		while (factorCounter <= num * 0.5) {
    			if (num % factorCounter == 0) {
					perfectNumberTotal += factorCounter;
				}
				factorCounter++;
			}

			return num == factorCounter;
		}
	}
}
