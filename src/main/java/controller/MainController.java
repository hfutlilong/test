package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.TestKafkaService;
import service.TestService;
import service.User1Service;

import javax.annotation.Resource;

@Controller
@RequestMapping
public class MainController {
    @Resource
    private TestKafkaService testKafkaService;

    @Resource
    private User1Service user1Service;

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    @ResponseBody
    public String welcome(){
        return "test Web";
    }

    @RequestMapping(value="/kafka/send", method = RequestMethod.GET)
    @ResponseBody
    public String testKafkaSend(){
        testKafkaService.testKafkaSend();
        return "Send message success!";
    }

//    @RestController
//    public String testKafkaReceive(){
//        testKafkaService.testKafkaReceive();
//        return "Send success!";
//    }

    @RequestMapping("/test/log")
    @ResponseBody
    public String testLog4j2(){
        testKafkaService.testLog4j();
        return "success";
    }

//    @RequestMapping("/mybatis/insert")
//    @ResponseBody
//    public String testMybatisInsert(){
//        user1Service.insert();
//        return "U are 666!";
//    }

    @RequestMapping("/test/async")
    @ResponseBody
    public String testAsync() {
        testService.testAsync();
        return "game over";
    }
}

