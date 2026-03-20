package com.starlink.backend.lld.nulldesignpattern;

public class NullUser implements User{
    @Override
    public String getCity() {
        return "its null empty";
    }
}
