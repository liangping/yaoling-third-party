package io.yaoling.starter.weixin.mp.pay.input;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信扫码支付的入口参数类（服务商版）
 *
 * Created by liangping on 2016-04-29.
 * <p>
 * 江苏摇铃网络科技有限公司，版权所有。
 * Copyright (C) 2015-2016 All Rights Reserved.
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class MicroPayInput {
    /**
     * 公众账号ID
     */
    private String appid;
    /**
     * 子商户公众账号ID
     */
    private String sub_appid;
    /**
     * 商户号
     * 微信支付分配的商户号
     */
    private String mch_id;
    /**
     * 子商户号
     * 微信支付分配的子商户号，开发者模式下必填
     */
    private String sub_mch_id;
    /**
     * 设备号
     * 终端设备号(商户自定义，如门店编号)
     */
    private String device_info;
    /**
     * 随机字符串
     * 随机字符串，不长于32位。推荐随机数生成算法
     */
    private String nonce_str;
    /**
     * 签名
     * 签名，详见签名生成算法
     */
    private String sign;
    /**
     * 商品描述
     * 商品或支付单简要描述
     */
    private String body;
    /**
     * 商品详情
     * 商品名称明细列表
     */
    private String detail;
    /**
     * 附加数据
     * 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
     */
    private String attach;
    /**
     * 商户订单号
     * 商户系统内部的订单号,32个字符内、可包含字母, 其他说明见商户订单号
     */
    private String out_trade_no;
    /**
     * 总金额
     * 订单总金额，单位为分，只能为整数，详见支付金额
     */
    private int total_fee;
    /**
     * 货币类型
     * 符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String fee_type = "CNY";
    /**
     * 终端IP
     * 调用微信支付API的机器IP
     */
    private String spbill_create_ip;
    /**
     * 商品标记
     * 商品标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠
     */
    private String goods_tag;
    /**
     * 指定支付方式
     * no_credit--指定不能使用信用卡支付
     */
    private String limit_pay;
    /**
     * 授权码
     * 扫码支付授权码，设备读取用户微信中的条码或者二维码信息
     */
    private String auth_code;

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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
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

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }

    public String getLimit_pay() {
        return limit_pay;
    }

    public void setLimit_pay(String limit_pay) {
        this.limit_pay = limit_pay;
    }

    public String getAuth_code() {
        return auth_code;
    }

    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }
}
