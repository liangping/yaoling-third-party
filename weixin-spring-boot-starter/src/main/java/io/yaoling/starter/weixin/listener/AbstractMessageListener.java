package io.yaoling.starter.weixin.listener;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class AbstractMessageListener implements MessageListener {
	
	@Autowired
	MessageListenerLocator locator;
	
	@PostConstruct
	public final void install(){
		locator.register(this);
	}

	@Override
	public int order() {
		return BUSSINESS_ORDER;
	}

}
