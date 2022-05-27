package cn.dcy.yygh.user.service;

import cn.dcy.yygh.vo.user.LoginVo;

import java.util.Map;

public interface UserInfoService {
    //用户手机号登录接口
    Map<String, Object> loginUser(LoginVo loginVo);
}
