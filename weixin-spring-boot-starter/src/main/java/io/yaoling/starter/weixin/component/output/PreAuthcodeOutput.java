package io.yaoling.starter.weixin.component.output;

import io.yaoling.starter.weixin.mp.output.JsonOutput;

public class PreAuthcodeOutput extends JsonOutput {
	private String pre_auth_code;

	public String getPre_auth_code() {
		return pre_auth_code;
	}

	public void setPre_auth_code(String pre_auth_code) {
		this.pre_auth_code = pre_auth_code;
	}
}
