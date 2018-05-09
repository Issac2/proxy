package com.minuor;

import com.minuor.aop.AsyncAopService;
import com.minuor.aop.TransactionalAopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: minuor
 * @Date: 2018/4/26
 * @Desc:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MinuorAnnotationService {

    @Autowired
    private TransactionalAopService transactionalAopService;
    @Autowired
    private AsyncAopService asyncAopService;

    @Test
    public void transactionalTest() {
        System.out.println("=======transactional test start=======");
        transactionalAopService.addOrder();
        System.out.println("=======transactional test end=======");
    }

    @Test
    public void AsyncTest() throws InterruptedException {
        System.out.println("=======async test start=======");
        asyncAopService.addOrder();
        System.out.println("=======async test end=======");
        /**
         * 在这里让线程睡5秒的原因是为了能够看到异步执行的结果日志
         * 小知识点：在Junit测试中，如果主线程执行结束，整个测试过程也结束了，存在的异步逻辑如果没有执行完就不会执行啦!
         * 测试方式：把这行代码去掉，执行测试，t_order_info表中会插入数据，但是t_msg_info表中无数据插入。
         */
        Thread.sleep(5000);
    }
}
