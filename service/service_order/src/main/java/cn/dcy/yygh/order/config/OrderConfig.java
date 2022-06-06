package cn.dcy.yygh.order.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.dcy.yygh.order.mapper")
public class OrderConfig {
}
