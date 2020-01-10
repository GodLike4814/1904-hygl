package com.fh.bean.login;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: 1904-hygl
 * @description: 登录
 * @author: 翟浩浩
 * @create: 2020-01-07 19:02
 **/
public class Login implements Serializable {

    private Integer id;

    private String loginName;

    private String pass;

    private String codeImg;

    private Date oldLoginTime;

    private Integer loginCount;

    private Date errorTime;

    private Integer errorCount;

    private Integer status;

    public String getCodeImg() {
        return codeImg;
    }

    public void setCodeImg(String codeImg) {
        this.codeImg = codeImg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getOldLoginTime() {
        return oldLoginTime;
    }

    public void setOldLoginTime(Date oldLoginTime) {
        this.oldLoginTime = oldLoginTime;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Date getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(Date errorTime) {
        this.errorTime = errorTime;
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
