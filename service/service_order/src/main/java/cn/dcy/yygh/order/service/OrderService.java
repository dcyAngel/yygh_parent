package cn.dcy.yygh.order.service;

import cn.dcy.yygh.model.order.OrderInfo;
import cn.dcy.yygh.vo.order.OrderCountQueryVo;
import cn.dcy.yygh.vo.order.OrderQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface OrderService extends IService<OrderInfo> {
    //生成挂号订单
    Long saveOrder(String scheduleId, Long patientId);

    //根据订单id查询订单详情
    OrderInfo getOrder(Long orderId);

    //订单列表（条件查询带分页）
    IPage<OrderInfo> selectPage(Page<OrderInfo> pageParam, OrderQueryVo orderQueryVo);

    //取消预约
    boolean cancelOrder(Long orderId);

    //就诊通知
    void patientTips();

    //预约统计方法
    Map<String,Object> getCountMap(OrderCountQueryVo orderCountQueryVo);
}
