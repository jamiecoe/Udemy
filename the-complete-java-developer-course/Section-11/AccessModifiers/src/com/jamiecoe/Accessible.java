package com.jamiecoe;

// the interface in package-private (eg: only available to other classes in com.jamiecoe package)
interface Accessible {
    // All interface variables are public static final
    int SOME_CONSTANT = 100;
    // all interface methods are automatically public
    public void methodA();
    void methodB();
    boolean methodC();
}
