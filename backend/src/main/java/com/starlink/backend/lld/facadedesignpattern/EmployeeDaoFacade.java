package com.starlink.backend.lld.facadedesignpattern;

public class EmployeeDaoFacade {
    EmployeeDao employeeDao;

    public EmployeeDaoFacade(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    public void getAllDetails(){
        employeeDao.getAllDetails();
    }
}
