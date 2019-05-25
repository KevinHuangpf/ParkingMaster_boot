package com.pfhuang.parkingmaster_boot.service.impl;

import com.mysql.jdbc.StringUtils;

import com.pfhuang.parkingmaster_boot.common.ServerResponse;
import com.pfhuang.parkingmaster_boot.dao.ParkinglotMapper;
import com.pfhuang.parkingmaster_boot.dao.ParkingspaceMapper;
import com.pfhuang.parkingmaster_boot.entity.ParkingMessage;
import com.pfhuang.parkingmaster_boot.entity.Parkinglot;
import com.pfhuang.parkingmaster_boot.entity.Parkingspace;
import com.pfhuang.parkingmaster_boot.service.IPakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.pfhuang.parkingmaster_boot.common.Const.regexPayload;
import static com.pfhuang.parkingmaster_boot.util.CheckMSG.checkMSG;


@Service("iPakService")
public class PakServiceImpl implements IPakService {


    @Autowired
    private ParkinglotMapper parkinglotMapper;
    @Autowired
    private ParkingspaceMapper parkingspaceMapper;

    public ServerResponse pakManage(String pakMSG){

        if(StringUtils.isNullOrEmpty(pakMSG)){
            return ServerResponse.createByErrorMessage("数据为空");
        }

        if(!checkMSG(pakMSG)){
            return ServerResponse.createByErrorMessage("数据内容无效");
        }

        String[] payload=pakMSG.split(regexPayload);

        ParkingMessage parkingMessage = new ParkingMessage();
        parkingMessage.setZoneId(Integer.valueOf(payload[0]));
        parkingMessage.setParkinglotId(Integer.valueOf(payload[1]));
        parkingMessage.setParkingSpaceId(Integer.valueOf(payload[2]));
        parkingMessage.setUserId(Integer.valueOf(payload[3]));

        String string = payload[4];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date msgTime = null;
        try {
            msgTime = sdf.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        parkingMessage.setMsgTime(msgTime);


        parkingMessage.setStatus(Integer.valueOf(payload[5]));

        // 查车位和车场表
        Parkingspace parkingSpaceTemp = parkingspaceMapper.selectByParkingSpaceIdAndParkinglotId(parkingMessage.getParkingSpaceId(),parkingMessage.getParkinglotId());
        Parkinglot parkinglotTemp  = parkinglotMapper.selectByParkinglotIdAndZoneId(parkingMessage.getParkinglotId(),parkingMessage.getZoneId());

        // 判断是否车位是新建的，不是新建的则插入
        if(parkingSpaceTemp==null){
            // 如果查询为空，则新插入数据
            // 插入space表
            Parkingspace parkingSpace = new Parkingspace();
            parkingSpace.setStatus(parkingMessage.getStatus());
            parkingSpace.setUserId(parkingMessage.getUserId());
            parkingSpace.setParkingspaceId(parkingMessage.getParkingSpaceId());
            parkingSpace.setParkinglotId(parkingMessage.getParkinglotId());
            parkingSpace.setStartTime(parkingMessage.getMsgTime());

            int resSpaceCount = parkingspaceMapper.insert(parkingSpace);
            int resLotCount=0;
            // 更新车场表
            if(parkinglotTemp!=null){

                int parkingspaceAvailable = parkinglotTemp.getParkingspaceAvailable();
                parkingspaceAvailable--;
                parkinglotTemp.setParkingspaceAvailable(parkingspaceAvailable);
                resLotCount= parkinglotMapper.updateByPrimaryKey(parkinglotTemp);
            }

            if(resSpaceCount>0&&resLotCount>0){
                return ServerResponse.createBySuccessMessage("新增车位与更新车场成功");
            }
            return ServerResponse.createByErrorMessage("新增车位失败或当前所在车场未注册");
        }else {
            // 车位非新建，更新或删除操作
            // indexSpace存之前车位的状态
            int indexSpace = parkingSpaceTemp.getStatus();
            parkingSpaceTemp.setStatus(parkingMessage.getStatus());
            parkingSpaceTemp.setUserId(parkingMessage.getUserId());

            int resLotCount=0;
            int resSpaceCount=0;
            // 状态1到来，进来停车
            if(parkingMessage.getStatus().intValue()==1){
                // 更新车位表
                parkingSpaceTemp.setStartTime(parkingMessage.getMsgTime());
                 resSpaceCount= parkingspaceMapper.updateByPrimaryKey(parkingSpaceTemp);


                // 更新车场表，车位状态变化时才更新
                if(parkingMessage.getStatus()!=indexSpace){

                    // 需要更新车库数量
                    if(parkinglotTemp!=null){
                        int parkingspaceAvailable = parkinglotTemp.getParkingspaceAvailable();
                        parkingspaceAvailable--;
                        parkinglotTemp.setParkingspaceAvailable(parkingspaceAvailable);
                        resLotCount = parkinglotMapper.updateByPrimaryKey(parkinglotTemp);
                    }
                }

            }

            // 状态0到来，离开车位
            if(parkingMessage.getStatus().intValue()==0){
                // 更新车位表
                parkingSpaceTemp.setEndTime(parkingMessage.getMsgTime());
                resSpaceCount= parkingspaceMapper.updateByPrimaryKey(parkingSpaceTemp);

                // 更新车场表，车位状态变化时才更新
                if(parkingMessage.getStatus()!=indexSpace){
                    if(parkinglotTemp.getParkingspaceAvailable()!=null){
                        int parkingspaceAvailable = parkinglotTemp.getParkingspaceAvailable();
                        parkingspaceAvailable++;
                        parkinglotTemp.setParkingspaceAvailable(parkingspaceAvailable);
                        resLotCount = parkinglotMapper.updateByPrimaryKey(parkinglotTemp);
                    }
                }

            }
            if(resSpaceCount>0&&resLotCount>=0){
                return ServerResponse.createBySuccessMessage("更新车位且更新车场成功");
            }
            return ServerResponse.createByErrorMessage("更新车位失败或当前所在车场未注册");
        }

    }

}
