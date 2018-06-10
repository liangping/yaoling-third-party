package io.yaoling.starter.weixin.message;

public interface EventMessage extends Message {
//	<Event><![CDATA[EVENT]]></Event>
//	<EventKey><![CDATA[EVENTKEY]]></EventKey>
	public String getEvent();

	public void setEvent(String event);

	public String getEventKey();

	public void setEventKey(String eventKey);
	
	public String getTicket();
	
	public void setTicket(String ticket);
}
