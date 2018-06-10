package io.yaoling.third.pay;

public interface PayStatusConstant {
	
	/**
	 * 等待支付，微支付
	 */
	static final int PAYING = 0;
	/**
	 * 已支付
	 */
	static final int SUCCESS = 1;
	/**
	 * 取消
	 */
	static final int CANCEL = -1;
	

}
