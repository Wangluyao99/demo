package com.bjpowernode.util;

import org.omg.Messaging.SyncScopeHelper;

import java.util.Date;

public class ServiceTools {
    public static void doLog(){
        System.out.println("方法执行的时间"+new Date());
    }
    public static void doTrans(){
        System.out.println("方法执行完毕，提交事务");
    }
}
