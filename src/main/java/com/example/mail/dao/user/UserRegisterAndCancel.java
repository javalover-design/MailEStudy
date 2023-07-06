package com.example.mail.dao.user;


import com.example.mail.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Mapper
@Repository
public interface UserRegisterAndCancel {

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
