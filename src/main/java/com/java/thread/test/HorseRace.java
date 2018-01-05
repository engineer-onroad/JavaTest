package com.java.thread.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

class Horse implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private int strides = 0;
    private static Random rand = new Random(47);
    private static CyclicBarrier barrier;
    public Horse(CyclicBarrier b) {barrier = b;}
    public synchronized int getStrides() {return strides;}
    public void run() {
        try {
            while (!Thread.interrupted()) {  //线程内不断循环
                synchronized (this) {
                    strides += rand.nextInt(3);   //每次马可以走0,1或者2步
                }
                barrier.await();  //走完后，就等所有其它马也走完，才能开始下一回合
            }
        } catch (InterruptedException e) {

        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Horse " + id + " ";
    }

    public String tracks() {
        StringBuilder s =new StringBuilder();
        for(int i = 0; i < getStrides();i++)
            s.append("*");   //这里打印每个马走的轨迹
        s.append(id);
        return s.toString();
    }
}
public class HorseRace {
    static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<Horse>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;
    public HorseRace(int nHorses, final int pause) {
        barrier = new CyclicBarrier(nHorses, new Runnable() {
            @Override
            public void run() {
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < FINISH_LINE; i++) {
                    s.append("="); //打印赛道
                }
                System.out.println(s);
                for (Horse horse : horses) {
                    System.out.println(horse.tracks());  //打印每匹马的轨迹
                }
                for (Horse horse : horses) {
                    if (horse.getStrides() >= FINISH_LINE) {
                        System.out.println(horse + "won!");   //每次检查，如果哪匹马到终点了，终止所有线程
                        exec.shutdownNow();
                        return;
                    }
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(pause); //每走完一轮，暂停一小会输出
                } catch (InterruptedException e) {
                    System.out.println("barrier-action sleep interrupted");
                }
            }
        });

        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);  //所有马的线程开始执行
        }
    }

    public static void main(String[] args) {
        int nHorses = 7;
        int pause = 200;
        new HorseRace(nHorses, pause);
    }
}

