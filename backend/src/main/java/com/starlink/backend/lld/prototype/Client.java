package com.starlink.backend.lld.prototype;

public class Client {
    public static void main(String[] args) {
        Student obj= new Student("123","rajat","mtr");
        Student cloneObj=(Student) obj.clone();
        System.out.println(cloneObj);
    }
}
