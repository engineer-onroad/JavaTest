package com.java.enums.test;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

import java.util.Collection;
import java.util.EnumSet;
public class EnumSetTest {
    public static void main(String[] args) {
        Integer num1=4;
        EnumSet<CircleBusinessType> allTypes=EnumSet.allOf(CircleBusinessType.class);
        Collection<Integer> typesSet=Collections2.transform(allTypes, new Function<CircleBusinessType, Integer>() {
            @Override
            public Integer apply(CircleBusinessType type) {
                return type.getValue();
            }
        });
        System.out.println(allTypes);
        if(typesSet.contains(num1)){
            System.out.println("contain num1");
        }else{
            System.out.println("not contain num1");
        }
    }
}