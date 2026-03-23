package com.starlink.backend.lld.builder;

public class Director {
    public static void main(String[] args) {
    Student student= new StudentBuilder().setCity("mathura").setFname("rajji01").build();
    System.out.println(student);
    student=student.withCity("mtr");
    System.out.println(student);
    }
}
