package com.aakash.design.atm.impl;

import com.aakash.design.atm.fsm.FSMState;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/25/17.
 */
public class TransactionInProgressState extends AtmState {
    @Override
    public FSMState transition(AtmEvent event, AtmContext context) {
        return null;
    }

    @Override
    public FSMState autoTransition(AtmEvent event, AtmContext context) {
        return null;
    }

    @Override
    public void performAction(AtmContext context) {

    }
}
