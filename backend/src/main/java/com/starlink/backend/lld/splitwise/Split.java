package com.starlink.backend.lld.splitwise;

public class Split {
    private User user;
    private double amountOwed;

    public Split(User user, double amountOwed) {
        this.user = user;
        this.amountOwed = amountOwed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }
}
