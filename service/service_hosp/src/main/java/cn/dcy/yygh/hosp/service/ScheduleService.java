package cn.dcy.yygh.hosp.service;

import cn.dcy.yygh.model.hosp.Schedule;
import cn.dcy.yygh.vo.hosp.ScheduleQueryVo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface ScheduleService {
    //上传排班接口
    void save(Map<String, Object> paramMap);

    //查询排班
    Page<Schedule> findPageSchedule(int page, int limit, ScheduleQueryVo scheduleQueryVo);

    //删除排班
    void remove(String hoscode, String hosScheduleId);

    //根据医院的编号和科室编号查询排班规则数据
    Map<String, Object> getRuleSchedule(long page, long limit, String hoscode, String depcode);

    //根据医院的编号和科室的编号以及工作日期，查询排班的详细信息
    List<Schedule> getDetailSchedule(String hoscode, String depcode, String workDate);
}
