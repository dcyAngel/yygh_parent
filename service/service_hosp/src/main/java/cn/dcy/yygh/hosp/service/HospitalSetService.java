package cn.dcy.yygh.hosp.service;

import cn.dcy.yygh.model.hosp.HospitalSet;
import com.baomidou.mybatisplus.extension.service.IService;

public interface HospitalSetService extends IService<HospitalSet> {
    String getSignKey(String hoscode);
}
