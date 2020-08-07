package org.example.service;

import org.example.domain.Student;

import java.util.List;

public interface StudentService {
    /**定义对数据操作的方法*/
    int addStudent(Student student);
    List<Student> queryStudent();
}
