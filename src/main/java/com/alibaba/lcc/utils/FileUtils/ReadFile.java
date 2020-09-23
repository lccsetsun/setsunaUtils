package com.alibaba.lcc.utils.FileUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) {
        String path = "";
        readFile(path);
    }

    private static void readFile(String path) {

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            String result = "";
            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
