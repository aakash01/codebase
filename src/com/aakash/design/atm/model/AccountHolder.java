package com.aakash.design.atm.model;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/25/17.
 */
public class AccountHolder {

    private String name;
    private String cardNumber;
    private String authToken;
    private int pin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
