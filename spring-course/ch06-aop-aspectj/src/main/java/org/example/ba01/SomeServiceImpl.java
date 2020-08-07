package org.example.ba01;
//目标类
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name,Integer age) {
        //对doSome方法增加功能，执行之前打印时间
        System.out.println("目标方法doSome");
    }
}
