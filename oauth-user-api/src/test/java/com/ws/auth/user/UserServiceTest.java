package com.ws.auth.user;

import com.ws.auth.user.entity.SysUser;
import com.ws.auth.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName UserServiceTest
 * @Deacription TODO
 * @Author apple
 * @Date 2020/7/25 21:35
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Test
    public void test01(){
        SysUser sysUser = userService.findByUsername("admin");
        System.out.println(sysUser.getPassword());
        System.out.println(new BCryptPasswordEncoder().encode(sysUser.getPassword()));
    }

    @Test
    public void testBCryptPasswordEncoder(){
        System.out.println(new BCryptPasswordEncoder().encode("123456"));

    }
}
