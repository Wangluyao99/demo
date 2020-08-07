package org.example.da01;

import org.springframework.stereotype.Component;

/**
 * Component:创建对象的，等同 于<bean>的功能
   属性:value就是对象的名称,也就是bean的id值，
     value的值是唯一的,创建的对象在整个spring容器中就一个.
   位置:在类的上面
   @component(value = "myStudent") 等同于
      <bean id= "myStudent" class="org.example.ba01.Student" />

   spring中和Component功能一致 ，创建对象的注解还有:
   1. @Repository (用在持久层类的上面) : 放在dao的实现类上面，
                表示创建dao对象, dao对象是能访问数据库的。
   2. @Service(用在业务层类的上面) :放在service的实现类上面，
                创建service对象, service对象是做业务处理,可以有事务等功能的。
   3. @Controller(用在控制器的上面) :放在控制器(处理器)类的上面，创建控制器对象的，
                控制器对象,能够接受用户提交的参数,显示请求的处理结果。
    以上三个注解的使用语法和Component一样的。都能创建对象 ,但是这三个注解还有额外的功能。
    @Repository @service ，@Controller 是给项目的对象分层的。

 */

/**@Component(value = "myStudent")
    @Component("myStudent") 常用的*/
@Component/**不指定对象名称，由spring提供默认名称：类名首字母小写*/
public class Student {
    private String name;
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
