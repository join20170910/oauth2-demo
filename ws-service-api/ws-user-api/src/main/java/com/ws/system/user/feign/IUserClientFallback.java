package com.ws.system.user.feign;

import com.ws.core.tool.api.R;
import com.ws.system.user.entity.UserInfo;
import com.ws.system.user.entity.UserOauth;
import org.springframework.stereotype.Component;

/**
 * Feign失败配置
 *
 * @author john
 */
@Component
public class IUserClientFallback implements IUserClient {

	@Override
	public R<UserInfo> userInfo(Long userId) {
		return R.fail("未获取到账号信息");
	}

	@Override
	public R<UserInfo> userInfo(String tenantId, String account, String password) {
		return R.fail("未获取到账号信息");
	}

	@Override
	public R<UserInfo> userAuthInfo(UserOauth userOauth) {
		return R.fail("未获取到账号信息");
	}
}
