package io.yaoling.starter.weixin.component.output.elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
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
 * @author think
 *
 */
@JsonIgnoreProperties
public class AuthorizationInfo {
	private String appid;
	private String authorizer_appid;  
	private String authorizer_access_token; //": "QXjUqNqfYVH0yBE1iI_7vuN_9gQbpjfK7hYwJ3P7xOa88a89-Aga5x1NMYJyB8G2yKt1KCl0nPC3W9GJzw0Zzq_dBxc8pxIGUNi_bFes0qM", 
	private int expires_in; //": 7200, 
	private String authorizer_refresh_token; //": "dTo-YCXPL4llX-u1W1pPpnp8Hgm4wpJtlR6iV0doKdY", 
	private List<FunctionInfo> func_info = new ArrayList<FunctionInfo>();
	
	public String getAuthorizer_appid() {
		return authorizer_appid;
	}
	public void setAuthorizer_appid(String authorizer_appid) {
		this.authorizer_appid = authorizer_appid;
	}
	public String getAuthorizer_access_token() {
		return authorizer_access_token;
	}
	public void setAuthorizer_access_token(String authorizer_access_token) {
		this.authorizer_access_token = authorizer_access_token;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	public String getAuthorizer_refresh_token() {
		return authorizer_refresh_token;
	}
	public void setAuthorizer_refresh_token(String authorizer_refresh_token) {
		this.authorizer_refresh_token = authorizer_refresh_token;
	}
	public List<FunctionInfo> getFunc_info() {
		return func_info;
	}
	public void setFunc_info(List<FunctionInfo> func_info) {
		this.func_info = func_info;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
}
