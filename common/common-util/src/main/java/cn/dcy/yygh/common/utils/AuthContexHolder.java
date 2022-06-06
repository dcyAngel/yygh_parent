package cn.dcy.yygh.common.utils;

import cn.dcy.yygh.common.helper.JwtHelper;
import com.baomidou.mybatisplus.extension.api.R;

import javax.servlet.http.HttpServletRequest;

//获取当前用户信息的工具类
public class AuthContexHolder {
    //获取当前用户的id
    public static long getUserId(HttpServletRequest request){
        //从header获取token
        String token = request.getHeader("token");
        //JWT从token获取userid
        Long userId = JwtHelper.getUserId(token);
        return userId;
    }

    //获取当前用户的名称
    public static String getUserName(HttpServletRequest request){
        //从header获取token
        String token = request.getHeader("token");
        //JWT从token获取userid
        String userName = JwtHelper.getUserName(token);
        return userName;
    }
}
