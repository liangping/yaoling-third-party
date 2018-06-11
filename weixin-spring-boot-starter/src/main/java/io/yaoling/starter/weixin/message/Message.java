package io.yaoling.starter.weixin.message;

/**
 * 微信消息格式<br>
 * &lt;ToUserName&gt;&lt;![CDATA[toUser]]&gt;&lt;/ToUserName&gt;<br>
 * &lt;FromUserName&gt;&lt;![CDATA[fromUser]]&gt;&lt;/FromUserName&gt;<br>
 * &lt;CreateTime&gt;12345678&lt;/CreateTime&gt; <br>
 * &lt;MsgType&gt;&lt;![CDATA[news]]&gt;&lt;/MsgType&gt;<br>
 * 
 * @author liangping
 * 
 */
public interface Message {
	
	public String getToUserName();

	public void setToUserName(String tousername);

	public String getFromUserName();

	public void setFromUserName(String fromUserName);

	public Integer getCreateTime();

	public void setCreateTime(Integer createtime);

	public MessageType getMsgType();

	public void setMsgType(MessageType msgType);

	public String toEncryptString();

}
