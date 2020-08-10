package com.bj.service.impl;

import com.bj.dao.StudentDao;
import com.bj.domain.Student;
import com.bj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    /**引用类型自动注入*/
    @Resource
    private StudentDao studentDao;
    @Override
    public int addStudent(Student student) {
        int nums=studentDao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> findStudents() {
        return studentDao.selectStudents();
    }
}
