package com.pfhuang.parkingmaster_boot.entity;

import java.util.Date;

public class Parkingspace {
    private Integer id;

    private Integer parkingspaceId;

    private Integer parkinglotId;

    private Integer status;

    private Integer userId;

    private Date startTime;

    private Date endTime;

    private Date gmtCreate;

    private Date gmtModified;

    public Parkingspace(Integer id, Integer parkingspaceId, Integer parkinglotId, Integer status, Integer userId, Date startTime, Date endTime, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.parkingspaceId = parkingspaceId;
        this.parkinglotId = parkinglotId;
        this.status = status;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public Parkingspace() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParkingspaceId() {
        return parkingspaceId;
    }

    public void setParkingspaceId(Integer parkingspaceId) {
        this.parkingspaceId = parkingspaceId;
    }

    public Integer getParkinglotId() {
        return parkinglotId;
    }

    public void setParkinglotId(Integer parkinglotId) {
        this.parkinglotId = parkinglotId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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