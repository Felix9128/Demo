package com.chenm.ssm.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: LoginController
 * Function:  TODO  功能说明.
 * <p>
 * date: 2019年12月18日  16:50
 *
 * @author chenm
 * @since JDK 1.8
 * <p>
 * Modified By： <修改人>
 * Modified Date: <修改日期，格式:YYYY-MM-DD>
 * Why & What is modified: <修改描述>
 */
@Controller
public class LoginController {

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("login")
    public String login(String username,String password) {
        //获取当前subject
        Subject currentUser = SecurityUtils.getSubject();
        //没有登陆
        if(!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                currentUser.login(token);
                //成功登陆，
                return "redirect:/main.jsp";
            }catch (UnknownAccountException e){
                System.out.println("用户名不存在");
                e.printStackTrace();
            }
            catch (IncorrectCredentialsException e){
                System.out.println("密码错误");
                e.printStackTrace();
            }
            catch (LockedAccountException e){
                System.out.println("用户锁定");
                e.printStackTrace();
            }
            catch (AuthenticationException e) {
                System.out.println("系统错误");
                e.printStackTrace();
            }
        }
        //登陆失败，跳回登录页
        return "redirect:/login.jsp";

    }
}
