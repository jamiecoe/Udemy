package com.jamiecoe;

public interface ITelephone {
    // Interfaces specify methods that a particular class (that uses the interface) must implement
    // Interfaces are abstract, you're only providing the method names/parameters
    // The actual coded method is still contained in the class
    // An interface can provide common behaviour used by multiple classes (good for standardisation)

    // we only define method signatures - return type / name / parameters
    // we don't need access modifiers (eg: private/public), they will added in the class
    void powerOn();
    void dial(int phoneNumber);
    void answer();
    boolean callPhone(int phoneNumber);
    boolean checkIfRinging();
}
