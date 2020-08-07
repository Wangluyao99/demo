package org.example.ba03;

import org.example.ba03.SomeService;

//目标类
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        //对doSome方法增加功能，执行之前打印时间
        System.out.println("目标方法doSome");
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("目标方法doOther");
        return "ABCD";
    }

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println("业务方法doFirst");
        return "doFirst";
    }
}
