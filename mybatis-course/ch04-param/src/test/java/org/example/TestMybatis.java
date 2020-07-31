package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MybatisUtils;
import org.example.vo.QueryParam;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
    @Test
    public void testSelectStudentById(){
        /**
         * 使用mybatis动态代理的机制，使用SqlSession.getMapper(dao接口)
         * getMapper能够获取dao接口对应的实现类对象。
         */
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student= dao.selectStudentById(1002);
        System.out.println(student);
    }
    @Test
    public void testSelectMultiObject(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        QueryParam queryParam=new QueryParam();
        queryParam.setParamName("张三");
        queryParam.getParamAge(20);
        List<Student> students=dao.selectMultiObject(queryParam);
        for (Student stu:students){
            System.out.println(stu);
        }
    }
    @Test
    public void testSelectMultiStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
        student.setName("张三");
        student.setAge(28);
        List<Student> students = dao.selectMultiStudent(student);
        for (Student stu : students) {
            System.out.println(stu);
        }
    }
}
