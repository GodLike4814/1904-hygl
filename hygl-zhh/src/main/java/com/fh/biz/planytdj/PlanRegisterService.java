package com.fh.biz.planytdj;

import com.fh.bean.planytdj.DutyUnit;
import com.fh.bean.planytdj.NsMeeting;
import com.fh.bean.planytdj.PlanRegister;
import com.fh.utils.PageBean;

import java.util.List;

public interface PlanRegisterService {
    List<NsMeeting> findNsMeeting();

    void add(PlanRegister planRegister);

    List<DutyUnit> findDutyUnit();

    PageBean<PlanRegister> findAllPlanRegister(PageBean<PlanRegister> page,PlanRegister planRegister);
}
