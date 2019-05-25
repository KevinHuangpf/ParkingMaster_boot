package com.pfhuang.parkingmaster_boot.service;


import com.pfhuang.parkingmaster_boot.common.ServerResponse;

public interface IPakService {
    ServerResponse pakManage(String pakMSG);
}
