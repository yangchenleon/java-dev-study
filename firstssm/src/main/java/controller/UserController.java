package controller;

import beans.Register;
import beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.IRegisterService;
import service.IUserService;


@Controller // 用于创建Controller对象
public class UserController {
    @Autowired
    public IUserService service;

//    @Autowired
//    IRegisterService service;

    // 1. 一般
//    @RequestMapping(path = "/login", method = RequestMethod.GET, params = {"username=xxx"})
//    @ResponseBody
//    public String login(){
//        System.out.println("我已经进入到login方法了，测试成功");
//        return "first study springmvc";
//    }

    // 2. 带参数
//    @RequestMapping("/login")
//    @ResponseBody
//    // 下面将username映射为name
//    public String login(@RequestParam(name="username") String name, @RequestParam(name="password") String pwd) {
//        System.out.println("我已经进入到login方法了，测试成功");
//        System.out.println("username: " + name + " paddword: " + pwd);
//        return "first study springmvc";
//    }

    // 3. 直接用对象+渲染到mian.jsp页面（需添加试图解析器）
//    @RequestMapping("/login")
//    @ResponseBody
//    public String login(User user) {
//        System.out.println("我已经进入到login方法了，测试成功");
//        System.out.println("username: " + user.getUsername() + " paddword: " + user.getPassword());
//        return "main"; // 这是内容渲染的网页名字
//    }

    // 4. 转发和重定向
    @RequestMapping("/login")
    public String login(User user) {
        System.out.println("进入到login方法");
        System.out.println(user);
        return "regist"; // 转发，数据带着转发；重定向Redirect就不行
    }

    // 5. 用户校验
    @RequestMapping("/check")
    public String check(User user) {
        System.out.println(user);
        if (user.getUsername().equals("csb") && user.getPassword().equals("123")) {
            return "success";
        } else
            return "error";
    }

    // 6. 注册
    @RequestMapping("/regist")
    public String regist(User user) {
        System.out.println("进入到regist方法");
        System.out.println(user);
        int numInsert = service.insert(user);
        if (numInsert > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    // 7. 首页
    @RequestMapping("/")
    public String indexPage() throws Exception {
        return "main";
    }
}
