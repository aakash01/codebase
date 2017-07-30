package com.aakash.design.atm.fsm;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/25/17.
 */
public abstract class FSM<E, C> {
    FSMState state;

    public FSM(FSMState initState){
        this.state = initState;
    }

    public FSMState getState() {
        return state;
    }

    public void setState(FSMState state) {
        this.state = state;
    }

    public FSMState transition(E event, C context){
        FSMState newState = state.transition(event, context);
        FSMState st = newState;
        while(st != null){
            newState = st;
            st = st.autoTransition(event, context);
        }
        this.state = newState;
        return newState;
    }
}
