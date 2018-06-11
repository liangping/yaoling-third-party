package io.yaoling.starter.weixin.listener;

import io.yaoling.starter.weixin.WeixinPropertiesConfig;
import io.yaoling.third.pay.PayNotification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


public class PayNotifyListenerController {

    private static final Logger logger = LoggerFactory.getLogger(PayNotifyListenerController.class);

    @Autowired
    private WeixinPropertiesConfig config;

    @Autowired
    AbstractWeixinPayNotifyHandler handler;

    @RequestMapping(value="/weixin/pay/notify", method=RequestMethod.POST )
    public @ResponseBody String orderNotify(HttpServletRequest request ) {

        logger.debug("Recieved a notification at {}", new Date());
        try{

            PayNotification notification = handler.buildNotification(request);

            if(handler.verify(notification, config.getPayKey())) {
                handler.onNotify(notification);
                logger.debug("Recieved a notification for order {} {}", new Object[]{notification.getOut_trade_no(), notification.getTransaction_id()});
                return handler.success();
            }
        }catch(NullPointerException e){
            logger.error("Pay notification proccess failed",e);
        }
        return handler.fail("signature failed or format unmatched!");
    }
}
