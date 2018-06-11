package io.yaoling.starter.weixin.mp;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.yaoling.common.exception.YaolingHttpException;
import io.yaoling.common.utils.HttpHelper;
import io.yaoling.common.utils.ObjectConverter;
import io.yaoling.common.utils.SignHelper;
import io.yaoling.starter.weixin.WeixinPropertiesConfig;
import io.yaoling.starter.weixin.message.parts.News;
import io.yaoling.starter.weixin.mp.input.CustomNewsMessageInput;
import io.yaoling.starter.weixin.mp.input.CustomTextMessageInput;
import io.yaoling.starter.weixin.mp.input.MenuInput;
import io.yaoling.starter.weixin.mp.input.QRTicketInput;
import io.yaoling.starter.weixin.mp.output.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

public class WeixinApi {

    @Autowired
    WeixinPropertiesConfig config;

    final static Logger logger = LoggerFactory.getLogger(WeixinApi.class);

    private static final String URL_MENU_GET = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=%s";
    private static final String URL_MENU_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";

    private AccessToken accesstoken = null;

    public WeixinApi() {
    }


    public String getAccessToken() throws YaolingHttpException {
        if (accesstoken == null|| accesstoken.getExpired() > System.currentTimeMillis()) {

            if(WeixinPropertiesConfig.CACHE_LOCAL.equalsIgnoreCase(config.getTokenCache())) {
                this.accesstoken = HttpHelper.objectGet(
                        String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s",
                                config.getAppid(), config.getAppsecret()), AccessToken.class);
                this.accesstoken.setExpired(System.currentTimeMillis()+accesstoken.getExpired());//更新过期时间
            }else {
                //accesstoken = HttpHelper.textGet(
                //String.format("%s/app/%s/accesstoken?appid=%s&key=%s",
                //EnvHelper.getTokenServerHost(),
                //EnvHelper.getComponentAppid(),
                //appid,
                //EnvHelper.getTokenServerKey()));
            }
        }
        return accesstoken.getAccessToken();
    }

    public boolean publishMenu(MenuInput menuinput) throws YaolingHttpException {

        JsonOutput output = HttpHelper.objectPost(String.format(URL_MENU_CREATE, getAccessToken()), menuinput, JsonOutput.class);
        if (output.getErrcode() == 0) {
            return true;
        } else {
            throw new YaolingHttpException(output.getErrmsg());
        }
    }

    public MenuOutput menuGet() throws YaolingHttpException {
        return HttpHelper.objectGet(String.format(URL_MENU_GET, getAccessToken()), MenuOutput.class);
    }

    /**
     * @param openid openid of weixin
     * @return 返回JSON格式 { "subscribe": 1, "openid":
     * "o6_bmjrPTlm6_2sgVt7hMZOPfL2M", "nickname": "Band", "sex": 1,
     * "language": "zh_CN", "city": "广州", "province": "广东", "country":
     * "中国", "headimgurl":
     * "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0"
     * , "subscribe_time": 1382694957 }
     * @throws YaolingHttpException http异常
     */
    public WeixinUser getUser(String openid) throws YaolingHttpException {
        StringBuffer url = new StringBuffer();
        url.append("https://api.weixin.qq.com/cgi-bin/user/info?access_token=")
                .append(getAccessToken()).append("&openid=").append(openid);
        WeixinUser user = HttpHelper.objectGet(url.toString(), WeixinUser.class);
        if (user.getErrcode() == 0) {
            return user;
        } else {
            throw new YaolingHttpException(user.getErrmsg());
        }
    }

    /**
     * 根据微信授权请求的授权码获取网页AccessToken.
     *
     * @param code 授权码
     * @return { "access_token":"ACCESS_TOKEN", "expires_in":7200,
     * "refresh_token":"REFRESH_TOKEN", "openid":"OPENID",
     * "scope":"SCOPE" }
     * @throws YaolingHttpException http异常
     */
    public WebAccessToken getWebAccessToken(String code)
            throws YaolingHttpException {

        String tokenserver = String.format("%s/component/%s/accesstoken?key=%s",
                config.getAccessTokenHost(),
                config.getComponentAppId(),
                config.getAccessTokenKey());
        String component_access_token = HttpHelper.textGet(tokenserver);

        StringBuffer url = new StringBuffer();
        if(WeixinPropertiesConfig.MODE_DIRECT.equalsIgnoreCase(config.getMode())) {
            url.append("https://api.weixin.qq.com/sns/oauth2/access_token?");
            url.append("appid=").append(config.getAppid());
            url.append("&secret=").append(config.getAppsecret());
            url.append("&code=").append(code);
            url.append("&grant_type=authorization_code");
        }else{
            url.append("https://api.weixin.qq.com/sns/oauth2/component/access_token?");
            url.append("appid=").append(config.getAppid());
            url.append("&code=").append(code);
            url.append("&grant_type=authorization_code");
            url.append("&component_appid=").append(config.getComponentAppId());
            url.append("&component_access_token=").append(component_access_token);
        }

        WebAccessToken output = HttpHelper.objectGet(url.toString(),
                WebAccessToken.class);
        if (output.getErrcode() > 0)
            throw new YaolingHttpException(output.getErrmsg());
        return output;

    }

    /**
     * 发起微信网页授权请求
     *
     * @param url 接口地址
     * @param scope 授权域
     * @return 授权地址
     * @throws YaolingHttpException http异常
     */
    public String getWebAuthorizeCodeURL(String url, SCOPE scope) throws YaolingHttpException {

        StringBuffer sb = new StringBuffer();
        try {
            if("direct".equalsIgnoreCase(config.getMode())) {
                sb.append("https://open.weixin.qq.com/connect/oauth2/component")
                        .append("?appid=").append(config.getAppid()).append("&redirect_uri=")
                        .append(URLEncoder.encode(url, "utf-8")).append("&response_type=code")
                        .append("&scope=").append(scope.toString())
                        .append("&state=").append(UUID.randomUUID())
                        .append("#wechat_redirect");
            }else{
                sb.append("https://open.weixin.qq.com/connect/oauth2/component")
                        .append("?appid=").append(config.getAppid()).append("&redirect_uri=")
                        .append(URLEncoder.encode(url, "utf-8")).append("&response_type=code")
                        .append("&scope=").append(scope.toString())
                        .append("&component_appid=").append(config.getComponentAppId())
                        .append("&state=").append(UUID.randomUUID())
                        .append("#wechat_redirect");
            }
        } catch (UnsupportedEncodingException e) {
            throw new YaolingHttpException(e);
        }
        return sb.toString();

    }

    /**
     * 发送文本消息
     *
     * @param openid 用户的openid
     * @param content 消息内容
     * @throws YaolingHttpException http异常
     */
    public void sendCustomMessage(String openid, String content) throws YaolingHttpException {

        StringBuffer url = new StringBuffer();
        url.append("https://mp.weixin.qq.com/cgi-bin/message/custom/send?access_token=").append(getAccessToken());

        HttpHelper.objectPost(url.toString(), new CustomTextMessageInput(openid, content));

    }
    
    /**
     * 发送自定义图文消息
     *
     * @param openid 用户openid
     * @param articles 文章列表
     * @throws YaolingHttpException http异常
     */
    public void sendCustomMessage(String openid, List<News> articles) throws YaolingHttpException {
    	
    	if(articles==null||articles.isEmpty()) return;

        StringBuffer url = new StringBuffer();
        url.append("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=").append(getAccessToken());

        HttpHelper.objectPost(url.toString(), new CustomNewsMessageInput(openid, articles));

    }
    
	public void sendTemplateMessage(String openid, String templateid, Map<String, String> msgBody, String msgUrl ) throws YaolingHttpException{
		
		StringBuffer url = new StringBuffer();
		url.append("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=").append(getAccessToken());
		
		Map<String,Object> data = new HashMap<String,Object>();
		Iterator<String> keys = msgBody.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			String value = msgBody.get(key);
			
			Map<String,String> item = new HashMap<String,String>();
			item.put("value", value);
			item.put("color", "#173177");
			data.put(key, item);
		}
		
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("touser", openid );
		msg.put("template_id", templateid );
		msg.put("url", msgUrl );
		msg.put("topcolor", "#FF0000");
		msg.put("data", data );
		
		StringWriter writer = new StringWriter();
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(writer , msg);
		} catch (IOException e) {
			throw new YaolingHttpException( e.fillInStackTrace() );
		}
		logger.debug( writer.toString() );
		 HttpHelper.jsonPost(url.toString(), writer.toString());
		
	}

    public String mediaUploadimg(InputStream in, String filename, long filelength) throws YaolingHttpException {

        String result = HttpHelper.upload(String.format("https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=%s", getAccessToken()), in, filename);
        UploadImageOutput output = ObjectConverter.jsonTextToBean(result, UploadImageOutput.class);

        return output.getUrl();
    }

    /**
     * 验证是否具有高级接口权限
     *
     * @param serviceType 公众号类型
     * @param verifyType  认证状态
     * @return api级别
     */
    public static boolean hasAdvanceApi(int serviceType, int verifyType) {
        return (serviceType == 2 && verifyType >= 0) ? true : false;
    }

    /**
     *
     * 从token服务器获取jsapi ticket
     *
     * @return ticket 凭证
     * @throws YaolingHttpException http异常
     */
    public String getJsapiTicket() throws YaolingHttpException {
        return HttpHelper.textGet(String.format("%s/app/%s/getticket?appid=%s&type=jsapi&key=%s",
                config.getAccessTokenHost(),
                config.getComponentAppId(),
                config.getAppid(),
                config.getAccessTokenKey()));
    }

    public Map<String, String> wxJsConfig(String url) throws YaolingHttpException{

        String jsapi_ticket = this.getJsapiTicket();        
        logger.debug("Genernate jsapi config for url:{} - {}", new Object[]{url, jsapi_ticket});

        Map<String, String> ret = new HashMap<String, String>();
        String nonce_str = String.valueOf(new Random().nextInt(10000)+10000);
        String timestamp = String.valueOf(System.currentTimeMillis()/1000);
        StringBuilder string1 = new StringBuilder();

               //注意这里参数名必须全部小写，且必须有序
        string1.append("jsapi_ticket=").append(jsapi_ticket).append("&noncestr=").append(nonce_str)
                .append("&timestamp=").append(timestamp).append("&url=").append(url);

        String signature = SignHelper.sha1Encrypt(string1.toString());

        ret.put("appid", config.getAppid());
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);

        return ret;
    }
    
    /**
     * 创建永久二维码。
     * @param sceneid 场景ID
     * @return 二位码
     * @throws YaolingHttpException http异常
     */
    public QRTicket createQRLimitTicket(String sceneid) throws YaolingHttpException{
    	QRTicketInput input = new QRTicketInput();
        input.setAction_name(QRTicketInput.ACTION_NAME_QR_LIMIT_STR_SCENE);
    	input.getAction_info().getScene().setScene_str(sceneid);
    	return HttpHelper.objectPost(String.format("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=%s", getAccessToken()), input, QRTicket.class);
    }

}

