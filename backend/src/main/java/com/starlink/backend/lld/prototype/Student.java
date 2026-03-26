package com.starlink.backend.lld.prototype;

public class Student implements Prototype{
    private String id;
    private String name;
    private String city;

    public Student(String id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    @Override
    public Prototype clone() {
         return new Student(id,name,city);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
