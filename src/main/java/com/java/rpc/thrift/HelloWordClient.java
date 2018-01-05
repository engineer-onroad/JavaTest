package com.java.rpc.thrift;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 *  on 2018/1/4.
 */
public class HelloWordClient {
    public static void main(String[] args) throws Exception {
        TTransport transport = new TSocket("localhost", 7912);
        TProtocol protocol = new TBinaryProtocol(transport);

        // 创建client
        HelloWordService.Client client = new HelloWordService.Client(protocol);

        transport.open();  // 建立连接

        // 第一种请求类型
        Request request = new Request()
                .setType(RequestType.SAY_HELLO).setName("winwill2012").setAge(24);
        System.out.println(client.doAction(request));

        // 第二种请求类型
        request.setType(RequestType.QUERY_TIME).setName("winwill2012");
        System.out.println(client.doAction(request));

        transport.close();  // 请求结束，断开连接
    }
}
