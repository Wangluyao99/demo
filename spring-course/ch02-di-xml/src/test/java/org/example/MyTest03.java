package org.example;

import org.example.ba03.School;
import org.example.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest03 {
    @Test
    public void test01(){
        String config="ba03/applicationContext.xml";
        ApplicationContext ac =new ClassPathXmlApplicationContext(config);

        //从容器中获取Student对象
        Student myStudent= (Student) ac.getBean("myStudent");
        System.out.println(myStudent);

    }
}
