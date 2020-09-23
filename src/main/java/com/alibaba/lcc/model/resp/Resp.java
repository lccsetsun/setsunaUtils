package com.alibaba.lcc.model.resp;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author: setsun
 * @create: 2018- 06-27
 * @description: 统一返回的工具类
 **/
public class Resp<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private final static String SUCCESS_CODE = "200";  //正确
    private final static String SUCCESS_ERROR = "1";  //错误

    /**
     * 返回状态码
     */
    private String status;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回内容
     */
    private T data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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


    public Resp(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public Resp(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;

    }


    //快速返回成功
    public static <T>Resp success(){
        return new Resp<T>(SUCCESS_CODE,"请求成功",null);
    }

    public static <T>Resp success(T result){
        return new Resp<T>(SUCCESS_CODE,"请求成功",result);
    }

    public static <T>Resp success(String message, T result){
        return new Resp<T>(SUCCESS_CODE,message,result);
    }

    public static  <T>Resp fail(String message){
        return new Resp<T>(SUCCESS_ERROR,message);
    }

    //快速返回失败状态
    public static <T>Resp fail(String message, HashMap<String, String> map){
        return new Resp<T>(ErrorCode.SYSTEM_ERROR.getCode(),ErrorCode.SYSTEM_ERROR.getMessage());
    }

    public <T>Resp fail(String message, T result){
        return new Resp<T>(ErrorCode.SYSTEM_ERROR.getCode(),message,result);
    }


}
