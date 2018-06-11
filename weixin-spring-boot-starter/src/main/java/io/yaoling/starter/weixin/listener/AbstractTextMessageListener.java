package io.yaoling.starter.weixin.listener;

import io.yaoling.starter.weixin.message.Message;
import io.yaoling.starter.weixin.message.MessageType;
import io.yaoling.starter.weixin.message.TextMessage;

public abstract class AbstractTextMessageListener extends AbstractMessageListener implements MessageListener {

	@Override
	public final MessageType type() {
		return MessageType.text;
	}

	@Override
	public final Message onMessageReceived(Message msg, MessageContext context) {
		return this.onTextMessageReceived((TextMessage)msg, context);
	}
	
	public abstract Message onTextMessageReceived(TextMessage msg, MessageContext context);

}
