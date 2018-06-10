package io.yaoling.starter.weixin.mp.pay.output;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class CallbackOutput extends XmlOutput{
	/**
	 * 微信分配的公众账号ID
	 */
	public String appid;
	/**
	 * 微信支付分配的商户号
	 */
	public String mch_id;
	/**
	 * 微信返回的随机字符串
	 */
	public String nonce_str;
	/**
	 * 调用统一下单接口生成的预支付ID
	 */
	public String prepay_id;
	/**
	 * SUCCESS/FAIL
	 */
	public String result_code;
	/**
	 * 当result_code为FAIL时，商户展示给用户的错误提
	 */
	public String err_code_des;
	/**
	 * 返回数据签名
	 */
	public String sign;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getPrepay_id() {
		return prepay_id;
	}
	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
}
