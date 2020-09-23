package com.alibaba.lcc.utils.ZipUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ZIP 压缩实例
 */
public class ZipRun {

    public static void main(String[] args) {
        //压缩出现乱码
//                send();
        String rootPath = "%u8BF7%u5728%u8FD9%u91CC%u8F93%u5165%u8981%u8F6C%u6362%u7684%u5185%u5BB9";
        try {
            rootPath = new String(rootPath.getBytes("GB2312"), "UTF-8");
            System.out.println(rootPath);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

    private static void send() {

        String p_PATH = "/Users/setsun/IdeaProjects/school_code/logs/file.zip";
        String start_PATH = "/Users/setsun/IdeaProjects/logs";

        List<File> listfile = getfilelist(start_PATH);
        for (File file : listfile) {
            System.out.println(file.getAbsolutePath());
        }
        File zipFile = new File(p_PATH);
        try {
            System.out.println("压缩 开始");
            ZipUtils.zipFiles(listfile, zipFile);
            System.out.println("压缩 结束");
            // 解压
            ZipUtils.upZipFile(zipFile,"/Users/setsun/IdeaProjects/school_code/logs/test/list/");
            System.out.println("解压");
            // huoqu
            ArrayList<String> ls = ZipUtils.getEntriesNames(zipFile);
            System.out.println("获取文件名");
            for (String file:ls
                    ) {
                System.out.println(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<File> getfilelist(String path) {
        File[] list = new File(path).listFiles();
        return Arrays.asList(list);
    }
}
