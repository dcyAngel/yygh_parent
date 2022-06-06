package cn.dcy.yygh.order.service;

import java.util.Map;

public interface WeixinService {
    //生成微信支付二维码
    Map createNative(Long orderId);
}
