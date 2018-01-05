package com.java.common.test;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * on 2017/12/27.
 */
public class CommonTest {
    public static void main(String[] args) {
        String fanUidStr="ad";
        long fanUid = NumberUtils.toLong(fanUidStr);
        if(0==fanUid){
            System.out.println("0");
        }else{
            System.out.println(fanUid);
        }
    }
}
