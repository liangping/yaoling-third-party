package io.yaoling.starter.weixin.mp.pay.output;

import io.yaoling.third.pay.PayNotification;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PayNotify extends XmlOutput implements PayNotification {
	/**
	 * 用于通知记录保存下来。
	 */
	@XmlTransient
	private String id;
	@XmlTransient
	private Date noticeTime;
	/**
	 * 微信分配的公众账号ID（企业号corpid即为此appId）
	 */
	private String appid;
	/**
	 * 微信支付分配的商户号
	 */
	private String mch_id;
	/**
	 * 随机字符串，不长于32位
	 */
	private String nonce_str;
	/**
	 * 签名，
	 */
	private String sign;
	/**
	 * 微信支付分配的终端设备号
	 */
	private String device_info;
	/**
	 * SUCCESS/FAIL
	 */
	private String result_code;
	/**
	 * 错误返回的信息描述
	 */
	private String err_code;
	/**
	 * 错误返回的信息描述
	 */
	private String err_code_des;
	/**
	 * 用户在商户appid下的唯一标识
	 */
	private String openid;
	/**
	 * 用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
	 */
	private String is_subscribe;
	/**
	 * JSAPI、NATIVE、APP
	 */
	private String trade_type;
	/**
	 * 银行类型，采用字符串类型的银行标识，银行类型见银行列表
	 */
	private String bank_type;
	/**
	 * 订单总金额，单位为分
	 */
	private int total_fee;
	/**
	 * 货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY，
	 */
	private String fee_type;
	/**
	 * 现金支付金额订单现金支付金额
	 */
	private int cash_fee;
	/**
	 * 货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY，
	 */
	private String cash_fee_type;
	/**
	 * 代金券或立减优惠金额<=订单总金额，订单总金额-代金券或立减优惠金额=现金支付金额，
	 */
	private Integer coupon_fee;
	/**
	 * 代金券或立减优惠使用数量
	 */
	private Integer coupon_count;
	/**
	 * 代金券或立减优惠ID,$n为下标，从0开始编号
	 */
	private String coupon_id_0;
	/**
	 * 单个代金券或立减优惠支付金额,$n为下标，从0开始编号
	 */
	private Integer coupon_fee_0;
	/**
	 * 微信支付订单号
	 */
	private String transaction_id;
	/**
	 * 商户系统的订单号，与请求一致。
	 */
	private String out_trade_no;
	/**
	 * 商家数据包，原样返回
	 */
	private String attach;
	/**
	 * 支付完成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。
	 */
	private String time_end;
	
	private String sub_mch_id;
	
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
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
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
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getIs_subscribe() {
		return is_subscribe;
	}
	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getBank_type() {
		return bank_type;
	}
	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}
	public int getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public int getCash_fee() {
		return cash_fee;
	}
	public void setCash_fee(int cash_fee) {
		this.cash_fee = cash_fee;
	}
	public String getCash_fee_type() {
		return cash_fee_type;
	}
	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}
	public int getCoupon_fee() {
		return coupon_fee;
	}
	public int getCoupon_count() {
		return coupon_count;
	}
	public String getCoupon_id_0() {
		return coupon_id_0;
	}
	public void setCoupon_id_0(String coupon_id_0) {
		this.coupon_id_0 = coupon_id_0;
	}
	public int getCoupon_fee_0() {
		return coupon_fee_0;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getTime_end() {
		return time_end;
	}
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PayNotify [id=");
		builder.append(id);
		builder.append(", appid=");
		builder.append(appid);
		builder.append(", mch_id=");
		builder.append(mch_id);
		builder.append(", nonce_str=");
		builder.append(nonce_str);
		builder.append(", sign=");
		builder.append(sign);
		builder.append(", device_info=");
		builder.append(device_info);
		builder.append(", result_code=");
		builder.append(result_code);
		builder.append(", err_code=");
		builder.append(err_code);
		builder.append(", err_code_des=");
		builder.append(err_code_des);
		builder.append(", openid=");
		builder.append(openid);
		builder.append(", is_subscribe=");
		builder.append(is_subscribe);
		builder.append(", trade_type=");
		builder.append(trade_type);
		builder.append(", bank_type=");
		builder.append(bank_type);
		builder.append(", total_fee=");
		builder.append(total_fee);
		builder.append(", fee_type=");
		builder.append(fee_type);
		builder.append(", cash_fee=");
		builder.append(cash_fee);
		builder.append(", cash_fee_type=");
		builder.append(cash_fee_type);
		builder.append(", coupon_fee=");
		builder.append(coupon_fee);
		builder.append(", coupon_count=");
		builder.append(coupon_count);
		builder.append(", coupon_id_0=");
		builder.append(coupon_id_0);
		builder.append(", coupon_fee_0=");
		builder.append(coupon_fee_0);
		builder.append(", transaction_id=");
		builder.append(transaction_id);
		builder.append(", out_trade_no=");
		builder.append(out_trade_no);
		builder.append(", attach=");
		builder.append(attach);
		builder.append(", time_end=");
		builder.append(time_end);
		builder.append(", return_code=");
		builder.append(getReturn_code());
		builder.append(", return_msg=");
		builder.append(getReturn_msg());
		builder.append("]");
		return builder.toString();
	}
	/**
	 * @return the sub_mch_id
	 */
	public String getSub_mch_id() {
		return sub_mch_id;
	}
	/**
	 * @param sub_mch_id the sub_mch_id to set
	 */
	public void setSub_mch_id(String sub_mch_id) {
		this.sub_mch_id = sub_mch_id;
	}
	/**
	 * @return the noticeTime
	 */
	public Date getNoticeTime() {
		return noticeTime;
	}
	/**
	 * @param noticeTime the noticeTime to set
	 */
	public void setNoticeTime(Date noticeTime) {
		this.noticeTime = noticeTime;
	}
	/**
	 * @param coupon_fee the coupon_fee to set
	 */
	public void setCoupon_fee(Integer coupon_fee) {
		this.coupon_fee = coupon_fee;
	}
	/**
	 * @param coupon_count the coupon_count to set
	 */
	public void setCoupon_count(Integer coupon_count) {
		this.coupon_count = coupon_count;
	}
	/**
	 * @param coupon_fee_0 the coupon_fee_0 to set
	 */
	public void setCoupon_fee_0(Integer coupon_fee_0) {
		this.coupon_fee_0 = coupon_fee_0;
	}
}
