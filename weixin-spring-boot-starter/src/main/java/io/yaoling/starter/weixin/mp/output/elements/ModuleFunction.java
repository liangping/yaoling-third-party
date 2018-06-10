package io.yaoling.starter.weixin.mp.output.elements;

import java.util.UUID;

/**
 * 后台管理功能的定义
 * @author liangping
 *
 */
public class ModuleFunction {
	public ModuleFunction() {
		super();
	}
	public ModuleFunction(String name, String url) {
		super();
		this.key = UUID.randomUUID().toString();
		this.name = name;
		this.url = url;
	}
	private String key;
	private String name;
	private String url;
	private boolean enabled = false;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}
	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
