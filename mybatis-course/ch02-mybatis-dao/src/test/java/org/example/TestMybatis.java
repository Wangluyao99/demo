package org.example;

import org.example.dao.StudentDao;
import org.example.dao.impl.StudentDaoImpl;
import org.example.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
    @Test
    public void testSelectStudent(){
        StudentDao dao =new StudentDaoImpl();
        List<Student> studentList=dao.selectStudents();
        for (Student stu:studentList){
            System.out.println(stu);
        }
    }
}
