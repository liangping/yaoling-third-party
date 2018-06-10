package io.yaoling.starter.weixin.component.output;

import io.yaoling.starter.weixin.mp.output.JsonOutput;

public class AuthorizerTokenOutput extends JsonOutput {
	
	private String authorizer_access_token; 
	private String authorizer_refresh_token;
	
	public String getAuthorizer_access_token() {
		return authorizer_access_token;
	}
	public void setAuthorizer_access_token(String authorizer_access_token) {
		this.authorizer_access_token = authorizer_access_token;
	}
	public String getAuthorizer_refresh_token() {
		return authorizer_refresh_token;
	}
	public void setAuthorizer_refresh_token(String authorizer_refresh_token) {
		this.authorizer_refresh_token = authorizer_refresh_token;
	}
}
