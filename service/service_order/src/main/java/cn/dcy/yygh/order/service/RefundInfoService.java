package cn.dcy.yygh.order.service;

import cn.dcy.yygh.model.order.PaymentInfo;
import cn.dcy.yygh.model.order.RefundInfo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface RefundInfoService extends IService<RefundInfo> {
    //保存退款记录
    RefundInfo saveRefundInfo(PaymentInfo paymentInfo);
}
