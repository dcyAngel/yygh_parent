package cn.dcy.yygh.user.config;

import org.mapstruct.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.dcy.yygh.user.mapper")
public class UserConfig {
}
