package io.yaoling.starter.weixin.listener;

import io.yaoling.starter.weixin.message.Message;
import io.yaoling.starter.weixin.message.MessageType;

/**
 * 微信消息监听器
 * @author ping
 *
 */
public interface MessageListener{
	
	static final int SYSTEM_ORDER = 10;
	static final int BUSSINESS_ORDER = 100;
	static final int NO_BUSSINESS_ORDER = 100000;

	/**
	 * 启动监听条件
	 * @param message 接收的消息
	 * @return
	 */
	public boolean trigger(Message message);
	
	/**
	 * 处理接收到的消息
	 * @param message
	 * @param context TODO
	 * @return
	 */
	public Message onMessageReceived(Message message, MessageContext context);
	
	/**
	 * 监听消息的类型；例如，文本消息，时间消息，语音消息等等。
	 * @return
	 */
	public MessageType type();
	
	/**
	 * 监听有限级别，由低到高，数字越低排序越优先。取值范围（1-1000）之间。
	 * @return
	 */
	public int order();

}
