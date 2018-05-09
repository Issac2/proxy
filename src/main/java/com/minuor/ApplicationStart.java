package com.minuor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Author: minuor
 * @Date: 2018/4/26
 * @Desc:
 */
@SpringBootApplication
@MapperScan("com.minuor.aop.dao")
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableAsync //开启异步功能
public class ApplicationStart {

    public static void main(String[] args){
        SpringApplication.run(ApplicationStart.class,args);
    }
}
