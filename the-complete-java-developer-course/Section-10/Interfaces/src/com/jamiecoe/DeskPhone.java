package com.jamiecoe;

// 'implements' allows a class to implement an interface
public class DeskPhone implements ITelephone {
    private int myNumber;
    private boolean isRinging;

    public DeskPhone(int myNumber) {
        this.myNumber = myNumber;
        this.isRinging = false;
    }

    @Override
    public void powerOn() {
        System.out.println("Desk phone does not have a power button");
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("Now ringing " + phoneNumber);
    }

    @Override
    public void answer() {
        if (this.isRinging) {
            System.out.println("Answering telephone");
            this.isRinging = false;
        } else {
            System.out.println("Phone is not ringing");
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (phoneNumber == this.myNumber) {
            this.isRinging = true;
            System.out.println("Phone is ringing");
        } else {
            this.isRinging = false;
        }

        return false;
    }

    @Override
    public boolean checkIfRinging() {
        return this.isRinging;
    }
}
