package com.ws.auth.center.service.impl;

import com.ws.auth.center.service.RoleService;
import com.ws.auth.common.vo.Result;
import com.ws.auth.common.vo.RoleVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author john
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
    @Override
    public Result<List<RoleVo>> getRoleByUserId(Integer userId) {
        log.info("调用{}失败","getRoleByUserId");
        return Result.failure(100,"调用getRoleByUserId失败");
    }
}
