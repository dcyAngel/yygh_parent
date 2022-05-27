package cn.dcy.yygh.hosp.service;

import cn.dcy.yygh.model.hosp.Hospital;
import cn.dcy.yygh.vo.hosp.HospitalQueryVo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface HospitalService {
    //上传医院接口方法
    void save(Map<String, Object> paramMap);

    //根据医院编号进行查询
    Hospital getByHoscode(String hoscode);

    //医院列表（条件查询分页）
    Page<Hospital> selectHospitalPage(Integer page, Integer limit, HospitalQueryVo hospitalQueryVo);

    //更新医院上线状态
    void updateStatus(String id, Integer status);

    //医院详情信息
    Map<String,Object> getHospById(String id);

    //获取医院的名称
    String getHospName(String hoscode);

    //根据医院名称查询
    List<Hospital> findByHosName(String hosname);

    //根据医院编号获取预约挂号详情
    Map<String, Object> item(String hoscode);
}
