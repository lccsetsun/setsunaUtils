package com.alibaba.lcc.utils.FileUtils;


import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author: setsun
 * @create: 2018- 12-03
 * @description:
 * @program: utilsLcc
 **/
public class FileUtils {

    private static String GAP_KEY = "48d3c5eca1aea03259960260131baf96";
    private static String ALI_IDST_KEY = "ec85d3648154874552835438ac6a02b2";

    static String path = "/Users/setsun/Downloads/json/";  //json计算地理位置文件存放路径

    public static void main(String[] args) {
        //读取文件
       String json = readFile("");

    }

    /**
     * 读取指定文件夹下所有json文件内容
     * @return
     */
    public static List<String> readListFile(String path) {
        List<String> list =new ArrayList<>(32);
        String result="";
        try {
        File file = new File(path);
        if (!file.isDirectory()){
            System.out.println("==="+file.getName());
        }else if(file.isDirectory()){
            String[] filelist = file.list();
            for (int i = 0; i <filelist.length ; i++) {
                if (file.isDirectory() && filelist[i].endsWith(".json")){
                    FileReader fileReader = new FileReader(path+filelist[i]);
                        BufferedReader br = new BufferedReader(fileReader);
                        String line;
                        while( (line = br.readLine()) != null ){
                            result+=line;
                        }
                    result+="_"+filelist[i];
                }
                if (StringUtils.isNotBlank(result)){
                    list.add(result);
                    result = "";
                }
            }
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     *   把json格式的字符串写到文件
     * @param filePath  save file is path
     * @param json      write jsonResult
     * @return
     */
    public static boolean writeFile(String filePath, String json) {
        FileWriter fw;
        try {
            fw = new FileWriter(filePath);
            PrintWriter out = new PrintWriter(fw);
            out.write(json);
            System.out.println("download file OK");
            fw.close();
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 读取指定文件的内容
     * @param path
     * @return
     */
    public static String readFile(String path) {

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            String result = "";
            while ((line = br.readLine()) != null) {
                result += line;
            }
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


}
