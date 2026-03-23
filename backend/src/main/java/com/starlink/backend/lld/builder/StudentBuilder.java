package com.starlink.backend.lld.builder;

public class StudentBuilder {
    private String id;
    private String fname;
    private String lname;
    private String city;
    private String fatherName;
    private String motherName;

    public String getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getCity() {
        return city;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public StudentBuilder setId(String id){
        this.id=id;
        return this;
    }

    public StudentBuilder setFname(String fname) {
        this.fname = fname;
        return this;
    }

    public StudentBuilder setLname(String lname) {
        this.lname = lname;
        return this;
    }

    public StudentBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public StudentBuilder setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public StudentBuilder setMotherName(String motherName) {
        this.motherName = motherName;
        return this;
    }
    public Student build(){
        return new Student(this);
    }
}
