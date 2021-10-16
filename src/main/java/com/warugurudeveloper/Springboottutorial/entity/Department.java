package com.warugurudeveloper.Springboottutorial.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
    //primary key
    @Id
    //how to generate theprimary key
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCodes;
    //getters and setters
    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentCodes() {
        return departmentCodes;
    }

    public void setDepartmentCodes(String departmentCodes) {
        this.departmentCodes = departmentCodes;
    }
    //constructor

    public Department(long departmentId, String departmentName, String departmentAddress, String departmentCodes) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCodes = departmentCodes;
    }
    //default constructor
    private Department(){

    }

    //to string method
    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentCodes='" + departmentCodes + '\'' +
                '}';
    }
}
