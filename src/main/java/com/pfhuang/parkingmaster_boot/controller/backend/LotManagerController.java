package com.pfhuang.parkingmaster_boot.controller.backend;

import com.pfhuang.parkingmaster_boot.common.ServerResponse;
import com.pfhuang.parkingmaster_boot.service.ILotService;
import com.pfhuang.parkingmaster_boot.service.IPakService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backend/manage")
public class LotManagerController {

    @Autowired
    private ILotService iLotService;

    @Autowired
    private IPakService iPakService;

    @RequestMapping("lot.do")
    public ServerResponse lotMSG(String LOTMSG){
        return iLotService.lotManage(LOTMSG);
    }

    @RequestMapping(value = "pak.do")
    @ResponseBody
    public ServerResponse pakMSG(String PAKMSG){

        return  iPakService.pakManage(PAKMSG);
    }

    @RequestMapping(value = "get.do")
    @ResponseBody
    public String get(){
        return  "1";
    }

    // TODO: 2019/5/25 login

}
