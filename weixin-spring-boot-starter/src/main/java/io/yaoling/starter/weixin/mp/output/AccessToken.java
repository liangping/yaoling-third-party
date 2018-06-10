package io.yaoling.starter.weixin.mp.output;

public class AccessToken {
	
	private int errorCode = 0;
	private String errorMessage;
	private String accessToken;
	private long expired;
	
	public AccessToken() {
		super();
	}
	
	public AccessToken(String accessToken, long expired) {
		super();
		this.accessToken = accessToken;
		this.expired = expired;
	}

	public AccessToken(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public long getExpired() {
		return expired;
	}
	public void setExpired(long expired) {
		this.expired = expired;
	}
	
	

}
