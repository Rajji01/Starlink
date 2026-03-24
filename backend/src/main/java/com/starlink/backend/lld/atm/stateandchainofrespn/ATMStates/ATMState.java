package com.starlink.backend.lld.atm.stateandchainofrespn.ATMStates;


import com.starlink.backend.lld.atm.stateandchainofrespn.ATMRoomComponents.ATM;
import com.starlink.backend.lld.atm.stateandchainofrespn.ATMRoomComponents.Card;
import com.starlink.backend.lld.atm.stateandchainofrespn.enums.TransactionType;

public abstract class ATMState {

    public void insertCard(ATM atm, Card card) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void authenticatePin(ATM atm, Card card, int pin) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void selectOperation(ATM atm, Card card, TransactionType txnType) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void displayBalance(ATM atm, Card card) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void returnCard() {
        System.out.println("OOPS!! Something went wrong");
    }

    public void exit(ATM atm) {
        System.out.println("OOPS!! Something went wrong");
    }
}