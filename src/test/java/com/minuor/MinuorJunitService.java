package com.minuor;

import com.minuor.dynamicProxy.TransformersDynamic;
import com.minuor.dynamicProxy.TransformersDynamicImpl;
import com.minuor.dynamicProxy.TransformersDynamicProxy;
import com.minuor.staticProxy.TransformersImpl;
import com.minuor.staticProxy.TransformersProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: minuor
 * @Date: 2018/4/25
 * @Desc:
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class MinuorJunitService {

    //静态代理方式
    @Test
    public void staticProxyTest() {
        System.out.println("=========static proxy test start=========");
        TransformersProxy proxy = new TransformersProxy();
        proxy.init(new TransformersImpl());
        proxy.trans2man();
        System.out.println("~~~~~~~~~华丽分隔线~~~~~~~~~~");
        proxy.trans2car();
        System.out.println("=========static proxy test end=========");
    }

    //动态代理方式
    @Test
    public void dynamicProxyTest() {
        System.out.println("=========dynamic proxy test start=========");
        TransformersDynamicProxy dynamicProxy = new TransformersDynamicProxy(new TransformersDynamicImpl());
        TransformersDynamic proxy = (TransformersDynamic) dynamicProxy.newProxyInstance();
        System.out.println("----->" + proxy.getClass());
        proxy.trans2man();
        System.out.println("=========dynamic proxy test end=========");
    }
}
