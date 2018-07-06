package com.java.spi.test;

import java.util.ServiceLoader;

/**
 * Created  on 2018/7/6.
 */
public class SpiTest {
    public static void main(String[] args) throws Exception {
        ServiceLoader<DogService> loaders = ServiceLoader.load(DogService.class);
        for (DogService d : loaders) {
            d.sleep();
        }
    }
}
