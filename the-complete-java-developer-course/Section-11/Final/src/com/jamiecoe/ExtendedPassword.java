package com.jamiecoe;

public class ExtendedPassword extends Password {
    private int decryptedPassword;

    public ExtendedPassword(int encryptedPassword, int decryptedPassword) {
        super(encryptedPassword);
        this.decryptedPassword = decryptedPassword;
    }

    // This is bad! We don't want ExtendedPassword to be able to overwrite this method
    // So we set final for this method in Password class which causes an error
//    @Override
//    public void storePassword() {
//        System.out.println("Saving password as " + this.decryptedPassword);
//    }
}
