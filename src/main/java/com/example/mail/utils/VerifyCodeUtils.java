package com.example.mail.utils;

public class VerifyCodeUtils {

    public static String getRandomVerifyCode(){
        return String.format("%04d", System.currentTimeMillis() % 10000L);
    }


}
