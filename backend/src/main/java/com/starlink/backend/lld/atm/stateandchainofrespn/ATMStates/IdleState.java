package com.starlink.backend.lld.atm.stateandchainofrespn.ATMStates;


import com.starlink.backend.lld.atm.stateandchainofrespn.ATMRoomComponents.ATM;
import com.starlink.backend.lld.atm.stateandchainofrespn.ATMRoomComponents.Card;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }
}