package com.alibaba.lcc.utils.contain;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class strindexOF {
    public static void main(String[] args) {

        contains();

    }

    private static void contains() {
        String str = "博奥路-湖滨花园北向南1";
        String str2 = "博奥路-湖滨花园南向北1";
        Matcher matcher=Pattern.compile("东|南|西|北").matcher(str);
        if (matcher.find()){
            System.out.println(matcher.start() + "===" +matcher.group());
            System.out.println(str.substring(0,matcher.start()));
        }
    }
}
