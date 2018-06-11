package io.yaoling.starter.weixin.mp.pay.output;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class UnifiedOrderOutput extends XmlOutput {

	public String appid;
	public String mch_id;
	/**
	 * 调用接口提交的终端设备号，
	 */
	public String device_info;
	public String nonce_str;
	public String sign;
	/**
	 * SUCCESS/FAIL
	 */
	public String result_code;
	/**
	 * 详细参见第6节错误列表
	 */
	public String err_code;
	/**
	 * 错误返回的信息描述
	 */
	public String err_code_des;
	/**
	 * 调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，
	 */
	public String trade_type;
	/**
	 * 微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
	 */
	public String prepay_id;
	/**
	 * trade_type为NATIVE是有返回，可将该参数值生成二维码展示出来进行扫码支付
	 */
	public String code_url;
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
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	public String getTrade_type() {
		return trade_type;
	}
	/**
	 * 调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，
	 * @param trade_type JSAPI，NATIVE，APP
	 */
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getPrepay_id() {
		return prepay_id;
	}
	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}
	public String getCode_url() {
		return code_url;
	}
	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UnifiedOrderOutput [appid=");
		builder.append(appid);
		builder.append(", mch_id=");
		builder.append(mch_id);
		builder.append(", device_info=");
		builder.append(device_info);
		builder.append(", nonce_str=");
		builder.append(nonce_str);
		builder.append(", sign=");
		builder.append(sign);
		builder.append(", result_code=");
		builder.append(result_code);
		builder.append(", err_code=");
		builder.append(err_code);
		builder.append(", err_code_des=");
		builder.append(err_code_des);
		builder.append(", trade_type=");
		builder.append(trade_type);
		builder.append(", prepay_id=");
		builder.append(prepay_id);
		builder.append(", code_url=");
		builder.append(code_url);
		builder.append(", return_code=");
		builder.append(getReturn_code());
		builder.append(", return_msg=");
		builder.append(getReturn_msg());
		builder.append("]");
		return builder.toString();
	}
	
}
