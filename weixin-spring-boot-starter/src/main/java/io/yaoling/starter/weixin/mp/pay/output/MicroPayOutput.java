package io.yaoling.starter.weixin.mp.pay.output;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信刷卡支付返回参数类（服务商版）
 *
 * Created by liangping on 2016-04-29.
 * <p>
 * 江苏摇铃网络科技有限公司，版权所有。
 * Copyright (C) 2015-2016 All Rights Reserved.
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class MicroPayOutput extends XmlOutput{
    /**
     * 公众账号ID
     */
    private String appid;
    /**
     * 子商户公众账号ID
     * 调用接口提交的子商户公众账号ID
     */
    private String sub_appid;
    /**
     * 商户号
     * 调用接口提交的商户号:1900000109
     */
    private String mch_id;
    /**
     * 子商户号
     * 调用接口提交的子商户号:1900000109
     */
    private String sub_mch_id;
    /**
     * 调用接口提交的终端设备号(不超过32位)，013467007045764
     */
    private String device_info;
    /**
     * 随机字符串
     */
    private String nonce_str;
    /**
     * 签名
     */
    private String sign;
    /**
     * 业务结果：SUCCESS/FAIL
     */
    private String result_code;
    /**
     * 错误代码：详细参见错误列表
     */
    private String err_code;
    /**
     * 错误代码描述
     */
    private String err_code_des;

    /* 以下字段尽在 return_code 和 result_code 都为SUCCESS时存在。*/
    /**
     * 用户标识
     * 用户在商户appid 下的唯一标识
     */
    private String openid;
    /**
     * 是否关注公众账号
     * 用户是否关注公众账号，仅在公众账号类型支付有效，取值范围：Y或N;Y-关注;N-未关注
     */
    private String is_subscribe;
    /**
     * 用户子标识
     * 子商户appid下用户唯一标识，如需返回则请求时需要传sub_appid
     */
    private String sub_openid;
    /**
     * 是否关注子公众账号
     * 用户是否关注子公众账号，仅在公众账号类型支付有效，取值范围：Y或N;Y-关注;N-未关注
     */
    private String sub_is_subscribe;
    /**
     * 交易类型
     * 支付类型为MICROPAY(即扫码支付)
     */
    private String trade_type = "MICROPAY";
    /**
     * 付款银行
     * 银行类型，采用字符串类型的银行标识，值列表详见银行类型
     */
    private String bank_type;
    /**
     * 货币类型
     * 符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String fee_type = "CNY";
    /**
     * 总金额
     * 订单总金额，单位为分，只能为整数，详见支付金额
     */
    private int total_fee;
    /**
     * 现金支付货币类型
     * 符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String cash_fee_type = "CNY";
    /**
     * 现金支付金额
     */
    private int cash_fee;
    /**
     * 代金券或立减优惠金额
     * 代金券或立减优惠金额<=订单总金额，订单总金额-代金券或立减优惠金额=现金支付金额
     */
    private int coupon_fee;
    /**
     * 微信支付订单号
     */
    private String transaction_id;
    /**
     * 商户订单号
     * 商户系统的订单号，与请求一致。
     */
    private String out_trade_no;
    /**
     * 商家数据包
     * 商家数据包，原样返回
     */
    private String attach;
    /**
     * 支付完成时间
     * 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。详见时间规则
     */
    private String time_end;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSub_appid() {
        return sub_appid;
    }

    public void setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
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

    public String getSub_openid() {
        return sub_openid;
    }

    public void setSub_openid(String sub_openid) {
        this.sub_openid = sub_openid;
    }

    public String getSub_is_subscribe() {
        return sub_is_subscribe;
    }

    public void setSub_is_subscribe(String sub_is_subscribe) {
        this.sub_is_subscribe = sub_is_subscribe;
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

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

    public String getCash_fee_type() {
        return cash_fee_type;
    }

    public void setCash_fee_type(String cash_fee_type) {
        this.cash_fee_type = cash_fee_type;
    }

    public int getCash_fee() {
        return cash_fee;
    }

    public void setCash_fee(int cash_fee) {
        this.cash_fee = cash_fee;
    }

    public int getCoupon_fee() {
        return coupon_fee;
    }

    public void setCoupon_fee(int coupon_fee) {
        this.coupon_fee = coupon_fee;
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
}
