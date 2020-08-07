package com.bjpowernode.handler;

import com.bjpowernode.util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    //目标对象
    /**target会是SomeServiceImpl类*/
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //通过代理对象执行方法时，会调用invoke方法
        System.out.println("执行InvocationHandler中的invoke()");
        Object res=null;
        ServiceTools.doLog();
        //执行目标类方法,用过method类实现
        /**SomeServiceImpl.doSome(),doOther()*/
        res=method.invoke(target,args);
        ServiceTools.doTrans();
        //目标方法执行结果
        return res;
    }
}
