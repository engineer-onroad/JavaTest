package com.java.collection.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by wudi06 on 2018/1/24.
 */
public class CollectionTest {
    public static void main(String[] args) {
        List<Map<Long, Long>> sourceList= Lists.newArrayList();
        Map<Long,Long> map1= Maps.newHashMap();
        Map<Long,Long> map2= Maps.newHashMap();
        map1.put(2385517056L,1510908242338L);
        map2.put(1275699363L,1510908207006L);
        sourceList.add(map1);
        sourceList.add(map2);
        List<Map<Long,Long>> targetList=Lists.newArrayList();
        targetList.addAll(sourceList);
        Iterator<Map<Long,Long>> itr1=targetList.iterator();
        while(itr1.hasNext()){
           /*Map<Long,Long> tempMap=itr1.next();
            Long val=tempMap.get(2385517056L);
            val=val+1L;
            tempMap.put(2385517056L,val);*/
          Map<Long,Long> tempMap=itr1.next();
            itr1.remove();
            break;
        }
        System.out.println("source:"+sourceList);
        System.out.println("target:"+targetList);
        List<Integer> testList=new ArrayList<Integer>();
        testList.add(1);
        testList.add(2);
        System.out.println(testList.remove(0).intValue());

    }


}
