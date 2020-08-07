package org.example.da02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myStudent")
public class Student {

    /**@value:简单类型的属性赋值
        属性: value是string类型的 ,表示简单类型的属性值
        位置: 1. 在属性定义的上面，无需set方法,推荐使用。
             2.在set方法的上面
     */

    /**可以将value省略：@Value("张三")*/
    @Value(value = "张三")
    private String name;
    @Value(value = "28")
    private Integer age;

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
                '}';
    }
}
