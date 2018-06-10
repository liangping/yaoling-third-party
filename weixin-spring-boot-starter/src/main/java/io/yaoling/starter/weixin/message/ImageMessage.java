package io.yaoling.starter.weixin.message;


public interface ImageMessage extends Message {

	// <PicUrl><![CDATA[this is a url]]></PicUrl>
	// <MsgId>1234567890123456</MsgId>
	public String getPicUrl();

	public void setPicUrl(String picUrl);

	public String getMsgId();

	public void setMsgId(String msgId);

}
