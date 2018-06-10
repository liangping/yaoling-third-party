package io.yaoling.starter.weixin.mp.pay.input;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class CallbackInput {
	/**
	 * 微信分配的公众账号ID
	 */
	public String appid;
	/**
	 * 用户在商户appid下的唯一标识
	 */
	public String openid;
	/**
	 * 微信支付分配的商户号
	 */
	public String mch_id;
	/**
	 * 用户是否关注公众账号，仅在公众账号类型支付有效，取值范围：Y或N;Y-关注;N-未关注
	 */
	public String is_subscribe = "Y";
	/**
	 * 随机字符串，不长于32位。
	 */
	public String nonce_str;
	/**
	 * 商户定义的商品id 或者订单号
	 */
	public String product_id;
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
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getIs_subscribe() {
		return is_subscribe;
	}
	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
}
