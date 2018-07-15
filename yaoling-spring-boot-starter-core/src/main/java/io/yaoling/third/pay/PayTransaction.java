package io.yaoling.third.pay;

/**
 * 支付申请信息。
 * 注意：同一个订单可能发起多次支付。
 * @author ping
 *
 */
public interface PayTransaction extends PayStatusConstant{

	/**
	 * 支付通知处理handler的名字。
	 * 指定这个名字的handler来处里本条支付的通知成功处理。
	 * @return
	 */
	String handlerName();

	/**
	 * 所以应的订单ID
	 * @return orderId
	 */
	String getOrderId();

	/**
	 * 支付单ID
	 * @return id
	 */
	String getId();
	/**
	 * 支付金额，单位（分）
	 * @return amount
	 */
	int getAmount();
	/**
	 * 外部用户ID
	 * @return openid
	 */
	String getOpenid();
	/**
	 * 发起支付的地址
	 * @return ip
	 */
	String getIpAddress();

}
