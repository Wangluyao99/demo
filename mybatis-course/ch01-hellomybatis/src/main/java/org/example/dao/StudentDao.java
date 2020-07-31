package org.example.dao;

import org.example.Student;

import java.util.List;

/**接口，操作student表*/
public interface StudentDao {

    /**查询student表所有数据*/
    public List<Student> selectStudents();

    /**插入操作：返回值int*/
    public int insertStudent(Student student);

}
