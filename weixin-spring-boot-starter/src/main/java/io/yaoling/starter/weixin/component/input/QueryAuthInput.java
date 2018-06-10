package io.yaoling.starter.weixin.component.input;

public class QueryAuthInput {
	private String component_appid; //":"appid_value" ,
	private String authorization_code; //": "auth_code_value"
	
	public String getComponent_appid() {
		return component_appid;
	}
	public void setComponent_appid(String component_appid) {
		this.component_appid = component_appid;
	}
	public String getAuthorization_code() {
		return authorization_code;
	}
	public void setAuthorization_code(String authorization_code) {
		this.authorization_code = authorization_code;
	}
}
