package io.yaoling.starter.weixin.mp.pay.output;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class UnifiedOrderQueryOutput extends XmlOutput {

	public String appid;
	public String mch_id;
	
	/**
	 * 子商户公众账号ID
	 */
	public String sub_appid;
	
	/**
	 * 子商户号
	 */
	public String sub_mch_id;

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
	 * 调用接口提交的终端设备号，
	 */
	public String device_info;
	
	/**
	 * 用户标识
	 */
	public String openid;
	
	
	/**
	 * 是否关注公众账号
	 */
	public String is_subscribe;
	
	/**
	 * 用户子标识
	 */
	public String sub_openid;
	
	/**
	 * 是否关注子公众账号
	 */
	public String sub_is_subscribe;
	
	/**
	 * 调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，
	 */
	public String trade_type;
	
	/**
	 * 交易状态	SUCCESS—支付成功
				REFUND—转入退款
				NOTPAY—未支付
				CLOSED—已关闭
				REVOKED—已撤销（刷卡支付）
				USERPAYING--用户支付中
				PAYERROR--支付失败(其他原因，如银行返回失败)
	 */
	public String trade_state;
	
	/**
	 * 付款银行 	银行类型，采用字符串类型的银行标识
	 */
	public String bank_type;
	
	/**
	 * 订单金额 	订单总金额，单位为分
	 */
	public int total_fee;
	
	/**
	 * 应结订单金额
	 */
	public int settlement_total_fee;
	
	/**
	 * 货币种类
	 */
	public String fee_type;
	
	/**
	 * 现金支付金额 (现金支付金额订单现金支付金额，详见支付金额)
	 */
	public String cash_fee;
	
	public String cash_fee_type;
	
	/**
	 * 代金券金额 (“代金券”金额&lt;=订单金额，订单金额-“代金券”金额=现金支付金额，详见支付金额)
	 */
	public int coupon_fee;
	
	/**
	 * 代金券使用数量
	 */
	public int coupon_count;
	
	/**
	 * 微信支付订单号	
	 */
	public String transaction_id;
	
	/**
	 * 商户订单号(商户系统的订单号，与请求一致。)
	 */
	public String out_trade_no;
	
	/**
	 * 支付完成时间
	 */
	public String time_end;
	
	/**
	 * 交易状态描述
	 */
	public String trade_state_desc;
	
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
	public String getTrade_state() {
		return trade_state;
	}
	public void setTrade_state(String trade_state) {
		this.trade_state = trade_state;
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
	public int getSettlement_total_fee() {
		return settlement_total_fee;
	}
	public void setSettlement_total_fee(int settlement_total_fee) {
		this.settlement_total_fee = settlement_total_fee;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public String getCash_fee() {
		return cash_fee;
	}
	public void setCash_fee(String cash_fee) {
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
	public void setCoupon_fee(int coupon_fee) {
		this.coupon_fee = coupon_fee;
	}
	public int getCoupon_count() {
		return coupon_count;
	}
	public void setCoupon_count(int coupon_count) {
		this.coupon_count = coupon_count;
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
	public String getTime_end() {
		return time_end;
	}
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
	public String getTrade_state_desc() {
		return trade_state_desc;
	}
	public void setTrade_state_desc(String trade_state_desc) {
		this.trade_state_desc = trade_state_desc;
	}
	@Override
	public String toString() {
		return "UnifiedOrderOutput [appid=" + appid + ", mch_id=" + mch_id + ", nonce_str=" + nonce_str + ", sign="
				+ sign + ", result_code=" + result_code + ", err_code=" + err_code + ", err_code_des=" + err_code_des
				+ ", device_info=" + device_info + ", openid=" + openid + ", is_subscribe=" + is_subscribe
				+ ", trade_type=" + trade_type + ", trade_state=" + trade_state + ", bank_type=" + bank_type
				+ ", total_fee=" + total_fee + ", settlement_total_fee=" + settlement_total_fee + ", fee_type="
				+ fee_type + ", cash_fee=" + cash_fee + ", cash_fee_type=" + cash_fee_type + ", coupon_fee="
				+ coupon_fee + ", coupon_count=" + coupon_count + ", transaction_id=" + transaction_id
				+ ", out_trade_no=" + out_trade_no + ", time_end=" + time_end + ", trade_state_desc=" + trade_state_desc
				+ "]";
	}

}
