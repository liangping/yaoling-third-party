package io.yaoling.starter.weixin.component.output;

import io.yaoling.starter.weixin.component.output.elements.AuthorizationInfo;
import io.yaoling.starter.weixin.mp.output.JsonOutput;

/**
 * authorization_info	授权信息
 * authorizer_appid	授权方appid
 * authorizer_access_token	授权方令牌（在授权的公众号具备API权限时，才有此返回值）
 * expires_in	有效期（在授权的公众号具备API权限时，才有此返回值）
 * authorizer_refresh_token	刷新令牌（在授权的公众号具备API权限时，才有此返回值），刷新令牌主要用于公众号第三方平台获取和刷新已授权用户的access_token，只会在授权时刻提供，请妥善保存。 一旦丢失，只能让用户重新授权，才能再次拿到新的刷新令牌
 * func_info	公众号授权给开发者的权限集列表（请注意，当出现用户已经将消息与菜单权限集授权给了某个第三方，再授权给另一个第三方时，由于该权限集是互斥的，后一个第三方的授权将去除此权限集，开发者可以在返回的func_info信息中验证这一点，避免信息遗漏），1到8分别代表：
 * 消息与菜单权限集
 * 用户管理权限集
 * 帐号管理权限集
 * 网页授权权限集
 * 微信小店权限集
 * 多客服权限集
 * 业务通知权限集
 * 微信卡券权限集
 * @author think
 *
 */
public class QueryAuthOutput extends JsonOutput {
	private AuthorizationInfo authorization_info;

	public AuthorizationInfo getAuthorization_info() {
		return authorization_info;
	}

	public void setAuthorization_info(AuthorizationInfo authorization_info) {
		this.authorization_info = authorization_info;
	}

}
