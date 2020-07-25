package com.ws.auth.center.controller;

import com.ws.auth.center.service.UserService;
import com.ws.auth.common.vo.Result;
import com.ws.auth.common.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Deacription TODO
 * @Author apple
 * @Date 2020/7/25 22:39
 * @Version 1.0
 **/

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("user/findByUsername/{username}")
    public void findByUsername(@PathVariable("username") String username){
        Result<UserVo>  voResult = userService.findByUsername(username);
        System.out.println("test");
    }

}
