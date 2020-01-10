package com.fh.mapper.planytdj;

import com.fh.bean.planytdj.DutyUnit;
import com.fh.bean.planytdj.NsMeeting;
import com.fh.bean.planytdj.PlanRegister;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
@Repository
public interface PlanRegisterMapper {
    List<NsMeeting> findNsMeeting();

    void add(PlanRegister planRegister);

    List<DutyUnit> findDutyUnit();
}
