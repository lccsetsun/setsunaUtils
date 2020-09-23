package com.alibaba.lcc.utils;

import org.apache.commons.lang.NullArgumentException;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;

import java.util.Base64;
import java.util.Date;

public class GetDataUtils {

    public static void main(String[] args) {
//        System.out.println(GetDataUtils.sdf.format(new Date()));
        System.out.println(stringMD5("nihaoa"));
    }

    public final static SimpleDateFormat SECONDE_DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    public final static SimpleDateFormat MONTH_DATE_FORMATTER = new SimpleDateFormat("yyyyMM-dd");

    public static SimpleDateFormat dayFdf = new SimpleDateFormat("dd");
    public static SimpleDateFormat hourSDF = new SimpleDateFormat("HH");
    public static SimpleDateFormat hourTime = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
    public static SimpleDateFormat fdf = new SimpleDateFormat("yyyyMMdd");
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat czdf = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss");

    public static String getCurrentDate() {
        org.joda.time.format.DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyyMMdd");
        String localDate = (new LocalDate()).toString(dtf);
        return localDate;
    }

    public static String stringMD5(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input argument can't be null");
        }

        try {
            // 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            byte[] inputByteArray = input.getBytes();

            messageDigest.update(inputByteArray);

            // 字符数组转换成字符串返回
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void checkParameterHasBank(String errorMsg, String... params) {
        for (String p : params) {
            if (StringUtils.isBlank(p)) {
                throw new NullArgumentException(errorMsg);
            } else {
                continue;
            }
        }
    }
    public static String base64Encodebytes(byte[] bytes){
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static boolean checkStringIsNull(String string){
        boolean flag = false;
        if (string == null || string.isEmpty()){
            flag = true;
        }
        return  flag;
    }


    public static String getOssString(String source,int type){
        String targetString;
        try {
            if (type == 1) {
                targetString=source.substring(0,source.indexOf("/"));
            } else {
                targetString=source.substring(source.indexOf("/")+1,source.length());
            }
        }catch (Exception e){
            targetString = null;
        }
        return targetString;
    }


}
