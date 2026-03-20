package com.starlink.backend.lld.nulldesignpattern;

class UserService {

    public User getUser(int id) {

        if (id == 1) {
            return new RealUser("Delhi");
        }

        return new NullUser(); // null ke jagah object
    }
}