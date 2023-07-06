package com.example.mail.service.user.impl;

import com.example.mail.dao.user.UserRegisterAndCancel;
import com.example.mail.entity.User;
import com.example.mail.service.user.UserRegisterAndCancelService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
@Service
public class UserRegisterAndCancelServiceImpl implements UserRegisterAndCancelService {
    @Resource
    private UserRegisterAndCancel userRegisterAndCancel;
    @Override
    public void registerUser(User user) {
        userRegisterAndCancel.registerUser(user);
    }

    @Override
    public User login(String username, String password) {
        return userRegisterAndCancel.login(username,password);
    }

    /**
     * 用户删除
     *
     * @param username
     * @return
     */
    @Override
    public boolean cancel(String username) {
        return userRegisterAndCancel.cancel(username);
    }


}
