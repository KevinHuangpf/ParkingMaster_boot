package com.pfhuang.parkingmaster_boot.entity;

import java.util.Date;

public class User {
    private Integer id;

    private String licenseNumber;

    private Date gmtCreate;

    private Date gmtModified;

    public User(Integer id, String licenseNumber, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.licenseNumber = licenseNumber;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber == null ? null : licenseNumber.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}