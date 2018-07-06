package com.java.common.test;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.hadoop.hbase.util.Bytes;

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
        String str="你好，test点此设置";

        System.out.println("length:"+str.length()+",index:"+str.indexOf("点此设置"));
        long time=System.currentTimeMillis();
        byte[] times= Bytes.toBytes(time);
        System.out.println("times:"+times.length);
        long circleId=209327147L;
        String rowkey=buildUserCloudRowKey(circleId,1000L);
        byte[] rowkeys=Bytes.toBytes(rowkey);
        System.out.println("rowkey:"+rowkeys.length);
        long parseCircleId=parseCircleId(rowkey);
        System.out.println("parse circle:"+parseCircleId+",result="+(circleId==parseCircleId));
    }

    private static String buildUserCloudRowKey(long myUid,long fuid) {
        String leftPadMyUid = StringUtils.leftPad(String.valueOf(myUid), 11, "0");
        String reversedMyUid = StringUtils.reverse(leftPadMyUid);
        String fanUidStr=StringUtils.leftPad(String.valueOf(fuid),11, "0");
        return reversedMyUid+"_"+fanUidStr;
    }

    public static long parseCircleId(String rowkey) {
        String circleId = "";
        String[] ts = StringUtils.split(rowkey, "_");
        if (!ArrayUtils.isEmpty(ts) && ts.length > 1) {
            circleId = ts[0];
        }
        circleId=StringUtils.reverse(circleId);
        return NumberUtils.toLong(circleId);
    }
}
