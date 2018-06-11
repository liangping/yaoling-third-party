package io.yaoling.starter.weixin.component.api;


import io.yaoling.common.exception.YaolingHttpException;
import io.yaoling.common.utils.HttpHelper;
import io.yaoling.starter.weixin.WeixinPropertiesConfig;
import io.yaoling.starter.weixin.component.input.AuthorizerInfoInput;
import io.yaoling.starter.weixin.component.input.AuthorizerOptionInput;
import io.yaoling.starter.weixin.component.input.PreAuthcodeInput;
import io.yaoling.starter.weixin.component.input.QueryAuthInput;
import io.yaoling.starter.weixin.component.output.AuthorizerInfoOutput;
import io.yaoling.starter.weixin.component.output.AuthorizerOptionOutput;
import io.yaoling.starter.weixin.component.output.PreAuthcodeOutput;
import io.yaoling.starter.weixin.component.output.QueryAuthOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.UnsupportedEncodingException;

/**
 * 微信第三方开放平台通用接口
 * @author liangping
 *
 */
public class WeixinComponentApi {

	@Autowired
	WeixinPropertiesConfig config;

	private String appid;
	private String access_token = null;

	static Logger logger = LoggerFactory.getLogger(WeixinComponentApi.class); 
	/**
	 * 客户端调用使用无参数构造函数	
	 */
	public WeixinComponentApi() {
		this.appid 		= config.getComponentAppId();
	}

