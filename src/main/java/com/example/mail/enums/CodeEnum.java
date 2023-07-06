package com.example.mail.enums;


import lombok.Data;
import lombok.Getter;
import org.springframework.cache.interceptor.CacheableOperation;

@Getter
public enum CodeEnum {
    LOG_IN_SUCCESS(200,"登陆成功"),
    ACCOUNT_OR_PASSWORD_ERROR(201,"账户或者密码错误"),
    ACCOUNT_NOT_GRANTED(401,"用户未得到授权"),
    SERVER_ERROR(500,"服务器错误"),
    RESOURCE_NOT_EXIST(404,"请求的资源并不可用呢"),
    CREATE_OR_MODIFY_DATA_SUCCESS(202,"创建或修改数据成功");



    private Integer code;

    private String  status;

    CodeEnum(Integer code, String status) {
        this.code = code;
        this.status = status;
    }
}
