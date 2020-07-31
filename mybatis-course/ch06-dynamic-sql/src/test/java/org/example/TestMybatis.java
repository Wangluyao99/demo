package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MybatisUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMybatis {
    @Test
    public void testSelectStudentIf(){
        /**
         * 使用mybatis动态代理的机制，使用SqlSession.getMapper(dao接口)
         * getMapper能够获取dao接口对应的实现类对象。
         */
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
        student.setName("李四");
        student.setAge(18);
        List<Student> students=dao.selectStudentIf(student);
        for (Student stu:students){
            System.out.println(stu);
        }
    }
    @Test
    public void testSelectStudentWhere(){
        /**
         * 使用mybatis动态代理的机制，使用SqlSession.getMapper(dao接口)
         * getMapper能够获取dao接口对应的实现类对象。
         */
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
        //student.setName("李四");
        student.setAge(18);
        List<Student> students=dao.selectStudentWhere(student);
        for (Student stu:students){
            System.out.println(stu);
        }
    }

    @Test
    public void testForeach(){
        List<Integer> list=new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        String sql="select * from student where id in";
        StringBuilder builder=new StringBuilder("");
        int init=0;
        int len=list.size();
        builder.append("(");
        for (Integer i:list){
            builder.append(i).append(",");
        }
        builder.deleteCharAt(builder.length()-1);/**删除最后一个逗号，*/
        builder.append(")");
        sql=sql+builder.toString();
        System.out.println(sql);
    }
    @Test
    public void testSelectForeach(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Integer> list=new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> students=dao.selectForeachOne(list);
        for (Student stu:students){
            System.out.println(stu);
        }
    }

    @Test
    public void testSelectForTwo(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> stuList=new ArrayList<>();
        Student s1=new Student();
        s1.setId(1002);
        stuList.add(s1);

        s1=new Student();
        s1.setId(1003);
        stuList.add(s1);

        List<Student> students=dao.selectForeachTwo(stuList);
        for (Student stu:students){
            System.out.println(stu);
        }
    }
}
