package com.starlink.backend.lld.carrental;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        List<User> users = addUsers();
        List<Vehicle> vehicles = addVehicles();
        List<Store> stores = addStores(vehicles);

        VehicleRentalSystem rentalSystem = new VehicleRentalSystem( users,stores);

        // 0. User comes
        User user = users.get(0);

        // 1. User searches store based on location
        Location location = new Location("Bangalore", "Karnataka", "403012");
        Store store = rentalSystem.getStore(location);

        // 2. Get all vehicles you are interested in
        List<Vehicle> storeVehicles = store.getVehicles(VehicleType.BIKE);
        // ✅ FIX 1: Check if vehicles available
        if (storeVehicles.isEmpty()) {
            System.out.println("No bikes available!");
            return;
        }

        // 3. Reserve a particular vehicle
        Reservation reservation = store.createReservation(storeVehicles.get(0), users.get(0));

        // ✅ FIX 2: Check if reservation created successfully
        if (reservation == null) {
            System.out.println("Reservation failed - vehicle might not be available!");
            return;
        }

        // 3. Reserve a particular vehicle
//        Reservation reservation = store.createReservation(storeVehicles.get(0), users.get(0));

        // 4. Generate bill
        Bill bill = new Bill(reservation);

        // 5. Make payment
        Payment payment = new Payment();
        payment.payBill(bill);

        // 6. Complete reservation
        store.completeReservation(reservation.getId());
    }
    public static  List<User> addUsers(){
        List<User> users= new ArrayList<>();
        users.add(new User(1,"rajat"));
        return users;
    }
//    public static  List<Vehicle>  addVehicles(){
//        List<Vehicle> users= new ArrayList<>();
//        users.add(new Vehicle(1,"1234",VehicleType.BIKE,12,Status.BOOKED,12,1));
//        return users;
//    }
    public static   List<Store> addStores(List<Vehicle>  vehicleList){
        List<Store> stores= new ArrayList<>();
        VehicleInventory vehicleInventory= new VehicleInventory(vehicleList);
        Store store= new Store();
        store.setVehicleInventory(vehicleInventory);
        Location location = new Location("Bangalore", "Karnataka", "403012");
        store.setLocation(location);
        stores.add(store);
        return stores;
    }
    public static List<Vehicle> addVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        // ✅ FIX 3: CHANGE STATUS TO AVAILABLE - YEH SABSE IMPORTANT FIX HAI
        vehicles.add(new Vehicle(1, "KA01AB1234", VehicleType.BIKE, 100,
                Status.AVAILABLE, 2, 1));
        return vehicles;
    }
}
