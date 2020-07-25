package com.ws.auth.center.service;

import com.ws.auth.center.service.impl.UserServiceImpl;
import com.ws.auth.common.vo.Result;
import com.ws.auth.common.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author john
 */
@FeignClient(name = "mss-upms", fallback = UserServiceImpl.class)
public interface UserService {

    /**
     * @Author apple
     * @Description //TODO 根据用户名查询用户信息
     * @Date 22:35 2020/7/25
     * @Param [username]
     * @return com.ws.auth.common.vo.Result<com.ws.auth.common.vo.UserVo>
     **/
    @GetMapping("user/findByUsername/{username}")
    Result<UserVo> findByUsername(@PathVariable("username") String username);
}
