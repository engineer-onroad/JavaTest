package com.java.common.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *  on 2018/1/4.
 */
public class CountTableTest {
    public static int TALBE_NUMBER_512 = 512;
    public static int TABLE_PER_DB = 1024;
    public static String TABLE_WALL_USER_TABLE_PREFIX="p_wall_user_";


    public static void main(String[] args) throws ParseException {
        long id=1167748419;
        String table=getTableName(id,TABLE_WALL_USER_TABLE_PREFIX);
        System.out.println("table="+table);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long millionSeconds = 1516095228443L;//
        /*try {
            millionSeconds = sdf.parse("20120809030000").getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(millionSeconds);*/

        String d = sdf.format(millionSeconds);

        System.out.println("Format To String(Date):"+d);
    }

    public static String getTableName(long key,String keyPrefix){
        if(keyPrefix == null || key < 0){
            throw new RuntimeException("data access error : NO ROUTER KEY FOUND");
        }
        return keyPrefix + key % TALBE_NUMBER_512;
    }

    public static String getTableNameByNum1024(long key,String keyPrefix){
        if(keyPrefix == null || key < 0){
            throw new RuntimeException("data access error : NO ROUTER KEY FOUND");
        }
        return keyPrefix + key % TABLE_PER_DB;
    }
}
