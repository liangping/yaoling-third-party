package io.yaoling.starter.weixin.mp.input;


import io.yaoling.starter.weixin.mp.output.elements.Text;

public class CustomTextMessageInput {
	
	public CustomTextMessageInput() {
		super();
	}
	public CustomTextMessageInput(String touser, String content) {
		super();
		this.touser = touser;
		this.text.setContent(content);
	}
	private String touser;
	private String msgtype = "text";
	private Text text = new Text();
	/**
	 * @return the touser
	 */
	public String getTouser() {
		return touser;
	}
	/**
	 * @param touser the touser to set
	 */
	public void setTouser(String touser) {
		this.touser = touser;
	}
	/**
	 * @return the msgtype
	 */
	public String getMsgtype() {
		return msgtype;
	}
	/**
	 * @param msgtype the msgtype to set
	 */
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	/**
	 * @return the text
	 */
	public Text getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(Text text) {
		this.text = text;
	}
}
