package com.minuor.staticProxy;

/**
 * @Author: minuor
 * @Date: 2018/4/25
 * @Desc:
 */
public class TransformersProxy implements Transformers {

    public Transformers transformers;

    public void init(Object transformers) {
        this.transformers = (Transformers) transformers;
    }

    @Override
    public void trans2man() {
        System.out.println("---->transform to man before");
        transformers.trans2man();
    }

    @Override
    public void trans2car() {
        System.out.println("---->transform to car before");
        transformers.trans2car();
    }
}
