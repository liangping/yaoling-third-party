package io.yaoling.starter.weixin.component.output;

import io.yaoling.starter.weixin.mp.output.JsonOutput;

public class ComponentTokenOutput extends JsonOutput {
	private String component_access_token;

	public String getComponent_access_token() {
		return component_access_token;
	}

	public void setComponent_access_token(String component_access_token) {
		this.component_access_token = component_access_token;
	}
}
