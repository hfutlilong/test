//package controller;
//
//import entity.Student;
//import entity.User;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.ui.ModelMap;
//
//import java.io.File;
//import java.util.UUID;
//
//@Controller
//public class StudentController {
//
//    @RequestMapping(value = "/student", method = RequestMethod.GET)
//    public ModelAndView student() {
//        return new ModelAndView("student", "command", new Student());
//    }
//
//    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
//    public String addStudent(@ModelAttribute("SpringWeb") Student student,
//                             ModelMap model) {
//        model.addAttribute("name", student.getName());
//        model.addAttribute("age", student.getAge());
//        model.addAttribute("id", student.getId());
//
//        return "result";
//    }
//
//    @RequestMapping(value="/toUploadPage", method=RequestMethod.GET)
//    public String toUploadPage() {
//        return "ImgUploadTest";
//    }
//
//    @RequestMapping(value="/uploadImg", method = RequestMethod.POST)
//    public String uploadImg(Model model, MultipartFile file) throws Exception {
//        //上传图片的原始名称
//        String originalFilename = file.getOriginalFilename();
//        String newFilename = null;
//
//        //上传图片
//        if (file != null && StringUtils.isNotBlank(originalFilename)) {
//            //图片存储路径
//            String savePath = "E:\\SelfLearnProject\\test\\pic\\";
//            newFilename = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
//            File newFile = new File(savePath + newFilename);
//            //写入磁盘
//            file.transferTo(newFile);
//        }
//
//        model.addAttribute("image", newFilename);
//        return "ImgUploadTest";
//    }
//
//    @RequestMapping("toJsonTestPage")
//    public String toJsonTestPage(Model model) {
//        return "/JsonTest";
//    }
//
//    @RequestMapping("/JsonTest")
//    @ResponseBody
//    public User JsonTest(@RequestBody User user) {
//        System.out.println("userInfo[username:" + user.getUsername() + ",password:" + user.getPassword());
//
//        return user;
//    }
//}