package org.example.ba01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

/**
 * @Aspect: 是Aspectj框架中的注解
 *  作用：表示当前类是切面类
 *  切面类：是用来给业务方法增加功能的类，在这个类中有切面的功能代码
 *  位置：在类定义的上面
 */
@Aspect
public class MyAspect {
    /**
     * 定义方法，方法是实现切面功能的
     * 方法定义要求：
     *  1、公共方法public
     *  2、方法没有返回值
     *  3、方法名称自定义
     *  4、方法可以有参数，也可以没有
     *      如果有参数，参数不是自定义，有几个参数类型可以使用
     *
     *   @Before(value ="execution(* *..SomeService.*(..))")可以写成这样
     */

    /**
     * 指定方法中的参数：JointPoint
     * JoinPoint：业务方法，要加入切面功能的业务方法
     *      作用是：可以在通知方法中获取方法执行时的信息，例如方法名，方法实参等
     *      如果切面功能中需要用到方法信息，就加入JoinPoint
     *      该参数的值由框架赋予，必须是第一个位置的参数
     */
    @Before(value ="execution(public void org.example.ba01.SomeServiceImpl.doSome(String,Integer))")
    public void myBefore(JoinPoint jp){
        //获取方法的完整定义
        System.out.println("方法的签名(定义)"+jp.getSignature());
        System.out.println("方法的名称"+jp.getSignature().getName());
        //获取方法参数
        Object args[]= jp.getArgs();
        for (Object arg:args){
            System.out.println("参数"+arg);
        }
        //就是你切面要执行的功能代码
        System.out.println("前置通知,切面功能：在目标方法之前输出时间："+new Date());
    }
}
