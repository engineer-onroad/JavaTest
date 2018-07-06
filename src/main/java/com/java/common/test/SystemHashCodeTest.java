package com.java.common.test;

/**
 * Created by wudi06 on 2018/2/1.
 */
public class SystemHashCodeTest {
    public static void main(String[] args) {
        // a和b指向不同对象。
        String a = new String("hhh");
        String b = new String("hhh");

        System.out.println("identityHashCode:"+System.identityHashCode(a));
        System.out.println("identityHashCode:"+System.identityHashCode(b));
        System.out.println("hasCode:"+a.hashCode());
        System.out.println("hasCode:"+b.hashCode());

        // string1和string2指向同一个对象。
        String string1 = "wxg";
        String string2 = "wxg";

        System.out.println("identityHashCode:"+System.identityHashCode(string1));
        System.out.println("identityHashCode:"+System.identityHashCode(string2));

        System.out.println("hasCode:"+string1.hashCode());
        System.out.println("hasCode:"+string2.hashCode());
        System.out.println(System.currentTimeMillis());
    }
}
