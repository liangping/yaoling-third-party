package io.yaoling.third.pay;

/**
 * 支付完成后，执行的任务。比如。支付成功后修改订单的状态。充值时增加账号的资金。是现实需考虑被重复通知的情况。
 * @author ping
 *
 */
public abstract class PayNotifyTask implements Runnable {

}
