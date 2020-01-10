package com.fh.controller.planytdj;

import com.fh.bean.planytdj.DutyUnit;
import com.fh.bean.planytdj.NsMeeting;
import com.fh.bean.planytdj.PlanRegister;
import com.fh.biz.planytdj.PlanRegisterService;
import com.fh.utils.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: 1904-hygl
 * @description: 计划议题登记controller
 * @author: 翟浩浩
 * @create: 2020-01-08 16:25
 **/
@RestController
@RequestMapping("planRegister")
@CrossOrigin
public class PlanRegisterController {

    @Autowired
    private PlanRegisterService planRegisterService;

    //添加计划议题登记
    @PostMapping("/add")
    public ResponseServer add( PlanRegister planRegister){
        planRegisterService.add(planRegister);
        return ResponseServer.success();
    }

    //查询拟上会议
    @PostMapping("/findNsMeeting")
    public ResponseServer findNsMeeting(){
       List<NsMeeting> list = planRegisterService.findNsMeeting();
        return ResponseServer.success(list);
    }

    //查询责任单位
    @PostMapping("/findDutyUnit")
    public ResponseServer findDutyUnit(){
       List<DutyUnit> list = planRegisterService.findDutyUnit();
        return ResponseServer.success(list);
    }

}
