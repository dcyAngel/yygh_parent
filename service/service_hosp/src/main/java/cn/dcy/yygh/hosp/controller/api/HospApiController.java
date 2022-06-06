package cn.dcy.yygh.hosp.controller.api;

import cn.dcy.yygh.common.result.Result;
import cn.dcy.yygh.hosp.service.DepartmentService;
import cn.dcy.yygh.hosp.service.HospitalService;
import cn.dcy.yygh.hosp.service.HospitalSetService;
import cn.dcy.yygh.hosp.service.ScheduleService;
import cn.dcy.yygh.model.hosp.Hospital;
import cn.dcy.yygh.model.hosp.Schedule;
import cn.dcy.yygh.vo.hosp.DepartmentVo;
import cn.dcy.yygh.vo.hosp.HospitalQueryVo;
import cn.dcy.yygh.vo.hosp.ScheduleOrderVo;
import cn.dcy.yygh.vo.order.SignInfoVo;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/hosp/hospital")
public class HospApiController {
    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private HospitalSetService hospitalSetService;

    @ApiOperation(value="查询医院列表功能")
    @GetMapping("findHospList/{page}/{limit}")
    public Result findHospList(@PathVariable Integer page,
                               @PathVariable Integer limit,
                               HospitalQueryVo hospitalQueryVo){
       Page<Hospital> hospitals = hospitalService.selectHospitalPage(page,limit,hospitalQueryVo);
       return Result.ok(hospitals);
    }

    @ApiOperation(value="根据医院名称查询")
    @GetMapping("findByHosName/{hosname}")
    public Result findByHosName(@PathVariable String hosname){
       List<Hospital> list = hospitalService.findByHosName(hosname);
       return Result.ok(list);
    }

    @ApiOperation(value="根据医院编号获取科室")
    @GetMapping("department/{hoscode}")
    public Result index(@PathVariable String hoscode){
        List<DepartmentVo> list = departmentService.findDeptTree(hoscode);
        return Result.ok(list);
    }

    @ApiOperation(value="根据医院编号获取预约挂号详情")
    @GetMapping("findHospDetail/{hoscode}")
    public Result item(@PathVariable String hoscode){
        Map<String,Object> map = hospitalService.item(hoscode);
        return Result.ok(map);
    }

    //获取可预约排班信息
    @ApiOperation(value="获取可预约排班信息")
    @GetMapping("auth/getBookingSchedule/{page}/{limit}/{hoscode}/{depcode}")
    public Result getBookingSchedule(@PathVariable Integer page,
                                     @PathVariable Integer limit,
                                     @PathVariable String hoscode,
                                     @PathVariable String depcode){
        return Result.ok(scheduleService.getBookingScheduleRule(page,limit,hoscode,depcode));

    }

    //获取排班具体信息
    @GetMapping("auth/findScheduleList/{hoscode}/{depcode}/{workDate}")
    public Result findScheduleList(@PathVariable String hoscode,
                                   @PathVariable String depcode,
                                   @PathVariable String workDate){
        return Result.ok(scheduleService.getDetailSchedule(hoscode,depcode,workDate));
    }

    //根据排班id获取排班数据
    @GetMapping("getSchedule/{scheduleId}")
    public Result getSchedule(@PathVariable String scheduleId){
        Schedule schedule = scheduleService.getScheduleId(scheduleId);
        return Result.ok(schedule);
    }

    //根据排班id获取预约下单数据
    @ApiOperation(value = "根据排班id获取预约下单数据")
    @GetMapping("inner/getScheduleOrderVo/{scheduleId}")
    public ScheduleOrderVo getScheduleOrderVo(
            @ApiParam(name = "scheduleId", value = "排班id", required = true)
            @PathVariable String scheduleId) {
        return scheduleService.getScheduleOrderVo(scheduleId);
    }

    //获取医院签名信息
    @ApiOperation(value = "获取医院签名信息")
    @GetMapping("inner/getSignInfoVo/{hoscode}")
    public SignInfoVo getSignInfoVo(
            @ApiParam(name = "hoscode", value = "医院code", required = true)
            @PathVariable("hoscode") String hoscode) {
        return hospitalSetService.getSignInfoVo(hoscode);
    }
}
