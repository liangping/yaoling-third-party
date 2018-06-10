package io.yaoling.starter.weixin.mp.output;

/**
 * Json格式的输出父类
 * @author liangping
 *
 */
public class JsonOutput {
	
	final public static int OK = 0;
	
	private int errcode;
	private String errmsg;
	private int expires_in;
	
	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Output [errcode=");
		builder.append(errcode);
		builder.append(", errmsg=");
		builder.append(errmsg);
		builder.append(", expires_in=");
		builder.append(expires_in);
		builder.append("]");
		return builder.toString();
	}

}
