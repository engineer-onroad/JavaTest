package com.java.string.test;

import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.util.Collections;
import java.util.Map;

/**
 * Created by wudi06 on 2018/3/12.
 */
public class StringTest {
    public static void main(String[] args) {
       /* String str=null;
        str=str+"test";
        System.out.println(str);
        String str2="C     AllStar  add";
        //str2=str2.replaceAll("\\s*", "");
        str2=StringUtils.replace(str2," ", "");
        System.out.println(str2);
        int pickCount=7;
        int totalCount=12;
        double pickCount1=pickCount;
        double totalCount1=totalCount;
        double percent=pickCount1/totalCount1;
        int percent1= (int) Math.floor(percent*100);
        System.out.println(percent1);*/
       double d1=100.1;
        System.out.println(d1>100);
        String str=null;
        String str2="test";
        System.out.println(StringUtils.equals(str,str2));
        String num="2170255534";
		int num1= NumberUtils.toInt(num, -1);
		System.out.println(num1);
		System.out.println((long)num1);

		Map<String,Object> data= Maps.newHashMap();
        data.put("vipinfo", Collections.EMPTY_MAP);
        System.out.println(data);
        System.out.println(org.apache.commons.lang3.math.NumberUtils.toInt("2463826324", -1));
    }
}
