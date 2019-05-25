package com.pfhuang.parkingmaster_boot.entity;

import java.util.Date;

public class ParkingMessage {

    Integer zoneId;
    Integer parkinglotId;
    Integer parkingSpaceId ;
    Integer userId ;
    Double fee;
    Integer spaceTotal;
    Integer spaceAvailable;

    Date msgTime;
    Integer status;

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Integer getSpaceTotal() {
        return spaceTotal;
    }

    public void setSpaceTotal(Integer spaceTotal) {
        this.spaceTotal = spaceTotal;
    }

    public Integer getSpaceAvailable() {
        return spaceAvailable;
    }

    public void setSpaceAvailable(Integer spaceAvailable) {
        this.spaceAvailable = spaceAvailable;
    }



    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public Integer getParkinglotId() {
        return parkinglotId;
    }

    public void setParkinglotId(Integer parkinglotId) {
        this.parkinglotId = parkinglotId;
    }

    public Integer getParkingSpaceId() {
        return parkingSpaceId;
    }

    public void setParkingSpaceId(Integer parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(Date msgTime) {
        this.msgTime = msgTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
