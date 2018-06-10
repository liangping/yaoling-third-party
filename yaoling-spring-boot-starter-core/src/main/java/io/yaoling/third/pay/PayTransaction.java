package io.yaoling.third.pay;

import java.util.Date;

/**
 * 支付申请信息。
 * @author ping
 *
 */
public interface PayTransaction extends PayStatusConstant{

	/**
	 * 所以应的订单ID
	 * @return
	 */
	public String getOrderId();
	/**
	 * 支付单ID
	 * @return
	 */
	public String getId();

	/**
	 * 外部应用的绑定授权appid. 例如：微信的appid
	 * @return
	 */
	public String getAppid();
	/**
	 * 发起操作人
	 * @return
	 */
	public String getOp();
	/**
	 * 支付流水号
	 * @return
	 */
	public String getPayNo();
	/**
	 * 支付方式
	 * @return
	 */
	public Payment getPayment();
	/**
	 * 支付金额，单位（分）
	 * @return
	 */
	public int getAmount();
	/**
	 * 外部商户号
	 * @return
	 */
	public String getMchId();
	/**
	 * 外部用户ID
	 * @return
	 */
	public String getOpenid();
	/**
	 * 发起支付日期
	 * @return
	 */
	public Date getCreateTime();
	/**
	 * 支付完成时间
	 * @return
	 */
	public Date getPayTime();
	/**
	 * 发起支付的地址
	 * @return
	 */
	public String getIpAddress();

}
