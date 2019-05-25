package com.pfhuang.parkingmaster_boot.util;

public class XOR {

    /**
     * 异或操作
     * @param datas
     * @return
     */
    public static byte getXor(byte[] datas) {
        byte temp = datas[0];
        for (int i = 1; i < datas.length; i++) {
            temp ^= datas[i];
        }
        return temp;
    }

    /**
     * 校验方法
     * @param MSG
     * @return
     */
    public static boolean xorMSG(String MSG){


        //  校验结果，16进制及ASCII方法均可识别
        final String[] StringMSG1 = MSG.split("\\*");

        //  校验计算，初值赋值差别
        int localXor = 999999;
        int remoteXor = 1;
        if (StringMSG1.length == 3) {
            // 本地校验值
            localXor = getXor(StringMSG1[0].getBytes()) ^ '*' ^ getXor(StringMSG1[1].getBytes()) ^ '*';
            System.out.println("1-"+localXor);
            // 远程传递的校验值
            String regex = "^[A-Fa-f0-9]+$";
            if (StringMSG1[2].matches(regex)) {
                remoteXor = Integer.valueOf(StringMSG1[2], 16);
                System.out.println("2"+remoteXor);
            }
        }

        if (localXor == remoteXor || localXor == Integer.parseInt(String.valueOf(remoteXor), 16)) {
            System.out.println("校验成功");
            return  true;
        } else {
            System.out.println("校验失败");
            return  false;
        }

    }


}


