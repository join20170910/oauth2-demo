package com.ws.auth.center.service;

import com.ws.auth.center.service.impl.PermissionServiceImpl;
import com.ws.auth.common.vo.MenuVo;
import com.ws.auth.common.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author john
 */
@FeignClient(name = "mss-upms",fallback = PermissionServiceImpl.class)
public interface PermissionService {

    @GetMapping("permission/getRolePermission/{roleId}")
    Result<List<MenuVo>> getRolePermission(@PathVariable("roleId") Integer roleId);
}
