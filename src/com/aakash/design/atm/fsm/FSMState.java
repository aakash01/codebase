package com.aakash.design.atm.fsm;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/25/17.
 */
public abstract class FSMState<E, C> {

    public abstract FSMState transition(E event, C context);

    public abstract FSMState autoTransition(E event, C context);

    public abstract void performAction(C context);
}
