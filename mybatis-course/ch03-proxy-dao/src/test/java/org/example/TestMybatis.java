package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MybatisUtils;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
    @Test
    public void testSelectStudent(){
        /**
         * 使用mybatis动态代理的机制，使用SqlSession.getMapper(dao接口)
         * getMapper能够获取dao接口对应的实现类对象。
         */
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        /**调用dao的方法，执行数据库操作*/
        List<Student> students=dao.selectStudents();
        for (Student stu:students){
            System.out.println("学生"+stu);
        }
    }
    @Test
    public void testInsertStudent(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
        student.setId(1004);
        student.setName("盾山");
        student.setEmail("dunshan@qq.com");
        int nums=dao.insertStudent(student);
        sqlSession.commit();
        System.out.println(nums);
    }
}
