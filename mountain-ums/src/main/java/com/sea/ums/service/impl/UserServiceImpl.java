package com.sea.ums.service.impl;

import com.sea.ums.dao.UserDao;
import com.sea.ums.domain.User;
import com.sea.ums.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User queryUserById(String id) {
        return userDao.findById(id).get();
    }

    @Override
    public User queryUserByMobile(String mobile) {
        return userDao.findByMobile(mobile);
    }
}
