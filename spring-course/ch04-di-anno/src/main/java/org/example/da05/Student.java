package org.example.da05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("myStudent")
public class Student {

    @Value("张三")
    private String name;
    @Value(value = "28")
    private Integer age;

    /**
     * 引用类型
     * @Resource: 来自jdk中的注解, spring框架提供了对这个注解的功能支持,可以使用它给引用类型赋值
     * 使用的也是自动注入原理，支持byName，byType 。 默认是byName，失败的话会使用byType.
     * 位置: 1. 在属性定义的上面，无需set方法,推荐使用。
     *      2.在set方法的上面
     *
     *  只使用ByName:增加一个属性name。@Resource(name="mySchool")
     */

    @Resource
    private School school;
    /**用得少*/
    @Value(value = "张三")
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
                ", school=" + school +
                '}';
    }
}
