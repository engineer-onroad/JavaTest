package com.java.performance.test;

/**
 * Created by wudi06 on 2017/12/13.
 */
public class IntegerCompare {
    public static void main(String[] args) {
        Integer i1=100;
        Integer i2=100;

        Integer i3=500;
        Integer i4=500;

        System.out.println("i1==i2:"+(i1==i2));
        System.out.println("i2==i3:"+(i3==i4));
        //
        System.out.println("i1 equals i2:"+(i1.equals(i2)));
        System.out.println("i2 equals i3:"+(i3.equals(i4)));
    }
}
