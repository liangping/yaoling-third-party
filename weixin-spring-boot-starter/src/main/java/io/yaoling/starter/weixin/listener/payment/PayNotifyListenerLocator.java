package io.yaoling.starter.weixin.listener.payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PayNotifyListenerLocator {
	
	private static final Logger logger = LoggerFactory.getLogger(PayNotifyListenerLocator.class);
	
	private Map<String, AbstractWeixinPayNotifyHandler> cached = new ConcurrentHashMap<>();
	
	/**
	 * 获取支付通知handler。
	 * @param name 支付通知handler的名子
	 * @return handler
	 */
	public AbstractWeixinPayNotifyHandler getHandler(String name){
		return cached.get(name);
	}
	
	/**
	 * 注册支付处理handler。
	 * @param listener handler
	 */
	@PostConstruct
	public void register(AbstractWeixinPayNotifyHandler listener){
		if(!cached.containsKey(listener.name())){
			cached.put( listener.name(), listener );
			logger.error("Payment handler [{}] has been installed.", listener.name());
		}else{
			logger.error("Payment handler [{}] already exists. Please give a new name to the handler", listener.name());
		}
	}
}
