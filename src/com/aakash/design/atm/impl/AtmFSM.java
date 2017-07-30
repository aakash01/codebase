package com.aakash.design.atm.impl;

import com.aakash.design.atm.fsm.FSM;
import com.aakash.design.atm.fsm.FSMState;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/25/17.
 */
public class AtmFSM extends FSM<AtmEvent, AtmContext> {

    public AtmFSM(FSMState initState) {
        super(initState);
    }


}
