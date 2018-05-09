package com.minuor.aop.dao;

import com.minuor.aop.model.MsgModel;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: minuor
 * @Date: 2018/4/26
 * @Desc:
 */
public interface MsgDao {
    void insert(@Param("model")MsgModel model);
}
