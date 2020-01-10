package com.fh.biz.planytdj;

import com.fh.bean.planytdj.WbPlanRegister;
import com.fh.utils.PageBean;

public interface WbPlanRegisterService {
    PageBean<WbPlanRegister> findWbPlanRegisterList(PageBean<WbPlanRegister> page, WbPlanRegister wbPlanRegister);
}
