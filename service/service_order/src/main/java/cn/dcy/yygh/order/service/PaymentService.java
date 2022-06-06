package cn.dcy.yygh.order.service;

import cn.dcy.yygh.model.order.OrderInfo;
import cn.dcy.yygh.model.order.PaymentInfo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface PaymentService extends IService<PaymentInfo> {
    //向支付记录表添加信息
    void savePaymentInfo(OrderInfo order, Integer status);
}
