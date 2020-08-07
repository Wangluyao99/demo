package org.example;

import org.example.da01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {
    @Test
    public void test01(){
        String config="applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        /**Student student= (Student) ac.getBean("myStudent");第1,2注解使用*/
        Student student= (Student) ac.getBean("student");/**第三注解使用*/
        System.out.println(student);
    }
}
