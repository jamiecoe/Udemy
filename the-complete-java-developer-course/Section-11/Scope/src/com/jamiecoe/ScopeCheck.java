package com.jamiecoe;

public class ScopeCheck {
    public int publicVar = 0;
    private int privateVar1 = 1;

    public ScopeCheck() {
        System.out.println("ScopeCheck created, publicVar = " + publicVar + ": privateVar1 = " + privateVar1);
    }

    public int getPrivateVar1() {
        return privateVar1;
    }

    public void timesTwo() {
        int privateVar2 = 2;
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " times two is " + i * privateVar2);
        }
    }

    public void useInner() {
        InnerClass innerClass = new InnerClass();
        System.out.println("privateVar3 from outer class = " + innerClass.privateVar3);
    }

    public class InnerClass {
        private int privateVar3 = 3;

        public InnerClass() {
            System.out.println("ScopeCheck created, privateVar1 = " + privateVar1 + " and privateVar3 = " + privateVar3);
        }

        public void timesTwo() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " times " + this.privateVar3 + " is " + i * this.privateVar3);
                System.out.println(i + " times " + privateVar1 + " is " + i * privateVar1);
            }

            // You can also reference outer Class methods
            //ScopeCheck.this.timesTwo();
        }
    }
}
