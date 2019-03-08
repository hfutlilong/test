//package controller;
//
//import dubbo.provider.ProviderService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.annotation.Resource;
//
///**
// * @Description TODO
// * @Author lilong
// * @Date 2019-01-09 15:23
// */
//@Controller
//@RequestMapping("/dubbo")
//public class DubboTestController {
//    @Resource(name="providerServiceRemote")
//    private ProviderService providerService;
//
//    @RequestMapping("/hello")
//    @ResponseBody
//    public String index(Model model){
//        String name = providerService.sayHello("zz");
//        System.out.println("xx==" + name);
//        return "";
//    }
//}
