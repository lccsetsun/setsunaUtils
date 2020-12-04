package com.alibaba.lcc.agent;

import java.lang.instrument.Instrumentation;

public class agentDemo {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("=========premain方法执行1========");
        System.out.println(agentArgs);
    }

}
