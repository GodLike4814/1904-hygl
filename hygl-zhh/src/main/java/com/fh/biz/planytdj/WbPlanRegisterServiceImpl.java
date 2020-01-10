package com.fh.biz.planytdj;

import com.fh.bean.planytdj.WbPlanRegister;
import com.fh.mapper.planytdj.WbPlanRegisterMapper;
import com.fh.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: 1904-hygl
 * @description: 委办计划议题实现类
 * @author: 翟浩浩
 * @create: 2020-01-09 19:18
 **/
@Service
public class WbPlanRegisterServiceImpl implements WbPlanRegisterService {

    @Autowired
    private WbPlanRegisterMapper wbPlanRegisterMapper;

    @Override
    public PageBean<WbPlanRegister> findWbPlanRegisterList(PageBean<WbPlanRegister> page, WbPlanRegister wbPlanRegister) {
        Long count = wbPlanRegisterMapper.findCount(wbPlanRegister);
        page.setRecordsTotal(count);
        page.setRecordsFiltered(count);
        List<WbPlanRegister> list = wbPlanRegisterMapper.findWbPlanRegisterList(page,wbPlanRegister);
        page.setData(list);
        return page;
    }
}
