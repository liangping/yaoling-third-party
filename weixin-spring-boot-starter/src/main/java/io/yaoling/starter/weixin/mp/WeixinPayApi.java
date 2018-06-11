package io.yaoling.starter.weixin.mp;

import io.yaoling.common.exception.YaolingHttpException;
import io.yaoling.common.utils.HttpHelper;
import io.yaoling.common.utils.SignHelper;
import io.yaoling.starter.weixin.mp.pay.input.MicroPayInput;
import io.yaoling.starter.weixin.mp.pay.input.OrderQueryInput;
import io.yaoling.starter.weixin.mp.pay.input.UnifiedOrderInput;
import io.yaoling.starter.weixin.mp.pay.output.MicroPayOutput;
import io.yaoling.starter.weixin.mp.pay.output.UnifiedOrderOutput;
import io.yaoling.starter.weixin.mp.pay.output.UnifiedOrderQueryOutput;
import io.yaoling.starter.weixin.mp.pay.output.WeixinPayJsConfigOutput;
import io.yaoling.third.pay.PayTransaction;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WeixinPayApi {
	
	public UnifiedOrderOutput createUnifiedOrder(PayTransaction transaction, String notifyUrl, String payKey) throws YaolingHttpException {
		UnifiedOrderInput input = new UnifiedOrderInput();
		input.setAppid(transaction.getAppid());
		input.setMch_id(transaction.getMchId());
		input.setNonce_str(genRandomNumber(5));
		input.setBody(String.format("订单编号:%s",transaction.getOrderId()));
		input.setOut_trade_no(transaction.getId());
		input.setTotal_fee( transaction.getAmount() );
		input.setSpbill_create_ip(transaction.getIpAddress());
		input.setNotify_url(notifyUrl);
		input.setOpenid(transaction.getOpenid());
		
		input.setSign(SignHelper.sign(input, payKey));
		
		return this.createUnifiedOrder(input);
	}
	
	public UnifiedOrderOutput createUnifiedOrder(PayTransaction transaction, String notifyUrl,String payKey,String body) throws YaolingHttpException{
		UnifiedOrderInput input = new UnifiedOrderInput();
		input.setAppid(transaction.getAppid());
		input.setMch_id(transaction.getMchId());
		input.setNonce_str(genRandomNumber(5));
		input.setBody(body);
		input.setOut_trade_no(transaction.getId());
		input.setTotal_fee( transaction.getAmount() );
		input.setSpbill_create_ip(transaction.getIpAddress());
		input.setNotify_url(notifyUrl);
		input.setOpenid(transaction.getOpenid());
		
		input.setSign(SignHelper.sign(input, payKey));
		
		return this.createUnifiedOrder(input);
	}
	
	
	public UnifiedOrderQueryOutput orderquery(OrderQueryInput input) throws YaolingHttpException{
		
		String url = "https://mp.mch.weixin.qq.com/pay/orderquery";
		
		return HttpHelper.xmlPost(url, input, UnifiedOrderQueryOutput.class);
	}
	
	
	public UnifiedOrderOutput createUnifiedOrder(UnifiedOrderInput input) throws YaolingHttpException{
		String url = "https://mp.mch.weixin.qq.com/pay/unifiedorder";
		return HttpHelper.xmlPost(url, input, UnifiedOrderOutput.class);
	}
	
	public MicroPayOutput createMicroPayOrder(PayTransaction transaction, String payKey) throws YaolingHttpException {
		return createMicroPayOrder(transaction, null, null, payKey);
	}	
	/**
	 * 发起微信扫码支付。
	 * @param transaction 支付信息
	 * @param brand 品牌名称
	 * @param device 设备号或支付人ID
	 * @param payKey 支付API密钥
	 * @return 微信支付相关配置
	 * @throws YaolingHttpException http异常
	 */
	public MicroPayOutput createMicroPayOrder(PayTransaction transaction,String brand,String device, String payKey) throws YaolingHttpException {
		MicroPayInput input = new MicroPayInput();
		input.setAppid(transaction.getAppid());
		input.setBody(brand==null?"微信刷卡支付":brand.concat(" 微信刷卡支付"));
		input.setDevice_info(device);
		input.setMch_id(transaction.getMchId());
		input.setNonce_str(genRandomNumber(5));
		input.setOut_trade_no(transaction.getId());
		input.setSpbill_create_ip(transaction.getIpAddress());
		input.setTotal_fee(transaction.getAmount());

		input.setAuth_code(transaction.getOrderId());
		
		input.setSign(SignHelper.sign(input, payKey));
		
		return createMicroPayOrder(input);
	}

	public MicroPayOutput createMicroPayOrder(MicroPayInput input) throws YaolingHttpException {
		String url = "https://mp.mch.weixin.qq.com/pay/micropay";
		return HttpHelper.xmlPost(url, input, MicroPayOutput.class);
	}

	public WeixinPayJsConfigOutput payJsConfig(String appId, String timeStamp, String nonceStr, String packageText, String signType, String payKey) throws YaolingHttpException{
	
		Map<String, String> input = new HashMap<>();
		input.put("appId", appId);
		input.put("timeStamp", timeStamp);
		input.put("nonceStr", nonceStr);
		input.put("package", packageText);
		input.put("signType", signType);
		
		String paySign = SignHelper.sign(input, payKey);
		
		WeixinPayJsConfigOutput output = new WeixinPayJsConfigOutput();
		output.setAppId(appId);
		output.setNonceStr(nonceStr);
		output.setTimeStamp(timeStamp);
		output.setPackageText(packageText);
		output.setSignType(signType);
		
		output.setPaySign(paySign);
	
	    return output;
	}

	private String genRandomNumber(int length){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < length; i++){
			int random = new Random().nextInt(10);
			sb.append(random==0?random+1:random);
		};

		return sb.toString();
	}
}
