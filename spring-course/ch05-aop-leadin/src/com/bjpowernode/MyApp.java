package com.bjpowernode;

import com.bjpowernode.handler.MyInvocationHandler;
import com.bjpowernode.service.SomeService;
import com.bjpowernode.service.impl.SomeServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyApp {
    public static void main(String[] args) {
        /*SomeService someService=new SomeServiceImpl();
        someService.doSome();
        System.out.println("-------------");
        someService.doOther();*/

        //使用jdk的proxy创建代理对象
        //创建目标对象
        SomeService target=new SomeServiceImpl();

        //创建InvocationHandler对象
        InvocationHandler handler=new MyInvocationHandler(target);

        //使用Proxy创建代理
        SomeService proxy= (SomeService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),handler);

        //通过代理执行方法，会调用handler中的invoke()
        proxy.doSome();
    }
}
