package io.yaoling.starter.weixin.listener.payment;

import io.yaoling.common.exception.YaolingHttpException;
import io.yaoling.common.utils.ObjectConverter;
import io.yaoling.common.utils.SignHelper;
import io.yaoling.starter.weixin.mp.pay.output.PayNotify;
import io.yaoling.third.pay.PayNotification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public abstract class AbstractWeixinPayNotifyHandler {

    protected abstract String name();

    @PostConstruct
    private void install(){
        PayNotifyListenerLocator.register(this );
    }

    private static final Logger logger = LoggerFactory.getLogger(AbstractWeixinPayNotifyHandler.class);

    public PayNotification buildNotification(HttpServletRequest request) {
        try {
            return ObjectConverter.xmlStreamToBean(request.getInputStream(), PayNotify.class);
        } catch (YaolingHttpException|IOException e) {
            return null;
        }
    }

    public boolean verify(PayNotification notification, String payKey) {
        try {
            String local = SignHelper.sign(notification, payKey );
            logger.debug("Notification verify: local {} = remote {}", new Object[]{local, notification.getSign()});
            return local.equals( notification.getSign());
        } catch (YaolingHttpException e) {
            logger.error("signature failed", e);
            return false;
        }
    }

    public abstract void onNotify(PayNotification notification);

    public static String success() {
        return "<xml><return_code>SUCCESS</return_code><return_msg>OK</return_msg></xml>";
    }

    public static String fail(String errorMsg) {
        return String.format("<xml><return_code>FAIL</return_code><return_msg>%s</return_msg></xml>", errorMsg);
    }

}
