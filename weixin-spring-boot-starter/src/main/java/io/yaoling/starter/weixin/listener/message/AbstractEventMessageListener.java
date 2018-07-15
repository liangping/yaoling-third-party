package io.yaoling.starter.weixin.listener.message;


import io.yaoling.starter.weixin.message.EventMessage;
import io.yaoling.starter.weixin.message.Message;
import io.yaoling.starter.weixin.message.MessageType;

public abstract class AbstractEventMessageListener extends AbstractMessageListener implements MessageListener {
	
	@Override
	public MessageType type() {
		return MessageType.event;
	}

	public final Message onMessageReceived(Message message, MessageContext context) {
		return this.onEventMessageReceived((EventMessage)message, context);
	}

	/**
	 * 处理事件消息
	 * @param message 消息体
	 * @param setting 当前微信公众号设置
	 * @return 回复消息，返回null,表示没有回复消息。
	 */
	public abstract Message onEventMessageReceived(EventMessage message, MessageContext setting);
	
}
