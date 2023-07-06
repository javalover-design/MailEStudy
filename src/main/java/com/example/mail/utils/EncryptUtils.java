package com.example.mail.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class EncryptUtils {

    public static String md5(String state){
        return DigestUtils.md5Hex(state);
    }


}
