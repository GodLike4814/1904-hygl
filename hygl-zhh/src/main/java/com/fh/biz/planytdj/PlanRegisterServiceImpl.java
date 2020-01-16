package com.fh.biz.planytdj;

import com.fh.bean.planytdj.DutyUnit;
import com.fh.bean.planytdj.NsMeeting;
import com.fh.bean.planytdj.PlanRegister;
import com.fh.mapper.planytdj.PlanRegisterMapper;
import com.fh.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: 1904-hygl
 * @description: 计划议题登记service实现类
 * @author: 翟浩浩
 * @create: 2020-01-08 16:28
 **/
@Service
public class PlanRegisterServiceImpl implements PlanRegisterService {

    @Autowired
    private PlanRegisterMapper planRegisterMapper;

    @Override
    public List<NsMeeting> findNsMeeting() {
        return planRegisterMapper.findNsMeeting();
    }

    @Override
    public void add(PlanRegister planRegister) {
        planRegisterMapper.add(planRegister);
    }

    @Override
    public List<DutyUnit> findDutyUnit() {
        return planRegisterMapper.findDutyUnit();
    }

    @Override
    public PageBean<PlanRegister> findAllPlanRegister(PageBean<PlanRegister> page,PlanRegister planRegister) {
        Long count = planRegisterMapper.findCountAll(planRegister);
        page.setRecordsTotal(count);
        page.setRecordsFiltered(count);
        List<PlanRegister> allPlanRegister = planRegisterMapper.findAllPlanRegister(page,planRegister);
        List<PlanRegister> list = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (PlanRegister plan: allPlanRegister) {
            String startTime = simpleDateFormat.format(plan.getStartTime());
            String endTime = simpleDateFormat.format(plan.getEndTime());
            plan.setTimePlan(startTime+"至"+endTime);
            list.add(plan);
        }
        page.setData(list);
        return page;
    }
}
