package org.example.vo;


//保存请求参数值
public class Student {
    /**属性名和请求参数名一致*/
    String name;
    Integer age;

    public Student() {
        System.out.println("student无参数构造");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
