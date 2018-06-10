package io.yaoling.starter.weixin.component.output.elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 公众号授权给开发者的权限集列表（请注意，当出现用户已经将消息与菜单权限集授权给了某个第三方，再授权给另一个第三方时，由于该权限集是互斥的，后一个第三方的授权将去除此权限集，开发者可以在返回的func_info信息中验证这一点，避免信息遗漏），1到13分别代表：
 * 
 * 消息与菜单权限集
 * 用户管理权限集
 * 帐号管理权限集
 * 网页授权权限集
 * 微信小店权限集
 * 多客服权限集
 * 业务通知权限集
 * 微信卡券权限集
 * 微信扫一扫权限集
 * 微信连WIFI权限集
 * 素材管理权限集
 * 摇一摇周边权限集
 * 微信门店权限集
 * 
 * 请注意：
 * 1）该字段的返回不会考虑公众号是否具备该权限集的权限（因为可能部分具备），请根据公众号的帐号类型和认证情况，来判断公众号的接口权限。
 * 
 * @author liangping
 *
 */
@JsonIgnoreProperties
public class FunctionInfo {
	private FunctionCategory funcscope_category;

	public FunctionCategory getFuncscope_category() {
		return funcscope_category;
	}

	public void setFuncscope_category(FunctionCategory funcscope_category) {
		this.funcscope_category = funcscope_category;
	}
}
