package org.example.ba02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
     * 后置通知定义方法，方法是实现切面功能的
     * 方法定义要求：
     *  1、公共方法public
     *  2、方法没有返回值
     *  3、方法名称自定义
     *  4、方法有参数，推荐Object,参数名自定义
     */
    /**
     * @AfterReturning: 后置通知
     *      属性：1、value：切入点表达式
     *           2、returning：自定义变量，表示目标方法返回值
     *             自定义变量名必须和通知方法的形参名一样。
     *     位置：方法定义上面
     *     特点：1、在目标方法之后执行
     *          2、能够获得目标方法的返回值，可以根据返回值做不同处理功能
     *          3、可以修改返回值
     *     执行顺序：Object res=doOther();
     *              myAfterReturning(res);
     */
    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))",returning = "res")
    public void myAfterReturning(Object res){
        //Object res是目标方法执行之后的返回值
        System.out.println("后置通知，返回值是："+res);
    }
}
