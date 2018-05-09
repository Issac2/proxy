package com.minuor.aop.impl;

import com.minuor.aop.AsyncAopService;
import com.minuor.aop.dao.MsgDao;
import com.minuor.aop.dao.OrderDao;
import com.minuor.aop.model.MsgModel;
import com.minuor.aop.model.OrderModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: minuor
 * @Date: 2018/4/26
 * @Desc:
 */
@Service
@Slf4j
public class AsyncAopServiceImpl implements AsyncAopService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private MsgDao msgDao;

    /**
     * 添加订单后会给用户异步的推送信息
     */
    @Transactional
    public void addOrder() {
        int result = orderDao.insert(OrderModel.builder()
                .amount(10000L)
                .orderId("ORDER_2018042601")
                .phone("15600001212")
                .userId("U_001")
                .build());
        String currentThreadName = Thread.currentThread().getName();
        AsyncAopService service = (AsyncAopService) AopContext.currentProxy();
        service.sendMsg(result);
        System.out.println("------>代理对象："+service.getClass());
        System.out.println("------>当前对象："+this.getClass());
        System.out.println(currentThreadName + "------>下单结束：mark");
    }

    @Async
    public void sendMsg(int result) {
        try {
            Thread thread = Thread.currentThread();
            thread.sleep(3000);//停留3秒
            String currentThreadName = thread.getName();
            if (result == 1) {
                msgDao.insert(MsgModel.builder().msgContent("下单成功！").receiver("15600001212").build());
                System.out.println(currentThreadName + "------>发送信息成功");
            } else {
                msgDao.insert(MsgModel.builder().msgContent("下单失败！").receiver("15600001212").build());
                System.out.println(currentThreadName + "------>发送信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
