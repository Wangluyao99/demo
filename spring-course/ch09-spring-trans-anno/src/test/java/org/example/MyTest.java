package org.example;

import org.example.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

public class MyTest {
    @Test
    public void test(){
        String config="applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //容器中获取service
       BuyGoodsService service= (BuyGoodsService) ac.getBean("buyService");
       //调用方法
        service.buy(1001,10);
    }
}
