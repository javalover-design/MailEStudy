package com.example.mail.dao.user;

import com.example.mail.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRegisterAndCancelTest {
    @Autowired
    private UserRegisterAndCancel userRegisterAndCancel;
    @Test
    public void register(){
        User user=new User("Mike","123456","17854554","15454@163.com","xie");
        userRegisterAndCancel.registerUser(user);
    }

    @Test
    public void cancel(){
        boolean user1 = userRegisterAndCancel.cancel("user1");
        if (user1){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }
}
