package com.java.rpc.thrift;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

import java.net.ServerSocket;

/**
 * wudi06 on 2018/1/4.
 */
public class HelloWordServer {
    public static void main(String[] args) throws Exception {
        ServerSocket socket = new ServerSocket(7912);
        TServerSocket serverTransport = new TServerSocket(socket);
        HelloWordService.Processor processor = new HelloWordService.Processor(new HelloWordServiceImpl());

        TServer.Args serverParams=new TServer.Args(serverTransport);
        serverParams.protocolFactory(new TBinaryProtocol.Factory());
        serverParams.processor(processor);

        TServer server = new TSimpleServer(serverParams);
        System.out.println("Running server...");
        server.serve();
    }
}
