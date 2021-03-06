package com.ws.auth.center.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户类型枚举
 *
 * @author John
 */
@Getter
@AllArgsConstructor
public enum WsUserEnum {

	/**
	 * web
	 */
	WEB("web", 1),

	/**
	 * app
	 */
	APP("app", 2),
	;

	final String name;
	final int category;

}