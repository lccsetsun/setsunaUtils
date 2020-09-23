package com.alibaba.lcc.utils.AES;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class demo {
    public static void main(String[] args) {
        String con = "c2Rhc2Q=";
        final BASE64Encoder encoder = new BASE64Encoder();
        final BASE64Decoder decoder = new BASE64Decoder();
        try {
            System.out.println(new String(decoder.decodeBuffer(con), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
