package com.fh.controller.login;

import com.fh.bean.login.Login;
import com.fh.biz.login.LoginService;
import com.fh.servlet.ImageCodeServlet;
import com.fh.utils.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @program: 1904-hygl
 * @description: 登录controller
 * @author: 翟浩浩
 * @create: 2020-01-07 18:45
 **/
@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * @description:登录验证
     * @params:[login, request]
     * @return:com.fh.utils.ResponseServer
     * @author:翟浩浩
     * @date:2020/01/07 20:09
     */
    @PostMapping
    public ResponseServer login(Login login, HttpServletRequest request){
        String codeImg = login.getCodeImg();
        //Object code = request.getSession().getAttribute("code");
        //获取客户端cookie提交的唯一标识fhid
        String fhId = CookieUtil.readCookie(request, "fhId");
        //判断唯一标识为空的话 将返回“非法登录”
        if(StringUtils.isEmpty(fhId)){
            return ResponseServer.error(ServerEnum.LOGIN_FAIL_ERROR);
        }
        //根据唯一标识获取Redis中的验证码
        String redisCode = RedisUtil.get("code:" + fhId);
        //判断Redis中的验证码为空的话 将返回“验证码超时”的信息
        if(StringUtils.isEmpty(redisCode)){
            return ResponseServer.error(ServerEnum.LOGIN_CODE_TIMEOUT);
        }
        //如果用户名没输或密码没输，返回“信息不完整”
        if (StringUtils.isEmpty(login.getLoginName()) || StringUtils.isEmpty(login.getPass())){
            return ResponseServer.error(ServerEnum.LOGIN_INFO_MISS);
        }
        //“验证码不正确”
        if (!redisCode.equals(codeImg)){
            return ResponseServer.error(ServerEnum.LOGIN_CODE_ERROR);
        }
        //根据用户名查询 员工信息
        Login loginInfo = loginService.queryLogin(login.getLoginName());
        //用户名不存在
        if (null == loginInfo){
            return ResponseServer.error(ServerEnum.LOGIN_USERNAME_MISS);
        }
        //先判断用户是否被锁定
        if (loginInfo.getStatus() == SystemConst.LOGIN_STATUS){
            return ResponseServer.error(ServerEnum.LOGIN_LOCK);
        }
        //判断错误登陆时间不为空
        if (null != loginInfo.getErrorTime()) {
            Date errorTime = DateUtil.converStr2Date(DateUtil.convertDate2Str(loginInfo.getErrorTime(), DateUtil.Y_M_D), DateUtil.Y_M_D);
            Date date = DateUtil.converStr2Date(DateUtil.convertDate2Str(new Date(), DateUtil.Y_M_D), DateUtil.Y_M_D);
            //判断是否在同一天  如果不是同一天，将登陆次数重置为0
            if (date.after(errorTime)) {
               loginService.updateLoginSuccessInfo(loginInfo.getId());
                loginInfo.setErrorCount(0);
            }
        }
        //密码错误是将登录错误次数+1，并且更新错误时的时间
        String pass = Md5Util.md5(login.getPass());
        if (!pass.equals(loginInfo.getPass())){
            loginService.updateLoginErrorInfo(new Date(),loginInfo.getId());
            //如果错误次数==3则锁定用户
            if (loginInfo.getErrorCount() == (SystemConst.LOGIN_ERROR_COUNT-1)){
                loginService.updateLoginStatus(SystemConst.LOGIN_LOCK,loginInfo.getId());
            }
            return ResponseServer.error(ServerEnum.LOGIN_PASSWORD_ERROR);
        }else{
            //密码输入正确
            loginService.updateLoginSuccessInfo(loginInfo.getId());
        }
        //判断是否为同一天，是则登陆次数+1，否则将错误登陆次数重置为1，更新错误登录时间
        if (loginInfo.getOldLoginTime() != null) {
            Date loginTime = DateUtil.converStr2Date(DateUtil.convertDate2Str(loginInfo.getOldLoginTime(), DateUtil.Y_M_D), DateUtil.Y_M_D);
            Date date = DateUtil.converStr2Date(DateUtil.convertDate2Str(new Date(), DateUtil.Y_M_D), DateUtil.Y_M_D);
            if (date.equals(loginTime)){
                loginInfo.setLoginCount(loginInfo.getLoginCount()+1);
            }else{
                loginInfo.setLoginCount(1);
            }
        }else{
            loginInfo.setLoginCount(1);
            loginInfo.setOldLoginTime(new Date());
        }
        //request.getSession().setAttribute("loginuser",empInfo);

        //用户登录成功的时候将用户信息存入到Redis中，key为前台客户端的cookie值
        Gson gson = new Gson();
        String loginJson = gson.toJson(loginInfo);
        RedisUtil.set("user:"+fhId,loginJson);
        //设置Redis中的用户信息的存活时间
        RedisUtil.expire("user:"+fhId,2*60);
        //在登陆成功时候清除Redis中的验证码
        RedisUtil.del("code:"+fhId);
        //request.getSession().removeAttribute("code");
        loginService.updateEmpLogin(loginInfo.getId(),loginInfo.getLoginCount(),new Date());
        return ResponseServer.success();
    }
}
