package cn.dcy.yygh.hosp.controller;

import cn.dcy.yygh.common.result.Result;
import cn.dcy.yygh.hosp.service.ScheduleService;
import cn.dcy.yygh.model.hosp.Schedule;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/admin/hosp/schedule")
//CrossOrigin
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    //根据医院的编号和科室编号查询排班规则数据
    @ApiOperation(value="查询排班规则数据")
    @GetMapping("getScheduleRule/{page}/{limit}/{hoscode}/{depcode}")
    public Result getScheduleRule(@PathVariable long page,
                                  @PathVariable long limit,
                                  @PathVariable String hoscode,
                                  @PathVariable String depcode){
        Map<String,Object> map = scheduleService.getRuleSchedule(page,limit,hoscode,depcode);
        return Result.ok(map);
    }

    //根据医院的编号和科室的编号以及工作日期，查询排班的详细信息
    @ApiOperation(value="查询排班的详细信息")
    @GetMapping("getScheduleDetail/{hoscode}/{depcode}/{workDate}")
    public Result getScheduleDetail(@PathVariable String hoscode,
                                    @PathVariable String depcode,
                                    @PathVariable String workDate){
        List<Schedule> list = scheduleService.getDetailSchedule(hoscode,depcode,workDate);
        return Result.ok(list);
    }
}
