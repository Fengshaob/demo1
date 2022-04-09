package com.example.demo.controller;

import com.example.demo.aspect.ExceptionHandler;
import com.example.demo.common.*;
import com.example.demo.model.UserInfoModel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/auth")
public class LoginController {

    @ExceptionHandler("提交登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Response submitLogin(String username, String password) {
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            UserInfoModel user = (UserInfoModel) subject.getPrincipal();
        } catch (DisabledAccountException e) {
            throw new BizException(CommonCodeEnum.SYSTEM_ERROR, "账户已被禁用");
        } catch (AuthenticationException e) {
            throw new BizException(CommonCodeEnum.SYSTEM_ERROR, "用户名或密码错误");
        }
        // 执行到这里说明用户已登录成功
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Response loginPage() {
        return ResponseUtil.fail(CommonCodeEnum.SYSTEM_ERROR, "去登录可以吗");
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Response loginSuccessMessage(HttpServletRequest request) {
        String username = "未登录";
        UserInfoModel currentLoginUser = RequestUtils.currentLoginUser();

        if (currentLoginUser != null && currentLoginUser.getId() != null) {
            username = currentLoginUser.getId().toString();
        } else {
            throw new BizException(CommonCodeEnum.SYSTEM_ERROR, "用户未登录");
        }
        request.setAttribute("username", username);
        return ResponseUtil.success();
    }

    @ExceptionHandler("登出")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public Response submitLogout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResponseUtil.success();
    }

    //被踢出后跳转的页面
    @RequestMapping(value = "/kickout", method = RequestMethod.GET)
    public String kickOut() {
        return "kickout";
    }
}
