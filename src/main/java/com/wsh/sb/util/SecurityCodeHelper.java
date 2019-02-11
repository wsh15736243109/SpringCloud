package com.wsh.sb.util;

/**
 * @Author:Create by Mr.w
 * @Date:2018/5/17 9:35
 * @Description:
 */
public class SecurityCodeHelper {
    public static String getSecurityCode(int length) {
        //产生length之类的随机数
        int pow = (int) Math.pow(10, length);
        String rand = (int)(Math.random() * pow) + "";
        if (rand.length() < length) {
            for (int i = 0; i < length - rand.length(); i++) {
                rand = rand.concat("0");
            }
        }
        return rand;
    }
}
