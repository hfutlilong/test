package controller;

import event.BaseEvent;
import event.EventPublisher;
import event.impl.AEvent;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private EventPublisher eventPublisher;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    @ResponseBody
    public String welcome() {
        BaseEvent event = new AEvent("fuck u very much...");
        eventPublisher.publish(event);
        return "test Web";
    }

    @RequestMapping(value = "/testTxName", method = RequestMethod.GET)
    @ResponseBody
    public String testTxName() {
        testTransactional.testTransactionalName();
        return "success";
    }
}

