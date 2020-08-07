ch09-spring-trans-anno:注解方式处理spring事务
    Spring框架中提供事务的解决方案：
    1、注解方式：（中小型项目）
        基于aop的环绕通知
             @Transactional(
                    propagation = Propagation.REQUIRED,
                    isolation = Isolation.DEFAULT,
                    readOnly = false,
                    rollbackFor = {NullPointerException.class,NotEnoughException.class}
             )
    Spring框架中提供事务的解决方案：
        2、aspectj框架
            适合大型项目，有很多类和方法，需要大量配置事务。业务方法和事务配置完全分离。
            实现步骤：都是在xml中实现
                1)加入aspectj依赖
                   <dependency>
                      <groupId>org.springframework</groupId>
                      <artifactId>spring-aspects</artifactId>
                      <version>5.2.7.RELEASE</version>
                   </dependency>
                2)声明事务管理器对象
                   <bean id="TransactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
                        <!--连接的数据库-->
                        <property name="dataSource" ref="myDataSource"/>
                   </bean>
                3)声明方法需要的事务类型（配置方法的属性【隔离级别，传播行为，超时】）

                4)配置aop：指定哪些类要创建代理

spring事务步骤：
1新建maven项目
2加入maven依赖
    1）spring依赖
    2）mybatis依赖
    3）mysql驱动
    4）spring事务的依赖
    5）mybatis和spring集成的依赖：mybatis官方提供，用来在spring项目中创建mybatis的sqlSessionFactory,dao对象。
3创建实体类
    Sale，Goods
4创建dao接口和mapper文件
    SaleDao,GoodsDao
    SaleDao.xml GoodsDao.xml
5创建mybatis主配置文件
6创建Service接口和实体类，属性是saleDao,goodsDao
7创建spring的配置文件：声明mybatis对象交给spring管理
    1）数据源DataSource
    2）SqlSessionFactory
    3) Dao对象
    4）声明自定义的service
8创建测试类，获取Service对象，通过service调用dao完成数据库访问



Spring框架中提供事务的解决方案：
    2、aspectj框架
        适合大型项目，有很多类和方法，需要大量配置事务。业务方法和事务配置完全分离。
        实现步骤：都是在xml中实现
            1)加入aspectj依赖
               <dependency>
                  <groupId>org.springframework</groupId>
                  <artifactId>spring-aspects</artifactId>
                  <version>5.2.7.RELEASE</version>
               </dependency>
            2)声明事务管理器对象
               <bean id="TransactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
                    <!--连接的数据库-->
                    <property name="dataSource" ref="myDataSource"/>
               </bean>
            3)声明方法需要的事务类型（配置方法的属性【隔离级别，传播行为，超时】）

            4)配置aop：指定哪些类要创建代理