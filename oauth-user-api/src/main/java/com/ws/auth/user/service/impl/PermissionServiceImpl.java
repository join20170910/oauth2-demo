package com.ws.auth.user.service.impl;

import com.ws.auth.user.entity.SysMenu;
import com.ws.auth.user.mapper.SysMenuMapper;
import com.ws.auth.user.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private SysMenuMapper menuMapper;
    @Override
    public List<SysMenu> getPermissionsByRoleId(Integer roleId) {
        return menuMapper.getPermissionsByRoleId(roleId);
    }
}
