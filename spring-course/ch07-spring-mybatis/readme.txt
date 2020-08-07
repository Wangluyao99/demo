ch07-spring-mybatis:spring和mybatis的集成

步骤：
1新建maven项目
2加入maven依赖
    1）spring依赖
    2）mybatis依赖
    3）mysql驱动
    4）spring事务的依赖
    5）mybatis和spring集成的依赖：mybatis官方提供，用来在spring项目中创建mybatis的sqlSessionFactory,dao对象。
3创建实体类
4创建dao接口和mapper文件
5创建mybatis主配置文件
6创建Service接口和实体类，属性是dao
7创建spring的配置文件：声明mybatis对象交给spring管理
    1）数据源DataSource
    2）SqlSessionFactory
    3) Dao对象
    4）声明自定义的service
8创建测试类，获取Service对象，通过service调用dao完成数据库访问