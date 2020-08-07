package org.example;

import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class myTest01 {

    @Test
    public void test01(){
       String config = "applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        String names[]= ac.getBeanDefinitionNames();
        for(String name:names){
            System.out.println("容器中对象名称+"+ name);
        }
        /**容器中对象名称+myDataSource
           容器中对象名称+SqlSessionFactory*/
    }

    @Test
    public void testDaoInsert(){
        String config = "applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        //获取spring容器中的dao对象
        StudentDao dao= (StudentDao) ac.getBean("studentDao");
        Student student=new Student();
        student.setId(1010);
        student.setName("获得");
        student.setEmail("huode@qq.com");
        student.setAge(20);
        int nums=dao.insertStudents(student);
        System.out.println(nums);
    }

    @Test
    public void testServiceInsert(){
        String config = "applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        //获取spring容器中的对象
        StudentService service= (StudentService) ac.getBean("studentService");
        Student student=new Student();
        student.setId(1011);
        student.setName("嗨嗨");
        student.setEmail("huode@qq.com");
        student.setAge(20);
        int nums=service.addStudent(student);
        /**spring mybatis 整合之后事务自动提交*/
        System.out.println(nums);

    }

    @Test
    public void testServiceSelect(){
        String config = "applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        //获取spring容器中的对象
        StudentService service= (StudentService) ac.getBean("studentService");

        List<Student> students=service.queryStudent();
        for (Student stu:students){
            System.out.println(stu);
        }
    }
}
