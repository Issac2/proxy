package com.minuor.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: minuor
 * @Date: 2018/4/25
 * @Desc:
 */
public class TransformersDynamicProxy implements InvocationHandler {

    private Object proxyObject;

    public TransformersDynamicProxy(Object proxyObject){
        this.proxyObject = proxyObject;
    }

    /**
     * 获取代理对象
     */
    public Object newProxyInstance() {
        return Proxy.newProxyInstance(proxyObject.getClass().getClassLoader(),
                proxyObject.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---->dynamic invoke before");
        method.invoke(proxyObject, args);
        System.out.println("---->dynamic invoke after");
        return null;
    }
}
