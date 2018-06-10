package io.yaoling.starter.weixin.component.output;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.yaoling.starter.weixin.component.output.elements.AuthorizationInfo;
import io.yaoling.starter.weixin.component.output.elements.AuthorizerInfo;
import io.yaoling.starter.weixin.mp.output.JsonOutput;

/**
 * authorizer_info	授权方昵称
 * head_img	授权方头像
 * service_type_info	授权方公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号
 * verify_type_info	授权方认证类型，-1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，3代表已资质认证通过但还未通过名称认证，4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
 * user_name	授权方公众号的原始ID
 * alias	授权方公众号所设置的微信号，可能为空
 * qrcode_url	二维码图片的URL，开发者最好自行也进行保存
 * authorization_info	授权信息
 * appid	授权方appid
 * func_info	公众号授权给开发者的权限集列表（请注意，当出现用户已经将消息与菜单权限集授权给了某个第三方，再授权给另一个第三方时，由于该权限集是互斥的，后一个第三方的授权将去除此权限集，开发者可以在返回的func_info信息中验证这一点，避免信息遗漏），1到9分别代表：
 * 消息与菜单权限集
 * 用户管理权限集
 * 帐号管理权限集
 * 网页授权权限集
 * 微信小店权限集
 * 多客服权限集
 * 业务通知权限集
 * 微信卡券权限集
 * 微信扫一扫权限集
 * 
 * @author liangping
 *
 */
@JsonIgnoreProperties
public class AuthorizerInfoOutput extends JsonOutput {
	
	private AuthorizationInfo authorization_info;
	private AuthorizerInfo authorizer_info;
	private String qrcode_url;
	
	public AuthorizationInfo getAuthorization_info() {
		return authorization_info;
	}
	public void setAuthorization_info(AuthorizationInfo authorization_info) {
		this.authorization_info = authorization_info;
	}
	public AuthorizerInfo getAuthorizer_info() {
		return authorizer_info;
	}
	public void setAuthorizer_info(AuthorizerInfo authorizer_info) {
		this.authorizer_info = authorizer_info;
	}
	public String getQrcode_url() {
		return qrcode_url;
	}
	public void setQrcode_url(String qrcode_url) {
		this.qrcode_url = qrcode_url;
	}

}
