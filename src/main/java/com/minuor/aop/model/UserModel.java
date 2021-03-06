package com.minuor.aop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: minuor
 * @Date: 2018/4/26
 * @Desc:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {
    private String userName;
    private String userPhone;
}
