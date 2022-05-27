package cn.dcy.yygh.user.controller;

import cn.dcy.yygh.common.result.Result;
import cn.dcy.yygh.user.service.UserInfoService;
import cn.dcy.yygh.vo.user.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserInfoApiController {
    @Autowired
    private UserInfoService userInfoService;

    //用户手机号登录接口
    @PostMapping("login")
    public Result login(@RequestBody LoginVo loginVo){
        Map<String,Object> info = userInfoService.loginUser(loginVo);
        return Result.ok(info);
    }
}
