package Blog2.springBlog2.controller;

import Blog2.springBlog2.DTO.userDTO;
import Blog2.springBlog2.model.User;
import Blog2.springBlog2.repository.UserRepository;
import Blog2.springBlog2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class userController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/auth/login")
    public String loginForm(){
        return "/user/loginForm";
    }

    @GetMapping("/auth/join")
    public String joinForm(){
        return "/user/joinForm";
    }

    @GetMapping("write")
    public String writeForm(){
        return "/post/postWrite";
    }

    @PostMapping("/auth/userJoin")
    public String userJoin(userDTO userdto){

        //form 에서 넘어온 DTO 데이터를 변환
        User user = userdto.toEntity();

        //userRepository에게 Entity를 DB에 저장하라고함
        userService.Join(user);

        return "redirect:/";
    }




}
