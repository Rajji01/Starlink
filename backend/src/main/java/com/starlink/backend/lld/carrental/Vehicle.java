package com.starlink.backend.lld.carrental;

public class Vehicle {
    private int id;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private int kmDriven;
    private Status status;
    private int hourlyCost;
    private int dayCost;
//    Status status;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(int kmDriven) {
        this.kmDriven = kmDriven;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getHourlyCost() {
        return hourlyCost;
    }

    public void setHourlyCost(int hourlyCost) {
        this.hourlyCost = hourlyCost;
    }

    public int getDayCost() {
        return dayCost;
    }

    public void setDayCost(int dayCost) {
        this.dayCost = dayCost;
    }

    public Vehicle(int id, String vehicleNumber, VehicleType vehicleType, int kmDriven, Status status, int hourlyCost, int dayCost) {
        this.id = id;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.kmDriven = kmDriven;
        this.status = status;
        this.hourlyCost = hourlyCost;
        this.dayCost = dayCost;
    }
}
