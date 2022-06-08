package cn.dcy.yygh.order.mapper;

import cn.dcy.yygh.model.order.OrderInfo;
import cn.dcy.yygh.vo.order.OrderCountQueryVo;
import cn.dcy.yygh.vo.order.OrderCountVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import feign.Param;

import java.util.List;

public interface OrderMapper extends BaseMapper<OrderInfo> {
    //查询预约统计数据的方法
    List<OrderCountVo> selectOrderCount(@Param("vo") OrderCountQueryVo orderCountQueryVo);
}
