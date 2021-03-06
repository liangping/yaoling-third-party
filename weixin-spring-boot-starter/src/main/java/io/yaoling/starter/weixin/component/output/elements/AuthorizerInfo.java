package io.yaoling.starter.weixin.component.output.elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * head_img	授权方头像
 * service_type_info	授权方公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号
 * verify_type_info	授权方认证类型，-1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，3代表已资质认证通过但还未通过名称认证，4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
 * user_name	授权方公众号的原始ID
 * alias	授权方公众号所设置的微信号，可能为空
 * 
 * @author liangping
 *
 */
@JsonIgnoreProperties
public class AuthorizerInfo {
	
	private String nick_name ; 
	private String head_img; 
	private TypeInfo service_type_info ; 
	private TypeInfo verify_type_info ;
	private String user_name; 
	private String alias;
	private String qrcode_url;
	private BusinessInfo business_info;
	
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getHead_img() {
		return head_img;
	}
	public void setHead_img(String head_img) {
		this.head_img = head_img;
	}
	public TypeInfo getService_type_info() {
		return service_type_info;
	}
	public void setService_type_info(TypeInfo service_type_info) {
		this.service_type_info = service_type_info;
	}
	public TypeInfo getVerify_type_info() {
		return verify_type_info;
	}
	public void setVerify_type_info(TypeInfo verify_type_info) {
		this.verify_type_info = verify_type_info;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getQrcode_url() {
		return qrcode_url;
	}
	public void setQrcode_url(String qrcode_url) {
		this.qrcode_url = qrcode_url;
	}
	public BusinessInfo getBusiness_info() {
		return business_info;
	}
	public void setBusiness_info(BusinessInfo business_info) {
		this.business_info = business_info;
	}
}
