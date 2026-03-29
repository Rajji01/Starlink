package com.starlink.backend.lld.iteratordesignpattern;

public class Mobile {
    String imiNumber;
    String setName;

    public Mobile(String setName, String imiNumber) {
        this.setName = setName;
        this.imiNumber = imiNumber;
    }

    public String getImiNumber() {
        return imiNumber;
    }

    public void setImiNumber(String imiNumber) {
        this.imiNumber = imiNumber;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }
}
