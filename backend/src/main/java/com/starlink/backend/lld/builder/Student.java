package com.starlink.backend.lld.builder;

public class Student {
    private String id;
    private String fname;
    private String lname;
    private String city;
    private String fatherName;
    private String motherName;


    public Student(StudentBuilder builder) {
        this.id = builder.getId();
        this.fname = builder.getFname();
        this.lname = builder.getLname();
        this.city = builder.getCity();
        this.fatherName = builder.getFatherName();
        this.motherName = builder.getMotherName();
    }

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

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", city='" + city + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                '}';
    }
//    wither method
    // kyunki setter allow ni krte apan real objectmai
    // to builderka use kr k same object mai city modify kr do or return
    public Student withCity(String newCity) {
        return new StudentBuilder()
                .setId(this.id)
                .setFname(this.fname)
                .setLname(this.lname)
                .setCity(newCity)  // Only change this
                .setFatherName(this.fatherName)
                .setMotherName(this.motherName)
                .build();
    }
}
