package com.ws.auth.center.granter;

import com.ws.auth.center.enums.WsUserEnum;
import com.ws.auth.center.utils.TokenUtil;
import com.ws.auth.common.cache.CacheNames;
import com.ws.core.tool.api.R;
import com.ws.core.tool.utils.*;
import com.ws.system.user.entity.UserInfo;
import com.ws.system.user.feign.IUserClient;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 验证码TokenGranter
 *
 * @author john
 */
@Component
@AllArgsConstructor
public class CaptchaTokenGranter implements ITokenGranter {

	public static final String GRANT_TYPE = "captcha";

	private IUserClient userClient;
	private RedisUtil redisUtil;

	@Override
	public UserInfo grant(TokenParameter tokenParameter) {
		HttpServletRequest request = WebUtil.getRequest();

		String key = request.getHeader(TokenUtil.CAPTCHA_HEADER_KEY);
		String code = request.getHeader(TokenUtil.CAPTCHA_HEADER_CODE);
		// 获取验证码
		String redisCode = String.valueOf(redisUtil.get(CacheNames.CAPTCHA_KEY + key));
		// 判断验证码
		if (code == null || !StringUtil.equalsIgnoreCase(redisCode, code)) {
			throw new ServiceException(TokenUtil.CAPTCHA_NOT_CORRECT);
		}

		String tenantId = tokenParameter.getArgs().getStr("tenantId");
		String account = tokenParameter.getArgs().getStr("account");
		String password = tokenParameter.getArgs().getStr("password");
		UserInfo userInfo = null;
		if (Func.isNoneBlank(account, password)) {
			// 获取用户类型
			String userType = tokenParameter.getArgs().getStr("userType");
			R<UserInfo> result;
			// 根据不同用户类型调用对应的接口返回数据，用户可自行拓展
			if (userType.equals(WsUserEnum.WEB.getName())) {
				result = userClient.userInfo(tenantId, account, DigestUtil.encrypt(password));
			} else if (userType.equals(WsUserEnum.APP.getName())) {
				result = userClient.userInfo(tenantId, account, DigestUtil.encrypt(password));
			} else {
				result = userClient.userInfo(tenantId, account, DigestUtil.encrypt(password));
			}
			userInfo = result.isSuccess() ? result.getData() : null;
		}
		return userInfo;
	}

}
