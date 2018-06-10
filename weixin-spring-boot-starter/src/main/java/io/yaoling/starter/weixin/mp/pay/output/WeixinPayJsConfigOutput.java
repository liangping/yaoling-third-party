package io.yaoling.starter.weixin.mp.pay.output;

import io.yaoling.starter.weixin.mp.output.JsonOutput;

/**
 * 注意：由于Weixin使用的JAVA 的保留字package,输出字使用packageText代替，发起参数的时候记得修改过来。
 * @author liangping
 *
 */
public class WeixinPayJsConfigOutput extends JsonOutput {
	private String appId ; 
	private String timeStamp; 
	private String nonceStr;
	private String packageText; 
	private String signType = "MD5";
	private String paySign;
	private String text;
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getPackageText() {
		return packageText;
	}
	public void setPackageText(String packageText) {
		this.packageText = packageText;
	}
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	public String getPaySign() {
		return paySign;
	}
	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WeixinPayJsConfigOutput [appId=");
		builder.append(appId);
		builder.append(", timeStamp=");
		builder.append(timeStamp);
		builder.append(", nonceStr=");
		builder.append(nonceStr);
		builder.append(", packageText=");
		builder.append(packageText);
		builder.append(", signType=");
		builder.append(signType);
		builder.append(", paySign=");
		builder.append(paySign);
		builder.append("]");
		return builder.toString();
	}

}
