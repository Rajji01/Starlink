package com.starlink.backend.lld.carrental;
import com.starlink.backend.lld.carrental.Status;
import com.starlink.backend.lld.carrental.Vehicle;
import com.starlink.backend.lld.carrental.VehicleType;

import java.util.List;
import java.util.stream.Collectors;

// Option 2: VehicleInventory mein filter AVAILABLE status ke saath
public class VehicleInventory {
    List<Vehicle> vehicleList;

    public VehicleInventory(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public List<Vehicle> findVehicle(VehicleType vehicleType) {
        return vehicleList.stream()
                .filter(v -> v.getVehicleType().equals(vehicleType))
                .filter(v -> v.getStatus() == Status.AVAILABLE)  // ✅ Add this filter
                .collect(Collectors.toList());
    }
}