package com.ws.auth.center.service.impl;

import com.ws.auth.center.service.UserService;
import com.ws.auth.common.vo.Result;
import com.ws.auth.common.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author john
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public Result<UserVo> findByUsername(String username) {

        log.info("调用{}失败","findByUsername");
        return Result.failure(100,"调用findByUsername接口失败");
    }
}
