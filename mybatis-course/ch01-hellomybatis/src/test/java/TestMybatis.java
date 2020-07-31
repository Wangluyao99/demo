import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.Student;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMybatis {
    //测试方法，测试功能
    @Test
    public void testInsert() throws IOException {
        //访问mybatis读取student数据
        //1、定义主配置文件名称
        String config="mybatis.xml";
        //2、读取主配置文件
        InputStream in= Resources.getResourceAsStream(config);
        //3、创建SqLSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4、创建SqLSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //5、从SqlSessionFactory中获取SqlSession对象（重要）
        /**可以在openSession(true),可以自动提交事务*/
        SqlSession sqlSession =factory.openSession();
        //6、指定执行的sql语句标识。sql映射文件中namespace+"."+标签的id值。（重要）
        String sqlId = "org.example.dao.StudentDao"+"."+"insertStudent";
        //7、通过sqlId找到语句，执行sql语句。
        Student student = new Student();
        student.setId(1003);
        student.setName("张飞");
        student.setEmail("zhangfei@163.com");
        student.setAge(28);
        int nums = sqlSession.insert(sqlId,student);
        //手动提交事务，insert,update,delete语句
        sqlSession.commit();
        //8、输出结果
        System.out.println("执行insert结果："+nums);
        //9、关闭SqlSession对象，保证线程安全
        sqlSession.close();
    }
}
