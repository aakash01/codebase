package com.aakash.design.atm.service;

import com.aakash.design.atm.model.Denomination;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/25/17.
 */
public class CashInventoryService {

    private Map<Denomination, Integer> inventory = new TreeMap<>();

    public void addDenomination(Denomination denomination, Integer number){
        if(inventory.containsKey(denomination)){
            inventory.put(denomination, inventory.get(denomination) + number);
        } else {
            inventory.put(denomination, number);
        }
    }

    public void dispenseCash(int amount){
        // pending Implementation
    }
}
