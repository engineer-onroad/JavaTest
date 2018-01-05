package com.java.common.test;

/**
 *  on 2018/1/4.
 */
public class CountTableTest {
    public static int TALBE_NUMBER_512 = 512;
    public static int TABLE_PER_DB = 1024;
    public static String TABLE_WALL_USER_TABLE_PREFIX="p_wall_user_";


    public static void main(String[] args) {
        long id=286846247;
        String table=getTableName(id,TABLE_WALL_USER_TABLE_PREFIX);
        System.out.println("table="+table);
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
