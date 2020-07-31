package org.example.dao;

import org.example.domain.Student;
import org.example.vo.QueryParam;

import java.util.List;

public interface StudentDao {
    public Student selectStudentById(Integer id);

    List<Student> selectMultiObject(QueryParam param);

    List<Student> selectMultiStudent(Student student);

}
