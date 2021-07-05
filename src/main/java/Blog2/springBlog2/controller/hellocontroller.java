package Blog2.springBlog2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class hellocontroller {

    @GetMapping("hi")
    public String hello(Model model){
        model.addAttribute("data" , "hello!!");
        return "post/hi";
    }
}
