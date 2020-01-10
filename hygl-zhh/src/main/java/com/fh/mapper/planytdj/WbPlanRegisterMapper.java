package com.fh.mapper.planytdj;

import com.fh.bean.planytdj.WbPlanRegister;
import com.fh.utils.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WbPlanRegisterMapper {
    Long findCount(@Param("wbPlanRegister") WbPlanRegister wbPlanRegister);

    List<WbPlanRegister> findWbPlanRegisterList(@Param("page") PageBean<WbPlanRegister> page, @Param("wbPlanRegister") WbPlanRegister wbPlanRegister);
}
