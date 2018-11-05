package com.jamiecoe;

public class MobilePhone implements ITelephone {
    private int myNumber;
    private boolean isRinging;
    private boolean isOn;

    public MobilePhone(int myNumber) {
        this.myNumber = myNumber;
        this.isRinging = false;
        this.isOn = false;
    }

    @Override
    public void powerOn() {
        this.isOn = true;
        System.out.println("Mobile phone turned on");
    }

    @Override
    public void dial(int phoneNumber) {
        if (this.isOn) {
            System.out.println("Now ringing " + phoneNumber);
        } else {
            System.out.println("Phone is switched off");
        }
    }

    @Override
    public void answer() {
        if (this.isRinging && this.isOn) {
            System.out.println("Answering telephone");
            this.isRinging = false;
        } else {
            System.out.println("Phone is not ringing");
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (phoneNumber == this.myNumber && this.isOn) {
            this.isRinging = true;
            System.out.println("Mobile phone is ringing");
        } else {
            System.out.println("Mobile cannot be called right now");
            this.isRinging = false;
        }

        return false;
    }

    @Override
    public boolean checkIfRinging() {
        return this.isRinging;
    }
}
