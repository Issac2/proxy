package com.minuor.dynamicProxy;

/**
 * @Author: minuor
 * @Date: 2018/4/25
 * @Desc:
 */
public class TransformersDynamicImpl implements TransformersDynamic {
    @Override
    public void trans2man() {
        System.out.println("---->transform to man");
        this.trans2car();
    }

    @Override
    public void trans2car() {
        System.out.println("---->transform to car");
    }
}
