package com.minuor.aop.impl;

import com.minuor.aop.TransactionalAopService;
import com.minuor.aop.dao.OrderDao;
import com.minuor.aop.dao.UserDao;
import com.minuor.aop.exception.OrderException;
import com.minuor.aop.exception.OtherException;
import com.minuor.aop.exception.UserException;
import com.minuor.aop.model.OrderModel;
import com.minuor.aop.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: minuor
 * @Date: 2018/4/26
 * @Desc:
 */
@Service
public class TransactionalAopServiceImpl implements TransactionalAopService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;

    @Transactional(rollbackFor = OrderException.class, noRollbackFor = RuntimeException.class)
    public void addOrder() {
        orderDao.insert(OrderModel.builder()
                .userId("YK_002") //游客编号
                .phone("13522203330")
                .orderId("ORDER_2018042602")
                .amount(10000L)
                .build());
        //默开用户
        System.out.println("--->" + this.getClass());
        addUser("13522203330");
    }

    @Transactional(rollbackFor = UserException.class, noRollbackFor = RuntimeException.class)
    public void addUser(String phone) {
        userDao.insert(UserModel.builder().userName("zhangsan").userPhone(phone).build());
        throw new OrderException("111");
    }
}
