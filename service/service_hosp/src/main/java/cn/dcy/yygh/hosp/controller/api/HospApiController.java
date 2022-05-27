package cn.dcy.yygh.hosp.controller.api;

import cn.dcy.yygh.common.result.Result;
import cn.dcy.yygh.hosp.service.DepartmentService;
import cn.dcy.yygh.hosp.service.HospitalService;
import cn.dcy.yygh.model.hosp.Hospital;
import cn.dcy.yygh.vo.hosp.DepartmentVo;
import cn.dcy.yygh.vo.hosp.HospitalQueryVo;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.ApiOperation;
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
}
