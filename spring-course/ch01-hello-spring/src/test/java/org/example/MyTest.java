package org.example;


import org.example.service.SomeService;
import org.example.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.crypto.Data;
import java.util.Date;

public class MyTest {
    @Test
    /**不使用spring，主动创建对象*/
    public void test01(){
        SomeService service=new SomeServiceImpl();
        service.doSome();
    }

    @Test
    /**使用spring*/
    public void test02(){
        //1、指定Spring配置文件的名称
        String config="beans.xml";
        //2、创建表示spring容器的对象，ApplicationContext
        /**
         * ApplicationContext表示spring容器，通过容器获取对象，
         * ClassPathXmlApplicationContext:表示从类路径加载Spring配置文件
         */
        ApplicationContext ac =new ClassPathXmlApplicationContext(config);

        //从容器中获取某个对象，要调用对象的方法
        SomeService service= (SomeService) ac.getBean("someService");/**id值*/

        //使用spring创建好的对象
        service.doSome();
    }

    @Test
    public void test03(){
        String config="beans.xml";
        ApplicationContext AC=new ClassPathXmlApplicationContext(config);
        int nums = AC.getBeanDefinitionCount();//容器中对象数量
        System.out.println(nums);//1

        String names[] =AC.getBeanDefinitionNames();//容器中对象的名字
        for (String name :names){
            System.out.println(name);//SomeService
        }
    }

    //获取一个非自定义类对象
    @Test
    public void test04(){
        String config="beans.xml";
        ApplicationContext AC=new ClassPathXmlApplicationContext(config);
       //使用getBean
        Date my = (Date) AC.getBean("mydate");
        System.out.println(my);
    }

}
