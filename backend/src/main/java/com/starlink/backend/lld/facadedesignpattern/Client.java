package com.starlink.backend.lld.facadedesignpattern;

public class Client {
    public static void main(String[] args) {
        EmployeeDaoFacade employeeDaoFacade=new EmployeeDaoFacade(new EmployeeDao());
        employeeDaoFacade.getAllDetails();
    }
}
