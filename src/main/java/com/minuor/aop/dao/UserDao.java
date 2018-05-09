package com.minuor.aop.dao;

import com.minuor.aop.model.UserModel;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: minuor
 * @Date: 2018/4/26
 * @Desc:
 */
public interface UserDao {
    int insert(@Param("model") UserModel model);
}
