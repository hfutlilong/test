package controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.impl.TestTransactional;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping
public class MainController {
    @Resource
    private TestTransactional testTransactional;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    @ResponseBody
    public String welcome(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(JSON.toJSONString(request.getCookies()));
        Cookie cookie = new Cookie("username", "biglong");
        response.addCookie(cookie);
        return "test Web";
    }

    @RequestMapping(value = "/testTxName", method = RequestMethod.GET)
    @ResponseBody
    public String testTxName() {
        testTransactional.testTransactionalName();
        return "success";
    }
}

