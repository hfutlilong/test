package controller;

import entity.vo.UserLoginVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserLoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @Description 登录页面
 * @Author lilong
 * @Date 2019-04-05 18:24
 */
@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/loginAction")
    public String loginAction(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        UserLoginVO userLoginVO = userLoginService.queryUserByNamePwd(username, password);
        if (userLoginVO != null) {
//            request.getSession().setAttribute("isLogin", true);

            // 把用户名保存在Cookie里
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60); // 单位：秒
            cookie.setPath("/");
            response.addCookie(cookie);

            return "welcome";
        }

        return "login";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/registerAction")
    @ResponseBody
    public String registerAction(String username, String password1, String password2, String email) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password1) || StringUtils.isBlank(password2)) {
            return "用户名和密码均不能为空";
        }

        if (!password1.equals(password2)) {
            return "两次输入的密码不相同";
        }

        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO.setUsername(username);
        userLoginVO.setPassword(password1);
        userLoginVO.setEmail(email);

        try {
            userLoginService.register(userLoginVO);
            return "注册成功";
        } catch (DuplicateKeyException e) {
            return "该邮箱已注册过账号";
        } catch (Exception e) {
            return "注册失败";
        }
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("username");
        try {
            //把过期时间设置成0秒，表示删除该属性
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    System.out.println(URLDecoder.decode(cookie.getName(), "utf-8"));
                    if (URLDecoder.decode(cookie.getName(), "utf-8").equals("username")) { // 表明已经登陆过了，就直接跳转了
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                    }
                }
            }
//            request.getSession().setAttribute("isLogin", false);
            response.sendRedirect("/user/login.do");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
