package com.fh.utils;


import java.io.Serializable;

public class ResponseServer<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    private ResponseServer(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    private ResponseServer(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResponseServer error() {
        return new ResponseServer(ServerEnum.ERROR.getCode(), ServerEnum.ERROR.getMessage());
    }

    public static ResponseServer error(ServerEnum serverEnum) {
        return new ResponseServer(serverEnum.getCode(), serverEnum.getMessage());
    }

    public static ResponseServer success() {
        return new ResponseServer(ServerEnum.SUCCESS.getCode(), ServerEnum.SUCCESS.getMessage());
    }

    public static <T> ResponseServer<T> success(T data) {
        return new ResponseServer<T>(ServerEnum.SUCCESS.getCode(), ServerEnum.SUCCESS.getMessage(), data);
    }

    public static ResponseServer error(Integer code,String msg){
        return new ResponseServer(code,msg);
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
