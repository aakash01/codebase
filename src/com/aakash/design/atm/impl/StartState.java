package com.aakash.design.atm.impl;

import com.aakash.design.atm.fsm.FSMState;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/25/17.
 */
public class StartState extends AtmState {

    @Override
    public FSMState transition(AtmEvent event, AtmContext context) {
        if(event == AtmEvent.ENTER_MAINTAINANCE_MODE){
            return new MaintainanceState();
        } else if(event == AtmEvent.INSERT_CARD){
            return new TransactionInProgressState();
        }
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
