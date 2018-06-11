package io.yaoling.starter.weixin.listener;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.yaoling.starter.weixin.message.Message;
import io.yaoling.starter.weixin.message.MessageFactory;
import io.yaoling.starter.weixin.message.MessageType;
import io.yaoling.starter.weixin.message.NullMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageListenerLocator {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageListenerLocator.class);
	
	private Map<MessageType, LinkedList<MessageListener>> cached = new ConcurrentHashMap<>();
	
	/**
	 * 获取当前消息的所有监听器。
	 * @param type
	 * @return
	 */
	protected List<MessageListener> getListeners(MessageType type){
		return cached.get(type);
	}
	
	/**
	 * 注册消息监听器。
	 * @param listener
	 */
	public void register(MessageListener listener){
		if(cached.containsKey(listener.type())){
			cached.get(listener.type()).add( listener );
		}else{
			LinkedList<MessageListener> ls = new LinkedList<>();
			ls.add(listener);
			cached.put(listener.type(), ls);
		}
		logger.info("Message lisenter [{}] has been installed.", listener.getClass());
	}
	
	public Message reply(Message message, MessageContext context){
		
		List<MessageListener> listeners = getListeners(message.getMsgType());	

		Message returnMsg = MessageFactory.createCustomServiceMessage(message);
		if(listeners!=null){
			int priority = 900000;
			for (MessageListener messageListener : listeners) {
				if(messageListener.trigger(message)){
					logger.debug("Message listener {} has be triggered with message {} ", new Object[]{messageListener.getClass(),message});
					Message msg = messageListener.onMessageReceived(message, context);
					if(msg!=null && !(msg instanceof NullMessage) && priority > messageListener.order()){ //优先级最高（order的数字最小）的作为返回消息。
						returnMsg = msg;
						priority = messageListener.order();
						logger.debug("Return Message has be replaced with:{}", msg);
					}
				}
			}
		}
		return returnMsg;
	}

}
