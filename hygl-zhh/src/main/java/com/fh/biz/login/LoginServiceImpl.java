package com.fh.biz.login;

import com.fh.bean.login.Login;
import com.fh.mapper.login.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: 1904-hygl
 * @description: login实现类
 * @author: 翟浩浩
 * @create: 2020-01-07 18:50
 **/
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Login queryLogin(String loginName) {

        return loginMapper.queryLogin(loginName);
    }

    @Override
    public void updateLoginSuccessInfo(Integer id) {
        loginMapper.updateLoginSuccessInfo(id);
    }

    @Override
    public void updateLoginErrorInfo(Date date, Integer id) {
        loginMapper.updateLoginErrorInfo(date,id);
    }

    @Override
    public void updateLoginStatus(int loginLock, Integer id) {
        loginMapper.updateLoginStatus(loginLock,id);
    }

    @Override
    public void updateEmpLogin(Integer id, Integer loginCount, Date date) {
        loginMapper.updateEmpLogin(id,loginCount,date);
    }
}
