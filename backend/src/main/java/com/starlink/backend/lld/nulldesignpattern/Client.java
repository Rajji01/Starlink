package com.starlink.backend.lld.nulldesignpattern;

public class Client {
    public static void main(String[] args) {

        UserService service = new UserService();

        User user = service.getUser(2);

        System.out.println(user.getCity()); // no null check needed
        User user2 = service.getUser(1);

        System.out.println(user2.getCity());
    }
}
