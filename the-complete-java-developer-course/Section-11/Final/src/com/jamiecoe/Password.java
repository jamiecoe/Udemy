package com.jamiecoe;

public class Password {
    private static final int KEY = 123456;
    private final int encryptedPassword;

    public Password(int encryptedPassword) {
        this.encryptedPassword = encryptDecrypt(encryptedPassword);
    }

    private int encryptDecrypt(int password) {
        return password ^ KEY;
    }

    public void storePassword() {
        System.out.println("Saving password as " + this.encryptedPassword);
    }

    public boolean isAllowedIn(int password) {
        if (encryptDecrypt(password) == this.encryptedPassword) {
            System.out.println("Welcome");
            return true;
        } else {
            System.out.println("Incorrect password!");
            return false;
        }
    }
}
