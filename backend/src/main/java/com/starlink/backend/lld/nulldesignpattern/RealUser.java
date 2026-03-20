package com.starlink.backend.lld.nulldesignpattern;

public class RealUser implements  User{
    String city;

    public RealUser(String city) {
        this.city = city;
    }

    @Override
    public String getCity() {
        return city;
    }
}
