package com.starlink.backend.lld.carrental;

import java.util.List;

public class VehicleRentalSystem {
    List<User> userList;
    List<Store> storeList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }

    public VehicleRentalSystem(List<User> userList, List<Store> storeList) {
        this.userList = userList;
        this.storeList = storeList;
    }
    public Store getStore(Location location){
       return storeList.stream().filter(s->s.getLocation().pincode.equals(location.getPincode())).findFirst().get();
    }
}
