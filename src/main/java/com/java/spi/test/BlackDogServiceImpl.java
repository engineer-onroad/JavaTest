package com.java.spi.test;

/**
 * Created on 2018/7/6.
 */
public class BlackDogServiceImpl implements DogService{

    @Override
    public void sleep() {
        System.out.println("黑色dog。。。汪汪叫，不睡觉...");

    }
}
