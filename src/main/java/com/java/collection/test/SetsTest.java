package com.java.collection.test;

import com.google.common.collect.Sets;
import org.apache.commons.lang.StringUtils;

import java.util.Set;

/**
 * Created by wudi06 on 2018/5/23.
 */
public class SetsTest {
    public static void main(String[] args) {
        Set<Integer> set1= Sets.newHashSet(1,2,3,4,5,6);
        Set<Integer>set2=Sets.newHashSet(3,4,5,6,7,8,9);
        System.out.println("交集为：");
        Set<Integer> S=Sets.difference(set1, set2);
        System.out.println(StringUtils.join(S,","));
    }
}
