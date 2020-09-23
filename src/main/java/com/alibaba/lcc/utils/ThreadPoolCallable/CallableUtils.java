package com.alibaba.lcc.utils.ThreadPoolCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class CallableUtils {
    private final static ArrayBlockingQueue<Runnable> WORK_QUEUE = new ArrayBlockingQueue<>(9);

    private final static RejectedExecutionHandler HANDLER = new ThreadPoolExecutor.CallerRunsPolicy();

    private static ThreadPoolExecutor executorService = new ThreadPoolExecutor(16, 16, 1000, TimeUnit.MILLISECONDS, WORK_QUEUE, HANDLER);

    public static void main(String[] args) {
        System.out.println("start application");
              String s = callabnum();
        System.out.println(s);

    }

    private static String callabnum() {
        Callable<List> productListCallable = () ->{
            List<String> list = new ArrayList<>();
            for (int i = 0; i <20 ; i++) {
                list.add("ceshi_"+i);
            }
            try{
                sleep(2000);
            }catch (Exception e){
                e.getMessage();
            }
            return list;
        };
        Callable<String> demo1ListCallable = () ->demo1();
        Callable<String> demo2ListCallable = () ->demo1();

        FutureTask<List> productListCallableTask = new FutureTask<List>(productListCallable);
        FutureTask<String> demo1ListCallableTask = new FutureTask<String>(demo1ListCallable);
        FutureTask<String> demo2ListCallableTask = new FutureTask<String>(demo2ListCallable);

        executorService.submit(productListCallableTask);
        executorService.submit(demo1ListCallableTask);
        executorService.submit(demo2ListCallableTask);
        try {
            System.out.println(productListCallableTask.get());
            System.out.println(demo1ListCallableTask.get());
            System.out.println(demo2ListCallableTask.get());

        }catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
        return "OK";
    }

    private static String demo1() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            list.add("ceshi_"+i);
        }
        try{
            sleep(2000);
        }catch (Exception e){
            e.getMessage();
        }
        return "sleep 2000";
    }
}
