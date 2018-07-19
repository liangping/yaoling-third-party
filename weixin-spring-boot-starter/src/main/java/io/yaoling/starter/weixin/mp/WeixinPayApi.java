package io.yaoling.starter.weixin.mp;

import io.yaoling.common.exception.YaolingHttpException;
import io.yaoling.common.utils.HttpHelper;
import io.yaoling.common.utils.SignHelper;
import io.yaoling.starter.weixin.WeixinPropertiesConfig;
import io.yaoling.starter.weixin.mp.pay.input.MicroPayInput;
import io.yaoling.starter.weixin.mp.pay.input.OrderQueryInput;
import io.yaoling.starter.weixin.mp.pay.input.UnifiedOrderInput;
import io.yaoling.starter.weixin.mp.pay.output.MicroPayOutput;
import io.yaoling.starter.weixin.mp.pay.output.UnifiedOrderOutput;
import io.yaoling.starter.weixin.mp.pay.output.UnifiedOrderQueryOutput;
import io.yaoling.starter.weixin.mp.pay.output.WeixinPayJsConfigOutput;
import io.yaoling.third.pay.PayTransaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WeixinPayApi {

    @Autowired
    protected WeixinPropertiesConfig config;

    public UnifiedOrderOutput createUnifiedOrder(PayTransaction transaction) throws YaolingHttpException {
        String body = String.format("订单编号:%s",transaction.getOrderId());
		return this.createUnifiedOrder(transaction, body);
	}

	public UnifiedOrderOutput createUnifiedOrder(PayTransaction transaction, String body) throws YaolingHttpException {
		return this.createUnifiedOrder(transaction, body, UnifiedOrderInput.JSAPI);
	}
	
	public UnifiedOrderOutput createUnifiedOrder(PayTransaction transaction, String body, String trade_type) throws YaolingHttpException{
        UnifiedOrderInput input = new UnifiedOrderInput();
        //基础参数
        input.setAppid(config.getAppid());
        input.setMch_id(config.getMch_id());
        input.setNotify_url(config.getNotifyHost().concat("/weixin/pay/").concat(transaction.handlerName()).concat("/notify"));
        input.setNonce_str(genRandomNumber(5));
        //业务参数
        input.setBody(body);
        input.setOut_trade_no(transaction.getId());
        input.setTotal_fee( transaction.getAmount() );
        input.setSpbill_create_ip(transaction.getIpAddress());
        input.setOpenid(transaction.getOpenid());
        input.setTrade_type(trade_type);
        input.setScene_info(transaction.getSceneInfo());
        //生成签名
        input.setSign(SignHelper.sign(input, config.getPayKey()));
		
		return this.createUnifiedOrder(input);
	}
	
	
	public UnifiedOrderQueryOutput orderquery(OrderQueryInput input) throws YaolingHttpException{
		
		String url = "https://api.mch.weixin.qq.com/pay/orderquery";
		
		return HttpHelper.xmlPost(url, input, UnifiedOrderQueryOutput.class);
	}
	
	
	public UnifiedOrderOutput createUnifiedOrder(UnifiedOrderInput input) throws YaolingHttpException{
		String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		return HttpHelper.xmlPost(url, input, UnifiedOrderOutput.class);
	}
	
	public MicroPayOutput createMicroPayOrder(PayTransaction transaction) throws YaolingHttpException {
		return createMicroPayOrder(transaction, null, null);
	}

	/**
	 * 发起微信扫码支付。
	 * @param transaction 支付信息
	 * @param brand 品牌名称
	 * @param device 设备号或支付人ID
	 * @return 微信支付相关配置
	 * @throws YaolingHttpException http异常
	 */
	public MicroPayOutput createMicroPayOrder(PayTransaction transaction,String brand,String device) throws YaolingHttpException {
		MicroPayInput input = new MicroPayInput();
		//基础参数
		input.setAppid(config.getAppid());
        input.setMch_id(config.getMch_id());
        input.setNonce_str(genRandomNumber(5));
        //业务参数
		input.setBody(brand==null?"微信刷卡支付":brand.concat(" 微信刷卡支付"));
		input.setDevice_info(device);
		input.setOut_trade_no(transaction.getId());
		input.setSpbill_create_ip(transaction.getIpAddress());
		input.setTotal_fee(transaction.getAmount());
		input.setAuth_code(transaction.getOrderId());
		//参数签名
		input.setSign(SignHelper.sign(input, config.getPayKey()));
		
		return createMicroPayOrder(input);
	}

	public MicroPayOutput createMicroPayOrder(MicroPayInput input) throws YaolingHttpException {
		String url = "https://api.mch.weixin.qq.com/pay/micropay";
		return HttpHelper.xmlPost(url, input, MicroPayOutput.class);
	}

	public WeixinPayJsConfigOutput payJsConfig(String timeStamp, String nonceStr, String packageText) throws YaolingHttpException{
	
		Map<String, String> input = new HashMap<>();
		input.put("appId", config.getAppid());
		input.put("timeStamp", timeStamp);
		input.put("nonceStr", nonceStr);
		input.put("package", packageText);
		input.put("signType", config.getPaySignType());
		
		String paySign = SignHelper.sign(input, config.getPayKey());
		
		WeixinPayJsConfigOutput output = new WeixinPayJsConfigOutput();
		output.setAppId(config.getAppid());
		output.setNonceStr(nonceStr);
		output.setTimeStamp(timeStamp);
		output.setPackageText(packageText);
		output.setSignType(config.getPaySignType());
		
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

	/**
	 * 生产微信支付二维码
	 * @param id 支付单ＩＤ　
	 * @return
	 */
	public String generateQRCode(int id){
		//二维码
		Map<String,String> map = new HashMap<String,String>();
		map.put("appid", this.config.getAppid());
		map.put("mch_id", this.config.getMch_id());
		map.put("product_id", String.valueOf(id));
		map.put("time_stamp", String.valueOf(System.currentTimeMillis() / 1000L));
		map.put("nonce_str", this.genRandomNumber(5));
		String queryString = SignHelper.mapToUrlString(map);
		StringBuffer sb = new StringBuffer();
		sb.append("weixin://wxpay/bizpayurl?");
		sb.append(queryString);
		sb.append("&sign="+SignHelper.sign(map,this.config.getPayKey()));
		return sb.toString();
	}
}
