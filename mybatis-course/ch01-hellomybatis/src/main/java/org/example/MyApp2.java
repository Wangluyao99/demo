package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.utils.MybatisUtils;

import java.io.IOException;
import java.util.List;

public class MyApp2 {
    public static void main(String[] args) throws IOException {
        //通过工具类获取SqlSession。将1-4步骤封装。
        //5、从SqlSessionFactory中获取SqlSession对象（重要）。SqlSessionFactory是个接口
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //6、指定执行的sql语句标识。sql映射文件中namespace+"."+标签的id值。（重要）
        String sqlId = "org.example.dao.StudentDao"+"."+"selectStudents";
        //7、通过sqlId找到语句，执行sql语句。
        List<Student> studentList= sqlSession.selectList(sqlId);
        //8、输出结果
        for (Student stu:studentList){System.out.println(stu);}
        //9、关闭SqlSession对象
        sqlSession.close();
    }
}
