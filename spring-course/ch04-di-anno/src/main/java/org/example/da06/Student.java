package org.example.da06;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myStudent")
public class Student {
    /**
     * @Value("${}}")用法：
     * 创建test.properties文件；
     * 在主配置文件applicationContext.xml中加载属性配置文件
     *      <context:property-placeholder location="classpath:test.properties"/>
     * 在Student类中使用 @Value("${myname}")；@Value("${myage}")
     */

    @Value("${myname}")
    private String name;
    @Value("${myage}")
    private Integer age;

    public void setName(String name) {
        this.name = name;
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
