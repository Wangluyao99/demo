package org.example.dao;

import org.example.domain.Student;

import java.util.List;

public interface StudentDao {

    /**动态sql，使用Java对象作为参数*/
   List<Student> selectStudentIf(Student student);

   /**where使用*/
   List<Student> selectStudentWhere(Student student);

   /**foreach用法1*/
   List<Student> selectForeachOne(List<Integer> idlist);

    /**foreach用法2*/
    List<Student> selectForeachTwo(List<Student> studentList);

}
