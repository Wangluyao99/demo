package org.example.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MybatisUtils;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> selectStudents() {
        //获取SqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        String SqlId="org.example.dao.StudentDao.selectStudents";
        //执行sql语句
        List<Student> students= sqlSession.selectList(SqlId);
        sqlSession.close();
        return students;
    }
}


