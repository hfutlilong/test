package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.impl.TestTransactional;

import javax.annotation.Resource;

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
    public String welcome() {
        return "test Web";
    }

    @RequestMapping(value = "/testTxName", method = RequestMethod.GET)
    @ResponseBody
    public String testTxName() {
        testTransactional.testTransactionalName();
        return "success";
    }
}

