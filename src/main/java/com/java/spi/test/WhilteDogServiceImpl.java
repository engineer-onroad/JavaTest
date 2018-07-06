package com.java.spi.test;

/**
 * Created on 2018/7/6.
 */
public class WhilteDogServiceImpl implements DogService{

    @Override
    public void sleep() {
        System.out.println("白色dog。。。呼呼大睡觉...");

    }
}
