package com.starlink.backend.streams;

import java.util.Optional;

public class OptionalScenario {
    public static void main(String[] args) {
        User user= new User();
        user.setCity("mtr");

//        2nd scenario
//        user=null;

//        3rd scenario
        user.setCity(null);

        String val=    Optional.ofNullable(user)
                .map(User::getCity)
                .map(s->s+" best")
                .orElse("nulls");
        System.out.println(val);
    }

}
