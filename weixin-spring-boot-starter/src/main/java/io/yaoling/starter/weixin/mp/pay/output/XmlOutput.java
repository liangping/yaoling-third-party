package io.yaoling.starter.weixin.mp.pay.output;

import java.util.Random;

/**
 * XML Bean 返回结果的父类
 * @author liangping
 *
 */
public class XmlOutput {
	/**
	 * SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
	 */
	private String return_code = "SUCCESS";
	/**
	 * 返回信息，如非空，为错误原因;签名失败;具体某个参数格式校验错误.
	 */
	private String return_msg;
	
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getReturn_msg() {
		return return_msg;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	
	public static String randomNonceStr(){
		return String.valueOf(new Random().nextInt());
	}
}
