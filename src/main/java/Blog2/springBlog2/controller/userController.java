package Blog2.springBlog2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class userController {

    @GetMapping("login")
    public String loginForm(){
        return "user/loginForm";
    }

    @GetMapping("join")
    public String joinForm(){
        return "user/joinForm";
    }

}
