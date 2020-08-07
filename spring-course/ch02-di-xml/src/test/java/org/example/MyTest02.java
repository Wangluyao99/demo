package org.example;

import org.example.ba02.School;
import org.example.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest02 {
    @Test
    public void test01(){
        String config="ba02/applicationContext.xml";
        ApplicationContext ac =new ClassPathXmlApplicationContext(config);

        //从容器中获取Student对象
        Student myStudent= (Student) ac.getBean("myStudent");
        System.out.println(myStudent);

    }
    @Test
    public void test02(){
        /**以前方法*/
        Student student=new Student();
        student.setName("lisi");
        student.setAge(22);

        School school=new School();
        school.setName("动力节点");
        school.setAddress("北京");
        student.setSchool(school);

        System.out.println("Student"+student);
    }
}