	/**
	 * 第三方平台方可以在自己的网站首页中放置“微信公众号登录授权”的入口，引导公众号运营者进入第三方平台授权页。
	 * 网址为https://mp.weixin.qq.com/cgi-bin/componentloginpage?component_appid=xxxx&pre_auth_code=xxxxx&redirect_uri=xxxx，
	 * 该网址中第三方平台方需要提供第三方平台方appid、预授权码和回调URI
	 * @return 授权地址
	 * @throws YaolingHttpException http异常
	 */
	public String authorize_url() throws YaolingHttpException {
		StringBuffer sb = new StringBuffer("https://mp.weixin.qq.com/cgi-bin/componentloginpage?");
		try {

			sb.append("component_appid=").append( this.appid )
			.append("&pre_auth_code=").append(this.api_create_preauthcode()).append("&redirect_uri=");
			
			ServletRequestAttributes request  = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes());
			if(request!=null){
				StringBuffer callback = new StringBuffer();
				callback.append(request.getRequest().getScheme()).append("://")
					.append(request.getRequest().getServerName())
					.append(request.getRequest().getContextPath());
				sb.append(java.net.URLEncoder.encode(callback.append("/component/success").toString(), "utf-8"));
			}
		} catch (UnsupportedEncodingException e) {
			throw new YaolingHttpException(e);
		}
		logger.debug(String.format("Current WeixinUser Address is: %s", sb.toString() ));
		return sb.toString();
	}

	/**
	 * 从token server上获取你access_token
	 * @return accesstoken
	 * @throws YaolingHttpException http异常
	 */
	public String api_component_token() throws YaolingHttpException{
		if(this.access_token==null){
			String tokenserver = String.format("%s/component/%s/accesstoken?key=%s", config.getAccessTokenHost(),this.appid,config.getAccessTokenKey());
			logger.debug("Weixin component mp get a new component token:{}", tokenserver);
			return HttpHelper.textGet(tokenserver);
		}else{
			return access_token;
		}
	}
	
	/**
	 * 获取平台的预授权码
	 * 该API用于获取预授权码。预授权码用于公众号授权时的第三方平台方安全验证。
	 * 
	 * @return 预授权码
	 * @throws YaolingHttpException http异常
	 */
	public String api_create_preauthcode() throws YaolingHttpException{
			PreAuthcodeInput input = new PreAuthcodeInput();
			input.setComponent_appid( this.appid );
			StringBuffer surl = new StringBuffer("https://mp.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token=");
			surl.append(this.api_component_token());
			PreAuthcodeOutput output  = objectPost(surl.toString(), input, PreAuthcodeOutput.class);

			logger.debug( output.toString() );
			
		return output.getPre_auth_code() ;
	}	

	/**
	 * 使用授权码换取公众号的授权信息
	 * 
	 * 该API用于使用授权码换取授权公众号的授权信息，并换取authorizer_access_token和authorizer_refresh_token。 
	 * 授权码的获取，需要在用户在第三方平台授权页中完成授权流程后，在回调URI中通过URL参数提供给第三方平台方。
	 * 
	 * @return 授权信息
	 * @throws YaolingHttpException http异常
	 */
	public QueryAuthOutput api_query_auth(String auth_code) throws YaolingHttpException{
		
		QueryAuthInput input = new QueryAuthInput();
		input.setComponent_appid( this.appid );
		input.setAuthorization_code( auth_code );
		StringBuffer surl = new StringBuffer("https://mp.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token=");
		surl.append(this.api_component_token());
		QueryAuthOutput output  = objectPost(surl.toString(), input, QueryAuthOutput.class);
		logger.debug( output.toString() );
				
		return output;
	}	

	/**
	 * 获取授权方的账户信息
	 * 
	 * 该API用于获取授权方的公众号基本信息，包括头像、昵称、帐号类型、认证类型、微信号、原始ID和二维码图片URL。
	 * 需要特别记录授权方的帐号类型，在消息及事件推送时，对于不具备客服接口的公众号，需要在5秒内立即响应；而若有客服接口，则可以选择暂时不响应，而选择后续通过客服接口来发送消息触达粉丝。
	 * 
	 * @param authorizer_appid 公众号ID
	 * @return 授权信息
	 * @throws YaolingHttpException http异常
	 */
	public AuthorizerInfoOutput api_get_authorizer_info(String authorizer_appid) throws YaolingHttpException{
		AuthorizerInfoInput input = new AuthorizerInfoInput();
		input.setAuthorizer_appid( authorizer_appid );
		input.setComponent_appid( this.appid );
		StringBuffer surl = new StringBuffer("https://mp.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?component_access_token=");
		surl.append(this.api_component_token());
		AuthorizerInfoOutput output  = objectPost(surl.toString(), input, AuthorizerInfoOutput.class);
		logger.debug( output.toString() );
		return output;
	}	
	/**
	 * 获取授权方的选项设置信息
	 * 
	 * 该API用于获取授权方的公众号的选项设置信息，如：地理位置上报，语音识别开关，多客服开关。注意，获取各项选项设置信息，需要有授权方的授权，详见权限集说明。
	 *  选项值说明
	 * location_report(地理位置上报选项)	
	 *  0	无上报
	 *  1	进入会话时上报
	 *  2	每5s上报
	 * voice_recognize（语音识别开关选项）	
	 *  0	关闭语音识别
  	 *  1	开启语音识别
	 * customer_service（客服开关选项）	
	 *  0	关闭多客服
	 *  1	开启多客服
	 *  
	 * @param authorizer_appid 被授权公众号ID
	 * @return 值
	 * @throws YaolingHttpException http异常
	 */
	public int api_get_authorizer_option(String authorizer_appid, String name) throws YaolingHttpException{
		AuthorizerOptionInput input = new AuthorizerOptionInput();
		input.setAuthorizer_appid(authorizer_appid);
		input.setComponent_appid( this.appid );
		input.setOption_name( name );
		
		StringBuffer surl = new StringBuffer("https://mp.weixin.qq.com/cgi-bin/component/api_get_authorizer_option?component_access_token=");
		surl.append(this.api_component_token());
		AuthorizerOptionOutput output  = objectPost(surl.toString(), input, AuthorizerOptionOutput.class);
		logger.debug( output.toString() );
		return output.getOption_value() ;
	}	
	/**
	 * 设置授权方的选项信息
	 * 
	 * 该API用于设置授权方的公众号的选项信息，如：地理位置上报，语音识别开关，多客服开关。注意，设置各项选项设置信息，需要有授权方的授权，详见权限集说明。
	 * 
	 *  选项值说明
	* location_report(地理位置上报选项)	
	*  0	无上报
	*  1	进入会话时上报
	*  2	每5s上报
	* voice_recognize（语音识别开关选项）	
	*  0	关闭语音识别
  	*  1	开启语音识别
	* customer_service（客服开关选项）	
	*  0	关闭多客服
	*  1	开启多客服
	*  
	 * @param authorizer_appid 被授权公众号ID
	 * @return 是否成功
	 * @throws YaolingHttpException http异常
	 */
	public boolean api_set_authorizer_option( String authorizer_appid, String name, String value ) throws YaolingHttpException{
		AuthorizerOptionInput input = new AuthorizerOptionInput();
		input.setAuthorizer_appid(authorizer_appid);
		input.setComponent_appid( this.appid );
		input.setOption_name( name );
		input.setOption_value( value );
		
		StringBuffer surl = new StringBuffer("https://mp.weixin.qq.com/cgi-bin/component/api_set_authorizer_option?component_access_token=");
		surl.append(this.api_component_token());
		AuthorizerOptionOutput output  = objectPost(surl.toString(), input, AuthorizerOptionOutput.class);
		
		logger.debug("api_set_authorizer_option: ".concat(name).concat(" => ").concat( value ).concat( " result: ").concat( output.toString() ));
		
		return output.getErrcode()==0;
	}

	private <T> T objectPost(String surl, Object input, Class<T> clasz ) throws YaolingHttpException {
		return HttpHelper.objectPost(surl, input, clasz);
	}
}
