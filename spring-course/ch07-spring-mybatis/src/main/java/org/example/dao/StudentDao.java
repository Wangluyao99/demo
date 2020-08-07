package org.example.dao;

import org.example.domain.Student;

import java.util.List;

public interface StudentDao {
    int insertStudents(Student student);
    List<Student> selectStudents();
}
