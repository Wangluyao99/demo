ch10-spring-trans-aspectj

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