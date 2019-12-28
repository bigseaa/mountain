package com.sea.ums.service;

import com.sea.ums.domain.User;

public interface UserService {
    User queryUserById(String id);

    /**
     * 根据mobile查询用户
     */
    User queryUserByMobile(String mobile);
}
