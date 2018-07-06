package com.java.proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wd on 2018/7/5.
 */
public class InvokerInvocationHandler implements InvocationHandler {
    private final Object invoker;

    public InvokerInvocationHandler(Object handler) {
        this.invoker = handler;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();

        if ("toString".equals(methodName) && parameterTypes.length == 0) {
            return invoker.toString();
        }
        if ("hashCode".equals(methodName) && parameterTypes.length == 0) {
            return invoker.hashCode();
        }
        if ("equals".equals(methodName) && parameterTypes.length == 1) {
            return invoker.equals(args[0]);
        }
        System.out.println(method);
        System.out.println("进行编码");
        System.out.println("发送网络请求");
        System.out.println("将网络请求结果进行解码并返回");
        return method.invoke(invoker, args);
    }
}
