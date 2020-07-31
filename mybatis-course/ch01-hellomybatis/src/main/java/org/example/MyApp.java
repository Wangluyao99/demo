package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp {
    public static void main(String[] args) throws IOException {
        //访问mybatis读取student数据
        //1、定义主配置文件名称
        String config="mybatis.xml";
        //2、读取主配置文件 Resources负责读取主配置文件
        InputStream in=Resources.getResourceAsStream(config);
        //3、创建SqLSessionFactoryBuilder对象，通过build方法获取SqlSessionFactory对象。
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4、创建SqLSessionFactory对象,重量级对象，只需一个。
        SqlSessionFactory factory = builder.build(in);
        //5、从SqlSessionFactory中获取SqlSession对象（重要）。SqlSessionFactory是个接口，
        SqlSession sqlSession =factory.openSession();
        //6、指定执行的sql语句标识。sql映射文件中namespace+"."+标签的id值。（重要）
        String sqlId = "org.example.dao.StudentDao"+"."+"selectStudents";
        //7、通过sqlId找到语句，执行sql语句。
        List<Student> studentList= sqlSession.selectList(sqlId);
        //8、输出结果
        //studentList.forEach(student -> System.out.println(student));
        for (Student stu:studentList){System.out.println(stu);}
        //9、关闭SqlSession对象
        sqlSession.close();
    }
}
