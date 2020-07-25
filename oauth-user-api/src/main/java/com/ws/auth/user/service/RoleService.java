package com.ws.auth.user.service;


import com.ws.auth.user.entity.SysRole;

import java.util.List;

/**
 * @author john
 */
public interface RoleService {

    List<SysRole> getRoleByUserId(Integer userId);
}
