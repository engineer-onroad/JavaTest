package com.java.rpc.thrift;

import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;

import java.util.Date;

/**
 * on 2018/1/4.
 */
public class HelloWordServiceImpl implements HelloWordService.Iface {
    @Override
    public String doAction(Request request) throws RequestException, TException {
        System.out.println("Get request: " + request);
        if (StringUtils.isBlank(request.getName()) || request.getType() == null) {
            throw new RequestException();
        }
        String result = "Hello, " + request.getName();
        if (request.getType() == RequestType.SAY_HELLO) {
            result += ", Welcome!";
        } else {
            result += ", Now is " + new Date().toLocaleString();
        }
        return result;
    }
}
