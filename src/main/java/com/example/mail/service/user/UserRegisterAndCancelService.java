package com.example.mail.service.user;

import com.example.mail.entity.User;

public interface UserRegisterAndCancelService {

    /**表示注册用户*/
    void registerUser(User user);

    /**
     *表示用户登陆验证
     */
    User login(String username,String password);

    /**
     * 用户删除
     * @param username
     * @return
     */
    boolean cancel(String username);
}
