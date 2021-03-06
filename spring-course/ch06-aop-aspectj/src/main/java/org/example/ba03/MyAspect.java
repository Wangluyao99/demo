package org.example.ba03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

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
     * 环绕通知方法的定义格式：
     *      1、public
     *      2、必须有返回值，推荐使用Object
     *      3、方法名称自定义
     *      4、方法有参数，固定参数：ProceedingJoinPoint
     */
    /**
     * @Around: 环绕通知
     *      属性：value 切入点表达式
     *      位置：方法名上面
     *      特点：1、功能最强的通知
     *           2、在目标方法前和后都能增强功能
     *           3、控制目标方法是否被调用执行
     *           4、修改原来的目标方法执行结果，影响最后调用结果
     *
     *      环绕通知等同于动态代理，invocationHandler接口
     *
     *      参数：ProceedingJoinPoint 等同于Method,
     *             作用：执行目标方法
     *             返回值：目标方法的执行结果，可被修改
     *
     *     环绕通知经常做事务，在目标方法之前开启事务，执行方法，在目标方法之后提交事务
     */
    @Around(value = "execution(* *..SomeServiceImpl.doFirst(..))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        String name="";
        //获取第一个参数
        Object args [] =  pjp.getArgs();
        if (args != null && args.length>1){
            Object arg=args[0];
            name=(String)arg;
        }

        //实现目标方法调用
        Object result=null;
        System.out.println("环绕通知，目标方法之前输出时间"+new Date());
        //1、目标方法调用,相当于method.invoke()
        if ("zhangsan".equals(name)){
            result=pjp.proceed();
        }
        System.out.println("环绕通知，目标方法之前，提交事务");
        //2、在目标方法前后加功能

        //返回目标方法结果
        if (result !=null){
            System.out.println("hello aspectj aop");
        }
        return result;
    }

}
