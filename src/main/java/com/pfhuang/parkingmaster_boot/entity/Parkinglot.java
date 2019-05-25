package com.pfhuang.parkingmaster_boot.entity;

import java.util.Date;

public class Parkinglot {
    private Integer id;

    private Integer parkinglotId;

    private Integer zoneId;

    private Double fee;

    private Integer parkingspaceTotal;

    private Integer parkingspaceAvailable;

    private Date gmtCreate;

    private Date gmtModified;

    public Parkinglot(Integer id, Integer parkinglotId, Integer zoneId, Double fee, Integer parkingspaceTotal, Integer parkingspaceAvailable, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.parkinglotId = parkinglotId;
        this.zoneId = zoneId;
        this.fee = fee;
        this.parkingspaceTotal = parkingspaceTotal;
        this.parkingspaceAvailable = parkingspaceAvailable;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public Parkinglot() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParkinglotId() {
        return parkinglotId;
    }

    public void setParkinglotId(Integer parkinglotId) {
        this.parkinglotId = parkinglotId;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Integer getParkingspaceTotal() {
        return parkingspaceTotal;
    }

    public void setParkingspaceTotal(Integer parkingspaceTotal) {
        this.parkingspaceTotal = parkingspaceTotal;
    }

    public Integer getParkingspaceAvailable() {
        return parkingspaceAvailable;
    }

    public void setParkingspaceAvailable(Integer parkingspaceAvailable) {
        this.parkingspaceAvailable = parkingspaceAvailable;
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