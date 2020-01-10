package com.fh.controller.planytdj;

import com.fh.bean.planytdj.WbPlanRegister;
import com.fh.biz.planytdj.WbPlanRegisterService;
import com.fh.utils.PageBean;
import com.fh.utils.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: 1904-hygl
 * @description: 委办计划议题controller
 * @author: 翟浩浩
 * @create: 2020-01-09 19:16
 **/
@RestController
@RequestMapping("wbPlanRegister")
@CrossOrigin
public class WbPlanRegisterController {

    @Autowired
    private WbPlanRegisterService wbPlanRegisterService;

    //查询委办计划议题list
    @PostMapping("/findWbPlanRegisterList")
    public PageBean<WbPlanRegister> findWbPlanRegisterList(PageBean<WbPlanRegister> page,WbPlanRegister wbPlanRegister){
        page = wbPlanRegisterService.findWbPlanRegisterList(page,wbPlanRegister);
        return page;
    }
}
