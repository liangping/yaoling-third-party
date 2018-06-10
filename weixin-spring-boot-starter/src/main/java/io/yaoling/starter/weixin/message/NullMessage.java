package io.yaoling.starter.weixin.message;
/**
 * 空消息，只返回 success 文本。
 * @author liangping
 *
 */
public class NullMessage implements Message{

	@Override
	public String getToUserName() {
		return null;
	}

	@Override
	public void setToUserName(String tousername) {
		
	}

	@Override
	public String getFromUserName() {
		return null;
	}

	@Override
	public void setFromUserName(String fromUserName) {
		
	}

	@Override
	public Integer getCreateTime() {
		return null;
	}

	@Override
	public void setCreateTime(Integer createtime) {
		
	}

	@Override
	public MessageType getMsgType() {
		return null;
	}

	@Override
	public void setMsgType(MessageType msgType) {
		
	}

	@Override
	public String toString() {
		return "success";
	}

	@Override
	public String toEncryptString() {
		return "success";
	}

}
