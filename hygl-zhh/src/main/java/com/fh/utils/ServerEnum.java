package com.fh.utils;

public enum ServerEnum {

    SUCCESS(200, "成功"),
    LOGIN_INFO_MISS(1000,"用户信息不完整"),
    LOGIN_CODE_ERROR(1001,"验证码错误"),
    LOGIN_FAIL_ERROR(1007,"非法登录"),
    LOGIN_CODE_TIMEOUT(1008,"验证码超时"),
    LOGIN_USERNAME_MISS(1002,"用户名不存在"),
    LOGIN_PASSWORD_ERROR(1003,"密码错误"),
    LOGIN_LOCK(1004,"用户已被锁定"),
    ERROR(500, "失败");

    private ServerEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;


    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
