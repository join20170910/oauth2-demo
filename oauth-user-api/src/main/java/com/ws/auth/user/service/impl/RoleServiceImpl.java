package com.ws.auth.user.service.impl;

import com.ws.auth.user.entity.SysRole;
import com.ws.auth.user.mapper.SysRoleMapper;
import com.ws.auth.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public List<SysRole> getRoleByUserId(Integer userId) {
        return roleMapper.getRoleByUserId(userId);
    }
}
