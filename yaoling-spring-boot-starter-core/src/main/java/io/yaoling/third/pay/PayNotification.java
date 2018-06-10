package io.yaoling.third.pay;

import java.util.Date;
/**
 * 支付成功消息通知对象。实现类必须保证所有的消息通知参数都有一个字段与参数名对应，以确保签名校验成功。<br>
 * 如果，实现类有无需签名的字段，可以在字段前加上注解  @XmlTransient。 该字段验证时将被忽略。 
 * @author ping
 *
 */
public interface PayNotification {
	/**
	 * 本地支付订单号，产品ID等。
	 * @return
	 */
	public String getOut_trade_no();
	/**
	 * 通知时间
	 * @return
	 */
	public Date getNoticeTime();
	/**
	 * 第三方支付流水号。如果无法获取，请生成一个非空字段或者随机数。
	 * @return
	 */
	public String getTransaction_id();
	/**
	 * 第三方接口提供的签名字段。
	 * @return
	 */
	String getSign();	
}
