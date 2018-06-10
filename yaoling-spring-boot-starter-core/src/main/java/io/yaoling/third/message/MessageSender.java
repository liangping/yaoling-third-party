package io.yaoling.third.message;

import io.yaoling.third.exception.ThirdPartyException;

import java.util.List;
import java.util.Map;

/**
 * 短信消息发送者
 *
 * Created by liangping on 2017/9/27 0027.
 * <p>
 * 江苏摇铃网络科技有限公司，版权所有。
 * Copyright (C) 2015-2017 All Rights Reserved.
 */
public interface MessageSender {
    /**
     * 群发短信消息
     *
     * @param templateCode 消息模板
     * @param phones 接收电话列表
     * @param params 模板中的参数/值。
     * @throws ThirdPartyException
     */
    void sendMessage(String templateCode, List<String> phones, Map<String,String> params) throws ThirdPartyException;

    /**
     *  单独发送一个号码发送短信
     * @param templateCode 消息模板
     * @param phone 接收电话号码
     * @param params 模板中的参数和值
     * @throws ThirdPartyException
     */
    void sendMessage(String templateCode, String phone, Map<String,String> params) throws ThirdPartyException;
}
