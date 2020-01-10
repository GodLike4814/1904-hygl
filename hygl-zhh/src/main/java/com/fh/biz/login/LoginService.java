package com.fh.biz.login;

import com.fh.bean.login.Login;

import java.util.Date;

public interface LoginService {
    Login queryLogin(String loginName);

    void updateLoginSuccessInfo(Integer id);

    void updateLoginErrorInfo(Date date, Integer id);

    void updateLoginStatus(int loginLock, Integer id);

    void updateEmpLogin(Integer id, Integer loginCount, Date date);
}
