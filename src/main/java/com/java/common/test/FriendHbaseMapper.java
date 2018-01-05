package com.java.common.test;


import org.apache.hadoop.hbase.util.Bytes;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class FriendHbaseMapper {

    public static final byte[] FAMILY = Bytes.toBytes("f");

    public static final byte[] QUALIFIER_UID = Bytes.toBytes("uid");
    public static final byte[] QUALIFIER_SOURCE = Bytes.toBytes("src");
    public static final byte[] QUALIFIER_CREATE_TIME = Bytes.toBytes("ct");

    public static final String TABLE_FOLLOW = "usercloud_friend_follow";
    public static final String TABLE_FANS = "usercloud_friend_fans";


    public static String buildKey(long myuid, long fuid) {
        String uidrev = StringUtils.reverse(leftPad(String.valueOf(myuid)));
        return uidrev + "_" + leftPad(String.valueOf(fuid));
    }

    public static long[] parseKey(String key) {
        long[] result = new long[2];
        String[] ts = StringUtils.split(key, "_");
        result[0] = NumberUtils.toLong(StringUtils.reverse(ts[0]));
        result[1] = NumberUtils.toLong(ts[1]);
        return result;
    }


    private static String leftPad(String uidrev) {
        return StringUtils.leftPad(uidrev, 11, "0");
    }

    public static void main(String[] args) {
        String rowkeyPrefix = buildKey(100L,20L);
        System.out.println(rowkeyPrefix);
    }

}

