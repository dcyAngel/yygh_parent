package cn.dcy.yygh.user.service.impl;

import cn.dcy.yygh.common.exception.YyghException;
import cn.dcy.yygh.common.result.ResultCodeEnum;
import cn.dcy.yygh.model.user.UserInfo;
import cn.dcy.yygh.user.mapper.UserInfoMapper;
import cn.dcy.yygh.user.service.UserInfoService;
import cn.dcy.yygh.vo.user.LoginVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.netty.util.internal.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserInfoServiceImpl extends
        ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    //用户手机号登录接口
    @Override
    public Map<String, Object> loginUser(LoginVo loginVo) {
        //从loginVo获取输入的手机号和验证码
        String phone = loginVo.getPhone();
        String code = loginVo.getCode();

        //判断手机号和验证码是否为空
        if(StringUtils.isEmpty(phone) || StringUtils.isEmpty((code))){
            throw new YyghException(ResultCodeEnum.PARAM_ERROR);
        }

        //TODO 判断手机号验证码和输入的验证码是否一致

        //判断是否是第一次登录：根据手机号查询数据库，如果不存在相同的手机号就是第一次登录
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("phone",phone);
        UserInfo userInfo = baseMapper.selectOne(wrapper);
        if(userInfo == null){
            userInfo = new UserInfo();
            userInfo.setName("");
            userInfo.setPhone(phone);
            userInfo.setStatus(1);
            baseMapper.insert(userInfo);
        }

        //校验是否被禁用
        if(userInfo.getStatus() == 0){
            throw new YyghException(ResultCodeEnum.LOGIN_DISABLED_ERROR);
        }

        //不是第一次登录，直接登录
        //返回登录信息
        //返回登录用户名
        //返回token
        Map<String,Object> map = new HashMap<>();
        String name = userInfo.getName();
        if(StringUtils.isEmpty(name)){
            name = userInfo.getNickName();
        }
        if(StringUtils.isEmpty(name)){
            name = userInfo.getPhone();
        }
        //TODO token生成
        map.put("name",name);
        map.put("token","");
        return map;
        //fgd
    }
}
