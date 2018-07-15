package io.yaoling.starter.weixin.listener.message;

import io.yaoling.starter.weixin.message.EventMessage;
import io.yaoling.starter.weixin.message.Message;
import io.yaoling.starter.weixin.message.MessageFactory;
import io.yaoling.starter.weixin.message.TextMessage;

public class ConfigSuccessMessageListener extends AbstractEventMessageListener {

    @Override
    public Message onEventMessageReceived(EventMessage message, MessageContext setting) {
        TextMessage reply = MessageFactory.createTextMessage(message);
        reply.setContent("接口已经配置完成，请继承AbstractMessageListener实现你自己的消息监听");
        return reply;
    }

    @Override
    public boolean trigger(Message message) {
        return true;
    }
}
