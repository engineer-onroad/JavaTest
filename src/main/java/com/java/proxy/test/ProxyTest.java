package com.java.proxy.test;

import java.lang.reflect.Proxy;

/**
 * Created on 2018/7/5.
 */
public class ProxyTest {
    public static void main(String[] args) {
        MenuService menuServiceImpl=new MenuServiceImpl();
        InvokerInvocationHandler invocationHandler=new InvokerInvocationHandler(menuServiceImpl);
        MenuService menuService = (MenuService) Proxy.newProxyInstance(invocationHandler.getClass().getClassLoader(), menuServiceImpl
                .getClass().getInterfaces(), invocationHandler);
        menuService.sayHello();
        //输出结果如下:
        //public abstract void com.toby.rpc.MenuService.sayHello()
        //进行编码
        //发送网络请求
        //将网络请求结果进行解码并返回
    }
}
