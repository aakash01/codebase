package com.aakash.design.atm.service;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/25/17.
 */
public class BankingService {
    private static BankingService ourInstance = new BankingService();

    public static BankingService getInstance() {
        return ourInstance;
    }

    private BankingService() {
    }
}
