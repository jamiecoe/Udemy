package com.jamiecoe;

public class Main {

    // In Java, an object's visibility is governed by the access modifiers

    public static void main(String[] args) {
        String privateVar4 = "this is private to main()";

        ScopeCheck scopeInstance = new ScopeCheck();
        System.out.println("scopeInstance privateVar is " + scopeInstance.getPrivateVar1());
        System.out.println(privateVar4);

        scopeInstance.timesTwo();

        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        innerClass.timesTwo();

        // still can't access private variable from Main class
        // innerClass.privateVar3 // error!

        scopeInstance.useInner();
    }
}
