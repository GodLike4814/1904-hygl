package com.fh.mapper.login;

import com.fh.bean.login.Login;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Mapper
@Repository
public interface LoginMapper {
    Login queryLogin(String loginName);

    void updateLoginSuccessInfo(Integer id);

    void updateLoginErrorInfo(Date date, Integer id);

    void updateLoginStatus(int status, Integer id);

    void updateEmpLogin(Integer id, Integer loginCount, Date oldLoginTime);
}
