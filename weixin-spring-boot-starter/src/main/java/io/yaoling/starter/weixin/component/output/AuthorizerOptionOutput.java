package io.yaoling.starter.weixin.component.output;

import io.yaoling.starter.weixin.mp.output.JsonOutput;

/**
 * authorizer_appid	授权公众号appid
 * option_name	选项名称
 * option_value	选项值
 * 
 * @author liangping
 *
 */
public class AuthorizerOptionOutput extends JsonOutput {
	private String authorizer_appid;
	private String option_name;
	private int option_value;
	
	public String getAuthorizer_appid() {
		return authorizer_appid;
	}
	public void setAuthorizer_appid(String authorizer_appid) {
		this.authorizer_appid = authorizer_appid;
	}
	public String getOption_name() {
		return option_name;
	}
	public void setOption_name(String option_name) {
		this.option_name = option_name;
	}
	public int getOption_value() {
		return option_value;
	}
	public void setOption_value(int option_value) {
		this.option_value = option_value;
	}
}
