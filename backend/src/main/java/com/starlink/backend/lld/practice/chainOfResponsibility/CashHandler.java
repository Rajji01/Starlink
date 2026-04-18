package com.starlink.backend.lld.practice.chainOfResponsibility;

public abstract  class CashHandler {
    CashHandler nextHandler;

    public void setNextHandler(CashHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handlePayment(int amount);
}
