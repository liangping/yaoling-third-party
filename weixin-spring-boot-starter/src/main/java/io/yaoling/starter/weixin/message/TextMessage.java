package io.yaoling.starter.weixin.message;


public interface TextMessage extends Message {

	public String getContent();

	public void setContent(String content);

	public String getMsgId();

	public void setMsgId(String msgId);
	
}
