package com.ws.auth.center.service.impl;

import com.ws.auth.center.service.PermissionService;
import com.ws.auth.common.vo.MenuVo;
import com.ws.auth.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author john
 */
@Slf4j
@Service
public class PermissionServiceImpl implements PermissionService {
    @Override
    public Result<List<MenuVo>> getRolePermission(Integer roleId) {
        log.info("调用{}失败","getRolePermission");
        return Result.failure(100,"调用getRolePermission失败");
    }
}
