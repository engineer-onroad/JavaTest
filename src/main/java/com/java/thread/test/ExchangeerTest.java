package com.java.thread.test;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ExchangeerTest {
    private static final Exchanger<String> exgr = new Exchanger<String>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        Future<?> r1 = threadPool.submit(new Runnable() {
            @Override
            public void run() {
                String A = "银行流水A";
                try {
                    String B = exgr.exchange(A);
                    System.out.println("B:" + B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                String B = "银行流水B";
                String A = null;
                try {
                    A = exgr.exchange(B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A和B是否一致：" + A.equals(B) + ",A录入的是：" + A + ",B录入的是：" + B);
            }
        });
        threadPool.shutdown();
    }
}
